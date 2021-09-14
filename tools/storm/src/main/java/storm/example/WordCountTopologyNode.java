package storm.example;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.spout.ShellSpout;
import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.ShellBolt;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.IRichBolt;
import org.apache.storm.topology.IRichSpout;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.TopologyBuilder;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.trident.operation.FlatMapFunction;
import org.apache.storm.trident.tuple.TridentTuple;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

/**
 * This topology demonstrates Storm's stream groupings and multilang capabilities.
 */
public class WordCountTopologyNode {
    public static void main(String[] args) throws Exception {

        TopologyBuilder builder = new TopologyBuilder();

        builder.setSpout("spout", new RandomSentence(), 5);

        builder.setBolt("split", new SplitSentence(), 8).shuffleGrouping("spout");
        builder.setBolt("count", new WordCount(), 12).fieldsGrouping("split", new Fields("words"));

        Config conf = new Config();
        conf.setDebug(true);
        String topoName = "word-count";
        if (args != null && args.length > 0) {
            topoName = args[0];
        }
        conf.setNumWorkers(3);
        System.setProperty("storm.jar", "/Users/prabhakarans/IdeaProjects/storm-hw/target/storm-1.0-SNAPSHOT.jar");

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("word-count-toppu", conf, builder.createTopology()  );

//        StormSubmitter.submitTopology("word-count-toppu", conf, builder.createTopology());

//        StormSubmitter.submitTopologyWithProgressBar(topoName, conf, builder.createTopology());
    }

    public static class SplitSentence extends BaseBasicBolt {


        @Override
        public void execute(Tuple tuple, BasicOutputCollector collector) {
            collector.emit(new Values(tuple.getString(0)));
        }

        @Override
        public void declareOutputFields(OutputFieldsDeclarer declarer) {
            declarer.declare(new Fields("words"));
        }
    }

    public static class RandomSentence extends BaseRichSpout {

        String[] sentences = new String[]{
                "the cow jumped over the moon",
                "an apple a day keeps the doctor away",
                "four score and seven years ago",
                "snow white and the seven dwarfs",
                "i am at two with nature"};

        private SpoutOutputCollector collector;

        @Override
        public void open(Map<String, Object> map, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
            this.collector = spoutOutputCollector;
        }

        @Override
        public void nextTuple() {
            int r = (int)Math.round(Math.random()*5+1);
            this.collector.emit(new Values(sentences[r]));
        }

        @Override
        public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
            outputFieldsDeclarer.declare(new Fields("sentence"));
        }
    }

    public static class WordCount extends BaseBasicBolt {
        Map<String, Integer> counts = new HashMap<String, Integer>();

        @Override
        public void execute(Tuple tuple, BasicOutputCollector collector) {
            String word = tuple.getString(0);
            Integer count = counts.get(word);
            if (count == null) {
                count = 0;
            }
            count++;
            counts.put(word, count);
            collector.emit(new Values(word, count));
        }

        @Override
        public void declareOutputFields(OutputFieldsDeclarer declarer) {
            declarer.declare(new Fields("words", "count"));
        }
    }
}

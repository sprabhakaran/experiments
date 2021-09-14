package storm.example;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.StormSubmitter;
import org.apache.storm.topology.TopologyBuilder;

public class WordCountTopology {
    public static void main(String args[]) throws Exception {

        TopologyBuilder builder = new TopologyBuilder();
        builder.setSpout("word-reader", new WordReaderSpout());
//        builder.setBolt("word-counter", new WordCountBolt(), 2).shuffleGrouping("word-reader");
        Config conf = new Config();
        conf.put("fileToRead", "/Users/prabhakarans/test.txt");
        conf.setDebug(true);

//        StormSubmitter.submitTopology("wordcounter-topology1", conf, builder.createTopology());

        LocalCluster localCluster = new LocalCluster();
        localCluster.submitTopology("wordcounter-topology", conf, builder.createTopology());
        try {
            Thread.sleep(5000);
            localCluster.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
            localCluster.shutdown();
        }

    }
}

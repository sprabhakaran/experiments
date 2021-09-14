package storm.example.fieldsgrp;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.topology.TopologyBuilder;

public class Main {
    public static void main(String[] args) throws Exception {
        TopologyBuilder tb = new TopologyBuilder();
        tb.setSpout("Word-count-spout", new WordCountSpout());
        tb.setBolt("Word-count-bolt", new WordCountBolt(), 1).shuffleGrouping("Word-count-spout");

        Config conf = new Config();
        conf.put(Config.TOPOLOGY_DEBUG, false);
        conf.put("fileToRead", "/Users/prabhakarans/Downloads/sales1.csv");

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("Word-count-topology", conf, tb.createTopology());

        Thread.sleep(8000);
        cluster.shutdown();
    }
}

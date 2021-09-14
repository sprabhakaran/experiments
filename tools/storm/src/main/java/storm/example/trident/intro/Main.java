package storm.example.trident.intro;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.LocalDRPC;
import org.apache.storm.trident.TridentTopology;
import org.apache.storm.tuple.Fields;

public class Main {

    public static void main(String[] args) throws Exception {
        LocalDRPC drpc = new LocalDRPC();
        TridentTopology topology = new TridentTopology();
        topology
                .newDRPCStream("simple", drpc)
                .each(new Fields("args"), new SimpleFunction(), new Fields("processed_word"));

        Config conf = new Config();
        conf.setDebug(false);

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("trident-topology", conf, topology.build());

        System.out.println("Setup is completed ....");

        for (int i = 0; i < 100; i++) {
            String word = "I am a word and my id is : " + i;
            System.out.println("Result for " + word + ": " + drpc.execute("simple", word));
        }

        System.out.println("DRPC operations are done. ....");

        cluster.shutdown();
    }
}


package storm.example.trident.map;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.LocalDRPC;
import org.apache.storm.trident.TridentTopology;

public class Main {
    public static void main(String[] args) throws Exception {

        LocalDRPC drpc = new LocalDRPC();

        TridentTopology topology = new TridentTopology();
        topology.newDRPCStream("simple", drpc)
                .map(new LowerCaseHandler())
                .flatMap(new SplitString())
                .map(new UpperCaseHandler());

        Config conf = new Config();
        conf.setDebug(false);

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("map-execution", conf, topology.build());

        for (int i=0; i<100; i++) {
            String word = "Num:"+i + " Trident provides a FULLY fledged BATCH processing API to process those small batches";
            System.out.println("Result : " + drpc.execute("simple", word));
        }

        cluster.shutdown();
    }
}

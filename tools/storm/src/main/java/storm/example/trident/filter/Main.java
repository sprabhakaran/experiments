package storm.example.trident.filter;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.LocalDRPC;
import org.apache.storm.trident.TridentTopology;

public class Main {
    public static void main(String[] args) throws Exception {
        LocalDRPC drpc = new LocalDRPC();
        TridentTopology topology = new TridentTopology();
        topology
                .newDRPCStream("filter-fn", drpc)
                .flatMap(new SplitHandler())
                .filter(new ShortWordFilterHandler());

        TridentTopology topology1 = new TridentTopology();
        topology1
                .newDRPCStream("uppercase-fn", drpc)
                .flatMap(new UpperCaseHandler());

        Config conf = new Config();
        conf.setDebug(false);

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("filter-executor", conf, topology.build());
        cluster.submitTopology("uppercase-executor", conf, topology1.build());

        for (int i=0; i<100; i++) {
            String word = "Num:"+i + " Trident provides a FULLY fledged BATCH processing API to process those small batches";
            String result1 = drpc.execute("filter-fn", word);
            System.out.println("Result1 : " + result1);

            String result2 = drpc.execute("uppercase-fn", result1);
            System.out.println("Result 2 :: " + result2);
        }

        cluster.shutdown();

    }
}

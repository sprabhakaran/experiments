package storm.example.trident.aggre;

import org.apache.storm.Config;
import org.apache.storm.LocalCluster;
import org.apache.storm.LocalDRPC;
import org.apache.storm.trident.TridentTopology;
import org.apache.storm.trident.operation.builtin.Count;
import org.apache.storm.trident.operation.builtin.Max;
import org.apache.storm.trident.operation.builtin.Min;
import org.apache.storm.tuple.Fields;
import storm.example.trident.map.LowerCaseHandler;
import storm.example.trident.map.SplitString;

public class Main {
    public static void main(String[] args) throws Exception {
        LocalDRPC drpc = new LocalDRPC();
        TridentTopology topology = new TridentTopology();
        topology.newDRPCStream("agg-count", drpc)
                .map(new LowerCaseHandler())
                .flatMap(new SplitString())
                .groupBy(new Fields("args"))
                .aggregate(new Count(), new Fields("count"));

        /*
        topology.newDRPCStream("agg-max", drpc)
                .map(new LowerCaseHandler())
                .flatMap(new SplitString())
                .aggregate(new Max("count"), new Fields("count"));

        topology.newDRPCStream("agg-min", drpc)
                .map(new LowerCaseHandler())
                .flatMap(new SplitString())
                .aggregate(new Min("count"), new Fields("count"));
         */

        Config conf = new Config();
        conf.setDebug(false);

        LocalCluster cluster = new LocalCluster();
        cluster.submitTopology("count-exec", conf, topology.build());

        String[] arr = new String[]{"This is a massive string method", "Cats are not eating any food", "Amukku dumuku dammal dumeel"};

        for (String s : arr) {
            System.out.println("Result coutn :; " + drpc.execute("agg-count", s));
//            System.out.println("Result max :; " + drpc.execute("agg-max", s));
//            System.out.println("Result min :; " + drpc.execute("agg-min", s));
        }
        cluster.shutdown();
    }
}

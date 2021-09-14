package storm.example.drpc;

import org.apache.storm.Config;
import org.apache.storm.LocalDRPC;
import org.apache.storm.StormSubmitter;
import org.apache.storm.drpc.LinearDRPCTopologyBuilder;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        LinearDRPCTopologyBuilder builder = new LinearDRPCTopologyBuilder("drpc-plusTen");
//        LocalDRPC builder = new LocalDRPC();
        builder.addBolt(new PlusTenBolt());

        Config conf = new Config();
        List<String> dprcServers = new ArrayList<String>();

        dprcServers.add("localhost");

        conf.put(Config.DRPC_SERVERS, dprcServers);

        conf.put(Config.DRPC_PORT, 3772);

        StormSubmitter.submitTopology("drpc-plusTen", conf, builder.createRemoteTopology());

    }

}

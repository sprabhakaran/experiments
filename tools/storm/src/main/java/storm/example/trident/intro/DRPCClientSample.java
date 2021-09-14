package storm.example.trident.intro;

import org.apache.storm.utils.DRPCClient;
import org.apache.storm.utils.Utils;

import java.util.Map;

public class DRPCClientSample {
    public static void main(String[] args) throws Exception {

        Map conf = Utils.readStormConfig();
        DRPCClient client = new DRPCClient(conf, "localhost", 3772);

        for (String word : new String[]{"word 1", "word 2", "word 3"}) {
            System.out.println("Result for " + word + ": " + client.execute("simple", word));


        }
    }
}

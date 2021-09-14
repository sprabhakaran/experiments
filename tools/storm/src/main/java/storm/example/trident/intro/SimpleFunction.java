package storm.example.trident.intro;

import org.apache.storm.trident.operation.BaseFunction;
import org.apache.storm.trident.operation.TridentCollector;
import org.apache.storm.trident.tuple.TridentTuple;
import org.apache.storm.tuple.Values;

public class SimpleFunction extends BaseFunction {
    @Override
    public void execute(TridentTuple tuple, TridentCollector collector) {
        System.out.println(">>>>>>>>>  Simple function called ... " + tuple);
        collector.emit(new Values(tuple.getString(0) + " After Processing"));
    }
}

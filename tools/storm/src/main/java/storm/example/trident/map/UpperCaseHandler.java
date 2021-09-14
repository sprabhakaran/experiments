package storm.example.trident.map;

import org.apache.storm.trident.operation.MapFunction;
import org.apache.storm.trident.tuple.TridentTuple;
import org.apache.storm.tuple.Values;

public class UpperCaseHandler implements MapFunction {
    @Override
    public Values execute(TridentTuple tuple) {
        return new Values(tuple.getString(0).toUpperCase());
    }
}

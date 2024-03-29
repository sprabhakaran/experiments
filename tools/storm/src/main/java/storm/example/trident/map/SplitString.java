package storm.example.trident.map;

import org.apache.storm.trident.operation.FlatMapFunction;
import org.apache.storm.trident.tuple.TridentTuple;
import org.apache.storm.tuple.Values;

import java.util.ArrayList;
import java.util.List;

public class SplitString implements FlatMapFunction {
    @Override
    public Iterable<Values> execute(TridentTuple tuple) {
        List<Values> valuesList = new ArrayList<Values>();
        for (String word : tuple.getString(0).split(" ")) {
            valuesList.add(new Values(word));
        }
        return valuesList;
    }
}

package storm.example.trident.filter;

import org.apache.storm.trident.operation.FlatMapFunction;
import org.apache.storm.trident.tuple.TridentTuple;
import org.apache.storm.tuple.Values;

import java.util.ArrayList;
import java.util.List;

public class SplitHandler implements FlatMapFunction {
    @Override
    public Iterable<Values> execute(TridentTuple tuple) {
        List list = new ArrayList();
        for(String s : tuple.getString(0).split(" ")){
            list.add(new Values(s));
        }
        return list;
    }
}

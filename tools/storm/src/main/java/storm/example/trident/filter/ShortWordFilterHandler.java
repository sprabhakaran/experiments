package storm.example.trident.filter;

import org.apache.storm.trident.operation.BaseFilter;
import org.apache.storm.trident.tuple.TridentTuple;

public class ShortWordFilterHandler extends BaseFilter {
    @Override
    public boolean isKeep(TridentTuple tuple) {
        return tuple.getString(0).length() > 5;
    }
}

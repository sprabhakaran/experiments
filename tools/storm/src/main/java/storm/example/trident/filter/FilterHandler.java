package storm.example.trident.filter;

import org.apache.storm.trident.operation.Filter;
import org.apache.storm.trident.operation.TridentOperationContext;
import org.apache.storm.trident.tuple.TridentTuple;

import java.util.Map;

public class FilterHandler implements Filter {
    @Override
    public boolean isKeep(TridentTuple tridentTuple) {
        return false;
    }

    @Override
    public void prepare(Map<String, Object> map, TridentOperationContext tridentOperationContext) {

    }

    @Override
    public void cleanup() {

    }
}

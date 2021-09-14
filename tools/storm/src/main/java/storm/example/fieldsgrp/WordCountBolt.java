package storm.example.fieldsgrp;

import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.BasicOutputCollector;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseBasicBolt;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Tuple;
import org.apache.storm.tuple.Values;

import java.util.Map;

public class WordCountBolt extends BaseBasicBolt {

    public void prepare(Map<String, Object> topoConf, TopologyContext context){
        System.out.println("----- " + topoConf +",  ctx : "+ context);
    }

    @Override
    public void execute(Tuple tuple, BasicOutputCollector basicOutputCollector) {
        System.out.println(" --------  bolt executed ... region :  " + tuple.getStringByField("Region") + ",  sales : " + tuple.getStringByField("Sales"));
        basicOutputCollector.emit(new Values("done"));
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("word1"));
    }
}

package storm.example.fieldsgrp;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

public class WordCountSpout extends BaseRichSpout {
    private SpoutOutputCollector collector;
    private FileReader fileReader;
    private boolean completed;
    private String str;
    private BufferedReader reader ;
    @Override
    public void open(Map<String, Object> conf, TopologyContext topologyContext, SpoutOutputCollector spoutOutputCollector) {
        System.out.println("Bolt's open method called ...");

        try {
            this.fileReader = new FileReader(conf.get("fileToRead").toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error reading file ["+conf.get("wordFile")+"]");
        }
        this.collector = spoutOutputCollector;
        this.reader =  new BufferedReader(fileReader);
    }

    @Override
    public void nextTuple() {
        if (!completed) {
            try {

                this.str = reader.readLine();
                if (this.str != null) {
                    System.out.println(" Row : " + this.str);
                    System.out.println("Split words : " + this.str.split(","));
                    Object[] arr = this.str.split(",");
                    System.out.println("Split words : arr : " + Arrays.toString(arr) +",  size : " + arr.length);
                    this.collector.emit(new Values(arr));
                } else {
                    completed = true;
                    fileReader.close();
                }

            } catch (Exception e) {
                throw new RuntimeException("Error reading tuple", e);
            }
        }

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {
        outputFieldsDeclarer.declare(new Fields("Region","Product Category","Product","Customer Name","Sales","Cost","Profit"));
    }
}

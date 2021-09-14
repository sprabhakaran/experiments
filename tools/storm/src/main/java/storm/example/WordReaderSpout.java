package storm.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Logger;

import org.apache.storm.spout.SpoutOutputCollector;
import org.apache.storm.task.TopologyContext;
import org.apache.storm.topology.IRichSpout;
import org.apache.storm.topology.OutputFieldsDeclarer;
import org.apache.storm.topology.base.BaseRichSpout;
import org.apache.storm.tuple.Fields;
import org.apache.storm.tuple.Values;

public class WordReaderSpout extends BaseRichSpout {

    private static long counter = 0l;


    static Logger log = Logger.getLogger(WordReaderSpout.class.getName());

    private static final long serialVersionUID = 441966625018520917L;
    private SpoutOutputCollector collector;
    private static Stack<String> stack = new Stack<>();
    private String[] sentences = {
            "Hello World",
            "Apache Storm",
            "Big Data",
            "Big Data",
            "Machine Learning",
            "Hello World",
            "World",
            "Hello"
    };
    boolean completed;
    String fileName;
    private String str;
    private FileReader fileReader;
    private BufferedReader reader ;

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector) {
        log.info("open method called for spout. count :; " + ++counter);
        try {
            this.fileReader = new FileReader(conf.get("fileToRead").toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error reading file [" + conf.get("wordFile") + "]");
        }
        this.collector = collector;
        this.reader =  new BufferedReader(fileReader);

    }


    @Override
    public void nextTuple() {
        log.info("next tuple triggered .... ");
         if (!completed) {
          try {

                this.str = reader.readLine();
                if (this.str != null) {

                    this.collector.emit(new Values(str));
                } else {
                    completed = true;
                    fileReader.close();;
                }

            } catch (Exception e) {
                throw new RuntimeException("Error reading tuple", e);
            }
        }

    }



    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("word"));

    }


}

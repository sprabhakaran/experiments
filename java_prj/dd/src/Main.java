import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File f = new File("/home/local/ZOHOCORP/prabha-1145/Documents/workspace/java_prj/dd/conf/dd.xml");

        try {
            DD dd = DDImpl.loadXML(f);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println(f.getName());
    }
}
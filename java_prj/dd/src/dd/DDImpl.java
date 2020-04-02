package dd;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DDImpl implements DD {

    private String name;

    private List<Table> tableList;
    private PK pk;
    private List<FK> fkList;

    public DDImpl(String name) {
        this.name = name;
        this.tableList = new ArrayList<Table>();
        this.pk = null;
        this.fkList = new ArrayList<FK>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addTable(Table t) {

    }

    @Override
    public Table getTableByName() {
        return null;
    }

    @Override
    public Table[] getTables() throws Exception {
        return new Table[0];
    }

    @Override
    public void addPK(PK pk) {

    }

    @Override
    public PK getPrimaryKey() {
        return null;
    }

    @Override
    public void addFK(FK... fk) {

    }

    @Override
    public FK getForeignKeys() {
        return null;
    }

    public static DD loadXML(File f) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(f);

        document.getDocumentElement().normalize();

        Element ddEl = document.getDocumentElement();

        DDImpl dd = new DDImpl(ddEl.getAttribute("name"));

        NodeList tblList = ddEl.getElementsByTagName("table");

        for(int i=0; i<tblList.getLength(); i++) {
            Element tblNode = (Element)tblList.item(i);

            DDTable t = new DDTable(tblNode.getAttribute("name"));
            t.setDataType(null);
            t.setDescription("");
            t.setNullable(false);
            t.setMaxSize(199);


            System.out.println(tblNode.getAttribute("name"));
        }


        return dd;

    }
}

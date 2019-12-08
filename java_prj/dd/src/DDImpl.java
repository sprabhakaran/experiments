import java.io.File;
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

    public static DD loadXML(File f) {
        DDImpl dd = new DDImpl();
    }
}

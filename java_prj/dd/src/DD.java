
public interface DD {
    public String getName();

    public void addTable(Table t);
    public Table getTableByName();
    public Table[] getTables() throws Exception;

    public void addPK(PK pk);
    public PK getPrimaryKey();

    public void addFK(FK ...fk);
    public FK getForeignKeys();
}

interface Table {
    public String getName();
    public Column[] getColumns();
    public boolean isRel(Table t);
}

interface FK {
    public String getName();
    public String getRefTableName();
    public Constraint getContraint();
}

interface Constraint {
    public String getName();
}

interface PK {
    public String getName();
    public Column[] getColumns();
}

interface FKColumn {
    public FKLocalColumn getLocalColumn();
    public FKRefColumn getRefColumn();
}

interface Column {
    public String getName();
    public String getDescription();
    public String dataType();
    public boolean isNullable();
    public boolean isUniqGen();
    public String getUniqGenName();

    public int getMaxSize();
    public Object defaultValue();
    public Object[] getAllowedValues();
}


interface FKLocalColumn extends Column {}

interface FKRefColumn extends Column {}
package dd;

class DDTable implements Table {

    private String name;
    private DataType type;
    public DDTable(String name){
        this.name = name;
    }

    public void setDataType(DataType t) {
        this.type = t;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Column[] getColumns() {
        return new Column[0];
    }

    @Override
    public boolean isRel(Table t) {
        return false;
    }

    public void setDescription(String s) {
    }

    public void setNullable(boolean b) {
    }

    public void setMaxSize(int i) {
    }

    private class DataType {
    }
}

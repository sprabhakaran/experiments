import java.io.File;

public class Main {
    public static void main(String[] args) {
        File f = new DFile("String");

        System.out.println(f.getName());
    }
}



class DFile extends java.io.File {

    public DFile(String path){
        super(path);
    }

    public String getName(){
        return "Dubuku";
    }
}
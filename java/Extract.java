import java.io.*;
public class Extract{
    public Extract()
    {
    }

    public static void main(String[] args) {

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("irisAfter.txt"));
            String read = null;
            while ((read = in.readLine()) != null) {
                read = in.readLine();
                String[] splited = read.split(",");
                for (int i =0; i<splited.length;i++) {
                    System.out.println(splited[0]);

                }

            }

        } catch (IOException e) {
            System.out.println("There was a problem: " + e);
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (Exception e) {
            }
        }

    }



}

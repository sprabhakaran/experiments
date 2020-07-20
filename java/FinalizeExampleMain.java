import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;


public class FinalizeExampleMain {
    
    // We are declaring the streams that we are going to use here.
    private OutputStream out;
    private BufferedReader reader;
    private FileReader fileReader;
    
    public FinalizeExampleMain() {
        try {
            // On instantiation of the class, we also instantiate the streams
            // that we need to use in the example. We will have to close them
            // afterwards, and this is where finalize() will be used.
            out = new FileOutputStream("example.txt");
            fileReader = new FileReader("example.txt");
            reader = new BufferedReader(fileReader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Just some public accessors for the needed streams.
    public OutputStream getOutputStream() {
        return out;
    }
    
    public BufferedReader getReader() {
        return reader;
    }
    
    // The finalize() method. As seen, we are using it to close all the
    // open streams and NOT to destroy the object itself, as this is useless
    // and dangerous. The GC will take care of that.
    @Override
    public void finalize() throws Throwable {
        try {
            System.out.println(this.getClass().getName() + " is finalized and streams closing!");
            if (out != null) {
                out.close();
                System.out.println("OutputStream closed!");
            }
            if (fileReader != null) {
                fileReader.close();
                System.out.println("FileReader closed!");
            }
            if (reader != null) {
                reader.close();
                System.out.println("BufferedReader closed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("All done!");
            super.finalize();
        }
    }

    // This annotation here is provided by eclipse, because the method
    // System.runFinalizersOnExit(true) that we are using is deprecated and 
    // generally should not be used. We are using it here to show how finalization
    // works, but it is not recommended.
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        System.runFinalizersOnExit(true);
        System.out.println("Starting program...");
        FinalizeExampleMain main = new FinalizeExampleMain();
        
        try {
            // Get the output stream and write a String in the file (in form of bytes).
            main.getOutputStream().write("This is an example.".getBytes());
            
            // Just to make sure that the streams are open and working correctly,
            // We use a BufferedReader to read the file and print everything in it
            // on the stdout.
            String line;
            while ((line = main.getReader().readLine()) != null) {
                System.out.println("Line read: " + line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Here we are forcing the program to run all the implemented
        // finalize() methods when the program finishes. Again, not recommended!
        System.out.println("Program exiting. The finalizers should run now.");
    }
}

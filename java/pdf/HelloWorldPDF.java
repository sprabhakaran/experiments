import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.*;
public class HelloWorldPDF
{
   public static void main(String[] args) throws Exception {
      Document document = new Document();
      PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
      document.open();
      document.add(new Paragraph("Hello World"));
      document.close();
   }
} 

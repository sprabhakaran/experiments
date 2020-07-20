import java.io.*;
public class LastLine
{
  public static String getLastNLogLines(File file, int nLines) 
  {
    java.io.RandomAccessFile fileHandler = null;
    try 
    {
      fileHandler = new java.io.RandomAccessFile( file, "r" );
      long fileLength = fileHandler.length() - 1;
      StringBuilder sb = new StringBuilder();
      int line = 0;

      for(long filePointer = fileLength; filePointer != -1; filePointer--)
      {
        fileHandler.seek( filePointer );
        char readByte = (char)fileHandler.readByte();
        if(readByte == '\n' && !sb.toString().equals(""))
        {
          break;
        }
        sb.append( readByte );
      }

      String lastLine = sb.reverse().toString();
      return lastLine;
    } 
    catch( java.io.IOException e ) 
    {
      e.printStackTrace();
      return null;
    }
    finally 
    {
      if (fileHandler != null )
      {
        try {
          fileHandler.close();
        } catch (IOException e) { }
    }
  }
  public static String tail2( File file, int lines) 
  {
    java.io.RandomAccessFile fileHandler = null;
    try {
      fileHandler = new java.io.RandomAccessFile( file, "r" );
      long fileLength = fileHandler.length() - 2;
      StringBuilder sb = new StringBuilder();
      int line = 0;

      for(long filePointer = fileLength; filePointer != -1; filePointer--){
        fileHandler.seek( filePointer );
        int readByte = fileHandler.readByte();

        if( readByte == 0xA ) 
        {
          line = line + 1;
          if (line == lines) {
            if (filePointer == fileLength) {
              continue;
            }
            break;
          }
        } else if( readByte == 0xD ) {
          line = line + 1;
          if (line == lines) {
            if (filePointer == fileLength - 1) {
              continue;
            }
            break;
          }
        }
        sb.append( ( char ) readByte );
      }

      String lastLine = sb.reverse().toString();
      return lastLine;
    } catch( java.io.FileNotFoundException e ) {
      e.printStackTrace();
      return null;
    } catch( java.io.IOException e ) {
      e.printStackTrace();
      return null;
    }
    finally {
      if (fileHandler != null )
        try {
          fileHandler.close();
        } catch (IOException e) {
        }
    }
  }
  public static void main ( String arg[])
  { 
    //String s = tail2(new File("test.txt"),1);
    String s = getLastNLogLines(new File("test.txt"),1);
    System.out.println(s);
  }
}

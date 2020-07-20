import java.sql.*;

public class MySQLCon
{
  public static void main(String[] args) {
    System.out.println("MySQL Connect Example.");
    Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/prabhakaran?useUnicode=true&characterEncoding=UTF-8";
    String driver = "com.mysql.jdbc.Driver";
    String userName = "root"; 
    String password = "";
    try {
      Class.forName(driver).newInstance();
      conn = DriverManager.getConnection(url,userName,password);
      System.out.println("Connected to the database");
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("select * from topictest");

      while (rs.next()) 
      {
        String dbtime = rs.getString(2);
        System.out.println(dbtime);
      }
      conn.close();
      System.out.println("Disconnected from database");
    } catch (Exception e) {
      e.printStackTrace();
    }

  }
}

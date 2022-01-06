import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public static void main(String[] args) {
    launch();
     String driver = "com.mysql.cj.jdbr.Driver";
     String url = "jdbc:msql://localhost:3306/handphone";
     String user = "root";
      String pass ="";

      try {
         Connection con =  DriverManager.getConnection(url, user, pass);
        System.out.println("Koneksi Berhasil");
     } catch (SQLException e) {
         // TODO Auto-generated catch block
          System.out.println("Koneksi Gagal");
     }

 }

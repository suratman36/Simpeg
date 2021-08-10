package Koneksi;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
private Connection koneksi;
public Connection open(){
try{
Class.forName("com.mysql.jdbc.Driver");
System.out.println("koneksi berhasil");
}
catch(ClassNotFoundException ex){
System.out.println("koneksi gagal"+ex);
}
String url = "jdbc:mysql://localhost/dbsimpeg";
try{
koneksi = DriverManager.getConnection(url,"root","");
System.out.println("koneksi database berhasil");
}
catch (SQLException ex){
System.out.println("koneksi database gagal"+ex);
}
return koneksi;
}
}
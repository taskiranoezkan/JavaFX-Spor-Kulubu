package VeriTabaniBaglan; 
import java.sql.*;  



public class BaglanVeriTabani {
	static Connection conn=null;
	
	public static Connection Baglan() {
		try {
			//jdbc:mysql://ServerIPAdresi/db_ismi","kullanici","sifre"
			conn=DriverManager.getConnection("jdbc:mysql://localhost/projemdb","root","");
			return conn;
		} catch (Exception e) {
			System.out.println(e.getMessage().toString());
			return null;
		}
	}
}

package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;


public class MysqlCon{
	private String driver = "org.gjt.mm.mysql.Driver", 
				   url 	  = "jdbc:mysql://localhost:3306/projectmaneger",
			   	   user   = "root",
			   	   passwd = "";
	protected Connection con = null;
	protected PreparedStatement st = null;

	protected Connection getConnection(){ 
		Connection conexao = null; 
		
		try {
			Class.forName(driver);
			conexao = DriverManager.getConnection(url,user,passwd);
		} catch (Exception e) {
			System.out.println(e);
		} 
		return conexao;
	}	
	
	protected void closeConnect(Connection con, Statement st, ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void executeSQL(Connection con, String sql){
		con = getConnection();
		try {
			st = (PreparedStatement) con.prepareStatement(sql);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}

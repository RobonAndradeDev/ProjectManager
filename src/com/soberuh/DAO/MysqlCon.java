package com.soberuh.DAO;
import com.mysql.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


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
	
	protected void closeConnect(Statement st, ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
			st.close();
			this.con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void executeSQL(String sql){
		this.con = getConnection();
		try {
			st = (PreparedStatement) this.con.prepareStatement(sql);
		} catch (Exception e) {
			System.out.println("Error: " + e);
		}
	}
}

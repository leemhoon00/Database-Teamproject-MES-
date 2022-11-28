package company_control;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import dbconn.dbconn;

public class Company_Select {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	
	public Company_Select(){
		driver = dbconn.getDriver();
		jdbcDriver = dbconn.getjdbcDriver();
		dbUser = dbconn.getdbUser();
		dbPass = dbconn.getdbPass();
		
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<String> get_Client_Company(){
		List<String> list = new ArrayList<String>();
		
		String sql = "select company_name from company where client_company='Y'";
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String s = new String();
				s = rs.getString("company_name");
				
				list.add(s);
			}
			
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public String get_Company_Name(String order_number) {
		String company_name="";
		String sql = "select company_name from order_table where order_number="+order_number;
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			company_name = rs.getString("company_name");
			
			
			rs.close();
			stmt.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return company_name;
	}
}

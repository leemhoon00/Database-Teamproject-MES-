package company_control;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dbconn.dbconn;
import entity.Company;

public class Company_Search {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	
	public Company_Search(){
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
	
	// 모든 회사 검색
	public List<Company> getAllList(){
		List<Company> list = new ArrayList<Company>();
		
		String sql = "select * from company";
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Company c = new Company();
				c.setCompany_name(rs.getString("company_name"));
				c.setClient_company(rs.getString("client_company"));
				c.setOutsourcing_company(rs.getString("outsourcing_company"));
				
				list.add(c);
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
	
	public List<Company> getSearchedList(String company_name){
		List<Company> list = new ArrayList<Company>();
		
		String sql = "select * from company where company_name like '%"+company_name+"%'";
		
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Company c = new Company();
				c.setCompany_name(rs.getString("company_name"));
				c.setClient_company(rs.getString("client_company"));
				c.setOutsourcing_company(rs.getString("outsourcing_company"));
				
				list.add(c);
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
}

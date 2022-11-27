package company_control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbconn.dbconn;
import entity.Company;

public class Company_Information {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	
	public Company_Information() {
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
	
	public Company getCompanyInformation(String company_name) {
		Company c = new Company();
		
		// 선택한 테이블이 없는 경우
		if(company_name.equals("0")) {
			c.setCompany_name("");
			c.setClient_company("");
			c.setOutsourcing_company("");
		}
		else {
			String sql = "select * from company where company_name='"+company_name+"'";
			
			try {
				conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					c.setCompany_name(rs.getString("company_name"));
					c.setClient_company(rs.getString("client_company"));
					c.setOutsourcing_company(rs.getString("outsourcing_company"));
				}
				
				rs.close();
				stmt.close();
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return c;
		
	}
}

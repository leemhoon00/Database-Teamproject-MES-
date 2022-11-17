package control;

import java.sql.*;
import dbconn.dbconn;

public class Login_control {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	
	public Login_control() {
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
	
	public boolean Login(String id, String pw) {
		
		String sql = "select * from worker where id='"+id+"'";
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			stmt=conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				String password = rs.getString("pw");
				if(password.equals(pw)) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				rs.close();
				stmt.close();
				conn.close();
				return false;
			}
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}

package facility_control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbconn.dbconn;
import entity.Facility;

public class Facility_Information {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	
	public Facility_Information() {
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
	
	public Facility getFacilityInformation(String facility_name) {
		Facility f = new Facility();
		
		// 선택한 테이블이 없는 경우
		if(facility_name.equals("0")) {
			f.setFacility_name("");
			f.setStatus("");
			f.setMinute_cost(0);
		}
		else {
			String sql = "select * from facility where facility_name='"+facility_name+"'";
			
			try {
				conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					f.setFacility_name(rs.getString("facility_name"));
					f.setStatus(rs.getString("status"));
					f.setMinute_cost(rs.getInt("minute_cost"));
					
				}
				
				rs.close();
				stmt.close();
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return f;
		
	}
}

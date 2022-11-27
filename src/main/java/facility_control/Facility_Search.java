package facility_control;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dbconn.dbconn;
import entity.Facility;

public class Facility_Search {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	
	public Facility_Search(){
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
	
	public List<Facility> getAllList(){
		List<Facility> list = new ArrayList<Facility>();
		
		String sql = "select * from facility";
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Facility f = new Facility();
				f.setFacility_name(rs.getString("facility_name"));
				f.setStatus(rs.getString("status"));
				f.setMinute_cost(rs.getInt("minute_cost"));
				
				list.add(f);
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

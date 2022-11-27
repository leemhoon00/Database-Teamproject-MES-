package facility_control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbconn.dbconn;
import entity.Facility;
import entity.Worker;

public class Facility_Control {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	
	public Facility_Control() {
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
	
	//설비 등록
	public Boolean InsertFacility(Facility f) {
		String sql = "insert into facility values(?,?,?)";
		int temp=0;
		
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, f.getFacility_name());
			pstmt.setString(2, f.getStatus());
			pstmt.setInt(3, f.getMinute_cost());
			
			temp = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		if(temp==0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public Boolean UpdateFacility(Facility f) {
		int temp=0;
		try {
			String sql = "update facility set status=?, minute_cost=? where facility_name=?";
			
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, f.getStatus());
			pstmt.setInt(2, f.getMinute_cost());
			pstmt.setString(3, f.getFacility_name());
			
			temp = pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		if(temp==0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public Boolean DeleteFacility(String facility_name) {
		int temp=0;
		
		try {
			String sql = "delete from facility where facility_name='"+facility_name+"'";
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			stmt = conn.createStatement();
			
			temp = stmt.executeUpdate(sql);
			stmt.close();
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		if(temp==0) {
			return false;
		}
		else {
			return true;
		}
	}
}

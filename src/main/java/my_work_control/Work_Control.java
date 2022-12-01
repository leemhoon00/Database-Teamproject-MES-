package my_work_control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbconn.dbconn;
import entity.Order;
import entity.Work;

public class Work_Control {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	
	public Work_Control() {
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
	
	public Boolean InsertWork(Work w) {
		String sql = "insert into work_list(work_number, part_name, facility_name, worker, start_time,  faulty, quantity, reg_date, end_time) values(work_list_auto_increment.nextval,?,?,?,to_date(?,'YYYY-MM-DD hh24:mi:ss'),?,?,sysdate,to_date(?,'YYYY-MM-DD hh24:mi:ss'))";
		int temp=0;
		
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			pstmt = conn.prepareStatement(sql);
			
			
			
			pstmt.setString(1, w.getPart_name());
			pstmt.setString(2, w.getFacility_name());
			pstmt.setString(3, w.getWorker());
			pstmt.setString(4, w.getStart_time());
			pstmt.setString(5, w.getFaulty());
			pstmt.setInt(6,  w.getQuantity());
			pstmt.setString(7, w.getEnd_time());
			
			
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
	
	
	public Boolean UpdateWork(Work o) {
		int temp=0;
		try {
			String sql = "update work_list set start_time=to_date(?,'YYYY-MM-DD hh24:mi:ss'), end_time=to_date(?,'YYYY-MM-DD hh24:mi:ss'), faulty=? where work_number=?";
			
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, o.getStart_time());
			pstmt.setString(2, o.getEnd_time());
			pstmt.setString(3, o.getFaulty());
			pstmt.setInt(4, o.getWork_number());
			
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
	
	public Boolean DeleteWork(int work_number) {
		int temp=0;
		
		try {
			String sql = "delete from work_list where work_number="+work_number;
			
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			stmt = conn.createStatement();
			
			temp = stmt.executeUpdate(sql);
			stmt.close();
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
}

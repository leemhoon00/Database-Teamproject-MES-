package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbconn.dbconn;
import entity.Worker;

public class Worker_Control {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	
	public Worker_Control() {
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
	
	
	
	
	// 작업자 등록
	public Boolean InsertWorker(Worker w) {
		String sql = "insert into worker values(?,?,?,?,?)";
		int temp=0;
		
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, w.getID());
			pstmt.setString(2, w.getPW());
			pstmt.setString(3, w.getName());
			pstmt.setString(4, w.getPosition());
			pstmt.setString(5, w.getPhone_number());
			
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
	
	public Boolean UpdateWorker(Worker w) {
		int temp=0;
		try {
			String sql = "update worker set PW=?, name=?, position=?, phone_number=? where id=?";
			
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, w.getPW());
			pstmt.setString(2, w.getName());
			pstmt.setString(3, w.getPosition());
			pstmt.setString(4, w.getPhone_number());
			pstmt.setString(5, w.getID());
			
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
	
	public Boolean DeleteWorker(String id) {
		int temp=0;
		
		try {
			String sql = "delete from worker where id='"+id+"'";
			
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

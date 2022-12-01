package outsourcing_control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbconn.dbconn;
import entity.Outsourcing;

public class Outsourcing_Control {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	
	public Outsourcing_Control() {
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
	
	public Boolean InsertOutsourcing(Outsourcing o) {
		String sql = "insert into outsourcing_list values(outsourcing_list_auto_increment.nextval,?,?,?,?,?,?,?,?,sysdate)";
		
		int temp=0;
		
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			pstmt = conn.prepareStatement(sql);
			
			
			
			pstmt.setString(1, o.getPart_name());
			pstmt.setString(2, o.getCompany_name());
			pstmt.setInt(3, o.getPrice());
			pstmt.setString(4, o.getWorker());
			pstmt.setString(5, o.getExp_date());
			pstmt.setString(6,  o.getStart_date());
			pstmt.setString(7, o.getEnd_date());
			pstmt.setInt(8, o.getQuantity());
			
			
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
	
	public Boolean UpdateOutsourcing(Outsourcing o) {
		int temp=0;
		try {
			String sql = "update outsourcing_list set exp_date=?, start_date=?, end_date=? where outsourcing_number=?";
			
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, o.getExp_date());
			pstmt.setString(2, o.getStart_date());
			pstmt.setString(3, o.getEnd_date());
			pstmt.setInt(4, o.getOutsourcing_number());
			
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
	
	public Boolean DeleteOutsourcing(int outsourcing_number) {
		int temp=0;
		
		try {
			String sql = "delete from outsourcing_list where outsourcing_number="+outsourcing_number;
			
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

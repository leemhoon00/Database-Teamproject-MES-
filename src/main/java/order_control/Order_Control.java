package order_control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbconn.dbconn;
import entity.Order;
import entity.Worker;

public class Order_Control {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	
	public Order_Control() {
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
	
	
	public Boolean InsertOrder(Order o) {
		String sql = "insert into order_table values(order_auto_increment.nextval,?,?,?,?,sysdate,?,?,?,?)";
		int temp=0;
		
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			pstmt = conn.prepareStatement(sql);
			
			
			pstmt.setString(1, o.getOrder_name());
			pstmt.setString(2, o.getCompany_name());
			pstmt.setString(3, o.getPart_name());
			pstmt.setInt(4, o.getQuantity());
			pstmt.setInt(5, o.getOrder_price());
			pstmt.setString(6, o.getExp_date());
			pstmt.setString(7,  o.getEnd_date());
			pstmt.setString(8, o.getNote());
			
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
}

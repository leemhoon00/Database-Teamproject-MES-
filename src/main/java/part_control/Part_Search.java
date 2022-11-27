package part_control;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dbconn.dbconn;
import entity.Part;

public class Part_Search {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	
	public Part_Search(){
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
	
	// 葛电 何前 八祸
	public List<Part> getAllList(){
		List<Part> list = new ArrayList<Part>();
		
		String sql = "select * from part";
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Part p = new Part();
				p.setPart_name(rs.getString("part_name"));
				p.setPrice(rs.getInt("price"));
				p.setQuantity(rs.getInt("quantity"));
				p.setSafety_quantity(rs.getInt("safety_quantity"));
				
				list.add(p);
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
	
	// 何前 八祸
	public List<Part> getSearchedList(String part_name){
		List<Part> list = new ArrayList<Part>();
		
		String sql = "select * from part where part_name like '%"+part_name+"%'";
		
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Part p = new Part();
				p.setPart_name(rs.getString("part_name"));
				p.setPrice(rs.getInt("price"));
				p.setQuantity(rs.getInt("quantity"));
				p.setSafety_quantity(rs.getInt("safety_quantity"));
				
				list.add(p);
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

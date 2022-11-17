package control;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dbconn.dbconn;
import entity.Worker;

public class Worker_Search {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	
	//작업자 검색 컨트롤 클래스
	public Worker_Search(){
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
	
	// 모든 작업자 검색
	public List<Worker> getAllList(){
		List<Worker> list = new ArrayList<Worker>();
		
		String sql = "select * from worker";
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Worker w = new Worker();
				w.setID(rs.getString("ID"));
				w.setName(rs.getString("name"));
				w.setPhone_number(rs.getString("phone_number"));
				w.setPosition(rs.getString("position"));
				w.setPW(rs.getString("PW"));
				
				list.add(w);
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
	
	public List<Worker> getSearchedList(String name){
		List<Worker> list = new ArrayList<Worker>();
		
		String sql = "select * from worker where name like '%"+name+"%'";
		
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Worker w = new Worker();
				w.setID(rs.getString("ID"));
				w.setName(rs.getString("name"));
				w.setPhone_number(rs.getString("phone_number"));
				w.setPosition(rs.getString("position"));
				w.setPW(rs.getString("PW"));
				
				list.add(w);
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

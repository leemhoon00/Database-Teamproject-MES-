package my_work_control;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dbconn.dbconn;
import entity.Work;

public class Work_Search {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	
	public Work_Search(){
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
	
	public List<Work> getWorkList(){
		List<Work> list = new ArrayList<Work>();
		
		String sql = "select * from work_list where end_time is null";
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Work w = new Work();
				
				w.setWork_number(rs.getInt("work_number"));
				w.setPart_name(rs.getString("part_name"));
				w.setFacility_name(rs.getString("facility_name"));
				w.setStart_time(rs.getString("start_time"));
				w.setFaulty(rs.getString("faulty"));
				w.setQuantity(rs.getInt("quantity"));
				
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

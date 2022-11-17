package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbconn.dbconn;
import entity.Worker;


public class Worker_Information {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	
	public Worker_Information() {
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
	
	public Worker getWorkerInformation(String id) {
		Worker w = new Worker();
		
		// 선택한 테이블이 없는 경우
		if(id.equals("0")) {
			w.setID("");
			w.setName("");
			w.setPhone_number("");
			w.setPosition("");
			w.setPW("");
		}
		else {
			String sql = "select * from worker where id='"+id+"'";
			
			try {
				conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					w.setID(rs.getString("id"));
					w.setName(rs.getString("name"));
					w.setPhone_number(rs.getString("phone_number"));
					w.setPosition(rs.getString("position"));
					w.setPW(rs.getString("PW"));
				}
				
				rs.close();
				stmt.close();
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return w;
		
	}
	
}

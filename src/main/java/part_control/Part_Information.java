package part_control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbconn.dbconn;
import entity.Part;

public class Part_Information {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	
	public Part_Information() {
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
	
	public Part getPartInformation(String part_name) {
		Part p = new Part();
		
		// 선택한 테이블이 없는 경우
		if(part_name.equals("0")) {
			p.setPart_name("");
			p.setPrice(0);
			p.setQuantity(0);
			p.setSafety_quantity(0);
		}
		else {
			String sql = "select * from part where part_name='"+part_name+"'";
			
			try {
				conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					p.setPart_name(rs.getString("part_name"));
					p.setPrice(rs.getInt("price"));
					p.setQuantity(rs.getInt("quantity"));
					p.setSafety_quantity(rs.getInt("safety_quantity"));
				}
				
				rs.close();
				stmt.close();
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return p;
		
	}
}

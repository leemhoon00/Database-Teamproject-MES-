package outsourcing_control;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dbconn.dbconn;
import entity.Outsourcing;

public class Outsourcing_Search {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	
	public Outsourcing_Search(){
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
	
	public List<Outsourcing> getOutsourcingList(){
		List<Outsourcing> list = new ArrayList<Outsourcing>();
		
		String sql = "select * from outsourcing_list where end_date is null";
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Outsourcing o = new Outsourcing();
				
				o.setOutsourcing_number(rs.getInt("outsourcing_number"));
				o.setPart_name(rs.getString("part_name"));
				o.setCompany_name(rs.getString("company_name"));
				o.setQuantity(rs.getInt("quantity"));
				o.setPrice(rs.getInt("price"));
				o.setExp_date(rs.getString("exp_date"));
				o.setStart_date(rs.getString("start_date"));
				
				list.add(o);
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

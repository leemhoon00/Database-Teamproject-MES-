package order_control;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dbconn.dbconn;
import entity.Order;

public class Order_Search {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	
	public Order_Search(){
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
	
	// 전체 검색
	public List<Order> getAllList(){
		List<Order> list = new ArrayList<Order>();
		
		String sql = "select * from order_table";
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Order o = new Order();
				o.setCompany_name(rs.getString("company_name"));
				o.setEnd_date(rs.getString("end_date"));
				o.setExp_date(rs.getString("exp_date").substring(0,10));
				o.setNote(rs.getString("note"));
				o.setOrder_date(rs.getString("order_date"));
				o.setOrder_name(rs.getString("order_name"));
				o.setOrder_number(rs.getInt("order_number"));
				o.setOrder_price(rs.getInt("order_price"));
				o.setPart_name(rs.getString("part_name"));
				o.setQuantity(rs.getInt("quantity"));
				
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
	
	
	// 진행중 수주 검색
	public List<Order> getProcessingList(){
		List<Order> list = new ArrayList<Order>();
		
		String sql = "select * from order_table where end_date is null";
		
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Order o = new Order();
				o.setCompany_name(rs.getString("company_name"));
				o.setEnd_date(rs.getString("end_date"));
				o.setExp_date(rs.getString("exp_date").substring(0,10));
				o.setNote(rs.getString("note"));
				o.setOrder_date(rs.getString("order_date"));
				o.setOrder_name(rs.getString("order_name"));
				o.setOrder_number(rs.getInt("order_number"));
				o.setOrder_price(rs.getInt("order_price"));
				o.setPart_name(rs.getString("part_name"));
				o.setQuantity(rs.getInt("quantity"));
				
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
	
	
	// 완료 수주 검색
		public List<Order> getCompleteList(){
			List<Order> list = new ArrayList<Order>();
			
			String sql = "select * from order_table where end_date is not null";
			
			try {
				conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				while(rs.next()) {
					Order o = new Order();
					o.setCompany_name(rs.getString("company_name"));
					o.setEnd_date(rs.getString("end_date"));
					o.setExp_date(rs.getString("exp_date").substring(0,10));
					o.setNote(rs.getString("note"));
					o.setOrder_date(rs.getString("order_date"));
					o.setOrder_name(rs.getString("order_name"));
					o.setOrder_number(rs.getInt("order_number"));
					o.setOrder_price(rs.getInt("order_price"));
					o.setPart_name(rs.getString("part_name"));
					o.setQuantity(rs.getInt("quantity"));
					
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

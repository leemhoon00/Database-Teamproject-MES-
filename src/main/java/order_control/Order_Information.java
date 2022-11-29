package order_control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dbconn.dbconn;
import entity.Order;

public class Order_Information {
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	
	public Order_Information() {
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
	
	public Order getOrderInformation(String order_number) {
		Order o = new Order();
		
		// 선택한 테이블이 없는 경우
		if(order_number.equals("0")) {
			o.setCompany_name("");
			o.setEnd_date("");
			o.setExp_date("");
			o.setNote("");
			o.setOrder_date("");
			o.setOrder_name("");
			o.setOrder_number(0);
			o.setOrder_price(0);
			o.setPart_name("");
			o.setQuantity(0);
			
		}
		else {
			String sql = "select * from order_table where order_number="+order_number+"";
			
			try {
				conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
				
				if(rs.next()) {
					o.setCompany_name(rs.getString("company_name"));
					o.setEnd_date(rs.getString("end_date"));
					o.setExp_date(rs.getString("exp_date"));
					o.setNote(rs.getString("note"));
					o.setOrder_date(rs.getString("order_date"));
					o.setOrder_name(rs.getString("order_name"));
					o.setOrder_number(rs.getInt("order_number"));
					o.setOrder_price(rs.getInt("order_price"));
					o.setPart_name(rs.getString("part_name"));
					o.setQuantity(rs.getInt("quantity"));
					
					if(o.getEnd_date()!=null) {
						o.setEnd_date(o.getEnd_date().substring(0,10));
					}
					else {
						o.setEnd_date("");
					}
					if(o.getExp_date()!=null) {
						o.setExp_date(o.getExp_date().substring(0,10));
					}
					if(o.getOrder_date()!=null) {
						o.setOrder_date(o.getOrder_date().substring(0,10));
					}
					if(o.getNote()==null) {
						o.setNote("");
					}
				}
				
				rs.close();
				stmt.close();
				conn.close();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return o;
		
	}
	
	
}

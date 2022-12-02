package facility_control;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import dbconn.dbconn;
import entity.Facility_Time;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;


public class Get_Working_Time {
	private Connection conn;
	private ResultSet rs;
	
	private String driver;
	private String jdbcDriver;
	private String dbUser;
	private String dbPass;
	private CallableStatement cstmt;
	private OracleCallableStatement ocstmt;
	
	public Get_Working_Time() {
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
	
	public List<Facility_Time> getAllList(){
		List<Facility_Time> list = new ArrayList<Facility_Time>();
		
		try {
			conn = DriverManager.getConnection(jdbcDriver,dbUser,dbPass);
			cstmt = conn.prepareCall("begin get_facility_time(?); end;");
			cstmt.registerOutParameter(1,OracleTypes.CURSOR);
			
			cstmt.executeQuery();
			
			ocstmt = (OracleCallableStatement)cstmt;
			rs = ocstmt.getCursor(1);
			
			while(rs.next()) {
				Facility_Time f = new Facility_Time();
				f.setFacility_name(rs.getString("facility_name"));
				f.setWorking_time(rs.getInt("working_time"));
				
				list.add(f);
			}
			
			rs.close();
			ocstmt.close();
			cstmt.close();
			conn.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}

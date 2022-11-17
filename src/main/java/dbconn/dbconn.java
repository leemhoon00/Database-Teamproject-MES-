package dbconn;

public abstract class dbconn {
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String jdbcDriver = "jdbc:oracle:thin:@localhost:1521:XE"; 
	static String dbUser = "dbteam"; 
	static String dbPass = "qwer1234";
	
	static public String getDriver() {
		return driver;
	}
	static public String getjdbcDriver() {
		return jdbcDriver;
	}
	static public String getdbUser() {
		return dbUser;
	}
	static public String getdbPass() {
		return dbPass;
	}
}

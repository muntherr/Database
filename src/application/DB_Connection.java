package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB_Connection {

	private static String dbUsername = "root"; // database username
	private static String dbPassword = "Munder.14"; // database password
	private static String URL = "127.0.0.1"; // server location
	private static String port = "3306"; // port that mysql uses
	private static String dbName = "PAC"; // database on mysql to connect to
	public static Connection con;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		DBConn a = new DBConn(URL, port, dbName, dbUsername, dbPassword);
		String SQL;

		// con = a.connectDB();
		// System.out.println("Connection established");

		// SQL = "select Job_ID,Sname,S_ID, Address, Phone from salesmen order by
		// Job_ID";

		// Statement stmt = con.createStatement();
		/// ResultSet rs = stmt.executeQuery(SQL);

		// while (rs.next())
		// System.out.println(rs.getString(1) + " " + rs.getString(2) + " " +
		// rs.getString(3) + " " + rs.getString(4));

		// rs.close();
		// stmt.close();

		con.close();
	}

	public static void close() throws ClassNotFoundException, SQLException {
	con.close();
	}
//}

	public static ResultSet select(String SQL) throws SQLException, ClassNotFoundException {
		System.out.println(SQL);
		DBConn a = new DBConn(URL, port, dbName, dbUsername, dbPassword);
		con = a.connectDB();
		Statement stmt = con.createStatement();
		return stmt.executeQuery(SQL);
	}

	public static void execute(String SQL) throws ClassNotFoundException, SQLException {
		System.out.println(SQL);
		DBConn a = new DBConn(URL, port, dbName, dbUsername, dbPassword);
		con = a.connectDB();
		Statement stmt = con.createStatement();
		stmt.executeUpdate(SQL);
		stmt.close();
		con.close();
	}
}

class DBConn {

	private Connection con;
	private String dbURL;
	private String dbUsername;
	private String dbPassword;
	private String URL;
	private String port;
	private String dbName;

	DBConn(String URL, String port, String dbName, String dbUsername, String dbPassword) {
		this.URL = URL;
		this.port = port;
		this.dbName = dbName;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
	}

	public Connection connectDB() throws ClassNotFoundException, SQLException {
		dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
		Properties p = new Properties();
		p.setProperty("user", dbUsername);
		p.setProperty("password", dbPassword);
		p.setProperty("useSSL", "false");
		p.setProperty("autoReconnect", "true");
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(dbURL, p);
		return con;
	}
}
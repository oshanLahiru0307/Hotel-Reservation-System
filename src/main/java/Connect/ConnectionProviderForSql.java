package Connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProviderForSql {

	private static String url = "jdbc:mysql://localhost:3306/hotel";
	private static String user = "root";
	private static String Pass = "Lahiru@123";
	private static Connection con;

	public static Connection getConnection() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, Pass);

		} catch (Exception e) {

			System.out.println("Database connection is not succesfull");

		}

		return con;

	}
}

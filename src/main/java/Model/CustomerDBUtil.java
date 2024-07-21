package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.Customer;

public class CustomerDBUtil {

	public static List<Customer> Validate() {

		ArrayList<Customer> cus = new ArrayList<>();

		// database connection
		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "root";
		String Pass = "Lahiru@22";

		// validate

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, Pass);

			Statement stmt = con.createStatement();

			String sql = "select * from customer";

			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {

				int id = rs.getInt(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String username = rs.getString(5);
				String password = rs.getString(6);

				Customer c = new Customer(id, name, phone, email, username, password);
				cus.add(c);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return cus;
	}

}

package Model;
import Connect.ConnectionProviderForSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StaffDBUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
public static boolean insertStaffRegistration(String name,String phone,String email,String position,String uname,String pwd) {
		
		boolean isSuccess = false;
				
		try {
		

			con = ConnectionProviderForSql.getConnection();
			stmt= con.createStatement();
			String sql = "insert into staff_details values ('0','"+name+"','"+phone+"','"+email+"','"+uname+"','"+position+"','"+pwd+"')";	
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				
				isSuccess = true;
				
			}else {
				
				isSuccess = false;
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();			
		}
		
		return isSuccess;
	}

public static boolean  updateStaff(String id,String name,String phone,String email,String position,String uname,String pwd){
		

	boolean isSuccess = false;
	
	try {
		

		con = ConnectionProviderForSql.getConnection();
		stmt= con.createStatement();
		
		String sql = "update staff_details set name = '"+name+"',phone = '"+phone+"', email = '"+email+"',"
				     + "   position = '"+position+"',username = '"+uname+"',password = '"+pwd+"' where id = '"+id+"' ";	
		
		int rs = stmt.executeUpdate(sql);
		
		if(rs > 0) {
			
			isSuccess = true;
			
		}else {
			
			isSuccess = false;
			
		}
		
	}catch(Exception e){
		
		e.printStackTrace();
		
	}
	
	return isSuccess;
}

}

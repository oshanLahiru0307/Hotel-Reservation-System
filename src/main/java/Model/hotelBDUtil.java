package Model;

import java.sql.Connection;
import Connect.ConnectionProviderForSql;
import java.sql.ResultSet;
import java.sql.Statement;

public class hotelBDUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
public static boolean insertHotels(String name,String location,String country,String phone,String email) {
		
		boolean isSuccess = false;
		
		try {
		
			con = ConnectionProviderForSql.getConnection();
			stmt= con.createStatement();
			
			String sql = "insert into hotels_details values ('0','"+name+"','"+location+"','"+country+"','"+phone+"','"+email+"')";	
			
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
	
public static boolean  updateHotels(String id,String name,String location,String country,String phone,String email){
	

	boolean isSuccess = false;
	
	try {
		
		con = ConnectionProviderForSql.getConnection();
		stmt= con.createStatement();
		
		String sql = "update hotels_details set name = '"+name+"',location = '"+location+"', country = '"+country+"',phone = '"+phone+"',email = '"+email+"' where id = '"+id+"' ";	
		
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

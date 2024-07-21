package Model;
import Connect.ConnectionProviderForSql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import Connect.ConnectionProviderForSql;

public class CardDetailsDBUtil {
	
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
public static boolean insertCardDetails(String fname,String lname,String cnum,String exdate,String cvc) {
		
		boolean isSuccess = false;
		
		try {
		
			con = ConnectionProviderForSql.getConnection();
			stmt= con.createStatement();
			
			String sql = "insert into payment_details values ('0','"+fname+"','"+lname+"','"+cnum+"','"+exdate+"','"+cvc+"')";	
			
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
	
public static boolean  updateCardDetails(String id,String fname,String lname,String cnum,String exdate,String cvc){
	

	boolean isSuccess = false;
	
	try {
		
		con = ConnectionProviderForSql.getConnection();
		stmt= con.createStatement();
		
		String sql = "update payment_details set first_name = '"+fname+"',last_name = '"+lname+"', card_number = '"+cnum+"',expiry_date = '"+exdate+"',cvc = '"+cvc+"' where id = '"+id+"' ";	
		
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

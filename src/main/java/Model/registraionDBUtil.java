package Model;

import java.sql.Connection;
import Connect.ConnectionProviderForSql;
import java.sql.ResultSet;
import java.sql.Statement;

public class registraionDBUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;

public static boolean insertRegistration(String name,String phone,String email,String uname,String pwd) {
		
		boolean isSuccess = false;
		
		try {
		
			con = ConnectionProviderForSql.getConnection();
			stmt= con.createStatement();
			
			String sql = "insert into customer values ('0','"+name+"','"+phone+"','"+email+"','"+uname+"','"+pwd+"')";	
			
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
	
public static boolean  updateCustomer(String id,String name,String phone,String email,String uname,String pwd){
	

	boolean isSuccess = false;

	try {
		
		con = ConnectionProviderForSql.getConnection();
		stmt= con.createStatement();
		
		String sql = "update customer set Name = '"+name+"',Phone = '"+phone+"', Email = '"+email+"',UserName = '"+uname+"',Paaword = '"+pwd+"' where Cus_id = '"+id+"' ";	
		
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

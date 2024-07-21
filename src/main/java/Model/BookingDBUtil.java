package Model;
import java.sql.Connection;
import Connect.ConnectionProviderForSql;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Entity.Booking;


public class BookingDBUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
public static boolean insertBooking(String name,String phone,String email,String fdate,String tdate,String hotelID,String num_pers,String status) {
		
		boolean isSuccess = false;
		
		
		try {
		
			con = ConnectionProviderForSql.getConnection();
			stmt= con.createStatement();
			
			String sql = "insert into booking_details values ('0','"+name+"','"+phone+"','"+email+"','"+fdate+"','"+tdate+"','"+hotelID+"','"+num_pers+"','"+status+"')";	
			
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
	
	
	public static List<Booking> getBookingDetails(){
		
		ArrayList<Booking> bookings= new ArrayList<Booking>();
		

		
		try {
			
			con = ConnectionProviderForSql.getConnection();
			stmt= con.createStatement();
			
			String sql = "select * from booking_details ";	
			
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				
				String ID = rs.getString(1);
				String name = rs.getString(2);
				String phone = rs.getString(3);
				String email = rs.getString(4);
				String fdate = rs.getString(5);
				String tdate = rs.getString(6);
				String hID = rs.getString(6);
				String nPers = rs.getString(7);
				
				Booking b = new Booking(ID,name,phone,email,fdate,tdate,hID,hID, nPers);
				bookings.add(b); 
				
				
			}
			
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}
		
		return bookings;
	}
	
	
    public static boolean  updateBooking(String id,String name,String phone,String email,String fdate,String tdate,String hotelID,String num_pers,String status){
 		

    	boolean isSuccess = false;
    	
    	
		try {
			
			con = ConnectionProviderForSql.getConnection();
			stmt= con.createStatement();
			
			String sql = "update booking_details set Cus_name = '"+name+"',Phone_num = '"+phone+"', Cus_email = '"+email+"',from_date = '"+fdate+"',"
					+ "   to_date = '"+tdate+"',hotel_id = '"+hotelID+"',num_of_persons = '"+num_pers+"', status = '"+status+"' where booking_ID = '"+id+"' ";	
			
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

package Entity;

public class Booking {
		
		private String id;
		private String Name;
		private String Phone;
		private String Email;
		private String Username;
		private String fdate;
		private String tdate;
		private String hotelID;
		private String persons;
		
		
		
		
		public Booking(String id, String name, String phone, String email, String username, String fdate, String tdate, String hotelID, String persons) {
			
			
			this.id = id;
			Name = name;
			Phone = phone;
			Email = email;
			Username = username;
			this.fdate = fdate;
			this.tdate = tdate;
			this.hotelID = hotelID;
			this.persons = persons;
			
		}

		public String getId() {
			return id;
		}

		public String getName() {
			return Name;
		}

		public String getPhone() {
			return Phone;
		}

		public String getEmail() {
			return Email;
		}

		public String getUsername() {
			return Username;
		}

		public String getFdate() {
			return fdate;
		}

		public String getTdate() {
			return tdate;
		}

		public String getHotelID() {
			return hotelID;
		}

		public String getPersons() {
			return persons;
		}
	
}

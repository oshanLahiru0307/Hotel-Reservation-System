package Entity;

public class hotel {
	
	private String id;
	private String Name;
	private String location;
	private String Country;
	private String phone;
	private String Email;
	
	
	public hotel(String id, String name, String location, String country, String phone, String email) {
		
		this.id = id;
		Name = name;
		this.location = location;
		Country = country;
		this.phone = phone;
		Email = email;
		
	}


	public String getId() {
		return id;
	}


	public String getName() {
		return Name;
	}


	public String getLocation() {
		return location;
	}


	public String getCountry() {
		return Country;
	}


	public String getPhone() {
		return phone;
	}


	public String getEmail() {
		return Email;
	}

	

}

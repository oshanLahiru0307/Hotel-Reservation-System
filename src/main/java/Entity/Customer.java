package Entity;

public class Customer {

	private int id;
	private String Name;
	private String Phone;
	private String Email;
	private String Username;
	private String Password;
	
	
	public Customer(int id, String Name, String Phone, String Email, String Username, String Password) {
	
		this.id = id;
		this.Name = Name;
		this.Phone = Phone;
		this.Email = Email;
		this.Username = Username;
		this.Password = Password;
		
	}


	public int getId() {
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


	public String getPassword() {
		return Password;
	}


	
}

package Entity;

public class Staff {
	
	private int id;
	private String Name;
	private String Phone;
	private String Email;
	private String Position;
	private String Username;
	private String Password;
	
	
	public Staff(int id, String name, String phone, String email, String position, String username, String password) {
		
		super();
		this.id = id;
		Name = name;
		Phone = phone;
		Email = email;
		Position = position;
		Username = username;
		Password = password;
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


	public String getPosition() {
		return Position;
	}


	public String getUsername() {
		return Username;
	}


	public String getPassword() {
		return Password;
	}



}

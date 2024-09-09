package dto;

public class UserDTO {
	private int userId;
	private String firstName;
	private String middleName = null;
	private String lastName;
	private String email;
	private String contact;
	private String address;
	private String city;
	private String state;
	private int role;
	
	public UserDTO(int userId, String firstName, String middleName, String lastName, String email, String contact, String address, String city, String state, int role) {
		this.userId = userId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.city = city;
		this.state = state;
		this.role = role;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public int getRole() {
		return role;
	}
	
	public void setRole(int role) {
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}

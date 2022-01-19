package business;

public class Person {
	private String firstName;
	private String lastName;
	private String telephone;
	private Address address;
	
	public Person(String firstName, String lastName, String telephone, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.telephone = telephone;
		this.address = address;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getTelephone() {
		return this.telephone;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Address getAddress() {
		return this.address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
}

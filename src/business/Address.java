package business;

public class Address {
	private String street;
	private String city;
	private String state;
	private int zip;

	public Address(String Street, String City, String State, int zip) {
		this.street = Street;
		this.city = City;
		this.state = State;
		this.zip = zip;

	}

	public String getStreet() {
		return this.street;
	}

	public String getCity() {
		return this.city;
	}

	public String getState() {
		return this.state;
	}

	public int getZip() {
		return this.zip;
	}

	public void setStreet(String Street) {
		this.street = Street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

}

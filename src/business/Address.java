package business;

import java.io.Serializable;

public class Address implements Serializable {
	private String street;
	private String city;
	private String state;
	private String zip;

	public Address(String Street, String City, String State, String zip) {
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

	public String getZip() {
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

	public void setZip(String zip) {
		this.zip = zip;
	}

	private static final long serialVersionUID = -4935233558647213035L;
}

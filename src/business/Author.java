package business;

public class Author extends Person {
	private String shortBio;
	
	public Author(String fName, String lName, String tel, Address addr, String shortBio) {
		super(fName, lName, tel, addr);
		this.shortBio = shortBio;
	}
	
	public String getShortBio() {
		return this.shortBio;
	}
	
	public void setShortBio(String shortBio) {
		this.shortBio = shortBio;
	}
}

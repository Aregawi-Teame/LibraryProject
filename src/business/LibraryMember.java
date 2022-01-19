package business;

public class LibraryMember extends Person {
	private String memberId;
	
	public LibraryMember(String fName, String lName, String tel, Address addr, String memberId) {
		super(fName, lName, tel, addr);
		this.memberId = memberId;
	}
	
	public String getMemberId() {
		return this.memberId;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
}

package business;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LibraryMember extends Person implements Serializable {
	private String memberId;
	
	public LibraryMember(String memberId, String fName, String lName, String tel, Address addr) {
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

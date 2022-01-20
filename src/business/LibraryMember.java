package business;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class LibraryMember extends Person implements Serializable {
	private String memberId;
	private CheckoutRecord checkoutRecord;

	public LibraryMember(String memberId, String fName, String lName, String tel, Address addr) {
		super(fName, lName, tel, addr);
		this.memberId = memberId;
		this.checkoutRecord = new CheckoutRecord();
	}

	public String getMemberId() {
		return this.memberId;
	}

	public void addCheckoutRecord(Book book, LocalDate checkoutDate, LocalDate dueDate) {
		checkoutRecord.addCheckoutEntry(book, checkoutDate, dueDate);
	}

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}
}

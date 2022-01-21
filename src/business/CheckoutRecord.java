package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements Serializable {
	static List<CheckoutEntry> checkoutEntries = new ArrayList<>();
	private Book book;
	private LocalDate checkoutDate, dueDate;

	public void addCheckoutEntry(Book book, LocalDate checkoutDate, LocalDate dueDate) {
		this.book = book;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
		checkoutEntries.add(new CheckoutEntry(book, checkoutDate, dueDate));
	}
	
	public List<CheckoutEntry> getCheckoutEntries() {
		return CheckoutRecord.checkoutEntries;
	}

	@Override
	public String toString() {
		return "BOOK " + book.toString() + "\nCHECKOUT DATE: " + this.checkoutDate + "\tDUE DATE: " + this.dueDate;
	}

	private static final long serialVersionUID = -3329931204020182890L;
}

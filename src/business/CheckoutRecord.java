package business;

import java.time.LocalDate;
import java.util.List;

public class CheckoutRecord {
	private List<CheckoutEntry> checkoutEntries;

	public void addCheckoutEntry(Book book, LocalDate checkoutDate, LocalDate dueDate) {
		checkoutEntries.add(new CheckoutEntry(book, checkoutDate, dueDate));
	}
}

package business;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@SuppressWarnings("serial")
public class CheckoutRecord implements Serializable {
	private List<CheckoutEntry> checkoutEntries;

	public void addCheckoutEntry(Book book, LocalDate checkoutDate, LocalDate dueDate) {
		checkoutEntries.add(new CheckoutEntry(book, checkoutDate, dueDate));
	}
}

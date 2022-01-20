package business;

import java.time.LocalDate;

public class CheckoutEntry {
	private Book book;
	private LocalDate checkoutDate;
	private LocalDate dueDate;

	public Book getBook() {
		return book;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public CheckoutEntry(Book book, LocalDate checkoutDate, LocalDate dueDate) {
		this.book = book;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}

}

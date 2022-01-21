package business;

import java.io.Serializable;
import java.time.LocalDate;

public class CheckoutEntry implements Serializable {

	private Book book;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	
	public CheckoutEntry(Book book, LocalDate checkoutDate, LocalDate dueDate) {
		this.book = book;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}


	public Book getBook() {
		return book;
	}

	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	

	private static final long serialVersionUID = 5399827794066637059L;

}

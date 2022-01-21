package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Book implements Serializable {

	private String isbn;
	private String title;
	private int maxCheckout;
	private List<Author> authors;
	private List<BookCopy> bookCopies;
	
	public Book(String isbn, String title, int maxCheckout, List<Author> authors) {
		this.title = title;
		this.isbn = isbn;
		this.maxCheckout = maxCheckout;
		this.authors = authors;
		this.bookCopies = new ArrayList<BookCopy>();
		bookCopies.add(new BookCopy(this, 1, true));
	}

	public void addCopy() {
		bookCopies.add(new BookCopy(this, this.getCopyNums() + 1, true));
	}

	public String getTitle() {
		return title;
	}

	public String getIsbn() {
		return isbn;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public List<BookCopy> getBookCopies() {
		return bookCopies;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public int getCopyNums() {
		return bookCopies.size();
	}

	public int getMaxCheckout() {
		return this.maxCheckout;
	}

	public BookCopy getCopy() {
		BookCopy bookCopy = null;
		if(this.numOfAvailableBooks() >= 1) {
			for(BookCopy copy: bookCopies) {
				if(copy.isAvailable() == true) {
					bookCopy = copy;
					copy.changeAvailaibility();
					break;
				}
					
			}
		}
		
		return bookCopy;
	}
	
	public int numOfAvailableBooks() {
		int count = 0;
		for(BookCopy copy: bookCopies) {
			if(copy.isAvailable() == true) {
				count = count + 1;
			}

		}
		return count;
	}
	
	@Override
	public String toString() {
		return "ISBN: " + isbn + "\tTITLE: " + title;
	}
	
	private static final long serialVersionUID = -5549374343698877820L;

}

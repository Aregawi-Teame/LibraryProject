package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
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
		int copies = this.getCopyNums();
		bookCopies.add(new BookCopy(this, copies + 1, true));
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
	
	public BookCopy getCopy(int copyNum) {
		BookCopy copy = null;
		for(BookCopy bookCopy: bookCopies) {
			if(bookCopy.getCopyNum() == copyNum)
				copy = bookCopy;
		}
		return copy;
	}

}

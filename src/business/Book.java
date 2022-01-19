package business;

import java.util.List;

public class Book {
	private String member_id;
	private long isbn;
	private List<Author> authors;
	private boolean availablity;
	private List<BookCopy> bookCopies;

	public Book(String member_id, long isbn, List<Author> authors, boolean availablity, List<BookCopy> bookCopies) {
		super();
		this.member_id = member_id;
		this.isbn = isbn;
		this.authors = authors;
		this.availablity = availablity;
		this.bookCopies = bookCopies;
	}

	public String getMember_id() {
		return member_id;
	}

	public long getIsbn() {
		return isbn;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public boolean isAvailablity() {
		return availablity;
	}

	public List<BookCopy> getBookCopies() {
		return bookCopies;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public void setAvailablity(boolean availablity) {
		this.availablity = availablity;
	}

}

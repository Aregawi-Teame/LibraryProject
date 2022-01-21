package business;

import java.io.Serializable;

public class BookCopy implements Serializable {
	private Book book;
	private int copyNum;
	private boolean isAvailable;

	public BookCopy(Book book, int copyNum, boolean isAvailable) {
		this.book = book;
		this.copyNum = copyNum;
		this.isAvailable = isAvailable;
	}

	public Book getBook() {
		return this.book;
	}

	public int getCopyNum() {
		return this.copyNum;
	}

	public boolean isAvailable() {
		return this.isAvailable;
	}

	public void changeAvailaibility() {
		isAvailable = !isAvailable;
	}

	private static final long serialVersionUID = -63741886311972126L;
}

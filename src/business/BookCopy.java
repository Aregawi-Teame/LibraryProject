package business;

public class BookCopy {
	private Book book;
	private int copyNum;
	
	public BookCopy(Book book, int copyNum) {
		this.book = book;
		this.copyNum = copyNum;
	}
	
	public Book getBook() {
		return this.book;
	}
	
	public int copyNum() {
		return this.copyNum;
	}
}

package controller;

import java.util.List;

import business.Book;
import business.LoginException;

public interface ISystemController {
	public void login(String id, String password) throws LoginException;
	public List<String> allMemberIds();
	public List<String> allBookIds();
	public void addBookCopy(String isbn);
	public void addBook(Book book);
	public Book getBook(String isbn);
}

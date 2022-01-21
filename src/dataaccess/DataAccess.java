package dataaccess;

import java.util.HashMap;

import business.Book;
import business.LibraryMember;
import dataaccess.DataAccessFacade.StorageType;

public interface DataAccess {
	public HashMap<String, Book> readBooksMap();

	public HashMap<String, User> readUserMap();

	public HashMap<String, LibraryMember> readMemberMap();
<<<<<<< HEAD

	public void saveNewMember(LibraryMember member);

	public void saveNewBook(Book book);

=======
	public void saveNewMember(LibraryMember member); 
	public void saveNewBook(Book book); 
>>>>>>> branch 'main' of https://github.com/Aregawi-Teame/LibraryProject.git
}

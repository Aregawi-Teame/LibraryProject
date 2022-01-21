package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import business.Book;
import business.LibraryMember;
import business.LoginException;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;

public class SystemController implements ISystemController {
	private DataAccess dataAccessFacade;
	public static User authenticatedUser = null;

	public void login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> users = da.readUserMap();
		if (!users.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = users.get(id).getPassword();
		if (!passwordFound.equals(password)) {
			throw new LoginException("Password incorrect");
		}
		authenticatedUser = users.get(id);
	}

	@Override
	public List<String> allMembersId() {
		dataAccessFacade = new DataAccessFacade();
		List<String> allId = new ArrayList<String>();
		allId.addAll(dataAccessFacade.readMemberMap().keySet());
		return allId;
	}

	@Override
	public List<String> allBooksIsbn() {
		dataAccessFacade = new DataAccessFacade();
		List<String> allIsbn = new ArrayList<>();
		allIsbn.addAll(dataAccessFacade.readBooksMap().keySet());
		return allIsbn;
	}
	
	public Book getBook(String isbn) {
		dataAccessFacade = new DataAccessFacade();
		return dataAccessFacade.readBooksMap().get(isbn);
	}
	
	public LibraryMember getMember(String memberId) {
		dataAccessFacade = new DataAccessFacade();
		return dataAccessFacade.readMemberMap().get(memberId);
	}
}

package controller;

import business.LoginException;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class LibrarianController {
	public boolean isValidIdAndIsbn(String memberId, String isbn) throws LoginException {
		DataAccess da = new DataAccessFacade();
		if (!da.readMemberMap().containsValue(memberId))
			throw new LoginException("Member not found");
		if (!da.readBooksMap().containsValue(isbn))
			throw new LoginException("Bookn not found");
		return true;
	}
}

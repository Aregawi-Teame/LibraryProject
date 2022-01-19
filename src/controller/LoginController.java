package controller;

import java.util.HashMap;

import business.LoginException;
import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;

public class LoginController {
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
}

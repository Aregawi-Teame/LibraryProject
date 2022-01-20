package controller;

import java.util.List;

import business.LoginException;

public interface ISystemController {
	void login(String id, String paasword) throws LoginException;

	List<String> allMembersId();

	List<String> allBooksIsbn();
}

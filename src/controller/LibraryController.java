package controller;

import java.io.Console;
import java.util.Scanner;

import business.LoginException;
import dataaccess.User;

public class LibraryController {
	public static void main(String[] args) throws LoginException {
		Scanner input = new Scanner(System.in);
		
		
		
		System.out.println("Enter User ID: ");
		String userId = input.next();
		
		System.out.println("Enter Password: ");
		String password = input.next();
		
		LoginController login = new LoginController();
		login.login(userId, password);
		User loggedIn = LoginController.authenticatedUser;
		
		System.out.println("Authenticated User: " + loggedIn.toString());
		
	}
}

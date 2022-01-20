package ui;
import java.io.Console;
import java.util.Scanner;

import business.LoginException;
import controller.SystemController;
import dataaccess.User;

public class LoginUi {
	public static void main(String[] args) throws LoginException {
		Scanner input = new Scanner(System.in);
		
		
		
		System.out.println("Enter User ID: ");
		String userId = input.next();
		
		System.out.println("Enter Password: ");
		String password = input.next();
		
		SystemController login = new SystemController();
		login.login(userId, password);
		User loggedIn = SystemController.authenticatedUser;
		
		System.out.println("Authenticated User: " + loggedIn.toString());
		System.out.println(loggedIn.getAuthorization());
//		if(loggedIn)
		
		
	}
}
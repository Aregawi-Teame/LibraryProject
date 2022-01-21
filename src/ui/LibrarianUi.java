package ui;

import java.util.Scanner;

import business.LoginException;
import controller.ISystemController;
import controller.LibrarianController;
import controller.SystemController;

public class LibrarianUi implements Ui {
	@Override
	public void displayMenu() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("   Enter 1 to checkout a book for a library member");
		System.out.println("   Enter 2 to list a book");
		System.out.println("   Enter 3 to logout");
		int choice;
		choice = sc.nextInt();
		LibrarianController librarian = new LibrarianController();
		if (choice == 1) {
			String memberId;
			String isbn;
			System.out.println("    Enter member Id");
			memberId = sc.next();
			if(memberId=="1") {
				System.out.println("    Enter ISBN");
				isbn = sc.next();
			}

		}

		sc.close();

	}
}

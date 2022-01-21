package ui;

import java.util.Scanner;

import business.LibraryMember;
import business.LoginException;
import controller.AdminController;

public class AdminUi implements Ui {
	@Override
	public void displayMenu() {
		Scanner sc = new Scanner(System.in);
		Util.displayHeader();
		int choice;
		choice = sc.nextInt();
		AdminController adminController = new AdminController();
		if (choice == 1) {
			String memberId, fName, lName, tel, street, city, state, zip;
			System.out.println("Enter member id");
			memberId = sc.next();
			System.out.println("Enter first name");
			fName = sc.next();
			System.out.println("Enter last name ");
			lName = sc.next();
			System.out.println("Enter telephone number");
			tel = sc.next();
			System.out.println("Enter your address");
			System.out.println("Enter street");
			street = sc.next();
			System.out.println("Enter city");
			city = sc.next();
			System.out.println("Enter state ");
			state = sc.next();
			System.out.println("Enter zip");
			zip = sc.next();
			adminController.addMember(memberId, fName, lName, tel, street, city, state, zip);
		} else if (choice == 2) {
			String memberId;
			System.out.println("Enter member id");
			memberId = sc.next();
			try {
				if (adminController.isFoundMember(memberId)) {
					String fName, lName, tel, street, city, state, zip;
					System.out.println("Enter first name");
					fName = sc.next();
					System.out.println("Enter last name ");
					lName = sc.next();
					System.out.println("Enter telephone number");
					tel = sc.next();
					System.out.println("Enter your address");
					System.out.println("Enter street");
					street = sc.next();
					System.out.println("Enter city");
					city = sc.next();
					System.out.println("Enter state ");
					state = sc.next();
					System.out.println("Enter zip");
					zip = sc.next();
					adminController.editMember(memberId, fName, lName, tel, street, city, state, zip);

				}
			} catch (LoginException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}

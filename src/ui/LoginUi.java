package ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import business.Book;
import business.BookCopy;
import business.CheckoutEntry;
import business.LibraryMember;
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
		
		// CHECKOUT BOOK
		List<String> membersId = login.allMembersId();
		System.out.println("Please Enter Member Id: ");
		String id = input.next();
		LocalDate checkoutDate = LocalDate.now();
		if (membersId.contains(id)) {
			List<String> booksIsbn = login.allBooksIsbn();
			System.out.println("Enter Isbn: ");
			String isbn = input.next();
			if (booksIsbn.contains(isbn) && login.getBook(isbn).numOfAvailableBooks() >= 1) {
				Book book = login.getBook(isbn);
				BookCopy bookCopy = book.getCopy();

				LibraryMember member = login.getMember(id);
				
				LocalDate checkoutDueDate = checkoutDate.plusDays(book.getMaxCheckout());
				member.addCheckoutRecord(book, checkoutDate, checkoutDueDate);
				
				System.out.println(member.getCheckoutRecord());

			} else
				System.out.println("Book you want to checkout doesn't exist. Try again.");
		} else {
			System.out.println("You are not a member of this library");
		}
		
		// CHECKOUT BOOK
		System.out.println("Please Enter Member Id: ");
		String id2 = input.next();

		if (membersId.contains(id2)) {
			List<String> booksIsbn = login.allBooksIsbn();
			System.out.println("Enter Isbn: ");
			String isbn2 = input.next();
			if (booksIsbn.contains(isbn2) && login.getBook(isbn2).numOfAvailableBooks() >= 1) {
				Book book = login.getBook(isbn2);
				BookCopy bookCopy = book.getCopy();

				LibraryMember member = login.getMember(id);
				LocalDate checkoutDate2 = checkoutDate.minusDays(20);
				LocalDate checkoutDueDate2 = checkoutDate2.plusDays(book.getMaxCheckout());
				member.addCheckoutRecord(book, checkoutDate2, checkoutDueDate2);
				
				System.out.println(member.getCheckoutRecord());

			} else
				System.out.println("Book you want to checkout doesn't exist. Try again.");
		} else {
			System.out.println("You are not a member of this library");
		}
		
		// SHOW CHECKOUT RECORD OF A MEMBER
		System.out.println("Enter Member ID: ");
		String memberId = input.next();
		
		System.out.println();
		
		LibraryMember member = login.getMember(memberId);
		System.out.printf("%6s %34s %30s \n", "BOOK", "CHECKOUT DATE", "DUE DATE");
		for(CheckoutEntry entry: member.getCheckoutRecord().getCheckoutEntries()) {
			System.out.printf("%2s %30s %34s", entry.getBook().getIsbn(), entry.getCheckoutDate(), entry.getDueDate());
		}
		
		// ADD NEW BOOK
//		System.out.println("***************** ADD NEW BOOK *****************");
//		System.out.println("Enter ISBN: ");
//		String isbn = input.next();
//		System.out.println("Enter Title: ");
//		String title = input.next();
//		System.out.println("Enter Number Authors: ");
//		int numberOfAuthors = input.nextInt();
//		
//		
//		List<Author> authors = new ArrayList<>();
//		for(int i = 0; i < numberOfAuthors; i++) {
//			System.out.println("***************** AUTHOR DETAILS *****************");
//			System.out.println("First Name: ");
//			String fName = input.next();
//			System.out.println("Last Name: ");
//			String lName = input.next();
//			System.out.println("TELEPHONE: ");
//			String tel = input.next();
//			System.out.println("SHORT BIO: ");
//			String shortBio = input.next();
//			
//			System.out.println("***************** AUTHOR ADDRESS DETAILS *****************");
//			System.out.println("Street: ");
//			String street = input.next();
//			System.out.println("City: ");
//			String city = input.next();
//			System.out.println("State: ");
//			String state = input.next();
//			System.out.println("Zip: ");
//			String zip = input.next();
//			Address address = new Address(street, city, state, zip);
//			authors.add(new Author(fName, lName, tel, address, shortBio));
//		}
//		
//		Book book = new Book(isbn, title, 7, authors);
//		DataAccess access = new DataAccessFacade();
//		access.saveNewBook(book);
		
		
		
		
		// ADD BOOK COPY
//		System.out.println("Enter Book ISBN: ");
//		String isbn = input.next();
//		Book book = login.getBook(isbn);
//		System.out.println(book.getCopyNums());
//		book.addCopy();
//		System.out.println(book.getCopyNums());

//		System.out.println("Authenticated User: " + loggedIn.toString());
//
		


	}
	
}
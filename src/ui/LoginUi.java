package ui;

<<<<<<< HEAD
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
=======
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
>>>>>>> branch 'main' of https://github.com/Aregawi-Teame/LibraryProject.git

import business.Book;
import business.BookCopy;
import business.CheckoutEntry;
import business.LibraryMember;
import business.LoginException;

import javax.swing.JOptionPane;

import controller.ISystemController;
import controller.SystemController;
import dataaccess.User;

<<<<<<< HEAD
public class LoginUi extends JFrame {
	public static final LoginUi INSTANCE = new LoginUi();

	private JPanel mainPanel;
	private JPanel upperHalf;
	private JPanel middleHalf;
	private JPanel lowerHalf;
	private JPanel container;

	private JPanel topPanel;
	private JPanel middlePanel;
	private JPanel lowerPanel;
	private JPanel leftTextPanel;
	private JPanel rightTextPanel;

	private JTextField username;
	private JTextField password;
	private JLabel label;
	private JButton loginButton;
	private JButton logoutButton;

	private JTextField messageBar = new JTextField();

	public void clear() {
		messageBar.setText("");
=======
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
		


>>>>>>> branch 'main' of https://github.com/Aregawi-Teame/LibraryProject.git
	}
<<<<<<< HEAD

	/* This class is a singleton */
	private LoginUi() {
	}

	public void init() {
		mainPanel = new JPanel();
		defineUpperHalf();
		defineMiddleHalf();
		BorderLayout bl = new BorderLayout();
		bl.setVgap(30);
		mainPanel.setLayout(bl);

		mainPanel.add(upperHalf, BorderLayout.NORTH);
		mainPanel.add(middleHalf, BorderLayout.CENTER);
		getContentPane().add(mainPanel);
		pack();
		// setSize(660, 500);

	}

	private void defineUpperHalf() {

		upperHalf = new JPanel();
		upperHalf.setLayout(new BorderLayout());
		defineTopPanel();
		defineMiddlePanel();
		defineLowerPanel();
		upperHalf.add(topPanel, BorderLayout.NORTH);
		upperHalf.add(middlePanel, BorderLayout.CENTER);
		upperHalf.add(lowerPanel, BorderLayout.SOUTH);

	}

	private void defineMiddleHalf() {
		middleHalf = new JPanel();
		middleHalf.setLayout(new BorderLayout());
		JSeparator s = new JSeparator();
		s.setOrientation(SwingConstants.HORIZONTAL);
		// middleHalf.add(Box.createRigidArea(new Dimension(0,50)));
		middleHalf.add(s, BorderLayout.SOUTH);

	}

	

	private void defineTopPanel() {
		topPanel = new JPanel();
		JPanel intPanel = new JPanel(new BorderLayout());
		intPanel.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.NORTH);
		JLabel loginLabel = new JLabel("Login");
		Util.adjustLabelFont(loginLabel, Color.BLUE.darker(), true);
		intPanel.add(loginLabel, BorderLayout.CENTER);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		topPanel.add(intPanel);

	}

	private void defineMiddlePanel() {
		middlePanel = new JPanel();
		middlePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		defineLeftTextPanel();
		defineRightTextPanel();
		middlePanel.add(leftTextPanel);
		middlePanel.add(rightTextPanel);
	}

	private void defineLowerPanel() {
		lowerPanel = new JPanel();
		loginButton = new JButton("Login");
		addLoginButtonListener(loginButton);
		lowerPanel.add(loginButton);
	}

	private void defineLeftTextPanel() {

		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

		username = new JTextField(10);
		label = new JLabel("Username");
		label.setFont(Util.makeSmallFont(label.getFont()));
		topText.add(username);
		bottomText.add(label);

		leftTextPanel = new JPanel();
		leftTextPanel.setLayout(new BorderLayout());
		leftTextPanel.add(topText, BorderLayout.NORTH);
		leftTextPanel.add(bottomText, BorderLayout.CENTER);
	}

	private void defineRightTextPanel() {

		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

		password = new JPasswordField(10);
		label = new JLabel("Password");
		label.setFont(Util.makeSmallFont(label.getFont()));
		topText.add(password);
		bottomText.add(label);

		rightTextPanel = new JPanel();
		rightTextPanel.setLayout(new BorderLayout());
		rightTextPanel.add(topText, BorderLayout.NORTH);
		rightTextPanel.add(bottomText, BorderLayout.CENTER);
	}

	private void addLoginButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			SystemController login = new SystemController();
			try {
				login.login(username.getText(), password.getText());
			} catch (LoginException e) {
				JOptionPane.showMessageDialog(LoginUi.this, "Error: " + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			User loggedIn = SystemController.authenticatedUser;
			if(SystemController.authenticatedUser!=null) {
//				LibrarySystem.hideAllWindows();
				LoginUi.INSTANCE.setVisible(false);
				
			Ui ui;

			if (loggedIn.getAuthorization().toString().equals("LIBRARIAN")) {
				ui = new LibrarianUi();
				ui.displayMenu();
			}

			else if (loggedIn.getAuthorization().toString().equals("ADMIN")) {
				ui = new AdminUi();
				ui.displayMenu();
			} else if (loggedIn.getAuthorization().toString().equals("BOTH")) {
				ui = new AdminAndLibUi();
				ui.displayMenu();
			}
			}
			//JOptionPane.showMessageDialog(this, "Successful Login");

		});
	}
	
	

}
=======
	
}
>>>>>>> branch 'main' of https://github.com/Aregawi-Teame/LibraryProject.git

package systemui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import business.CheckoutException;
import controller.SystemController;

public class Checkout extends JFrame implements LibWindow {
	public static final Checkout INSTANCE = new Checkout();

	private boolean isInitialized = false;
	private SystemController control;

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

	private JTextField memberID;
	private JTextField bookID;
	private JLabel label;
	private JButton loginButton;
	private JButton logoutButton;

	public boolean isInitialized() {
		return isInitialized;
	}

	public void isInitialized(boolean val) {
		isInitialized = val;
	}

	private JTextField messageBar = new JTextField();

	public void clear() {
		memberID.setText("");
		bookID.setText("");
	}

	/* This class is a singleton */
	private Checkout() {
	}

	public void init() {
		mainPanel = new JPanel();
		defineUpperHalf();
		defineMiddleHalf();
		defineLowerHalf();
		BorderLayout bl = new BorderLayout();
		bl.setVgap(30);
		mainPanel.setLayout(bl);

		mainPanel.add(upperHalf, BorderLayout.NORTH);
		mainPanel.add(middleHalf, BorderLayout.CENTER);
		mainPanel.add(lowerHalf, BorderLayout.SOUTH);
		getContentPane().add(mainPanel);
		isInitialized(true);
		pack();

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
		middleHalf.add(s, BorderLayout.SOUTH);

	}

	private void defineLowerHalf() {

		lowerHalf = new JPanel();
		lowerHalf.setLayout(new FlowLayout(FlowLayout.LEFT));

		JButton backButton = new JButton("<= Back to Main");
		addBackButtonListener(backButton);
		lowerHalf.add(backButton);

	}

	private void defineTopPanel() {
		topPanel = new JPanel();
		JPanel intPanel = new JPanel(new BorderLayout());
		intPanel.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.NORTH);
		JLabel loginLabel = new JLabel("Checkout");
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
		loginButton = new JButton("Book Checkout");
		addLoginButtonListener(loginButton);
		lowerPanel.add(loginButton);
	}

	private void defineLeftTextPanel() {

		JPanel topText = new JPanel();
		JPanel bottomText = new JPanel();
		topText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));
		bottomText.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 0));

		memberID = new JTextField(10);
		label = new JLabel("Member ID");
		label.setFont(Util.makeSmallFont(label.getFont()));
		topText.add(memberID);
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

		bookID = new JTextField(10);
		label = new JLabel("Book ISBN");
		label.setFont(Util.makeSmallFont(label.getFont()));
		topText.add(bookID);
		bottomText.add(label);

		rightTextPanel = new JPanel();
		rightTextPanel.setLayout(new BorderLayout());
		rightTextPanel.add(topText, BorderLayout.NORTH);
		rightTextPanel.add(bottomText, BorderLayout.CENTER);
	}

	private void addBackButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			LibrarySystem.hideAllWindows();
			LibrarySystem.INSTANCE.setVisible(true);
		});
	}

	private void addLoginButtonListener(JButton butn) {
		butn.addActionListener(evt -> {
			String memberid = memberID.getText();
			String bookid = bookID.getText();
			control = new SystemController();
			try {
				control.checkout(memberid, bookid);
			} catch (CheckoutException e) {
				JOptionPane.showMessageDialog(this, e.getMessage());
			}

		});
	}

}

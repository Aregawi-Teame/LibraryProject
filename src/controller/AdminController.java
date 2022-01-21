package controller;

import java.util.HashMap;

import javax.print.attribute.HashDocAttributeSet;

import business.Address;
import business.LibraryMember;
import business.LoginException;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class AdminController {

	public void addMember(String memberId, String fName, String lName, String tel, String street, String city,
			String state, String zip) {
		Address address = new Address(street, city, state, zip);
		LibraryMember libraryMember = new LibraryMember(memberId, fName, lName, tel, address);
		DataAccess da = new DataAccessFacade();
		da.saveNewMember(libraryMember);

	}

	public LibraryMember getLibraryMember(String memberId) {
		DataAccess da = new DataAccessFacade();
		HashMap<String, LibraryMember> mem = da.readMemberMap();
		return mem.get(memberId);
	}

	public void editMember(String memberId, String fName, String lName, String tel, String street, String city,
			String state, String zip) throws LoginException {
		LibraryMember member = getLibraryMember(memberId);
		member.getAddress().setCity(city);
		member.getAddress().setState(state);
		member.getAddress().setStreet(street);
		member.getAddress().setZip(zip);
		member.setFirstName(fName);
		member.setLastName(lName);
		member.setTelephone(tel);
	}

	public boolean isFoundMember(String memberId) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, LibraryMember> mem = da.readMemberMap();
		if (!mem.containsKey(memberId))
			throw new LoginException("Member not found");
		return true;
	}

}

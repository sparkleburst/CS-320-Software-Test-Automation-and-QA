/*
 * Max Gilhespy
 * SNHU CS-320
 * Module 3 Milestone
 */

package com.maxgilhespy.snhu_cs_320.Grand_Strand_Systems;

public class Contact {	
	
// contactId is final because it shall not be updatable
	private final String contactId;
	
	private String firstName, lastName, phone, address;

// default constructor 

	// private Contact() {}	

// public object constructor

	public Contact(String contactId, String firstName, String lastName, String phone,
			String address) throws IllegalArgumentException {

		// Check contactId meets requirements before setting.
		if (contactId == null || contactId.isBlank()) {
			throw new IllegalArgumentException("contactId must have a value.");
		} else if (contactId.length() > 10) {
			throw new IllegalArgumentException("contactId cannot be longer than 10 characters.");
		} else {
			this.contactId = contactId;
		}

		// Calls methods that set the rest of the values and validate the input.
		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
	}
	
	// Getters
	public String getContactId() {
		return this.contactId;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getAddress() {
		return this.address;
	}

	// Setters
	public void setFirstName(final String firstName) throws IllegalArgumentException {
		// Check fistName meets requirements before setting
		if (firstName == null || firstName.isBlank()) {
			throw new IllegalArgumentException("firstName must have a value.");
		} else if (firstName.length() > 10) {
			throw new IllegalArgumentException("firstName cannot be longer than 10 characters.");
		} else {
			this.firstName = firstName;
		}
	}
	
	public void setLastName(final String lastName) throws IllegalArgumentException {
		// Check lastName meets requirements before setting
		if (lastName == null || lastName.isBlank()) {
			throw new IllegalArgumentException("lastName must have a value.");
		} else if (lastName.length() > 10) {
			throw new IllegalArgumentException("lastName cannot be longer than 10 characters.");
		} else {
			this.lastName = lastName;
		}
	}

	public void setPhone(final String phone) throws IllegalArgumentException {
		// Check phone meets requirements before setting
		if (phone == null || phone.isBlank()) {
			throw new IllegalArgumentException("phone number must have a value.");
		} else if (phone.length() != 10 || !phone.matches("[0-9]+")) {
			throw new IllegalArgumentException("phone number must be 10 digits.");
		} else {
			this.phone = phone;
		}
	}

	public void setAddress(final String address) throws IllegalArgumentException {
		// Check address meets requirements before setting
		if (address == null || address.isBlank()) {
			throw new IllegalArgumentException("address must have a value.");
		}
		if (address.length() > 30) {
			throw new IllegalArgumentException("address cannot be longer than 30 characters.");
		}
		this.address = address;
	}

}

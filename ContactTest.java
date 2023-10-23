/*
 * Max Gilhespy
 * SNHU CS-320
 * Module 3 Milestone
 */

package com.maxgilhespy.snhu_cs_320.Grand_Strand_Systems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ContactTest {
	
	// Test for creating a contact with valid arguments.
	
	@ParameterizedTest
	@ValueSource(strings = { 
			"0",
			"01",
			"012",
			"0123",
			"01234",
			"012345",
			"0123456",
			"01234567",
			"0123456789" })
	public void testCreateContactWithValidId(String testId) {
		assertTrue(new Contact(testId, "fName", "lName", "0123456789", "address").getContactId() == testId);
	}

	// Test that creates a contact with invalid null or empty argument for contactId will throw an exception.
	// Test only passes if IllegalArgumentException is thrown with the correct message.	 
	//////////////////////////// USE this to change all with the exception message ////////////////////////////////
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {
			"    " })
	public void testCreateContactWithInvalidNullOrEmptyId(String testId) {
		String message = "(did not throw)";
		try {
			new Contact(testId, "fName", "lName", "0123456789", "address");
		} catch(Throwable exception) {
			message = exception.getMessage();
		}
		assertEquals("contactId must have a value.", message);	
	}
	
	///////////////////////////////////////////// Use Above /////////////////////////////////////////////////////////
	

	// Test that creates a contact with invalid length argument for contactId will throw an exception.
	// Test only passes if IllegalArgumentException is thrown with the correct message.	 
	
	@Test
	public void testCreateContactWithInvalidLengthId() {
		String message = "(did not throw)";
		try {
			new Contact("01234567890", "fName", "lName", "0123456789", "address");
		} catch(Throwable exception) {
			message = exception.getMessage();
		}
		assertEquals("contactId cannot be longer than 10 characters.", message);	
		//Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("01234567890", "fName", "lName", "0123456789", "address"));
		//assertEquals("contactId cannot be longer than 10 characters.", exception.getMessage());			
	}

	// Test for creating a contact with valid argument for firstName.
	 
	@ParameterizedTest
	@ValueSource(strings = { 
			"0",
			"01",
			"012",
			"0123",
			"01234",
			"012345",
			"0123456",
			"01234567",
			"0123456789" })
	public void testCreateContactWithValidFirstName(String testFirstName) {
		Contact testContact = new Contact("id", testFirstName, "lName", "0123456789", "address");
		assertTrue(testContact.getFirstName() == testFirstName);	
	}

	// Test for creating a contact with invalid null or empty argument for firstName.

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { 
			"    " })
	public void testCreateContactWithInvalidNullOrEmptyFirstName(String testFirstName) {
		String message = "(did not throw)";
		try {
			new Contact("id", testFirstName, "lName", "0123456789", "address");
		} catch(Throwable exception) {
			message = exception.getMessage();
		}
		assertEquals("firstName must have a value.", message);	
		//Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("id", testFirstName, "lName", "0123456789", "address"));
		//assertEquals("firstName must have a value.", exception.getMessage());	
	}

	// Test for creating a contact with invalid length argument for firstName.
	
	@Test
	public void testCreateContactWithInvalidLengthFirstName() {
		String message = "(did not throw)";
		try {
			new Contact("id", "01234567890", "lName", "0123456789", "address");
		} catch(Throwable exception) {
			message = exception.getMessage();
		}
		assertEquals("firstName cannot be longer than 10 characters.", message);
		//Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("id", "01234567890", "lName", "0123456789", "address"));
		//assertEquals("firstName cannot be longer than 10 characters.", exception.getMessage());	
	}

	// Test for creating a contact with valid argument for lastName.
	 
	@ParameterizedTest
	@ValueSource(strings = { 
			"0",
			"01",
			"012",
			"0123",
			"01234",
			"012345",
			"0123456",
			"01234567",
			"0123456789" })
	public void testCreateContactWithValidLastName(String testLastName) {
		Contact testContact = new Contact("id", "fName", testLastName, "0123456789", "address");
		assertTrue(testContact.getLastName() == testLastName);
	}

	// Test for creating a contact with invalid null or empty argument for lastName.
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { 
			"    " })
	public void testCreateContactWithInvalidNullOrEmptyLastName(String testLasttName) {
		String message = "(did not throw)";
		try {
			new Contact("id", "fName", testLasttName, "0123456789", "address");
		} catch(Throwable exception) {
			message = exception.getMessage();
		}
		assertEquals("lastName must have a value.", message);
		//Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("id", "fName", testLasttName, "0123456789", "address"));
		//assertEquals("lastName must have a value.", exception.getMessage());	
	}

	// Test for creating a contact with invalid length argument for firstName.
	 
	@Test
	public void testCreateContactWithInvalidLengthLastName() {
		String message = "(did not throw)";
		try {
			new Contact("id", "fName", "01234567890", "0123456789", "address");
		} catch(Throwable exception) {
			message = exception.getMessage();
		}
		assertEquals("lastName cannot be longer than 10 characters.", message);
		//Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("id", "fname", "01234567890", "0123456789", "address"));
		//assertEquals("lastName cannot be longer than 10 characters.", exception.getMessage());	
	}

	// Test for creating a contact with valid argument for phone.
	
	@Test
	public void testCreateContactWithValidPhone() {
		Contact testContact = new Contact("id", "fName", "lName", "0123456789", "address");
		assertTrue(testContact.getPhone() == "0123456789");
	}

	// Test for creating a contact with invalid null or empty argument for phone.
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {
			"    " })
	public void testCreateContactWithInvalidNullOrEmptyPhone(String testPhone) {
		String message = "(did not throw)";
		try {
			new Contact("id", "fName", "lName", testPhone, "address");
		} catch(Throwable exception) {
			message = exception.getMessage();
		}
		assertEquals("phone number must have a value.", message);
		//Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("id", "fName", "lName", testPhone, "address"));
		//assertEquals("phone number must have a value.", exception.getMessage());
	}

	// Test for creating a contact with invalid length or non-digit argument for phone.
	 
	@ParameterizedTest
	@ValueSource(strings = { 
			"01234",
			"abcdefghij",
			"01234567890" })
	public void testCreateContactWithInvalidLengthOrNonDigitPhone(String testPhone) {
		String message = "(did not throw)";
		try {
			new Contact("id", "fName", "lName", testPhone, "address");
		} catch(Throwable exception) {
			message = exception.getMessage();
		}
		assertEquals("phone number must be 10 digits.", message);
		//Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("id", "fName", "lName", testPhone, "address"));
		//assertEquals("phone number must be 10 digits.", exception.getMessage());
	}

	// Test for creating a contact with valid argument for address.
	 
	@ParameterizedTest
	@ValueSource(strings = { 
			"0",
			"01",
			"012",
			"0123",
			"01234",
			"012345",
			"0123456",
			"01234567",
			"0123456789",
			"01234567890123456789",
			"012345678901234567890123456789" })
	public void testCreateContactWithValidAddress(String testAddress) {
		Contact testContact = new Contact("id", "fName", "lName", "0123456789", testAddress);
		assertTrue(testContact.getAddress() == testAddress);
	}

	//Test for creating a contact with invalid null or empty argument for address.
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { 
			"    " })
	public void testContactWithInvalidNullOrEmptyAddress(String testAddress) {
		String message = "(did not throw)";
		try {
			new Contact("id", "fName", "lName", "0123456789", testAddress);
		} catch(Throwable exception) {
			message = exception.getMessage();
		}
		assertEquals("address must have a value.", message);
		//Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("id", "fName", "lName", "0123456789", testAddress));
		//assertEquals("address must have a value.", exception.getMessage());
	}

	// Test for creating a contact with invalid length argument for address.
	 
	@Test
	public void testContactWithInvalidLengthAddress() {
		String message = "(did not throw)";
		try {
			new Contact("id", "fName", "lName", "0123456789", "0123456789012345678901234567890");
		} catch(Throwable exception) {
			message = exception.getMessage();
		}
		assertEquals("address cannot be longer than 30 characters.", message);
		//Exception exception = assertThrows(IllegalArgumentException.class, () -> new Contact("id", "fName", "lName", "0123456789", "0123456789012345678901234567890"));
		//assertEquals("address cannot be longer than 30 characters.", exception.getMessage());
	}


}

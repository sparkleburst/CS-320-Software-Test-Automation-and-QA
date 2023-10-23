/*
 * Max Gilhespy
 * SNHU CS-320
 * Module 3 Milestone
 */

package com.maxgilhespy.snhu_cs_320.Grand_Strand_Systems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ContactServiceTest {
	
	private ContactService testContactService;

	
	// Setup of ContactService for use with the tests.
	
	@BeforeEach
	void setUp() {
		testContactService = new ContactService();
		testContactService.addContact(new Contact("1", "fName1", "lName1", "0123456789", "address1"));
		testContactService.addContact(new Contact("2", "fName2", "lName2", "9876543210", "address2"));
	}

	// Test for adding a contact to a list of contacts.
	
	@Test
	void testAddContact(){
		assertAll(
			() -> assertTrue(testContactService.addContact(new Contact("3", "fName3", "lName3", "0123456789", "address3"))),
			//() -> assertTrue(testContactService.getContacts().size() == 3)
			() -> assertDoesNotThrow(() -> testContactService.getContact("3"))
		);
	}
	
	// Test for adding a contact that already exists to a list of contacts.
	
	@Test
	void testAddContactThatAlreadyExists() {
		assertFalse(testContactService.addContact(new Contact("2", "fName2", "lName2", "0123456789", "address2")));
	}	

	// Test for deleting a contact using a valid contactId.
	
	@Test
	void testDeleteContactWithValidId() {
		assertAll(
			() -> assertTrue(testContactService.deleteContact("2")),
			//() -> assertTrue(testContactService.getContacts().size() == 1)
			() -> assertThrows(IllegalArgumentException.class, () -> testContactService.getContact("2"))
		);
	}

	// Test for deleting a contact using an invalid contactId.
	 
	@Test
	void testDeleteContactWithInvalidId() {
		assertFalse(testContactService.deleteContact("5"));
	}

	// Test for updating a contacts firstName using a valid id and first name.
	 
	@Test
	void testUpdateFirstNameWithValidIdAndFirstName() {
		assertAll(
			() -> assertTrue(testContactService.updateFirstName("2", "Dwight")),
			() -> assertTrue(testContactService.getContacts().get(1).getFirstName() == "Dwight")
		);
	}

	// Test for updating a contacts firstName using an invalid id and valid first name.
	
	@Test
	void testUpdateFirstNameWithInvalidId() {
		assertFalse(testContactService.updateFirstName("5", "Dwight"));
	}

	// Test for updating a contacts firstName using a valid id and invalid first name.
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {
			"    ",
			"01234567890" })
	void testUpdateFirstNameWithInvalidFirstName(String testFirstName) {
		assertThrows(IllegalArgumentException.class, () -> testContactService.updateFirstName("2", testFirstName));
	}

	// Test for updating a contacts lastName using a valid id and last name.
	 
	@Test
	void testUpdateLastNameWithValidIdAndLastName() {
		assertAll(
			() -> assertTrue(testContactService.updateLastName("2", "Schrute")),
			() -> assertTrue(testContactService.getContacts().get(1).getLastName() == "Schrute")
		);
	}

	// Test for updating a contacts lastName using an invalid id and valid last name.
	  
	@Test
	void testUpdateLastNameWithInvalidId() {
		assertFalse(testContactService.updateLastName("5", "Schrute"));
	}

	// Test for updating a contacts lastName using a valid id and invalid last name.
	
	@ParameterizedTest
	@NullSource
	@ValueSource(strings = { 
			"",
			"    ",
			"01234567890" })
	void testUpdateLastNameWithInvalidLastName(String testLastName) {
		assertThrows(IllegalArgumentException.class, () -> testContactService.updateFirstName("2", testLastName));
	}

	// Test for updating a contacts phone number using a valid id and phone number.
	
	@Test
	void testUpdatePhoneWithValidIdAndPhone() {
		assertAll(
			() -> assertTrue(testContactService.updatePhone("2", "1238675309")),
			() -> assertTrue(testContactService.getContacts().get(1).getPhone() == "1238675309")
		);
	}

	// Test for updating a contacts phone number using an invalid id and valid phone number.
	 
	@Test
	void testUpdatePhoneWithInvalidId() {
		assertFalse(testContactService.updatePhone("5", "867-5309"));
	}

	// Test for updating a contacts phone number using a valid id and invalid phone number.
	 
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {
			"    ",
			"01234567890" })
	void testUpdatePhoneWithInvalidPhone(String testPhone) {
		assertThrows(IllegalArgumentException.class, () -> testContactService.updateFirstName("2", testPhone));
	}

	// Test for updating a contacts address using a valid id and address.
	 
	@Test
	void testUpdateAddressWithValidIdAndAddress() {
		assertAll(
			() -> assertTrue(testContactService.updateAddress("2", "Scranton, PA")),
			() -> assertTrue(testContactService.getContacts().get(1).getAddress() == "Scranton, PA")
		);
	}

	// Test for updating a contacts phone number using an invalid id and valid phone number.
	
	@Test
	void testUpdateAddressWithInvalidId() {
		assertFalse(testContactService.updateAddress("5", "Scranton, PA"));
	}

	// Test for updating a contacts address using a valid id and invalid address.
	 
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = { 
			"    ",
			"0123456789012345678901234567890" })
	void testUpdateAddressWithInvalidAddress(String testAddress) {
		assertThrows(IllegalArgumentException.class, () -> testContactService.updateFirstName("2", testAddress));
	}	

}

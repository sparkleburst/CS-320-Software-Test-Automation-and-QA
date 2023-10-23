/*
 * Max Gilhespy
 * SNHU CS-320
 * Module 3 Milestone
 */

package com.maxgilhespy.snhu_cs_320.Grand_Strand_Systems;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactService {
	
	private final List<Contact> contacts;

	// Default constructor for ContactService that initializes a new list of contacts.
	
	public ContactService() {
		this.contacts  = new ArrayList<Contact>();
	}

	// Getter for the list of contacts.	 
	// Returns list of contacts
	
	public List<Contact> getContacts(){
		return contacts;
	}
	
	// This method adds a new contact to the list of contacts.	 
	// newContact contact will be added to the contacts list
	// returns true for contact added, false for contact already exists
	
	public boolean addContact(final Contact newContact) {
		boolean contactExists = false;
		for(Contact contact : contacts) {
			if (newContact.getContactId() == contact.getContactId()) {
				contactExists = true;
			}
		}

		// If contact doesn't exist, add it to the contacts list.
		if (!contactExists) {
			this.contacts.add(newContact);
			// Return true for adding contact to list.
			return true;
		} else {
			// Contact already exists, return false for adding the contact.
			return false;
		}
	}
	
	public Contact getContact(final String id) {
		Optional<Contact> result = this.contacts.stream().filter(contact -> (contact.getContactId() == id)).findFirst();
		if (!result.isPresent())
		{
			throw new IllegalArgumentException("contact does not exist.");
		}
		return result.get();
	}

	// This method deletes a contact from the list with matching id.
	// String id value to match to existing id
	// Returns true for contact found and deleted, false if not found
	 
	public boolean deleteContact(final String id) {
		return this.contacts.removeIf(contact -> (contact.getContactId() == id));
	}

	// This method updates the first name of a contact from the list with matching id.
	// String id value to match to existing id
	// Returns true for contact found and updated, false if not found
	 
	public boolean updateFirstName(final String id, final String firstName) {
		boolean updateComplete = false;
		for(Contact contact : contacts) {
			if (contact.getContactId() == id) {
				contact.setFirstName(firstName);
				updateComplete = true;
			}
		}
		return updateComplete;
	}

	// This method updates the last name of a contact from the list with matching id.
	// String id value to match to existing id
	// Returns true for contact found and updated, false if not found
	 
	public boolean updateLastName(final String id, final String lastName) {
		boolean updateComplete = false;
		for(Contact contact : contacts) {
			if (contact.getContactId() == id) {
				contact.setLastName(lastName);
				updateComplete = true;
			}
		}
		return updateComplete;
	}

	// This mMethod updates the phone number of a contact from the list with matching id.
	// String id value to match to existing id
	// Returns true for contact found and updated, false if not found
	 
	public boolean updatePhone(final String id, final String phone) {
		boolean updateComplete = false;
		for(Contact contact : contacts) {
			if (contact.getContactId() == id) {
				contact.setPhone(phone);
				updateComplete = true;
			}
		}
		return updateComplete;
	}

	// This method updates the address of a contact from the list with matching id.
	// String id value to match to existing id
	// Returns true for contact found and updated, false if not found
	 
	public boolean updateAddress(final String id, final String address) {
		boolean updateComplete = false;
		for(Contact contact : contacts) {
			if (contact.getContactId() == id) {
				contact.setAddress(address);
				updateComplete = true;
			}
		}
		return updateComplete;
	}
	
}

package com.Website.Contact.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Website.Contact.Model.Contact;
import com.Website.Contact.Repository.ContactRepository;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepository contactRepository;
	
	
	//Adding Data to DataBase
	public Contact saveContact(Contact contact)
	{
		return contactRepository.save(contact);
	}
	
	//Getting Data from DataBase
	public List<Contact> getAllContacts(){
		return contactRepository.findAll();
	}
	
	
	//Getting Contact By ID
	public Contact getContactById(Long id) {
		return contactRepository.findById(id).orElse(null);
		
	}
	
	//Delete Contact by ID
	public void deleteContact(Long id)
	{
		contactRepository.deleteById(id);
	}
	

	

}

package com.Website.Contact.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Website.Contact.Model.Contact;
import com.Website.Contact.Service.ContactService;

@RestController
@RequestMapping("/api/contact")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	
	
	//Adding data into database
	   @PostMapping
	    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
	        Contact savedContact = contactService.saveContact(contact);
	        return ResponseEntity.ok(savedContact);
	    }
	   
	   
	  //Getting all data
	   @GetMapping
	   public ResponseEntity<List<Contact>> getAllContacts() {
		List<Contact> contacts = contactService.getAllContacts();
	      return ResponseEntity.ok(contacts);		
	   }
	   
	   //Getting contact by Id
	   @GetMapping("/{id}")
	   public ResponseEntity<Contact> getContactById(@PathVariable Long id){
		   Contact contact = contactService.getContactById(id);
		   if(contact == null)
		   {
			   return ResponseEntity.notFound().build();
		   }
		   return ResponseEntity.ok(contact);
	   }
	   

	   //Deleting contact by Id
	   @DeleteMapping("/{id}")
	   public ResponseEntity<Void> deleteContact(@PathVariable Long id){
		   contactService.deleteContact(id);
		   return ResponseEntity.noContent().build();
	   }
	  

}

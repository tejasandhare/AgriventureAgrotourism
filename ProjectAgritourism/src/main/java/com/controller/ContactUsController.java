package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.ContactUs;
import com.service.ContactUsService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ContactUsController 
{
	@Autowired
	ContactUsService contactService;
	
	@PostMapping("/addContact")
	public ResponseEntity<ContactUs> addContact(@RequestBody ContactUs contact)
	{
		ContactUs con = contactService.addContact(contact);
		return ResponseEntity.status(HttpStatus.CREATED).header("Add", "Contact Save").body(con);
	}
	
	@GetMapping("/getContact/{id}")
	public ResponseEntity<ContactUs> getContact(@PathVariable("id") long id) 
	{
		ContactUs con = contactService.getContactById(id);
		return ResponseEntity.status(HttpStatus.OK).header("Get", "Contact Receive").body(con);
	}
	
	@GetMapping("/getAllContact")
	public ResponseEntity<List<ContactUs>> getAllContacts() 
	{
		List<ContactUs> con = contactService.getAllContact();
		return ResponseEntity.status(HttpStatus.OK).header("Get", "ALL Contact Receive").body(con);
	}
	
	@PutMapping("/updateContact")
	public ResponseEntity<ContactUs> updateContact(@RequestBody ContactUs contact)
	{
		ContactUs con = contactService.updateContact(contact);
		return ResponseEntity.status(HttpStatus.OK).header("Update", "Contact Updated").body(con);
	}
	
	@DeleteMapping("/deleteContact/{id}")
	public ResponseEntity<Map<String, Object>> deleteContact(@PathVariable long id)
	{
		Map<String, Object> response = contactService.deleteContact(id);
		
		return ResponseEntity.ok(response);
	}
	
}

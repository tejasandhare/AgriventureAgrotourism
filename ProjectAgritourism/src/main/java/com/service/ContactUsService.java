package com.service;

import java.util.List;
import java.util.Map;

import com.model.ContactUs;

public interface ContactUsService 
{
	public ContactUs addContact(ContactUs contact);
	public ContactUs getContactById(long id);
	public List<ContactUs> getAllContact();
	public ContactUs updateContact(ContactUs contact);
	/*public ContactUs deleteContact(long id);*/
	public Map<String, Object> deleteContact(long id);
	
	public String sendContactMail(long id);
}

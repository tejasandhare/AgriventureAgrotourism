package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.dao.ContactUsRepository;
import com.model.ContactUs;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class ContactUsServiceImplement implements ContactUsService
{
	@Autowired 
	ContactUsRepository contactRepo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	private String sender = "agriventuretourism2024@gmail.com";

	@Override
	public ContactUs addContact(ContactUs contact) 
	{
		ContactUs con = new ContactUs();
		con = contactRepo.save(contact);
		sendContactMail(con.getContactId());
		return con;
	}

	@Override
	public ContactUs getContactById(long id) 
	{
		return contactRepo.findById(id).orElse(null);
	}

	@Override
	public List<ContactUs> getAllContact() 
	{
		return contactRepo.findAll();
	}

	@Override
	public ContactUs updateContact(ContactUs contact) 
	{
		ContactUs existingContact = contactRepo.findById(contact.getContactId()).orElse(null);
		existingContact.setCustName(contact.getCustName());
		
		ContactUs updatedContact = contactRepo.save(existingContact);
		return updatedContact;
	}

	@Override
	public Map<String, Object> deleteContact(long id) 
	{
		Map<String, Object> response = new HashMap<>();
		ContactUs con = contactRepo.findById(id).orElse(null);
		
		if(con == null)
		{
			response.put("Not Deleted", "Contact Not Deleted Because ID not FOUND");
		}
		else
		{
			contactRepo.delete(con);
			response.put("Deleted", "Contact Deleted Successfully");
		}
		return response;
	}

	@Override
	public String sendContactMail(long id) 
	{
		 Optional<ContactUs> optionalContact = contactRepo.findById(id);
		    if (!optionalContact.isPresent()) 
		    {
		        return "Contact not found with ID: " + id;
		    }
		    
		    ContactUs con = optionalContact.get();
		    
		    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		    MimeMessageHelper mimeMessageHelper;
		    
		    try 
		    {
		        mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		        mimeMessageHelper.setFrom(sender);
		        mimeMessageHelper.setTo(con.getEmail() );
		        mimeMessageHelper.setText("Dear " + con.getCustName() + ",\n\n"
		            + "\r\n"
		            + "Thank you for Reaching out to us. "
		            + "We appreciate your contact and will respond to your Inquiry as soon as possible.\n\n"
		          
		            // Add more relevant details as needed
		            + "\n\nBest Regards,\nAgriventure Agrotourism");
		        mimeMessageHelper.setSubject("Thank You for Contacting Us");
		        
		        javaMailSender.send(mimeMessage);
		        
		        return "Mail sent successfully";
		    } 
		    catch (MessagingException e) 
		    {
		        return "Error while sending mail!!!";
		    }
	}
	
	
}

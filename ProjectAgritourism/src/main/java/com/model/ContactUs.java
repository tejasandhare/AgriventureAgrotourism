package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class ContactUs 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "contact_seq_gen")
    @SequenceGenerator(name = "contact_seq_gen", sequenceName = "contact_id_seq", allocationSize = 5190)
	private long contactId;
	private String custName;
	private String email;
	private String message;
	
	public ContactUs() 
	{
		super();
	}

	public ContactUs(long contactId, String custName, String email, String message) 
	{
		super();
		this.contactId = contactId;
		this.custName = custName;
		this.email = email;
		this.message = message;
	}

	public long getContactId() 
	{
		return contactId;
	}
	public void setContactId(long contactId) 
	{
		this.contactId = contactId;
	}

	public String getCustName() 
	{
		return custName;
	}
	public void setCustName(String custName) 
	{
		this.custName = custName;
	}

	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getMessage() 
	{
		return message;
	}
	public void setMessage(String message) 
	{
		this.message = message;
	}
	
}

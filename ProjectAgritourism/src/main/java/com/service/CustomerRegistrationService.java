package com.service;

import java.util.List;
import java.util.Map;

import com.model.CustomerRegistration;

public interface CustomerRegistrationService 
{
	public CustomerRegistration saveCustomer(CustomerRegistration cust);
	public CustomerRegistration getCustomerById(long id);
	public List<CustomerRegistration> getAllCustomer();
	public CustomerRegistration updateCustomer(CustomerRegistration admin);
	/*public Player deletePlayer(int id);*/
	public Map<String, Object> deleteCustomer(long id);
	
	public String sendMailWithAttachment(Long id);
	
}

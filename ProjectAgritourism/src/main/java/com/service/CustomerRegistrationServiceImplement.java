package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.dao.CustomerRegistrationRepository;
import com.model.CustomerRegistration;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;


@Service
public class CustomerRegistrationServiceImplement implements CustomerRegistrationService 
{
	@Autowired
	CustomerRegistrationRepository customerRepo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	 //@Value("${spring.mail.username}")
	private String sender = "agriventuretourism2024@gmail.com";

	@Override
	public CustomerRegistration saveCustomer(CustomerRegistration cust) 
	{
		CustomerRegistration c=new CustomerRegistration();
		c=customerRepo.save(cust);
		sendMailWithAttachment(c.getCustomerId());
		return c;
	}
	
	@Override
	public CustomerRegistration getCustomerById(long id) 
	{
		//return customerRepo.findById(id).orElse(null);
		return customerRepo.findById(id).orElse(null);
	}

	@Override
	public List<CustomerRegistration> getAllCustomer() 
	{
		return customerRepo.findAll();
	}

	@Override
	public CustomerRegistration updateCustomer(CustomerRegistration admin) 
	{
		CustomerRegistration existingCustomer = customerRepo.findById(admin.getCustomerId()).orElse(null);
		existingCustomer.setCustomerName(admin.getCustomerName());
		
		CustomerRegistration updatedCustomer = customerRepo.save(existingCustomer);
		return updatedCustomer;
	}

	@Override
	public Map<String, Object> deleteCustomer(long id) 
	{
		Map<String, Object> response = new HashMap<>();
		CustomerRegistration c = customerRepo.findById(id).orElse(null);
		
		if(c == null)
		{
			response.put("Not Deleted", "Customer Not Deleted Because ID not FOUND");
		}
		else
		{
			customerRepo.delete(c);
			response.put("Deleted", "Customer Deleted Successfully");
		}
		return response;
	}
	
	
	

	@Override
	public String sendMailWithAttachment(Long id) 
	{
	    Optional<CustomerRegistration> optionalCustomer = customerRepo.findById(id);
	    if (!optionalCustomer.isPresent()) 
	    {
	        return "CustomerRegistration not found with ID: " + id;
	    }
	    
	    CustomerRegistration customer = optionalCustomer.get();
	    
	    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	    MimeMessageHelper mimeMessageHelper;
	    
	    try 
	    {
	        mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	        mimeMessageHelper.setFrom(sender);
	        mimeMessageHelper.setTo(customer.getCustomerEmail());
	        mimeMessageHelper.setText("Dear " + customer.getCustomerName() + ",\n\n"
	            + "Thank you for registering with us. Below your UserName & Password:\n\n"
	            + "UserName : " + customer.getCustomerUserName() + "\n"
	            + "Password : " + customer.getCustomerPassword() + "\n"
	            // Add more relevant details as needed
	            + "\n\nBest Regards,\nAgrotourism");
	        mimeMessageHelper.setSubject("Customer Registration Successful");
	        
	        // Add attachment if needed
	        // mimeMessageHelper.addAttachment("FileName", new File("Path_to_your_file"));
	        
	        javaMailSender.send(mimeMessage);
	        
	        return "Mail sent successfully";
	    } 
	    catch (MessagingException e) 
	    {
	        return "Error while sending mail!!!";
	    }
	}
	

}


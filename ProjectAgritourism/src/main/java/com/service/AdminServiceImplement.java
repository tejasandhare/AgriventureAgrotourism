package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.dao.AdminRepository;
import com.model.Admin;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class AdminServiceImplement implements AdminService
{
	@Autowired
	AdminRepository adminRepo;

	@Autowired
	private JavaMailSender javaMailSender;
	private String sender = "agriventuretourism2024@gmail.com";
	
	@Override
	public Admin addAdmin(Admin ad) 
	{
		Admin a = new Admin();
		a = adminRepo.save(ad);
		sendRegistrationMail(a.getAdminId());
		return a;
	}
	
	@Override
	public Admin getAdminById(long id) 
	{
		return adminRepo.findById(id).orElse(null);
	}

	@Override
	public List<Admin> getAllAdmin() 
	{
		return adminRepo.findAll();
	}

	@Override
	public Admin updateAdmin(Admin admin) 
	{
		Admin existingAdmin = adminRepo.findById(admin.getAdminId()).orElse(null);
		existingAdmin.setAdminName(admin.getAdminName());
		
		Admin updatedAdmin = adminRepo.save(existingAdmin);
		return updatedAdmin;
	}

	@Override
	public Map<String, Object> deleteAdmin(long id) 
	{
		Map<String, Object> response = new HashMap<>();
		Admin a = adminRepo.findById(id).orElse(null);
		
		if(a == null)
		{
			response.put("Not Deleted", "Admin Not Deleted Because ID not FOUND");
		}
		else
		{
			adminRepo.delete(a);
			response.put("Deleted", "Admin Deleted Successfully");
		}
		return response;
	}
	
	

	@Override
	public String sendRegistrationMail(long id) 
	{
	    Optional<Admin> optionalAdmin = adminRepo.findById(id);
	    if (!optionalAdmin.isPresent()) 
	    {
	        return "AdminRegistration not found with ID: " + id;
	    }
	    
	    Admin admin = optionalAdmin.get();
	    
	    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	    MimeMessageHelper mimeMessageHelper;
	    
	    try 
	    {
	        mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	        mimeMessageHelper.setFrom(sender);
	        mimeMessageHelper.setTo(admin.getAdminEmail() );
	        mimeMessageHelper.setText("Dear " + admin.getAdminName() + ",\n\n"
	            + "Thank you Admin for Jion with us. Below your UserName & Password:\n\n"
	            + "UserName : " + admin.getAdminUserName() + "\n"
	            + "Password : " + admin.getAdminPassword() + "\n"
	            // Add more relevant details as needed
	            + "\n\nBest Regards,\nAgriventure Agrotourism");
	        mimeMessageHelper.setSubject("Admin Registration Successful");
	        
	        javaMailSender.send(mimeMessage);
	        
	        return "Mail sent successfully";
	    } 
	    catch (MessagingException e) 
	    {
	        return "Error while sending mail!!!";
	    }
	}

//	@Override
//	public Admin authenticate(String adminUserName, String adminPassword) 
//	{
//		Admin admin = adminRepo.findByAdminUserNameAndAdminPassword(adminUserName, adminPassword);
//        if (admin != null && admin.getAdminPassword().equals(adminPassword)) {
//            return admin;
//        }
//        return null;
//	}
	
	@Override
	public Map<String, Object> authenticate(String adminUserName, String adminPassword) 
	{
	    Map<String, Object> response = new HashMap<>();
	    Admin admin = adminRepo.findByAdminUserNameAndAdminPassword(adminUserName, adminPassword);
	    
	    if (admin != null) {
	        response.put("success", true);
	        response.put("admin", admin);
	    } else {
	        response.put("success", false);
	        response.put("message", "You have entered wrong UserName and Password, kindly please check once");
	    }
	    return response;
	}


}

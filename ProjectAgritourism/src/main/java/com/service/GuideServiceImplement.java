package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.dao.GuideRepository;
import com.model.Guide;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class GuideServiceImplement implements GuideService
{
	@Autowired
	GuideRepository guideRepo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	private String sender = "agriventuretourism2024@gmail.com";

	@Override
	public Guide addGuide(Guide guide) 
	{
		Guide g = new Guide();
		g = guideRepo.save(guide);
		sendRegistrationMail(g.getGuideId());
		return g;
	}
	
	@Override
	public Guide findByGuideName(String guideName) 
	{
		return guideRepo.findByGuideName(guideName);
	}

	@Override
	public Guide getGuideById(long id) {
		return guideRepo.findById(id).orElse(null);
	}
	
	@Override
	public List<Guide> getAllGuide() 
	{
		return guideRepo.findAll();
	}

	@Override
	public Guide updateGuide(Guide guide) 
	{
		Guide existingGuide = guideRepo.findById(guide.getGuideId()).orElse(null);
		//existingGuide.setGuideName(guide.getGuideName());
		existingGuide.setGuideMoNo(guide.getGuideMoNo());	
		existingGuide.setGuideEmail(guide.getGuideEmail());
		
		Guide updatedGuide = guideRepo.save(existingGuide);
		
		sendUpdateDetailsMail(updatedGuide.getGuideId());
		return updatedGuide;
	}

	@Override
	public Map<String, Object> deleteGuide(long id) 
	{
		Map<String, Object> response = new HashMap<>();
		Guide guide = guideRepo.findById(id).orElse(null);
		
		if(guide == null)
		{
			response.put("Not Deleted", "Guide Not Deleted Because ID not FOUND");
		}
		else
		{
			guideRepo.delete(guide);
			response.put("Deleted", "Guide Deleted Successfully");
		}
		return response;
	}

	@Override
	public String sendRegistrationMail(long id) 
	{
	    Optional<Guide> optionalGuide = guideRepo.findById(id);
	    if (!optionalGuide.isPresent()) 
	    {
	        return "Guide not found with ID: " + id;
	    }
	    
	    Guide guide = optionalGuide.get();
	    
	    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	    MimeMessageHelper mimeMessageHelper;
	    
	    try 
	    {
	        mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	        mimeMessageHelper.setFrom(sender);
	        mimeMessageHelper.setTo(guide.getGuideEmail());
	        mimeMessageHelper.setText("Dear " + guide.getGuideName() + ",\n\n"
	            + "Thank you for Join with us. \nHope you will be guide to our Customers in good way.\n\n"
	            // Add more relevant details as needed
	            + "\n\nBest Regards,\nAgriVenture Agrotourism");
	        mimeMessageHelper.setSubject("Guide Added Successful");
	        
	        javaMailSender.send(mimeMessage);
	        
	        return "Mail sent successfully";
	    } 
	    catch (MessagingException e) 
	    {
	        return "Error while sending mail!!!";
	    }
	}
	
	
	
	@Override
	public String sendUpdateDetailsMail(long id) 
	{
	    Optional<Guide> optionalGuide = guideRepo.findById(id);
	    if (!optionalGuide.isPresent()) 
	    {
	        return "Guide not found with ID: " + id;
	    }
	    
	    Guide guide = optionalGuide.get();
	    
	    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	    MimeMessageHelper mimeMessageHelper;
	    
	    try 
	    {
	        mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	        mimeMessageHelper.setFrom(sender);
	        mimeMessageHelper.setTo(guide.getGuideEmail());
	        mimeMessageHelper.setText("Dear " + guide.getGuideName() + ",\n\n"
	            + "Your Details has been Updated Successfully.\n\n"
	            // Add more relevant details as needed
	            + "\n\nBest Regards,\nAgriVenture Agrotourism");
	        mimeMessageHelper.setSubject("Guide Updated Successful");
	        
	        javaMailSender.send(mimeMessage);
	        
	        return "Mail sent successfully";
	    } 
	    catch (MessagingException e) 
	    {
	        return "Error while sending mail!!!";
	    }
	}	
	
}

package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.dao.FeedbackReviewRepository;
import com.model.FeedbackReview;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class FeedbackReviewServiceImplement implements FeedbackReviewService
{
	@Autowired
	FeedbackReviewRepository feedbackRepo;
	
	@Autowired
	private JavaMailSender javaMailSender;
	private String sender = "agriventuretourism2024@gmail.com";

	@Override
	public FeedbackReview addFeedback(FeedbackReview feed) 
	{
		//return feedbackRepo.save(feed);
		FeedbackReview fd = new FeedbackReview();
		fd = feedbackRepo.save(feed);
		sendFeedbackMail(fd.getFeedbackID());
		return fd;
	}

	@Override
	public FeedbackReview getFeedbackById(long id) 
	{
		return feedbackRepo.findById(id).orElse(null);
	}

	@Override
	public List<FeedbackReview> getAllFeedback() 
	{
		return feedbackRepo.findAll();
	}

	@Override
	public FeedbackReview updateFeedback(FeedbackReview feed) 
	{
		FeedbackReview existingFeedback = feedbackRepo.findById(feed.getFeedbackID()).orElse(null);
		existingFeedback.setRating(feed.getRating());
		existingFeedback.setAgrotourismService(feed.getAgrotourismService());
		existingFeedback.setCommentsuggestions(feed.getCommentsuggestions());
		
		FeedbackReview updatedFeedback = feedbackRepo.save(existingFeedback);
		return updatedFeedback;
	}

	@Override
	public Map<String, Object> deleteFeedback(long id) 
	{
		Map<String, Object> response = new HashMap<>();
		FeedbackReview fd = feedbackRepo.findById(id).orElse(null);
		
		if(fd == null)
		{
			response.put("Not Deleted", "Feedback Not Deleted Because ID not FOUND");
		}
		else
		{
			feedbackRepo.delete(fd);
			response.put("Deleted", "Feedback Deleted Successfully");
		}
		return response;
	}

	@Override
	public String sendFeedbackMail(long id) 
	{
		Optional<FeedbackReview> optionalFeedback = feedbackRepo.findById(id);
	    if (!optionalFeedback.isPresent()) 
	    {
	        return "Feedback of Customer not found with ID: " + id;
	    }
	    
	    FeedbackReview feed = optionalFeedback.get();
	    
	    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
	    MimeMessageHelper mimeMessageHelper;
	    
	    try 
	    {
	        mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
	        mimeMessageHelper.setFrom(sender);
	        mimeMessageHelper.setTo(feed.getEmail());
	        mimeMessageHelper.setText("Dear " + feed.getCustomerName() + ",\n\n"
	            + "Thank You...! \nfor giving us your Valuable Feedback and Suggestion."
	            //+ "UserName : " + feed.getAdminUserName() + "\n"
	            //+ "Password : " + feed.getAdminPassword() + "\n"
	            // Add more relevant details as needed
	            + "\n\nBest Regards,\nAgriVenture Agrotourism");
	        mimeMessageHelper.setSubject("Giving Feedback and Suggestion");
	        
	        javaMailSender.send(mimeMessage);
	        
	        return "Mail sent successfully";
	    } 
	    catch (MessagingException e) 
	    {
	        return "Error while sending mail!!!";
	    }
	}
	

}

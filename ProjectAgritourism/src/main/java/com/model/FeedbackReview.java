package com.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class FeedbackReview 
{	
	 @Id
	 @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "feedback_seq")
	 @SequenceGenerator(name = "feedback_seq", sequenceName = "feedback_seq", initialValue = 700, allocationSize = 1)
	 private long feedbackID;
	 private String customerName;
	 private String email;
	 private String rating;
	 private LocalDate feedbackDate;
	 private String agrotourismService;
	 private String commentsuggestions;

	
	public FeedbackReview() 
	{
		super();
	}

	public FeedbackReview(long feedbackID, String customerName, String email, String rating, LocalDate feedbackDate,
			String agrotourismService, String commentsuggestions) {
		super();
		this.feedbackID = feedbackID;
		this.customerName = customerName;
		this.email = email;
		this.rating = rating;
		this.feedbackDate = feedbackDate;
		this.agrotourismService = agrotourismService;
		this.commentsuggestions = commentsuggestions;
	}

	public long getFeedbackID() {
		return feedbackID;
	}
	public void setFeedbackID(long feedbackID) {
		this.feedbackID = feedbackID;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}

	public LocalDate getFeedbackDate() {
		return feedbackDate;
	}
	public void setFeedbackDate(LocalDate feedbackDate) {
		this.feedbackDate = feedbackDate;
	}

	public String getAgrotourismService() {
		return agrotourismService;
	}
	public void setAgrotourismService(String agrotourismService) {
		this.agrotourismService = agrotourismService;
	}

	public String getCommentsuggestions() {
		return commentsuggestions;
	}
	public void setCommentsuggestions(String commentsuggestions) {
		this.commentsuggestions = commentsuggestions;
	}
	
		
	
	
	
	
	
	
	// @ManyToOne
		 // @JoinColumn(name = "customer_id") // name of the foreign key column in FeedbackReview table
		 // private CustomerRegistration customer;
	 
	 /*public FeedbackReview() 
	 {
		super();
	 }

	 public FeedbackReview(long feedbackID, String customerName, String email, int rating, String comment, Date feedbackDate, String agrotourismService, String location, String suggestions) 
	 {
		super();
		this.feedbackID = feedbackID;
		this.customerName = customerName;
		this.email = email;
		this.rating = rating;
		this.comment = comment;
		this.feedbackDate = feedbackDate;
		this.agrotourismService = agrotourismService;
		this.location = location;
		this.suggestions = suggestions;
	 }

	public long getFeedbackID() {
		return feedbackID;
	}
	public void setFeedbackID(long feedbackID) {
		this.feedbackID = feedbackID;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Date getFeedbackDate() {
		return feedbackDate;
	}
	public void setFeedbackDate(Date feedbackDate) {
		this.feedbackDate = feedbackDate;
	}
	
	public String getAgrotourismService() {
		return agrotourismService;
	}
	public void setAgrotourismService(String agrotourismService) {
		this.agrotourismService = agrotourismService;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getSuggestions() {
		return suggestions;
	}
	public void setSuggestions(String suggestions) {
		this.suggestions = suggestions;
	}*/
	  
	  
	  
}

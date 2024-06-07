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

import com.model.FeedbackReview;
import com.service.FeedbackReviewServiceImplement;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class FeedbackReviewController 
{
	@Autowired
	FeedbackReviewServiceImplement feedbackService;
	
	@PostMapping("/addFeed")
	public ResponseEntity<FeedbackReview> addFeedback(@RequestBody FeedbackReview feed)
	{
		FeedbackReview fd = feedbackService.addFeedback(feed);
		return ResponseEntity.status(HttpStatus.CREATED).header("Add", "Feedback Added").body(fd);
	}
	
	@GetMapping("/getFeed/{id}")
	public ResponseEntity<FeedbackReview> getPlayer(@PathVariable("id") long id) 
	{
		FeedbackReview p = feedbackService.getFeedbackById(id);
		return ResponseEntity.status(HttpStatus.OK).header("Get", "Player GET").body(p);
	}
	
	@GetMapping("/getAllFeed")
	public ResponseEntity<List<FeedbackReview>> getAll() 
	{
		List<FeedbackReview> fd = feedbackService.getAllFeedback();
		return ResponseEntity.status(HttpStatus.OK).header("Get", "ALL Feedback GET").body(fd);
	}
	
	@PutMapping("/updateFeed")
	public ResponseEntity<FeedbackReview> updateFeedback(@RequestBody FeedbackReview feed)
	{
		FeedbackReview fd = feedbackService.updateFeedback(feed);
		return ResponseEntity.status(HttpStatus.OK).header("Update", "Feedback Updated").body(fd);
	}

	@DeleteMapping("/deleteFeed/{id}")
	public ResponseEntity<Map<String, Object>> deleteFeedback(@PathVariable long id)
	{
		Map<String, Object> response = feedbackService.deleteFeedback(id);
		
		return ResponseEntity.ok(response);
	}
	
	
	/* @GetMapping("/getName/{name}")
	 public List<User> findByName(@PathVariable("name") String name) 
		{
			return userService.findByName(name);
		}*/
}

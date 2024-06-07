package com.service;

import java.util.List;
import java.util.Map;

import com.model.FeedbackReview;

public interface FeedbackReviewService 
{
	public FeedbackReview addFeedback(FeedbackReview feed);
	public FeedbackReview getFeedbackById(long id);
	public List<FeedbackReview> getAllFeedback();
	public FeedbackReview updateFeedback(FeedbackReview feed);
	/*public FeedbackReview deleteFeedback(long id);*/
	public Map<String, Object> deleteFeedback(long id);
	
	public String sendFeedbackMail(long id);
}

package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.FeedbackReview;

public interface FeedbackReviewRepository extends JpaRepository<FeedbackReview, Long>
{
	
}

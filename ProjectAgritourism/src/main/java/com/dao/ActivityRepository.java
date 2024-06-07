package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Activities;

public interface ActivityRepository extends JpaRepository<Activities, Long>
{
	Activities findByActivityName(String activityName);
	
	//Optional<Activities> findByActivityName(String activityName);
	
	//List<Activities> findAllActivity();
}

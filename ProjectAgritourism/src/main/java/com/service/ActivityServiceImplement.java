package com.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dao.ActivityRepository;
import com.model.Activities;

@Service
public class ActivityServiceImplement implements ActivityService
{
	@Autowired
	ActivityRepository activityRepo;

	@Override
	public Activities getActivityById(long id) 
	{
		return activityRepo.findById(id).orElse(null);
	}

	public Activities updateActivity(Long id, String activityDescription,  MultipartFile image) throws Exception 
	{
        Optional<Activities> existingActivityOptional = activityRepo.findById(id);

        if (existingActivityOptional.isPresent()) 
        {
        	Activities existingActivity = existingActivityOptional.get();
        	existingActivity.setActivityDescription(activityDescription);
        	existingActivity.setImage(image.getBytes());
            return activityRepo.save(existingActivity);
        } 
        else 
        {
        	 return null;
        }
    }

	@Override
	public Map<String, Object> deleteActivity(long id) 
	{
		Map<String, Object> response = new HashMap<>();
		Activities a = activityRepo.findById(id).orElse(null);
		
		if(a == null)
		{
			response.put("Not Deleted", "Activity Not Deleted Because ID not FOUND");
		}
		else
		{
			activityRepo.delete(a);
			response.put("Deleted", "Activity Deleted Successfully");
		}
		return response;
	}
	
	@Override
	public Activities storeActivityFile(String fileName, String activityDescription, MultipartFile file) 
	{
	   // String fileName = file.getOriginalFilename();
	    try 
	    {
	        Activities image = new Activities();
	        image.setActivityName(fileName);
	        image.setActivityDescription(activityDescription);  // Set the activity description
	        image.setImage(file.getBytes());
	        return activityRepo.save(image);
	    } 
	    catch (IOException ex) 
	    {
	        throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
	    }
	}

	@Override
	public List<Activities> getAllActivity() 
	{
		return activityRepo.findAll();
	}

}

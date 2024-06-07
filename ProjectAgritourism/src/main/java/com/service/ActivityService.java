package com.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.model.Activities;

public interface ActivityService 
{
	public Activities getActivityById(long id);
	public List<Activities> getAllActivity();
	public Activities updateActivity(Long id, String activityDescription, MultipartFile image) throws Exception;
	public Map<String, Object> deleteActivity(long id);
	Activities storeActivityFile(String fileName, String activityDescription, MultipartFile file);
}

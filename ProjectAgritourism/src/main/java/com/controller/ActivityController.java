package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.model.Activities;
import com.service.ActivityService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ActivityController 
{
	@Autowired
	ActivityService activityService;
	 
	 @GetMapping("/getActivity/{id}")
	 public ResponseEntity<Activities> getActivityById(@PathVariable long id) 
	 {
	    Activities activity = activityService.getActivityById(id);
	    if (activity != null) 
	    {
	    	return ResponseEntity.ok(activity);
	    } 
	    else 
	    {
	        return ResponseEntity.notFound().build();
	    }
	 }
	
	@PutMapping("/updateActivity/{id}")
	public ResponseEntity<Activities> updateActivity(@PathVariable Long id, @RequestParam("activityDescription") String activityDescription, @RequestParam("image") MultipartFile image) 
	{
        try 
        {
        	Activities updatedActivity = activityService.updateActivity(id, activityDescription, image);
            return ResponseEntity.ok(updatedActivity);
        } 
        catch (Exception e) 
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
	 
	@DeleteMapping("/deleteActivity/{id}")
	public ResponseEntity<Map<String, Object>> deleteAdmin(@PathVariable long id)
	{
		Map<String, Object> response = activityService.deleteActivity(id);	
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/uploadActivity")
	public ResponseEntity<Activities> uploadFile(
	        @RequestParam("fileName") String fileName,
	        @RequestParam("description") String description,
	        @RequestParam("file") MultipartFile file) 
	{
	    Activities activity = activityService.storeActivityFile(fileName, description,file);
	    return new ResponseEntity<>(activity, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/getAllActivities")
	  public ResponseEntity<List<Activities>> findAllActi() 
	  {
		  List<Activities> files = activityService.getAllActivity();
	      HttpHeaders headers = new HttpHeaders();
	      headers.add("Custom-Header", "All files retrieved");

	      return new ResponseEntity<>(files, headers, HttpStatus.OK);
	  }

}

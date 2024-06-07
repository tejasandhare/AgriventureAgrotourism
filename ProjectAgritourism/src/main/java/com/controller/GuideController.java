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

import com.model.Guide;
import com.service.GuideService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class GuideController 
{
	@Autowired
	GuideService guideService;
	
	@PostMapping("/saveGuide") 
	public ResponseEntity<Guide> addGuide(@RequestBody Guide guide)
	{
		Guide g = guideService.addGuide(guide);
		return ResponseEntity.status(HttpStatus.CREATED).header("Add", "Guide Added").body(g);
	}
	
	@GetMapping("/getGuide/{id}")
	public ResponseEntity<Guide> getAdmin(@PathVariable("id") long id) 
	{
		Guide g = guideService.getGuideById(id);
		return ResponseEntity.status(HttpStatus.OK).header("Get", "Guide GET").body(g);
	}
	
	@GetMapping("/getByName/{name}")
	public ResponseEntity<Guide> getByName(@PathVariable("name") String name) 
	{
		Guide g = guideService.findByGuideName(name);
		return ResponseEntity.status(HttpStatus.OK).header("Get", "Guide GET").body(g);
	}
	
	@GetMapping("/getAllGuides")
	public ResponseEntity<List<Guide>> getAll() 
	{
		List<Guide> g = guideService.getAllGuide();
		return ResponseEntity.status(HttpStatus.OK).header("Get", "ALL Guides GET").body(g);
	}
	
	@PutMapping("/updateGuides")
	public ResponseEntity<Guide> updateGuide(@RequestBody Guide guide)
	{
		Guide g = guideService.updateGuide(guide);
		return ResponseEntity.status(HttpStatus.OK).header("Update", "Guide Updated").body(g);
	}
	
	@DeleteMapping("/deleteGuides/{id}")
	public ResponseEntity<Map<String, Object>> deleteGuide(@PathVariable long id)
	{
		Map<String, Object> response = guideService.deleteGuide(id);
		
		return ResponseEntity.ok(response);
	}
}

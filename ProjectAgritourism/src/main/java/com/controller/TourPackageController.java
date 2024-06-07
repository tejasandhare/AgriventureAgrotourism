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

import com.model.TourPackage;

import com.service.TourPackageService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TourPackageController 
{
	@Autowired
	TourPackageService packageService;
	
	@PostMapping("/addTourPackage")
	public ResponseEntity<TourPackage> addPackages(@RequestBody TourPackage tour)
	{
		TourPackage t = packageService.addPackage(tour);
		return ResponseEntity.status(HttpStatus.CREATED).header("Add", "TourPackage Added").body(t);
	}
	
	/*@PostMapping("/addTourPackage")
    public ResponseEntity<TourPackage> addPackages(@RequestBody TourPackageRequest tourPackageRequest) {
        TourPackage tour = new TourPackage();
        tour.setPackageType(tourPackageRequest.getPackageType());
        tour.setPackagePrice(tourPackageRequest.getPackagePrice());
        tour.setAccommodationType(tourPackageRequest.getAccommodationType());
        tour.setPackageDescription(tourPackageRequest.getPackageDescription());

        // Retrieve activity IDs based on activity names
        List<Activities> activities = new ArrayList<>();
        for (String activityName : tourPackageRequest.getActivityNames()) {
            Activities existingActivity = activityRepo.findByActivityName(activityName);
            if (existingActivity != null) 
            {
                activities.add(existingActivity);
            }
        }
        tour.setActivitiesName(activities);

        TourPackage savedTourPackage = packageService.addPackage(tour);
        return ResponseEntity.status(HttpStatus.CREATED).header("Add", "TourPackage Added").body(savedTourPackage);
    }*/
	
	@GetMapping("/getPackage/{id}")
	public ResponseEntity<TourPackage> getPackage(@PathVariable("id") long id) 
	{
		TourPackage tour = packageService.getPackageById(id);
		return ResponseEntity.status(HttpStatus.OK).header("Get", "Package GET").body(tour);
	}
	
	/*@GetMapping("/getAllPackages")
	public ResponseEntity<List<TourPackage>> getAll() 
	{
		List<TourPackage> p = packageService.getAllPackage();
		return ResponseEntity.status(HttpStatus.OK).header("Get", "ALL Packages GET").body(p);
	}*/
	
	@GetMapping("/getAllTourPackages")
	public ResponseEntity<List<TourPackage>> getAll() 
	{
		List<TourPackage> p = packageService.getAllPackage();
		return ResponseEntity.status(HttpStatus.OK).header("Get", "ALL Packages GET").body(p);
	}

	

	/*@PutMapping("/updatePackages")
	public ResponseEntity<TourPackage> updateGuide(@RequestBody TourPackage tour)
	{
		TourPackage p = packageService.updatePackage(tour);
		return ResponseEntity.status(HttpStatus.OK).header("Update", "Package Updated").body(p);
	}*/
	@PutMapping("/updatePackage/{id}")
    public ResponseEntity<TourPackage> updatePackage(@PathVariable("id") long packageId, @RequestBody TourPackage updatedPackage) 
	{
        TourPackage p = packageService.updatePackage(packageId, updatedPackage);
        if (p != null) 
        {
            return ResponseEntity.status(HttpStatus.OK).header("Update", "Package Updated").body(p);
        } 
        else 
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).header("Update", "Package Not Found").build();
        }
    }
	
	
	@DeleteMapping("/deletePackages/{id}")
	public ResponseEntity<Map<String, Object>> deletePackage(@PathVariable long id)
	{
		Map<String, Object> response = packageService.deletePackage(id);
		
		return ResponseEntity.ok(response);
	}
}

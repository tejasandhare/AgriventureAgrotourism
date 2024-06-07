package com.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ActivityRepository;
import com.dao.TourPackageRepository;
import com.model.Activities;
import com.model.TourPackage;

@Service
public class TourPackageServiceImplement implements TourPackageService
{
	/*@Autowired
	TourPackageRepository packageRepo;
	
	@Override
	public TourPackage addPackage(TourPackage tour) 
	{
		return packageRepo.save(tour);
	}*/
	
	@Autowired
    TourPackageRepository packageRepo;

    @Autowired
    ActivityRepository activityRepo;

    @Override
    public TourPackage addPackage(TourPackage tour) 
    {
        // Retrieve activity IDs based on activity names
        List<Activities> activities = new ArrayList<>();
        for (Activities activity : tour.getActivitiesName()) 
        {
            Activities existingActivity = activityRepo.findByActivityName(activity.getActivityName());
            if (existingActivity != null) 
            {
                activities.add(existingActivity);
            }
        }
        tour.setActivitiesName(activities);
        return packageRepo.save(tour);
    }
    
    @Override
	public TourPackage getPackageById(long id) 
    {
    	return packageRepo.findById(id).orElse(null);
	}

	@Override
	public List<TourPackage> getAllPackage()
	{
		return packageRepo.findAll();
	}

	/*@Override
	public TourPackage updatePackage(TourPackage tour) 
	{
		TourPackage existingPackage = packageRepo.findById(tour.getPackageId()).orElse(null);
		existingPackage.setPackageName(tour.getPackageName());
		existingPackage.setPackagePrice(tour.getPackagePrice());
		existingPackage.setPackageDescription(tour.getPackageDescription());
		
		TourPackage updatedPackage = packageRepo.save(existingPackage);
		return updatedPackage;
	}*/
	@Override
    public TourPackage updatePackage(long packageId, TourPackage updatedPackage) 
	{
        TourPackage existingPackage = packageRepo.findById(packageId).orElse(null);
        if (existingPackage != null) 
        {
            existingPackage.setPackagePrice(updatedPackage.getPackagePrice());
            existingPackage.setPackageDescription(updatedPackage.getPackageDescription());
            List<Activities> updatedActivities = new ArrayList<>();
            for (Activities activity : updatedPackage.getActivitiesName()) 
            {
                Activities existingActivity = activityRepo.findByActivityName(activity.getActivityName());
                if (existingActivity != null) 
                {
                    updatedActivities.add(existingActivity);
                }
            }
            existingPackage.setActivitiesName(updatedActivities);
            return packageRepo.save(existingPackage);
        }
        return null; // Handle case when packageId is not found
    }
	

	@Override
	public Map<String, Object> deletePackage(long id) 
	{
		Map<String, Object> response = new HashMap<>();
		TourPackage pack = packageRepo.findById(id).orElse(null);
		
		if(pack == null)
		{
			response.put("Not Deleted", "Package Not Deleted Because ID not FOUND");
		}
		else
		{
			packageRepo.delete(pack);
			response.put("Deleted", "Package Deleted Successfully");
		}
		return response;
	}

	

}

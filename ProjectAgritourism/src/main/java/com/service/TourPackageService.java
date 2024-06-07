package com.service;

import java.util.List;
import java.util.Map;

import com.model.TourPackage;

public interface TourPackageService 
{
	public TourPackage addPackage(TourPackage tour);
	public TourPackage getPackageById(long id);
	public List<TourPackage> getAllPackage();
	//public TourPackage updatePackage(TourPackage tour);
	public TourPackage updatePackage(long packageId, TourPackage updatedPackage);
	/*public TourPackage deletePackage(long id);*/
	public Map<String, Object> deletePackage(long id);
}

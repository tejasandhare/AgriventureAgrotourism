package com.service;

import java.util.List;
import java.util.Map;

import com.model.LivingHome;

public interface LivingHomeService 
{
	public LivingHome addHome(LivingHome home);
	public LivingHome getHomeById(long id);
	public LivingHome findByHomeType(String homeType);
	public List<LivingHome> getAllHome();
	public LivingHome updateHome(LivingHome home);
	/*public LivingHome deleteHome(long id);*/
	public Map<String, Object> deleteHome(long id);
	
}

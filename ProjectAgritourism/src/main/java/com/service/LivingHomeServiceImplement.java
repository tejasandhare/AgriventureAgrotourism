package com.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.LivingHomeRepository;
import com.model.LivingHome;

@Service
public class LivingHomeServiceImplement implements LivingHomeService
{
	@Autowired
	LivingHomeRepository homeRepo;

	@Override
	public LivingHome addHome(LivingHome home) 
	{
		return homeRepo.save(home);
	}

	@Override
	public List<LivingHome> getAllHome() 
	{
		return homeRepo.findAll();
	}

	/*@Override
	public LivingHome updateHome(LivingHome home) 
	{
		LivingHome existingHome = homeRepo.findById(home.getHomeId()).orElse(null);
		//existingHome.setHomeType(home.getHomeType());
		existingHome.setHomeDescription(home.getHomeDescription());
		existingHome.setHomeRent(home.getHomeRent());
		
		LivingHome updatedHome = homeRepo.save(existingHome);
		return updatedHome;
	}*/
	@Override
    public LivingHome updateHome(LivingHome home) 
	{
        LivingHome existingHome = homeRepo.findById(home.getHomeId()).orElse(null);
        if (existingHome != null) 
        {
            existingHome.setHomeDescription(home.getHomeDescription());
            existingHome.setHomeRent(home.getHomeRent());
            return homeRepo.save(existingHome);
        }
        return null;
    }
	

	@Override
	public Map<String, Object> deleteHome(long id) 
	{
		Map<String, Object> response = new HashMap<>();
		LivingHome hm = homeRepo.findById(id).orElse(null);
		
		if(hm == null)
		{
			response.put("Not Deleted", "Home Not Deleted Because ID not FOUND");
		}
		else
		{
			homeRepo.delete(hm);
			response.put("Deleted", "Home Deleted Successfully");
		}
		return response;
	}

	@Override
	public LivingHome getHomeById(long id) 
	{
		return homeRepo.findById(id).orElse(null);
	}

	@Override
	public LivingHome findByHomeType(String homeType) {
		return homeRepo.findByHomeType(homeType);
	}
	
	
}

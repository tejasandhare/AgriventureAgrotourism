package com.service;

import java.util.List;
import java.util.Map;

import com.model.Guide;

public interface GuideService 
{
	public Guide addGuide(Guide guide);
	public Guide getGuideById(long id);
	public Guide findByGuideName(String guideName);
	public List<Guide> getAllGuide();
	public Guide updateGuide(Guide guide);
	//public Guide deleteGuide(long id);
	public Map<String, Object> deleteGuide(long id);
	
	public String sendRegistrationMail(long id);
	
	public String sendUpdateDetailsMail(long id);
}

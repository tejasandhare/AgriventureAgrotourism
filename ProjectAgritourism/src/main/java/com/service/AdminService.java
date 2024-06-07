package com.service;

import java.util.List;
import java.util.Map;

import com.model.Admin;

public interface AdminService 
{
	public Admin addAdmin(Admin ad);
	public Admin getAdminById(long id);
	public List<Admin> getAllAdmin();
	public Admin updateAdmin(Admin admin);
	/*public Admin deleteAdmin(long id);*/
	public Map<String, Object> deleteAdmin(long id);
	
	public String sendRegistrationMail(long id);
	
	//Admin authenticate(String adminUserName, String adminPassword);
	public Map<String, Object> authenticate(String adminUserName, String adminPassword);
}

package com.model;

import java.util.Random;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Admin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_seq")
    @SequenceGenerator(name = "admin_seq", sequenceName = "admin_sequence", allocationSize = 111)
	private long adminId;
	private String adminName;
	private String adminPhoneNo;
	private String adminEmail;
	private String adminUserName;
	private String adminPassword;
	
	public Admin() 
	{
		super();
	}

	public Admin(long adminId, String adminName, String adminPhoneNo, String adminEmail, String adminUserName, String adminPassword) 
	{
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPhoneNo = adminPhoneNo;
		this.adminEmail = adminEmail;
		this.adminUserName = adminUserName;
		this.adminPassword = adminPassword;
	}

	public long getAdminId() 
	{
		return adminId;
	}
	public void setAdminId(long adminId) 
	{
		this.adminId = adminId;
	}

	public String getAdminName() 
	{
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPhoneNo() {
		return adminPhoneNo;
	}
	public void setAdminPhoneNo(String adminPhoneNo) 
	{
		this.adminPhoneNo = adminPhoneNo;
	}

	public String getAdminEmail() 
	{
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) 
	{
		this.adminEmail = adminEmail;
	}

	public String getAdminUserName() 
	{
		return adminUserName;
	}
	public void setAdminUserName(String adminUserName) 
	{
		this.adminUserName = adminUserName;
	}

	public String getAdminPassword() 
	{
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) 
	{
		this.adminPassword = adminPassword;
	}
	
	
	
	@PrePersist
    public void prePersist() 
	{
        generateCredentials();
    }

	private void generateCredentials() 
	{
        this.adminUserName = generateRandomString(8);
        this.adminPassword = generateRandomString(6);
    }
	
	 private String generateRandomString(int length) 
	 {
	        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        StringBuilder stringBuilder = new StringBuilder();
	        Random rnd = new Random();
	        while (stringBuilder.length() < length) 
	        {
	            int index = (int) (rnd.nextFloat() * chars.length());
	            stringBuilder.append(chars.charAt(index));
	        }
	        return stringBuilder.toString();
	  }
	
}








/*@GeneratedValue(strategy=GenerationType.AUTO)*/

//@OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, orphanRemoval = true)
//private List<CustomerRegistration> customers;
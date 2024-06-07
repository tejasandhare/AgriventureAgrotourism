package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class LivingHome 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "home_seq_gen")
    @SequenceGenerator(name = "home_seq_gen", sequenceName = "home_id_seq", allocationSize = 1201)
  	private long homeId;
	private String homeType;
	private String homeDescription;
	private String homeRent;
	  
	public LivingHome() 
	{
		super();
	}

	public LivingHome(long homeId, String homeType, String homeDescription, String homeRent) {
		super();
		this.homeId = homeId;
		this.homeType = homeType;
		this.homeDescription = homeDescription;
		this.homeRent = homeRent;
	}

	public long getHomeId() {
		return homeId;
	}

	public void setHomeId(long homeId) {
		this.homeId = homeId;
	}

	public String getHomeType() {
		return homeType;
	}

	public void setHomeType(String homeType) {
		this.homeType = homeType;
	}

	public String getHomeDescription() {
		return homeDescription;
	}

	public void setHomeDescription(String homeDescription) {
		this.homeDescription = homeDescription;
	}

	public String getHomeRent() {
		return homeRent;
	}

	public void setHomeRent(String homeRent) {
		this.homeRent = homeRent;
	}
	
	
	

//	public LivingHome(long homeId, String homeType, String homeDescription) {
//		super();
//		this.homeId = homeId;
//		this.homeType = homeType;
//		this.homeDescription = homeDescription;
//	}
//
//	public long getHomeId() {
//		return homeId;
//	}
//	public void setHomeId(long homeId) {
//		this.homeId = homeId;
//	}
//
//	public String getHomeType() {
//		return homeType;
//	}
//	public void setHomeType(String homeType) {
//		this.homeType = homeType;
//	}
//	public String getHomeDescription() {
//		return homeDescription;
//	}
//	public void setHomeDescription(String homeDescription) {
//		this.homeDescription = homeDescription;
//	}
	
}

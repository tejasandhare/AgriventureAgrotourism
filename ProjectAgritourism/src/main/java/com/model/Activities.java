package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Activities 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activity_seq")
    @SequenceGenerator(name = "activity_seq", sequenceName = "activity_sequence", allocationSize = 901)
	private long activityId;
	private String activityName;
	private String activityDescription;
	
	@Column(length = 1000000) // Adjust the length as needed
	@Lob
	private byte[] image;
	//private String image;
	
//    @ManyToMany(mappedBy = "activitiesName")
//    private List<TourPackage> tourPackages;

	public Activities()
	{
		super();
	}

	/*public Activities(long activityId, String activityName, String activityDescription, byte[] image,
			List<TourPackage> tourPackages) {
		super();
		this.activityId = activityId;
		this.activityName = activityName;
		this.activityDescription = activityDescription;
		this.image = image;
		this.tourPackages = tourPackages;
	}

	public long getActivityId() {
		return activityId;
	}
	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityDescription() {
		return activityDescription;
	}
	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}

	public List<TourPackage> getTourPackages() {
		return tourPackages;
	}
	public void setTourPackages(List<TourPackage> tourPackages) {
		this.tourPackages = tourPackages;
	}*/

	
	

	public Activities(long activityId, String activityName, String activityDescription, byte[] image) {
		super();
		this.activityId = activityId;
		this.activityName = activityName;
		this.activityDescription = activityDescription;
		this.image = image;
	}

	public long getActivityId() {
		return activityId;
	}
	public void setActivityId(long activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityDescription() {
		return activityDescription;
	}
	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}

	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}	
	
	
	
	
}


/*  */

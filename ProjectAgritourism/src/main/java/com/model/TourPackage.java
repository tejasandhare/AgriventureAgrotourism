package com.model;

import java.util.List;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class TourPackage 
{
		@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long packageId;
	    private String packageName; // Ex.: oneday, twoday, threeday
	    private String packagePrice;
	    
	    @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(
	        name = "tour_package_activities",
	        joinColumns = @JoinColumn(name = "package_id"),
	        inverseJoinColumns = @JoinColumn(name = "activity_id")
	    )
	    private List<Activities> activitiesName;
	    //  @ManyToMany(fetch = FetchType.EAGER)
		  //  @JoinColumn(name = "activityName")

	    private String packageDescription;

	    // Constructors, getters, and setters

	    public TourPackage() {
			super();
	    }

		public TourPackage(long packageId, String packageName, String packagePrice, List<Activities> activitiesName,
				String packageDescription) {
			super();
			this.packageId = packageId;
			this.packageName = packageName;
			this.packagePrice = packagePrice;
			this.activitiesName = activitiesName;
			this.packageDescription = packageDescription;
		}

		public long getPackageId() {
			return packageId;
		}
		public void setPackageId(long packageId) {
			this.packageId = packageId;
		}

		public String getPackageName() {
			return packageName;
		}
		public void setPackageName(String packageName) {
			this.packageName = packageName;
		}

		public String getPackagePrice() {
			return packagePrice;
		}
		public void setPackagePrice(String packagePrice) {
			this.packagePrice = packagePrice;
		}

		public List<Activities> getActivitiesName() {
			return activitiesName;
		}
		public void setActivitiesName(List<Activities> activitiesName) {
			this.activitiesName = activitiesName;
		}

		public String getPackageDescription() {
			return packageDescription;
		}
		public void setPackageDescription(String packageDescription) {
			this.packageDescription = packageDescription;
		}

	    
	    
		/*public TourPackage(long packageId, String packageName, String packagePrice, List<Activities> activitiesName,
				String packageDescription) {
			super();
			this.packageId = packageId;
			this.packageName = packageName;
			this.packagePrice = packagePrice;
			this.activitiesName = activitiesName;
			this.packageDescription = packageDescription;
		}

		public long getPackageId() {
			return packageId;
		}
		public void setPackageId(long packageId) {
			this.packageId = packageId;
		}
		public String getPackageName() {
			return packageName;
		}

		public void setPackageName(String packageName) {
			this.packageName = packageName;
		}
		public String getPackagePrice() {
			return packagePrice;
		}

		public void setPackagePrice(String packagePrice) {
			this.packagePrice = packagePrice;
		}
		public List<Activities> getActivitiesName() {
			return activitiesName;
		}

		public void setActivitiesName(List<Activities> activitiesName) {
			this.activitiesName = activitiesName;
		}
		public String getPackageDescription() {
			return packageDescription;
		}

		public void setPackageDescription(String packageDescription) {
			this.packageDescription = packageDescription;
		}
		public void addActivity(Activities activity) {
	        if (activitiesName == null) {
	        	activitiesName = new ArrayList<>();
	        }
	        activitiesName.add(activity);
	    }*/

		
		
		
		
		
		   // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tourpackage_seq")
		   // @SequenceGenerator(name = "tourpackage_seq", sequenceName = "tourpackage_sequence", allocationSize = 901)
		  
		
		// @ElementCollection
		   // private List<String> activityNames; // Storing activity names directly
		 
	    //private String accommodationType; // Type of accommodation provided during the tour (e.g., farmhouse, guesthouse)
		
		
		/*@Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tourpackage_seq")
	    @SequenceGenerator(name = "tourpackage_seq", sequenceName = "tourpackage_sequence", allocationSize = 901)
		private long packageId;
		private String packageType; //Ex.: oneday, twoday, threeday
		private String packagePrice;
		//@ElementCollection
	    //private List<String> activities; // Activities included in the tour package (e.g., farm visit, fruit picking, animal feeding)
		//@OneToMany(cascade = CascadeType.ALL) // Define the one-to-many relationship
		//private List<Activities> activities; // Activities included in the tour package

		private String accommodationType; // Type of accommodation provided during the tour (e.g., farmhouse, guesthouse)
		private String packageDescription;*/
		
		/*public TourPackage() {
			super();
		}
		
		

		public TourPackage(long packageId, String packageType, String packagePrice, List<Activities> activities,
				String accommodationType, String packageDescription) {
			super();
			this.packageId = packageId;
			this.packageType = packageType;
			this.packagePrice = packagePrice;
			this.activities = activities;
			this.accommodationType = accommodationType;
			this.packageDescription = packageDescription;
		}

		public long getPackageId() {
			return packageId;
		}
		public void setPackageId(long packageId) {
			this.packageId = packageId;
		}

		public String getPackageType() {
			return packageType;
		}
		public void setPackageType(String packageType) {
			this.packageType = packageType;
		}

		public String getPackagePrice() {
			return packagePrice;
		}
		public void setPackagePrice(String packagePrice) {
			this.packagePrice = packagePrice;
		}

		public List<Activities> getActivities() {
			return activities;
		}
		public void setActivities(List<Activities> activities) {
			this.activities = activities;
		}

		public String getAccommodationType() {
			return accommodationType;
		}
		public void setAccommodationType(String accommodationType) {
			this.accommodationType = accommodationType;
		}

		public String getPackageDescription() {
			return packageDescription;
		}
		public void setPackageDescription(String packageDescription) {
			this.packageDescription = packageDescription;
		}*/

		
		
		

		/*public TourPackage(long packageId, String packageType, String packagePrice, List<String> activities,
				String accommodationType, String packageDescription) {
			super();
			this.packageId = packageId;
			this.packageType = packageType;
			this.packagePrice = packagePrice;
			this.activities = activities;
			this.accommodationType = accommodationType;
			this.packageDescription = packageDescription;
		}

		public long getPackageId() {
			return packageId;
		}
		public void setPackageId(long packageId) {
			this.packageId = packageId;
		}

		public String getPackageType() {
			return packageType;
		}
		public void setPackageType(String packageType) {
			this.packageType = packageType;
		}

		public String getPackagePrice() {
			return packagePrice;
		}
		public void setPackagePrice(String packagePrice) {
			this.packagePrice = packagePrice;
		}

		public List<String> getActivities() {
			return activities;
		}
		public void setActivities(List<String> activities) {
			this.activities = activities;
		}

		public String getAccommodationType() {
			return accommodationType;
		}
		public void setAccommodationType(String accommodationType) {
			this.accommodationType = accommodationType;
		}

		public String getPackageDescription() {
			return packageDescription;
		}
		public void setPackageDescription(String packageDescription) {
			this.packageDescription = packageDescription;
		}*/
		
		
		
		
		
	    	    
	    /*public TourPackage(long packageId, String packageName, String packagePrice, List<Activities> activitiesName,
				String accommodationType, String packageDescription) {
			super();
			this.packageId = packageId;
			this.packageName = packageName;
			this.packagePrice = packagePrice;
			this.activitiesName = activitiesName;
			this.accommodationType = accommodationType;
			this.packageDescription = packageDescription;
		}

		public long getPackageId() {
			return packageId;
		}
		public void setPackageId(long packageId) {
			this.packageId = packageId;
		}

		public String getpackageName() {
			return packageName;
		}
		public void setpackageName(String packageName) {
			this.packageName = packageName;
		}

		public String getPackagePrice() {
			return packagePrice;
		}
		public void setPackagePrice(String packagePrice) {
			this.packagePrice = packagePrice;
		}

		public List<Activities> getActivitiesName() {
			return activitiesName;
		}
		public void setActivitiesName(List<Activities> activitiesName) {
			this.activitiesName = activitiesName;
		}

		public String getAccommodationType() {
			return accommodationType;
		}
		public void setAccommodationType(String accommodationType) {
			this.accommodationType = accommodationType;
		}

		public String getPackageDescription() {
			return packageDescription;
		}
		public void setPackageDescription(String packageDescription) {
			this.packageDescription = packageDescription;
		}*/

		
	   
	    
}

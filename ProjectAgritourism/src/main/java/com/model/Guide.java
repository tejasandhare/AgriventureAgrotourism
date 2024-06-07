package com.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Guide 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guide_seq")
    @SequenceGenerator(name = "guide_seq", sequenceName = "guide_sequence", allocationSize = 10011)
	private long guideId;
	private String guideName;
	private String guideMoNo;
	private String guideEmail;
	
	public Guide() 
	{
		super();
	}

	public Guide(long guideId, String guideName, String guideMoNo, String guideEmail) {
		super();
		this.guideId = guideId;
		this.guideName = guideName;
		this.guideMoNo = guideMoNo;
		this.guideEmail = guideEmail;
	}

	public long getGuideId() {
		return guideId;
	}
	public void setGuideId(long guideId) {
		this.guideId = guideId;
	}

	public String getGuideName() {
		return guideName;
	}
	public void setGuideName(String guideName) {
		this.guideName = guideName;
	}

	public String getGuideMoNo() {
		return guideMoNo;
	}
	public void setGuideMoNo(String guideMoNo) {
		this.guideMoNo = guideMoNo;
	}

	public String getGuideEmail() {
		return guideEmail;
	}
	public void setGuideEmail(String guideEmail) {
		this.guideEmail = guideEmail;
	}

	
}

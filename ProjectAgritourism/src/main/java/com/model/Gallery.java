package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Gallery 
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_seq")
    @SequenceGenerator(name = "image_seq", sequenceName = "image_sequence", allocationSize = 201)
	private long imageId;
	//private String name;
	
	@Column(length = 1000000) // Adjust the length as needed
	@Lob
	private byte[] image;
	
	public Gallery() 
	{
		super();
	}

	public Gallery(long imageId, /*String name,*/ byte[] image) {
		super();
		this.imageId = imageId;
		//this.name = name;
		this.image = image;
	}

	public long getImageId() {
		return imageId;
	}

	public void setImageId(long imageId) {
		this.imageId = imageId;
	}
	
	/*public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}*/

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
}

package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Gallery;

public interface GalleryRepository extends JpaRepository<Gallery, Long>
{
	//Optional<Gallery> findByName(String name);
	
	//List<Gallery> findAll();
}

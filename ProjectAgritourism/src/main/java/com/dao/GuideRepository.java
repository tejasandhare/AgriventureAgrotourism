package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Guide;

public interface GuideRepository extends JpaRepository<Guide, Long> 
{
	Guide findByGuideName(String guideName);
}

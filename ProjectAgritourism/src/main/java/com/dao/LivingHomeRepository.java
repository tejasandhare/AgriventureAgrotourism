package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.LivingHome;

public interface LivingHomeRepository extends JpaRepository<LivingHome, Long>
{
	LivingHome findByHomeType(String homeType);
}

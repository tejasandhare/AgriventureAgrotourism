package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.model.TourPackage;

public interface TourPackageRepository extends JpaRepository<TourPackage, Long> 
{
	TourPackage findByPackageName(String packageType);
}

package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.CustomerRegistration;

public interface CustomerRegistrationRepository extends JpaRepository<CustomerRegistration, Long>
{

}

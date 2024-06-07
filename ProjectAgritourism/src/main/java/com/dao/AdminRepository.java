package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>
{
	Admin findByAdminUserNameAndAdminPassword(String username, String password);
}

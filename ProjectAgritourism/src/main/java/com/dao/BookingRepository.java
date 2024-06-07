package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long>
{

}

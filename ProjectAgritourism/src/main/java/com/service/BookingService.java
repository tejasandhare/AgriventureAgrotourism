package com.service;

import java.util.List;
import java.util.Map;

import com.model.Booking;

public interface BookingService 
{
	//public Booking addBooking(Booking book);
	public Booking getBookingById(long id);
	public List<Booking> getAllBooking();
	public Booking updateBooking(Booking book);
	//public Booking deleteBooking(long id);
	public Map<String, Object> deleteBooking(long id);
	
	//public String sendMailWithAttachment(Long id);
	
	void saveBookingAndSendEmail(Booking booking);
}

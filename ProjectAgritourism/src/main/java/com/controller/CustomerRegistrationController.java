package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.CustomerRegistration;
import com.service.CustomerRegistrationService;

@RestController
public class CustomerRegistrationController 
{
	@Autowired
	CustomerRegistrationService customerService;
	
	@PostMapping("/addCustomer")
	public ResponseEntity<CustomerRegistration> addCustomer(@RequestBody CustomerRegistration custo)
	{
		CustomerRegistration c = customerService.saveCustomer(custo);
		return ResponseEntity.status(HttpStatus.CREATED).header("Add", "Player Added").body(c);
	}
	
	@GetMapping("/getCustomer/{id}")
	public ResponseEntity<CustomerRegistration> getCustomer(@PathVariable("id") long id) 
	{
		CustomerRegistration c = customerService.getCustomerById(id);
		return ResponseEntity.status(HttpStatus.OK).header("Get", "Customer GET").body(c);
	}
	
	@GetMapping("/getAllCustomer")
	public ResponseEntity<List<CustomerRegistration>> getAll() 
	{
		List<CustomerRegistration> c = customerService.getAllCustomer();
		return ResponseEntity.status(HttpStatus.OK).header("Get", "ALL Customer GET").body(c);
	}
	
	@PutMapping("/updateCust")
	public ResponseEntity<CustomerRegistration> updateCustomer(@RequestBody CustomerRegistration cust)
	{
		CustomerRegistration c = customerService.updateCustomer(cust);
		return ResponseEntity.status(HttpStatus.OK).header("Update", "Admin Updated").body(c);
	}
	
	@DeleteMapping("/deleteCust/{id}")
	public ResponseEntity<Map<String, Object>> deleteCustomer(@PathVariable long id)
	{
		Map<String, Object> response = customerService.deleteCustomer(id);
		
		return ResponseEntity.ok(response);
	}
	
}

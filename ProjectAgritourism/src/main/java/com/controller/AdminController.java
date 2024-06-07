package com.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Admin;
import com.service.AdminServiceImplement;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AdminController 
{
	@Autowired
	AdminServiceImplement adminService;
	
	@PostMapping("/addAdmin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin)
	{
		Admin a = adminService.addAdmin(admin);
		return ResponseEntity.status(HttpStatus.CREATED).header("Add", "Admin Added").body(a);
	}
	
	@GetMapping("/getAdmin/{id}")
	public ResponseEntity<Admin> getAdmin(@PathVariable("id") long id) 
	{
		Admin a = adminService.getAdminById(id);
		return ResponseEntity.status(HttpStatus.OK).header("Get", "Admin GET").body(a);
	}
	
	@GetMapping("/getAllAdmin")
	public ResponseEntity<List<Admin>> getAll() 
	{
		List<Admin> a = adminService.getAllAdmin();
		return ResponseEntity.status(HttpStatus.OK).header("Get", "ALL Admin GET").body(a);
	}
	
	@PutMapping("/updateAdmin")
	public ResponseEntity<Admin> updateAdmin(@RequestBody Admin admin)
	{
		Admin a = adminService.updateAdmin(admin);
		return ResponseEntity.status(HttpStatus.OK).header("Update", "Admin Updated").body(a);
	}
	
	@DeleteMapping("/deleteAd/{id}")
	public ResponseEntity<Map<String, Object>> deleteAdmin(@PathVariable long id)
	{
		Map<String, Object> response = adminService.deleteAdmin(id);
		
		return ResponseEntity.ok(response);
	}

//		@PostMapping("/authenticate")
//		public ResponseEntity<Admin> addAdminn(@RequestBody Admin admin)
//		{
//			Admin admin1 = adminService.authenticate(admin.getAdminUserName(), admin.getAdminPassword());
//	        if (admin1 != null) {
//	            return ResponseEntity.ok(admin1);
//	        } else {
//	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//	        }
//		}
	
	
	@PostMapping("/authenticate")
	public ResponseEntity<Map<String, Object>> authenticate(@RequestBody Admin admin)
	{
	    Map<String, Object> response = adminService.authenticate(admin.getAdminUserName(), admin.getAdminPassword());
	    if ((boolean) response.get("success")) 
	    {
	        return ResponseEntity.ok(response);
	    } 
	    else 
	    {
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	    }
	}
}

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

import com.model.LivingHome;
import com.service.LivingHomeService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class LivingHomeController 
{
	@Autowired
	LivingHomeService homeService;
	
	@PostMapping("/addHome")
	public ResponseEntity<LivingHome> addAdmin(@RequestBody LivingHome home)
	{
		LivingHome h = homeService.addHome(home);
		return ResponseEntity.status(HttpStatus.CREATED).header("Add", "Home Added").body(h);
	}
	
	/*@GetMapping("/getAllHomes")
	public ResponseEntity<List<LivingHome>> getAll() 
	{
		List<LivingHome> h = homeService.getAllHome();
		return ResponseEntity.status(HttpStatus.OK).header("Get", "ALL Homes GET").body(h);
	}*/
	
	@GetMapping("/getAllLivingHomes")
	public ResponseEntity<List<LivingHome>> getAll() 
	{
		List<LivingHome> h = homeService.getAllHome();
		return ResponseEntity.status(HttpStatus.OK).header("Get", "ALL Homes GET").body(h);
	}
	
	/*@GetMapping("/getHome/{id}")
	public ResponseEntity<LivingHome> getHome(@PathVariable("id") long id) 
	{
		LivingHome h = homeService.getHomeById(id);
		return ResponseEntity.status(HttpStatus.OK).header("Get", "Home GET").body(h);
	}*/
	@GetMapping("/getHome/{id}")
    public ResponseEntity<LivingHome> getHome(@PathVariable("id") long id) 
	{
        LivingHome h = homeService.getHomeById(id);
        return ResponseEntity.ok(h);
    }
	
	@GetMapping("/getByHomeType/{hometype}")
	public ResponseEntity<LivingHome> getByHomeType(@PathVariable("name") String name) 
	{
		LivingHome h = homeService.findByHomeType(name);
		return ResponseEntity.status(HttpStatus.OK).header("Get", "Home GET").body(h);
	}
	
	/*@PutMapping("/updateHomes")
	public ResponseEntity<LivingHome> updateHome(@RequestBody LivingHome home)
	{
		LivingHome h = homeService.updateHome(home);
		return ResponseEntity.status(HttpStatus.OK).header("Update", "Home Updated").body(h);
	}*/
    @PutMapping("/updateHomes/{id}")
    public ResponseEntity<LivingHome> updateHome(@PathVariable("id") long id, @RequestBody LivingHome home) 
    {
        home.setHomeId(id);
        LivingHome updatedHome = homeService.updateHome(home);
        if (updatedHome != null) 
        {
            return ResponseEntity.ok(updatedHome);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
	@DeleteMapping("/deleteHomes/{id}")
	public ResponseEntity<Map<String, Object>> deleteHome(@PathVariable long id)
	{
		Map<String, Object> response = homeService.deleteHome(id);
		
		return ResponseEntity.ok(response);
	}
}








/*@GetMapping("/getAdmin/{id}")
public ResponseEntity<LivingHome> getHome(@PathVariable("id") long id) 
{
	LivingHome h = homeService.get(id);
	return ResponseEntity.status(HttpStatus.OK).header("Get", "Admin GET").body(a);
}*/

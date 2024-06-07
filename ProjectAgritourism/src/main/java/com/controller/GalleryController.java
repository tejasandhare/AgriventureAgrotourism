package com.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.model.Gallery;
import com.service.GalleryService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class GalleryController 
{
	@Autowired
	GalleryService galleryService;
	
	@PutMapping("/updateGallery/{id}")
	public ResponseEntity<Gallery> updatePhoto(@PathVariable Long id, @RequestParam("image") MultipartFile image) 
	{
        try 
        {
            Gallery updatedGallery = galleryService.updatePhoto(id, image);
            return ResponseEntity.ok(updatedGallery);
        } 
        catch (Exception e) 
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
		
	@DeleteMapping("/deletePhoto/{id}")
	public ResponseEntity<Map<String, Object>> deletePhoto(@PathVariable long id)
	{
		Map<String, Object> response = galleryService.deletePhoto(id);
		return ResponseEntity.ok(response);
	}
	
	
	 @PostMapping("/upload")
	 public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) 
	 {
		 Gallery image = galleryService.addGallery(file);
		 return ResponseEntity.ok("File uploaded successfully: "+image);
	 }
	
	 @GetMapping("/getGalleryImage/{id}")
	 public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable Long id) 
	 {
		 Optional<Gallery> imageOptional = galleryService.findGalleryById(id);
		 
		 if (!imageOptional.isPresent()) 
		 {
			 return ResponseEntity.notFound().build();
		 }
		 
		 Gallery image = imageOptional.get();
		 return ResponseEntity.ok()
				 .header(HttpHeaders.CONTENT_DISPOSITION) // "attachment; filename=\"" + image.getName() + "\"")
				 .body(new ByteArrayResource(image.getImage()));
	 }
		  
	 @GetMapping("/allGallery")
	 public ResponseEntity<List<Gallery>> getAllData() 
	 {
		 List<Gallery> allImages = galleryService.getAllGallery();

		 if (allImages.isEmpty()) 
		 {
			 return ResponseEntity.noContent().build();
		 }

		 return ResponseEntity.ok(allImages);
	 }
		  	  
	 @GetMapping("/getAll")
	 public ResponseEntity<List<Gallery>> findAllFiles() 
	 {
		 List<Gallery> files = galleryService.getAllGallery();
		 HttpHeaders headers = new HttpHeaders();
		 headers.add("Custom-Header", "All files retrieved");
		      
		 return new ResponseEntity<>(files, headers, HttpStatus.OK);
	 }	  
		   
}


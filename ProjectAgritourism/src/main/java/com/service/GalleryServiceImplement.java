package com.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dao.GalleryRepository;
import com.model.Gallery;

@Service
public class GalleryServiceImplement implements GalleryService
{
	@Autowired
	GalleryRepository galleryRepo;
	
	public Gallery updatePhoto(Long id, MultipartFile image) throws Exception 
	{
        Optional<Gallery> existingGalleryOptional = galleryRepo.findById(id);

        if (existingGalleryOptional.isPresent()) 
        {
            Gallery existingGallery = existingGalleryOptional.get();
            existingGallery.setImage(image.getBytes());
            return galleryRepo.save(existingGallery);
        } 
        else 
        {
        	 return null;
        }
    }
	
	@Override
	public Map<String, Object> deletePhoto(long id) 
	{
		Map<String, Object> response = new HashMap<>();
		Gallery gallery = galleryRepo.findById(id).orElse(null);
		
		if(gallery == null)
		{
			response.put("Not Deleted", "Image Not Deleted Because ID not FOUND");
		}
		else
		{
			galleryRepo.delete(gallery);
			response.put("Deleted", "Image Deleted Successfully");
		}
		return response;
	}
	
	public Gallery addGallery(MultipartFile file) 
	{
		// String fileName = file.getOriginalFilename();
		try 
		{
			Gallery image = new Gallery();
			//image.setName(fileName);;
			image.setImage(file.getBytes());
			return galleryRepo.save(image);
		} 
		catch (IOException ex) 
		{
			throw new RuntimeException("File could not store. \nPlease try again!", ex);
		}                                              /*+ fileName +*/
   }

   
	public Optional<Gallery> findGalleryById(Long fileId) 
	{
		System.out.println(fileId+"Inside service");
       return galleryRepo.findById(fileId);
	}
	
	public List<Gallery> getAllGallery() 
	{
	    return galleryRepo.findAll();
	}

}

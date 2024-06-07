package com.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.model.Gallery;

public interface GalleryService 
{
	public Gallery updatePhoto(Long id, MultipartFile image) throws Exception;
	public Map<String, Object> deletePhoto(long id);
	public Gallery addGallery(MultipartFile file);
	public Optional<Gallery> findGalleryById(Long fileId);
	public List<Gallery> getAllGallery();
}

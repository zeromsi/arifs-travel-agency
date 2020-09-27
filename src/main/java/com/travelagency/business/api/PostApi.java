package com.travelagency.business.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

public interface PostApi<T,I> {
	@PostMapping("posts")
	ResponseEntity<?> save(T t);

	@GetMapping("posts")
	ResponseEntity<?> findAll(@RequestParam(name = "type") String type);
	
	@PutMapping("posts")
	ResponseEntity<T> update(T t);
	
	
}
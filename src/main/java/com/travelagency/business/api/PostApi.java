package com.travelagency.business.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface PostApi<T,I> {
	@PostMapping("posts")
	ResponseEntity<?> save(T t);

	@GetMapping("posts")
	ResponseEntity<?> findAll();
}
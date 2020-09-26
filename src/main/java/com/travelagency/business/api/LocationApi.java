package com.travelagency.business.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface LocationApi <T,I> {
	@PostMapping("locations")
	ResponseEntity<?> save(String t);

	@GetMapping("locations")
	ResponseEntity<?> findAll();
}

package com.travelagency.business.api.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.travelagency.business.PostDto;
import com.travelagency.business.api.PostApi;
import com.travelagency.business.service.PostService;

@RestController
@RequestMapping("api/v1/")
public class PostApiImplementation implements PostApi<PostDto, Long>{

	
	@Autowired
	PostService postService;

	@Override
	@PreAuthorize("hasAuthority('role_user')")
	public ResponseEntity<?> save(@RequestBody PostDto dto) {
		try {
			postService.save(dto.convertIntoPost());
			return new ResponseEntity<PostDto>(dto,HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	@PreAuthorize("hasAuthority('role_user')")
	public ResponseEntity<?> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}

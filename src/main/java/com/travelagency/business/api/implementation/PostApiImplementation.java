package com.travelagency.business.api.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.travelagency.business.PostDto;
import com.travelagency.business.api.PostApi;
import com.travelagency.business.service.PostService;
import com.travelagency.config.CustomPrincipal;
@CrossOrigin
@RestController
@RequestMapping("api/v1/")
public class PostApiImplementation implements PostApi<PostDto, Long>{

	
	@Autowired
	PostService postService;

	@Override
	@PreAuthorize("hasAuthority('role_super_admin') or hasAuthority('role_user')")
	public ResponseEntity<?> save(@RequestBody PostDto dto) {
		CustomPrincipal customPrincipal = ((CustomPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal());
		dto.setOwner(customPrincipal.getUsername());
		try {
			postService.save(dto);
			return new ResponseEntity<PostDto>(dto,HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	@PreAuthorize("hasAuthority('role_super_admin') or hasAuthority('role_user')")
	public ResponseEntity<?> findAll(@RequestParam(name = "type") String type) {
		CustomPrincipal customPrincipal = ((CustomPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal());
		List<PostDto> list=new ArrayList<>();
		if(type.equals("own_post")) {
			list=postService.findAllOwnPosts(customPrincipal.getUsername());
		}else {
			list=postService.findAllPublicPosts(customPrincipal.getUsername());
		}
		
		return new ResponseEntity<PostDto>(HttpStatus.ACCEPTED).ok(list);
	}


	@Override
	@PreAuthorize("hasAuthority('role_super_admin') or hasAuthority('role_user')")
	public ResponseEntity<?> pin(@RequestBody PostDto dto,@RequestParam(name = "privacy") String privacy) {
		CustomPrincipal customPrincipal = ((CustomPrincipal) SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal());
		if(privacy.equals("") || privacy=="") {
		try {
			postService.pin(dto,customPrincipal.getUsername());
			return new ResponseEntity<PostDto>(HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}else {
		if(privacy=="public") {
		dto.setVisibility("public");
		}else if(privacy=="private") {
		  dto.setVisibility("private");
		}
		try {
			postService.updatePrivacy(dto,customPrincipal.getUsername());
			return new ResponseEntity<PostDto>(HttpStatus.ACCEPTED);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	}


	
	
	
}

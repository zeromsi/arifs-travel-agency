package com.travelagency.business.api.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.travelagency.business.LocationDto;
import com.travelagency.business.api.LocationApi;
import com.travelagency.business.service.LocationService;

@CrossOrigin
@RestController
@RequestMapping("api/v1/")
public class LocationApiImplementation implements LocationApi<LocationDto, Long>{
	
	@Autowired
	LocationService locationService;

	@Override
	@PreAuthorize("hasAuthority('role_super_admin')")
	public ResponseEntity<?> save(@RequestBody LocationDto location) {
		try {
		    locationService.save(location);
			return new ResponseEntity<LocationDto>(location, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@Override
	@PreAuthorize("hasAuthority('role_user') or hasAuthority('role_super_admin') ")
	public ResponseEntity<?> findAll() {
		return new ResponseEntity<List<LocationDto>>(locationService.findAll(), HttpStatus.OK);
	}
	
	

}

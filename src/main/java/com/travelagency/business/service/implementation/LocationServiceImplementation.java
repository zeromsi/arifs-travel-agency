package com.travelagency.business.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.travelagency.business.LocationDto;
import com.travelagency.business.service.LocationService;
import com.travelagency.data.repository.LocationRepository;

public class LocationServiceImplementation implements LocationService<LocationDto, Long>{
	
	@Autowired
	LocationRepository locationRepository;

	@Override
	public void save(LocationDto location) throws Exception {
		try {
			locationRepository.save(location.convertIntoLocation());
		}catch(Exception e) {
			throw e;
		}
		
	}

	@Override
	public List<LocationDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LocationDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}



package com.travelagency.business.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelagency.business.LocationDto;
import com.travelagency.business.service.LocationService;
import com.travelagency.data.Location;
import com.travelagency.data.repository.LocationRepository;

@Service
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
		List<Location> locations=locationRepository.findAll();
		return Location.convertIntoDtos(locations);
	}

}



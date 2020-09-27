package com.travelagency.business.service;

import java.util.List;

public interface LocationService<T,I> extends CoreService<T,I> {

	List<T> findAll();
	
}

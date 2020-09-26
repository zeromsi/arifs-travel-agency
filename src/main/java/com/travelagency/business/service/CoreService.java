package com.travelagency.business.service;

import java.util.List;

public interface CoreService<T,Object>{		

	void save(T object) throws Exception;

	List<T> findAll();
	
	T findById(Object id);
	
	
}
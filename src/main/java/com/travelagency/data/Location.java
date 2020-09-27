package com.travelagency.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.travelagency.business.LocationDto;

@Entity
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", name=" + name + "]";
	}

	public Location(Long id) {
		super();
		this.id = id;
	}

	public Location() {
		super();
	}

	public LocationDto convertIntoDto() {
		LocationDto dto=new LocationDto();
		dto.setId(this.id);
		dto.setName(this.name);
		// TODO Auto-generated method stub
		return dto;
	}
	
	
}
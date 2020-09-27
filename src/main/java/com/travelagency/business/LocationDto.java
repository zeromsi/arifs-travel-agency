package com.travelagency.business;

import com.travelagency.data.Location;

public class LocationDto {
	private Long id;
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
	
	public Location convertIntoLocation() {
		Location location=new Location();
		location.setName(this.name);
		location.setId(this.id);
		return location;
	}

}

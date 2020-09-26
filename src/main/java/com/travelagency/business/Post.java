package com.travelagency.business;

public class Post {
	private Long id;
	private String body;
	private String visibility;
	private Location location;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", body=" + body + ", visibility=" + visibility + ", location=" + location + "]";
	}
	
}

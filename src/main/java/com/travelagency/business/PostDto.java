package com.travelagency.business;

import java.util.Date;
import com.travelagency.data.PinnedPost;
import com.travelagency.data.Post;

public class PostDto {
	private Long id;
	private String body;
	private String visibility;
	private LocationDto location;

	private String owner;
	private Date createdAt;
	private Date lastUpdatedAt;
	
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
	public LocationDto getLocation() {
		return location;
	}
	public void setLocation(LocationDto location) {
		this.location = location;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}
	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}
	public Post convertIntoPost() {
		Post post=new Post();
		post.setBody(this.body);
		post.setOwner(this.owner);
		post.setCreatedAt(this.createdAt);
		post.setLastUpdatedAt(this.lastUpdatedAt);
		post.setVisibility(this.visibility);
		return post;
	}
	
	public PinnedPostDto pin() {
		PinnedPostDto pinnedPostDto=new PinnedPostDto();
		pinnedPostDto.setOwner(this.owner);
		pinnedPostDto.setPostId(this.id);
		return pinnedPostDto;
	}
	
}

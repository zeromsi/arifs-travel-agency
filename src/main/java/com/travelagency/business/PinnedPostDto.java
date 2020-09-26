package com.travelagency.business;

import com.travelagency.data.PinnedPost;

public class PinnedPostDto {
	
	private Long id;

	private String postId;
	
	private String owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "PinnedPost [id=" + id + ", postId=" + postId + ", owner=" + owner + "]";
	}
	
	public PinnedPost convertIntoPinnedPost() {
		PinnedPost pinnedPost=new PinnedPost();
		pinnedPost.setOwner(this.owner);
		pinnedPost.setPostId(this.postId);
		return pinnedPost;
	}
	

}

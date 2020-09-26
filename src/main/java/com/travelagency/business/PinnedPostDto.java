package com.travelagency.business;

import com.travelagency.data.PinnedPost;

public class PinnedPostDto {
	private Long postId;
	
	private String owner;

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}


	public PinnedPost convertIntoPinnedPost() {
		PinnedPost pinnedPost=new PinnedPost();
		pinnedPost.setOwner(this.owner);
		pinnedPost.setPostId(this.postId);
		return pinnedPost;
	}
	

}

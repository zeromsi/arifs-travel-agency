package com.travelagency.business.service;

import java.util.List;

import com.travelagency.business.PostDto;

public interface PostService<T,I> extends CoreService<T,I> {


	List<PostDto> findAllPublicPosts(String owner);

	List<PostDto> findAllOwnPosts(String owner);
 
	void pin(T t, String username) throws Exception;

	void updatePrivacy(T dto, String username) throws Exception; 

}

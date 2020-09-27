package com.travelagency.business.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelagency.business.PostDto;
import com.travelagency.business.service.PostService;
import com.travelagency.data.Post;
import com.travelagency.data.repository.PostRepository;

@Service
public class PostServiceImplementation implements PostService<PostDto, Long>{
	
	@Autowired
	PostRepository postRepository;
	

	@Override
	public void save(PostDto post) throws Exception {
		try {
			postRepository.save(post.convertIntoPost());
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public List<PostDto> findAllPublicPosts(String owner) {
		List<Post> posts=new ArrayList();
		posts=postRepository.findAllPublicPosts("public");
		List<PostDto> dtos=new Post().convertIntoDtos(posts);
		return dtos;
	}

	@Override
	public List<PostDto> findAllOwnPosts(String owner) {
		List<Post> posts=new ArrayList();
		posts=postRepository.findAllByOwnerOrderByLastUpdatedAtDesc(owner);
		List<PostDto> dtos=new Post().convertIntoDtos(posts);
		return dtos;
	}
	
	
	@Override
	public List<PostDto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

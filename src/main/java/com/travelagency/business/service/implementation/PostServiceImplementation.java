package com.travelagency.business.service.implementation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.travelagency.business.PostDto;
import com.travelagency.business.service.PostService;
import com.travelagency.data.Location;
import com.travelagency.data.PinnedPost;
import com.travelagency.data.Post;
import com.travelagency.data.repository.LocationRepository;
import com.travelagency.data.repository.PinnedPostRepository;
import com.travelagency.data.repository.PostRepository;

@Service
public class PostServiceImplementation implements PostService<PostDto, Long>{
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	PinnedPostRepository pinnedPostRepository;
	

	@Override
	public void save(PostDto dto) throws Exception {
		try {
			Post post=dto.convertIntoPost();
			post.setCreatedAt(new Date());
			post.setLastUpdatedAt(new Date());
			
			Location location=new Location();
			location=locationRepository.getOne(post.getLocation().getId());
			if (location.getId()==null || location.getId().equals(null)) {
				throw new Exception("No Location found");
			}
			postRepository.save(post);
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
		PinnedPost pinnedPost=new PinnedPost();
		pinnedPost=pinnedPostRepository.findByOwner(owner);
		List<PostDto> dtos=new ArrayList<>();
		try {
			dtos.add(postRepository.getOne(pinnedPost.getPostId()).convertIntoDto());
			for(int i=0;i<posts.size();i++) {
	           if(posts.get(i).getId()==pinnedPost.getPostId()) {
					posts.remove(i);
					break;
				}
			}
		}catch(Exception e) {
			
		}
		 dtos.addAll(new Post().convertIntoDtos(posts));
		return dtos;
	}
	
	@Override
	public void pin(PostDto dto, String username) throws Exception{
		Post post=new Post();
		post=postRepository.getOne(dto.getId());
		if (post.getId()==null || post.getId().equals(null)) {
			throw new Exception("No record found");
		}
		if (!post.getOwner().equals(username)) {
			throw new Exception("Unauthorized to edit!");
		}
		PinnedPost pinnedPost=new PinnedPost();
		pinnedPost.setPostId(post.getId());
		pinnedPost.setOwner(post.getOwner());
		try {
		pinnedPostRepository.save(pinnedPost);
		}catch(Exception e) {
			throw e;
		}
	}

	@Override
	public void updatePrivacy(PostDto dto, String username)throws Exception {
		Post post=new Post();
		post=postRepository.getOne(dto.getId());
		if (post.getId()==null || post.getId().equals(null)) {
			throw new Exception("No record found");
		}
		if (!post.getOwner().equals(username)) {
			throw new Exception("Unauthorized to edit!");
		}
		
		post.setVisibility(dto.getVisibility());
		try {
			postRepository.save(post);
			}catch(Exception e) {
				throw e;
			}
	}

}

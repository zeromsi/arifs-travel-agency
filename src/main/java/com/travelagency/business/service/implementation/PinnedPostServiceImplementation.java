package com.travelagency.business.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelagency.business.PinnedPostDto;
import com.travelagency.business.service.PinnedPostService;
import com.travelagency.data.repository.PinnedPostRepository;

@Service
public class PinnedPostServiceImplementation implements PinnedPostService<PinnedPostDto, Long>{
	
	@Autowired
	PinnedPostRepository pinnedPostRepository;

	@Override
	public void save(PinnedPostDto pinnedPost) throws Exception {
		try {
			pinnedPostRepository.save(pinnedPost.convertIntoPinnedPost());
		}catch(Exception e) {
			throw e;
		}
	}



}

package com.travelagency.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.travelagency.data.PinnedPost;

@Repository
public interface PinnedPostRepository extends JpaRepository<PinnedPost,Long>{

	PinnedPost findByOwner(String owner);

	
}
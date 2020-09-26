package com.travelagency.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.travelagency.data.Post;


@Repository
public interface PostRepository extends JpaRepository<Post,Long>{


}
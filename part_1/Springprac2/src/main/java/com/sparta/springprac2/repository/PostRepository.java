package com.sparta.springprac2.repository;

import com.sparta.springprac2.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}

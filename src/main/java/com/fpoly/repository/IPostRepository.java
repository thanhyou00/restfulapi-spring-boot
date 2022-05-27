package com.fpoly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fpoly.entities.Posts;

@Repository
public interface IPostRepository extends JpaRepository<Posts, Long> {

}

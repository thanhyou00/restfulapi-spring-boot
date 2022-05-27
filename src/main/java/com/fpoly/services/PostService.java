package com.fpoly.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fpoly.entities.Posts;
import com.fpoly.repository.IPostRepository;

@Service
public class PostService implements IPostService {
	@Autowired
	IPostRepository repository;

	@Override
	public Iterable<Posts> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Posts> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public Posts save(Posts t) {
		return repository.save(t);
	}

	@Override
	public void remove(Long id) {
		repository.deleteById(id);
	}

}
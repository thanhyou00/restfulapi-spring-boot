package com.fpoly.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.entities.Posts;
import com.fpoly.services.IPostService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/posts")
public class APIController {

	@Autowired
	IPostService repository;

	// getAll
	@GetMapping
	public ResponseEntity<Iterable<Posts>> getAllPost() {
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}

	// add new
	@PostMapping
	public ResponseEntity<Posts> createNewPost(@RequestBody Posts post) {
		return new ResponseEntity<>(repository.save(post), HttpStatus.OK);
	}

	// getById
	@GetMapping("/{id}")
	public ResponseEntity<Posts> getPost(@PathVariable Long id) {
		Optional<Posts> postOptional = repository.findById(id);
		return postOptional.map(post -> new ResponseEntity<>(post, HttpStatus.OK))
				.orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	// update
	@PutMapping("/{id}")
	public ResponseEntity<Posts> updatePost(@PathVariable Long id, @RequestBody Posts post) {
		Optional<Posts> postOptional = repository.findById(id);
		return postOptional.map(p -> {
			post.setId(p.getId());
			return new ResponseEntity<>(repository.save(p), HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	// delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Posts> deletePost(@PathVariable Long id) {
		Optional<Posts> postOptional = repository.findById(id);
		return postOptional.map(p -> {
			repository.remove(id);
			return new ResponseEntity<>(p, HttpStatus.OK);
		}).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}

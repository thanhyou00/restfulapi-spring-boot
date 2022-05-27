package com.fpoly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fpoly.entities.Posts;
import com.fpoly.services.IPostService;

@RestController
@RequestMapping("/api/posts")
public class APIController {

	@Autowired
	IPostService repository;

	@GetMapping
	public ResponseEntity<Iterable<Posts>> getAllCategory() {
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Posts> createNewCategory(@RequestBody Posts post) {
		return new ResponseEntity<>(repository.save(post), HttpStatus.OK);
	}

}

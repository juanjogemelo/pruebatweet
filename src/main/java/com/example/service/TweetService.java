package com.example.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Tweet;

import twitter4j.Status;

public interface TweetService {
	
	 public List<Tweet> consultarTodos();
	 public List<Tweet> consultarTweetValidados();
	 public Tweet marcarValidado(Long id);
	 public Tweet guardarTweet(Status status);
	 
}

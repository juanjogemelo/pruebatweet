package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TweetApplication {


	
	public static void main(String[] args) {
		SpringApplication.run(TweetApplication.class, args);		
	}

	
//	@Bean
//	  public CommandLineRunner demo(TweetRepository repository) {
//	    return (args) -> {
//	      // save a few customers
//	      repository.save(new Tweet(1l,2d,3d,false,"texto 1"));
//	      repository.save(new Tweet(2l,2d,3d,true,"texto 2"));
//	      repository.save(new Tweet(3l,2d,3d,true,"texto 3"));
//	      repository.save(new Tweet(4l,2d,3d,false,"texto 4"));
//	      repository.save(new Tweet(5l,2d,3d,false,"texto 5"));
//	    };
//	  }
}

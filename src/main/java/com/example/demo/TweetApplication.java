package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Tweet;
import com.example.demo.properties.Propiedades;
import com.example.demo.repository.TweetRepository;
import com.example.service.TweetService;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

@SpringBootApplication
public class TweetApplication {

	@Autowired
	private static TweetService tweetService;
	
	public static void main(String[] args) {
		SpringApplication.run(TweetApplication.class, args);
		
		
//		StatusListener listener = new StatusListener(){
//	        public void onStatus(Status status) {
//	            System.out.println(status.getUser().getName() + " : " + status.getText());
//	            tweetService.guardarTweet(status);
//	        }
//	        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
//	        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
//	        public void onException(Exception ex) {
//	            ex.printStackTrace();
//	        }
//			@Override
//			public void onScrubGeo(long userId, long upToStatusId) {
//				
//				
//			}
//			@Override
//			public void onStallWarning(StallWarning warning) {
//				
//				
//			}
//	    };
//	    TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
//	    twitterStream.addListener(listener);
//	    twitterStream.sample();
		
		
	}
	
	@Bean
	  public CommandLineRunner demo(TweetRepository repository) {
	    return (args) -> {
	      // save a few customers
	      repository.save(new Tweet(1l,2d,3d,false,"texto 1"));
	      repository.save(new Tweet(2l,2d,3d,true,"texto 2"));
	      repository.save(new Tweet(3l,2d,3d,true,"texto 3"));
	      repository.save(new Tweet(4l,2d,3d,false,"texto 4"));
	      repository.save(new Tweet(5l,2d,3d,false,"texto 5"));
	    };
	  }
}

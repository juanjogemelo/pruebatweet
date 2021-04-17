package com.example.demo.service.impl;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.service.TweetService;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

	
	private TweetService tweetService;


    public CommandLineAppStartupRunner(TweetService ptweetService) {
        this.tweetService = ptweetService;
    }
	
	
    @Override
    public void run(String...args) throws Exception {
    	   	
		StatusListener listener = new StatusListener(){
	        public void onStatus(Status status) {
	            System.out.println(status.getUser().getName() + " : " + status.getText());
	            tweetService.guardarTweet(status);
	        }
	        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {}
	        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {}
	        public void onException(Exception ex) {
	            ex.printStackTrace();
	        }
			@Override
			public void onScrubGeo(long userId, long upToStatusId) {
				
				
			}
			@Override
			public void onStallWarning(StallWarning warning) {
				
				
			}
	    };
	    TwitterStream twitterStream = new TwitterStreamFactory().getInstance();
	    twitterStream.addListener(listener);
	    twitterStream.sample();

    }
}
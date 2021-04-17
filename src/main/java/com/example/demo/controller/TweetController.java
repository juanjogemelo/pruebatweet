package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Tweet;
import com.example.service.TweetService;

import twitter4j.Status;
import twitter4j.Trend;
import twitter4j.Trends;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@RestController
public class TweetController {

	@Autowired
	private TweetService tweetService;
	
	/**
	 * Consultar todos los tweets guardados.
	 * @return Lista de tweets.
	 */
	@GetMapping("/consultartweets")
	public List<Tweet> consultarTodosTweet(){		
		return tweetService.consultarTodos();		
	}
	
	/**
	 * Consultar tweets validados por el usuario.
	 * @return Lista de tweet validdos.
	 */
	@GetMapping("/consultartweetsvalidados")
	public List<Tweet> consultarTweetValidados(){		
		return tweetService.consultarTweetValidados();		
	}
		
	/**
	 * Permite validar tweets.
	 * @param id del tweet que queremos validar.
	 * @return
	 */
	@GetMapping("/validartweet")
	public Tweet validarTweet(@RequestParam(value="id", defaultValue = "-1") Long id){
		if (id > 0)
			return tweetService.marcarValidado(id);
		else {
			return null;
		}	
	}
	
	/**
	 * Permite guardar un tweet directamente.
	 * @param status tweet de entrada.
	 * @return Datos guardados en caso de exito.
	 */
	@PostMapping("/guardartweet")
	public Tweet guardarTweet(Status status){		
		
		return tweetService.guardarTweet(status);
	}
	
	/**
	 * Listado de hastag mas usados.
	 * @param woeid id del lugar para obtener los mas usados. Por defecto es 1, todo el mundo 
	 * @return lista de hastag mas usados.
	 */
	@GetMapping("/masusados")
	public List<String> masUsados(@RequestParam(value = "woeid", defaultValue = "1") int woeid){
        try {
        	
        	List<String> resultado = new ArrayList<String>();
        	
            Twitter twitter = new TwitterFactory().getInstance();
            Trends trends = twitter.getPlaceTrends(woeid);
           
            
            
            for (Trend trend : trends.getTrends()) {
            	resultado.add(trend.getName());
            }
            
            return resultado;
            
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to get trends: " + te.getMessage());
            return null;
        }
	}
	
}

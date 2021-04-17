package com.example.demo.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.exception.TweetExcepction;
import com.example.demo.model.Tweet;
import com.example.demo.properties.Propiedades;
import com.example.demo.repository.TweetRepository;
import com.example.service.TweetService;

import twitter4j.GeoLocation;
import twitter4j.Status;
import twitter4j.User;

@Service
@Component
public class TweetServiceImpl implements TweetService {

	@Autowired
	private TweetRepository tweetRepository;

	@Autowired
	private Environment env;

	@Override
	/**
	 * Obtiene todos los tweet guardados.
	 */
	public List<Tweet> consultarTodos() {

		try {
			return (List<Tweet>) tweetRepository.findAll();

		} catch (DataAccessException e) {

			throw new TweetExcepction(Propiedades.getMostrartodosexception());
		}

	}

	/**
	 * Obtiene los tweet validados.
	 */
	@Override
	public List<Tweet> consultarTweetValidados() {

		try {

			return (List<Tweet>) tweetRepository.findByValidacion(true);

		} catch (DataAccessException e) {

			throw new TweetExcepction(Propiedades.getConsultarvalidadosexception());
		}
	}

	/**
	 * Actualiza el tweet seleccionado como validado.
	 */
	@Override
	public Tweet marcarValidado(Long id) {

		try {

			Tweet tweet = tweetRepository.getOne(id);

			if (tweet != null) {
				tweet.setValidacion(true);
				return tweetRepository.saveAndFlush(tweet);
			}
		} catch (DataAccessException e) {

			throw new TweetExcepction(Propiedades.getMarcarvalidacionexception());
		}

		return null;
	}

	/**
	 * Guarda un tweet si este cumple una serie de condiciones.
	 */
	@Override
	public Tweet guardarTweet(Status status) {

		try {

			if (status != null) {

				User usuario = status.getUser();
				if (usuario != null) {

					// Comprobar seguidores
					if (usuario.getFriendsCount() > Propiedades.getSeguidores()) {
						// Obtenermos lenguaje
						List<String> lenguaje = Propiedades.getIdiomas();
						if (lenguaje.contains(status.getLang())) {

							GeoLocation geo = status.getGeoLocation();
							
							
							Tweet tweet = new Tweet(usuario.getId(), geo != null ? geo.getLatitude() : null,
									geo != null ? geo.getLongitude() : null, false, status.getText());

							return tweetRepository.saveAndFlush(tweet);
						}
					}
				}
			}

		} catch (DataAccessException e) {

			throw new TweetExcepction(Propiedades.getGuardartweetexception());
		}

		return null;
	}

}

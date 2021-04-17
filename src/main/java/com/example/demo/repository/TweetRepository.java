package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
	/**
	 * Buscar por el parametro validacion.
	 * @param validado valor buscado.
	 * @return lista de tweet con ese valor.
	 */
	List<Tweet> findByValidacion(@Param("validacion") boolean validado);
}

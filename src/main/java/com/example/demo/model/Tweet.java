package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tweet {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long usuario;
	private Double latitud;
	private Double longitud;	
	private boolean validacion;
	private String texto;
	
	
	
	
	
	public Tweet() {
		super();
	}
	

	
	/**
	 * Constructor de tweet.
	 * @param usuario id del usuario.
	 * @param latitud latitud geolocalizacion.
	 * @param longitud longitud geolocalizacion.
	 * @param validacion validacion.
	 * @param texto texto del tweet.
	 */
	public Tweet(Long usuario, Double latitud, Double longitud, boolean validacion, String texto) {
		super();
		this.usuario = usuario;
		this.latitud = latitud;
		this.longitud = longitud;
		this.validacion = validacion;
		this.texto = texto;
	}




	/**
	 * @return the usuario
	 */
	public Long getUsuario() {
		return usuario;
	}




	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}




	/**
	 * @return the latitud
	 */
	public Double getLatitud() {
		return latitud;
	}




	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}




	/**
	 * @return the longitud
	 */
	public Double getLongitud() {
		return longitud;
	}




	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}




	/**
	 * @return the validacion
	 */
	public boolean isValidacion() {
		return validacion;
	}




	/**
	 * @param validacion the validacion to set
	 */
	public void setValidacion(boolean validacion) {
		this.validacion = validacion;
	}




	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}




	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}




	
	
	
	
}

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
	

	
	
	public Tweet(Long usuario, Double latitud, Double longitud, boolean validacion, String texto) {
		super();
		this.usuario = usuario;
		this.latitud = latitud;
		this.longitud = longitud;
		this.validacion = validacion;
		this.texto = texto;
	}




	public Long getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	
	public Double getLatitud() {
		return latitud;
	}
	
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	
	public Double getLongitud() {
		return longitud;
	}
	
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}
	
	public boolean isValidacion() {
		return validacion;
	}
	
	public void setValidacion(boolean validacion) {
		this.validacion = validacion;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
		
	
	
	
}

package com.example.demo.properties;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:values.properties")
public class Propiedades {

	
	private static int seguidores;
	
	private static List<String> idiomas;
	
	private static String mostrartodosexception;
	
	private static String marcarvalidacionexception;
	
	private static String consultarvalidadosexception;
	
	private static String mostrarhashtagsexception;
	
	private static String guardartweetexception;
	
	public static int getSeguidores() {
		return seguidores;
	}
	@Autowired
	public void setSeguidores(@Value("${var.seguidores}") int seguidores) {
		this.seguidores = seguidores;
	}
	public static List<String> getIdiomas() {
		return idiomas;
	}
	
	@Autowired
	public void setIdiomas(@Value("#{'${var.idiomas}'.split(',')}") List<String> idiomas) {
		this.idiomas = new ArrayList<String>();
		this.idiomas.addAll(idiomas);
	}
	public static String getMostrartodosexception() {
		return mostrartodosexception;
	}
	
	@Autowired
	public void setMostrartodosexception(@Value("${msg.mostrartodosexception}") String mostrartodosexception) {
		this.mostrartodosexception = mostrartodosexception;
	}
	public static String getMarcarvalidacionexception() {
		return marcarvalidacionexception;
	}
	
	@Autowired
	public void setMarcarvalidacionexception(@Value("${msg.marcarvalidacionexception}") String marcarvalidacionexception) {
		this.marcarvalidacionexception = marcarvalidacionexception;
	}
	public static String getConsultarvalidadosexception() {
		return consultarvalidadosexception;
	}
	
	@Autowired
	public void setConsultarvalidadosexception(@Value("${msg.consultarvalidadosexception}") String consultarvalidadosexception) {
		this.consultarvalidadosexception = consultarvalidadosexception;
	}
	public static String getMostrarhashtagsexception() {
		return mostrarhashtagsexception;
	}
	
	@Autowired
	public void setMostrarhashtagsexception(@Value("${msg.mostrarhashtagsexception}") String mostrarhashtagsexception) {
		this.mostrarhashtagsexception = mostrarhashtagsexception;
	}
	public static String getGuardartweetexception() {
		return guardartweetexception;
	}
	
	@Autowired
	public void setGuardartweetexception(@Value("${msg.guardartweetexception}") String guardartweetexception) {
		this.guardartweetexception = guardartweetexception;
	}
	
	
	
	
}

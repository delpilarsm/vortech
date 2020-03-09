package com.vortech.model;

import java.io.Serializable;
import java.util.List;

public class Pelicula  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -413068637728912760L;
	
	private String titulo;
	private String genero;
	private int anio;
	private int oscar;
		
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getOscar() {
		return oscar;
	}
	public void setOscar(int oscar) {
		this.oscar = oscar;
	}


}

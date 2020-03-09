package com.vortech.model;

import java.io.Serializable;

public class PeliculaOver  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -413068637728912760L;

	private String titulo;
	private int año;
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
}

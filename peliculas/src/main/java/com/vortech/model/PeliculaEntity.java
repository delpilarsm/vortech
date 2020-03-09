package com.vortech.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "peliculas")
public class PeliculaEntity {
	@Id
	private int id;
	@Column
	private String titulo;
	@Column
	private String genero;
	@Column
	private int año;
	@Column
	private int oscar;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public int getOscar() {
		return oscar;
	}
	public void setOscar(int oscar) {
		this.oscar = oscar;
	}

	
}

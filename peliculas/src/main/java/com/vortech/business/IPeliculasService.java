package com.vortech.business;

import java.util.List;
import java.util.Optional;

import com.vortech.model.Pelicula;
import com.vortech.model.PeliculaOver;

public interface IPeliculasService {
	public Pelicula savePelicula(Pelicula pelicula);
	public List<PeliculaOver> getPeliculas();
	public Optional<List<Pelicula>> getPeliculaByTitulo(String titulo);

}

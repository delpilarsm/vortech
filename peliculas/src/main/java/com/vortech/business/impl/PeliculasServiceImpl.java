package com.vortech.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vortech.business.IPeliculasService;
import com.vortech.model.Pelicula;
import com.vortech.model.PeliculaEntity;
import com.vortech.model.PeliculaOver;
import com.vortech.repo.IPeliculaRepo;

@Service
public class PeliculasServiceImpl implements IPeliculasService {

	@Autowired
	private IPeliculaRepo peliculaRepo;

	@Override
	public Pelicula savePelicula(Pelicula pelicula) {
		PeliculaEntity entity = new PeliculaEntity();
		entity.setTitulo(pelicula.getTitulo());
		entity.setAño(pelicula.getAnio());
		entity.setGenero(pelicula.getGenero());
		entity.setOscar(entity.getOscar());
		peliculaRepo.save(entity);
		return pelicula;
	}

	@Override
	public List<PeliculaOver> getPeliculas() {
		List<PeliculaEntity> peliculas = peliculaRepo.findAll();
		List<PeliculaOver> peliculasResponse = new ArrayList<PeliculaOver>();
		for (PeliculaEntity e : peliculas) {
			PeliculaOver pelicula = new PeliculaOver();
			pelicula.setTitulo(e.getTitulo());
			pelicula.setAño(e.getAño());
			peliculasResponse.add(pelicula);
		}
		return peliculasResponse;
	}

	@Override
	public Optional<List<Pelicula>> getPeliculaByTitulo(String titulo) {
		List<PeliculaEntity> peliculas = (List<PeliculaEntity>) peliculaRepo.findByTitulo(titulo);
		Optional<List<Pelicula>> pelicula = Optional.empty();
		List<Pelicula> list = new  ArrayList<Pelicula>();
		
		if (!peliculas.isEmpty()) {
			for (PeliculaEntity e : peliculas) {
				Pelicula p = new Pelicula();
				p.setTitulo(e.getTitulo());
				p.setAnio(e.getAño());
				p.setGenero(e.getGenero());
				p.setOscar(e.getOscar());
				list.add(p);				
			}
			return Optional.of(list);
		}
		return pelicula;
	}
}

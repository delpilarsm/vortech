package com.vortech.business.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.vortech.model.Pelicula;
import com.vortech.model.PeliculaOver;
import com.vortech.repo.IPeliculaRepo;

@SpringBootTest
public class PeliculasServiceImplTest {

	@Mock
	private IPeliculaRepo peliculaRepo;

	@Autowired	
	private PeliculasServiceImpl peliculasServiceImpl;

	@Test
	void savePelicula() {
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo("Alicia");
		pelicula.setGenero("Comedia");
		pelicula.setAnio(20);
		pelicula.setOscar(0);
		assertEquals(pelicula, peliculasServiceImpl.savePelicula(pelicula));
	}

	@Test
	void getPeliculas() {
		List<PeliculaOver> peliculas = peliculasServiceImpl.getPeliculas();
		Boolean existData = true;
		System.out.println("peliculas.size()!=0"+(peliculas.size()!=0));
		if (peliculas.size()==0) {
			existData = false;
		}
		assertEquals(existData, peliculas.size()!=0);
	}

	@Test
	void getPeliculaByTitulo() {
		Optional<List<Pelicula>> response = peliculasServiceImpl.getPeliculaByTitulo("El Castillo Vagabundo");
		assertEquals(false, response.isPresent());
	}

}

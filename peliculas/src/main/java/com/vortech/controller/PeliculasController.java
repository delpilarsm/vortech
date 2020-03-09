package com.vortech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.vortech.business.impl.PeliculasServiceImpl;
import com.vortech.model.Pelicula;
import com.vortech.model.PeliculaOver;

@RestController
@RequestMapping(path = "/peliculas/")
public class PeliculasController {

	@Autowired
	private PeliculasServiceImpl peliculas;

	@PostMapping("/add")
	@ResponseBody
	public Pelicula savePelicula(@RequestBody Pelicula pelicula) {
		peliculas.savePelicula(pelicula);
		return pelicula;
	}

	@GetMapping(path = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<PeliculaOver> getPeliculas() {
		List<PeliculaOver> peliculasList = peliculas.getPeliculas();
		return peliculasList;
	}

	@GetMapping(path = "/detalle", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Object getPeliculaByTitulo(@RequestParam(value = "titulo") String titulo) {
		Optional<List<Pelicula>> pelicula = peliculas.getPeliculaByTitulo(titulo);
		if (!pelicula.isPresent()) {
			return "No hay peliculas con ese titulo";
		} else {
			return pelicula;
		}
	}
}

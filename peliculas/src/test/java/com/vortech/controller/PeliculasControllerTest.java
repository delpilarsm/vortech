package com.vortech.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.vortech.PeliculasApplication;

@ContextConfiguration(classes = PeliculasApplication.class)
@SpringBootTest
public class PeliculasControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext wac;

	@BeforeEach
	public void setUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void savePelicula() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/peliculas/add").contentType(MediaType.APPLICATION_JSON)
				.content("{\"titulo\":\"Date perfect\",\"genero\":\"Romantica\",\"anio\":10,\"oscar\":2}")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(content().json(
						"{\"titulo\":\"Date perfect\",\"genero\":\"Romantica\",\"anio\":10,\"oscar\":2}"))
				.andDo(print());
	}

	@Test
	public void getPeliculaByTitulo() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/peliculas/detalle?titulo=No%existe%peli")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.andExpect(content().string("No hay peliculas con ese titulo")).andDo(print());
	}

	@Test
	public void getPeliculas() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/peliculas/all").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$").exists()).andDo(print());
	}

}

package com.vortech.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vortech.model.PeliculaEntity;
@Repository
public interface IPeliculaRepo  extends JpaRepository<PeliculaEntity, Integer> {

	public List<PeliculaEntity> findByTitulo(String titulo);

}

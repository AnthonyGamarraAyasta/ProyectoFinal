package com.gamarraayasta.cursoservice.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.gamarraayasta.cursoservice.entity.Curso;

public interface CursoService {
	public List<Curso>findAll(Pageable page);
	public List<Curso>findByNumerodocumento(String numerodocumento, Pageable page);
	public Curso findById(int id);
	public Curso save(Curso curso);
	public Curso update(Curso curso);
	public void delete(int id);
	
}

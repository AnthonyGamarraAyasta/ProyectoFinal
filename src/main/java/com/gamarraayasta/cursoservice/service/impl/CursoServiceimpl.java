package com.gamarraayasta.cursoservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gamarraayasta.cursoservice.entity.Curso;
import com.gamarraayasta.cursoservice.repository.CursoRepository;
import com.gamarraayasta.cursoservice.service.*;
import com.gamarraayasta.cursoservice.service.CursoService;
import com.gamarraayasta.cursoservice.validator.CursoValidator;

@Service
public class CursoServiceimpl implements CursoService{

	@Autowired
	private CursoRepository repository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Curso> findAll(Pageable page) {
		try {
			return repository.findAll(page).toList();
		}catch(Exception e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Curso> findByNumerodocumento(String numerodocumento, Pageable page) {
		try {
			return repository.findByNumerodocumentoContaining(numerodocumento, page);
		}catch(Exception e){
			return null;
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Curso findById(int id) {
		try {
			Curso registro=repository.findById(id).orElseThrow();
			return registro;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Curso save(Curso curso) {
		try {
			CursoValidator.save(curso);
			Curso registro=repository.save(curso);
			return registro;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public Curso update(Curso curso) {
		try {
			CursoValidator.save(curso);
			Curso registro=repository.findById(curso.getId()).orElseThrow();
			registro.setNombrecurso(curso.getNombrecurso());
			registro.setSeccion(curso.getSeccion());
			registro.setCodigo(curso.getCodigo());
			repository.save(registro);
			return registro;
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public void delete(int id) {
		try {
			Curso registro=repository.findById(id).orElseThrow();
			repository.delete(registro);
		}catch(Exception e){
			
		}
		
	}



}

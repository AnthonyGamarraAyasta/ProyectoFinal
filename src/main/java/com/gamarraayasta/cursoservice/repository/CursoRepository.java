package com.gamarraayasta.cursoservice.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gamarraayasta.cursoservice.entity.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
	List<Curso>findByNumerodocumentoContaining(String numerodocumento, Pageable page);
}

package com.gamarraayasta.cursoservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import com.gamarraayasta.cursoservice.converter.CursoConverter;
import com.gamarraayasta.cursoservice.dto.CursoDTO;
import com.gamarraayasta.cursoservice.entity.Curso;
import com.gamarraayasta.cursoservice.service.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	private CursoService service;
	
	@Autowired
	private CursoConverter converter;
	
	@GetMapping()
	public ResponseEntity<List<CursoDTO>>findAll(
		@RequestParam(value="nombrecurso", required=false,defaultValue="")String nombrecurso,
		@RequestParam(value="offset", required=false,defaultValue="0")int pageNumber,
		@RequestParam(value="limit", required=false,defaultValue="5")int pageSize
			){
		Pageable page=PageRequest.of(pageNumber, pageSize);
		List<Curso> cursos;
		if(nombrecurso==null) {
			cursos=service.findAll(page);
		}else {
			cursos=service.findByNumerodocumento(nombrecurso, page);
		}
		
		if(cursos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		List<CursoDTO>cursosDTO=converter.fromEntity(cursos);
		return ResponseEntity.ok(cursosDTO);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<CursoDTO> findById(@PathVariable("id") int id){
		Curso curso = service.findById(id);
		if(curso==null) {
			return ResponseEntity.notFound().build();
		}
		CursoDTO cursoDTO=converter.fromEntity(curso);
		return ResponseEntity.ok(cursoDTO);
	}
	
	@PostMapping
	public ResponseEntity<CursoDTO> create(@RequestBody CursoDTO cursoDTO){
		Curso registro=service.save(converter.fromDTO(cursoDTO));
		CursoDTO registroDTO=converter.fromEntity(registro);
		return ResponseEntity.status(HttpStatus.CREATED).body(registroDTO);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<CursoDTO> update(@PathVariable("id") int id,@RequestBody CursoDTO cursoDTO){
		Curso registro =service.update(converter.fromDTO(cursoDTO));
		if(registro==null) {
			return ResponseEntity.notFound().build();
		}
		CursoDTO registroDTO=converter.fromEntity(registro);
		return ResponseEntity.ok(registroDTO);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<CursoDTO>delete(@PathVariable("id") int id){
		service.delete(id);
		return ResponseEntity.ok(null);
	}
}

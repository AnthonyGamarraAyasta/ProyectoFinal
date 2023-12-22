package com.gamarraayasta.cursoservice.converter;

import org.springframework.stereotype.Component;

import com.gamarraayasta.cursoservice.dto.CursoDTO;
import com.gamarraayasta.cursoservice.entity.Curso;


@Component
public class CursoConverter extends AbstractConverter<Curso, CursoDTO> {

	@Override
	public CursoDTO fromEntity(Curso entity) {
		if(entity==null) return null;
		return CursoDTO.builder()
				.id(entity.getId())
				.nombrecurso(entity.getNombrecurso())
				.seccion(entity.getSeccion())
				.codigo(entity.getCodigo())
				.build();
	}

	@Override
	public Curso fromDTO(CursoDTO dto) {
		if(dto==null) return null;
		return Curso.builder()
				.id(dto.getId())
				.nombrecurso(dto.getNombrecurso())
				.seccion(dto.getSeccion())
				.codigo(dto.getCodigo())
				.build();
	}

}

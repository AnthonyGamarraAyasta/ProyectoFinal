package com.gamarraayasta.cursoservice.validator;

import com.gamarraayasta.cursoservice.entity.Curso;
import com.gamarraayasta.cursoservice.exceptions.ValidateServiceException;

public class CursoValidator {
	public static void save(Curso curso) {
		if(curso.getNombrecurso()==null||curso.getNombrecurso().isEmpty()) {
			throw new ValidateServiceException("Nombre del curso es requerido");
		}
		if(curso.getNombrecurso().length()>100) {
			throw new ValidateServiceException("Nombre del curso es muy largo");
		}
		if(curso.getSeccion()==null) {
			throw new ValidateServiceException("La seccion es requerido");
		}
		if(curso.getSeccion().length()>30) {
			throw new ValidateServiceException("La seccion es muy largo");
		}
		if(curso.getCodigo().length()>200) {
			throw new ValidateServiceException("El código es muy largo");
		}
	}
}

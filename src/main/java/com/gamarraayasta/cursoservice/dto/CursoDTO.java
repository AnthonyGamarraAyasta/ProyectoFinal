package com.gamarraayasta.cursoservice.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CursoDTO {
	private int id;
	private String nombrecurso;
	private String seccion;
	private String codigo;
}

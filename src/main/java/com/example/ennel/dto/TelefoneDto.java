package com.example.ennel.dto;

import com.example.ennel.entity.Pessoa;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TelefoneDto {
	
	private Long id;
	private String estado;
	private String tipoTelefone;
	private Pessoa pessoa;

}

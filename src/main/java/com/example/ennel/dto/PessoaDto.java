package com.example.ennel.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDto implements Serializable {

	private static final long serialVersionUID = -3883948527710768792L;

	private Long id;
	private String nome;
	private String nascimento;
	private String estado;
	private String tipoTelefone;
	
}

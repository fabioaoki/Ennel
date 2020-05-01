package com.example.ennel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity(name = "pessoa")
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "nascimento")
	private String nascimento;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "tipo_telefone")
	private String tipoTelefone;

}

package com.example.ennel.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "telefone")
public class Telefone  implements Serializable {
	
	private static final long serialVersionUID = 3675272447226763080L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "tipoTelefone")
	private String tipoTelefone;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Pessoa pessoa;

}

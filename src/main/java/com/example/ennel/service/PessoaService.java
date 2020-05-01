package com.example.ennel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ennel.dto.PessoaDto;
import com.example.ennel.entity.Pessoa;
import com.example.ennel.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;

	public PessoaDto cadastra(PessoaDto pessoaDto) {
		Pessoa pessoa = Pessoa.builder().id(pessoaDto.getId()).estado(pessoaDto.getEstado())
				.nascimento(pessoaDto.getNascimento()).nome(pessoaDto.getNome())
				.tipoTelefone(pessoaDto.getTipoTelefone()).build();
		pessoaRepository.save(pessoa);
		return pessoaDto;
	}
}

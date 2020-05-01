package com.example.ennel.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.ennel.dto.TelefoneDto;
import com.example.ennel.entity.Telefone;
import com.example.ennel.repository.TelefoneRepository;

public class TelefoneService {
	
	@Autowired
	TelefoneRepository telefoneRepository;
	
	public TelefoneDto getId(long id) {
		Telefone telefone = telefoneRepository.findById(id);
		TelefoneDto telefoneDto = TelefoneDto.builder().id(telefone.getId()).estado(telefone.getEstado())
				.tipoTelefone(telefone.getTipoTelefone()).pessoa(telefone.getPessoa()).build();
		return telefoneDto;
	}

	public TelefoneDto save(TelefoneDto telefoneDto) {
		Telefone telefone = Telefone.builder().id(telefoneDto.getId()).tipoTelefone(telefoneDto.getTipoTelefone())
				.estado(telefoneDto.getEstado()).pessoa(telefoneDto.getPessoa()).build();
		telefoneRepository.save(telefone);
		return telefoneDto;
	}

	public void remove(long id) {
		telefoneRepository.deleteById(id);
	}

	public List<TelefoneDto> getAll() {
		List<Telefone> telefones = telefoneRepository.findAll();
		List<TelefoneDto> telefoneDtos = new ArrayList<>();
		
		for (Telefone telefone : telefones) {
			telefoneDtos.add(TelefoneDto.builder().id(telefone.getId()).estado(telefone.getEstado())
					.pessoa(telefone.getPessoa()).tipoTelefone(telefone.getTipoTelefone()).build());
		}
		return telefoneDtos;
	}

}

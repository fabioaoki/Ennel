package com.example.ennel.controller;

import java.security.spec.PSSParameterSpec;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ennel.dto.PessoaDto;
import com.example.ennel.service.PessoaService;

@RestController
public class PessoaController {

	@Autowired
	PessoaService pessoaService;
	
	@RequestMapping(value = "/pessoa/cadatro", method = RequestMethod.POST)
	public ResponseEntity<PessoaDto> cadastro(@RequestBody PessoaDto pessoaDto){
	
		if(Objects.nonNull(pessoaDto)) {
			pessoaService.cadastra(pessoaDto);
			return new ResponseEntity<PessoaDto>(pessoaDto, HttpStatus.CREATED);
		}
		return new ResponseEntity<PessoaDto>(HttpStatus.BAD_REQUEST);
	}
}

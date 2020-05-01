package com.example.ennel.controller;

import java.util.List;
import java.util.Objects;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.ennel.dto.TelefoneDto;
import com.example.ennel.service.TelefoneService;

@RestController
public class TelefoneController {
	
	@Autowired
	TelefoneService telefoneService;

	@RequestMapping(value = "/telefone/cadastro", method = RequestMethod.POST)
	public ResponseEntity<TelefoneDto> cadastrar(@RequestBody TelefoneDto telefoneDto){
		
		if(Objects.nonNull(telefoneDto)) {
			telefoneService.save(telefoneDto);
			return new ResponseEntity<TelefoneDto>(telefoneDto,HttpStatus.CREATED);
		}
		return new ResponseEntity<TelefoneDto>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/telefone/list", method = RequestMethod.GET)
	public ResponseEntity<List<TelefoneDto>> list (){
		
		List<TelefoneDto> telefoneDtos = telefoneService.getAll();
		if(Objects.nonNull(telefoneDtos)) {
			return null;
		}
		
		return null ;
	}
	
	@RequestMapping(value = "/telefone/cadastro/atualiza/{id}", method = RequestMethod.PUT)
	public ResponseEntity<TelefoneDto> atualizaCadastro(@PathVariable(value = "id") long id,
			@RequestBody TelefoneDto dto){
		
		TelefoneDto telefoneDto = telefoneService.getId(id);
	if(Objects.nonNull(telefoneDto)) {
		if(Strings.isEmpty(telefoneDto.getEstado())) {
			dto.setEstado(telefoneDto.getEstado());
		}
		if(Strings.isEmpty(telefoneDto.getTipoTelefone())) {
			dto.setTipoTelefone(telefoneDto.getTipoTelefone());
		}
		telefoneService.save(dto);
		return new ResponseEntity<TelefoneDto>(dto,HttpStatus.ACCEPTED);
	}
		
		return new ResponseEntity<TelefoneDto>(HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value = "/telefone/remove/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TelefoneDto> remove(@PathVariable (value = "id") long id){
		
		TelefoneDto telefoneDto = telefoneService.getId(id);
		
		if(Objects.nonNull(telefoneDto)) {
			telefoneService.remove(id);
			return new ResponseEntity<TelefoneDto>(HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<TelefoneDto>(HttpStatus.BAD_REQUEST);
	}
	
}

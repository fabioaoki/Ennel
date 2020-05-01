package com.example.ennel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ennel.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{

	Pessoa findById(long id);
	
}

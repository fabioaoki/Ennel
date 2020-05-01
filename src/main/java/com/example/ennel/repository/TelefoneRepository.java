package com.example.ennel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ennel.entity.Telefone;

public interface TelefoneRepository extends JpaRepository<Telefone, Long>{

	Telefone findById(long id);
	
}

package com.cairone.ejemplo01.datasources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cairone.ejemplo01.entities.PersonaRelEnity;
import com.cairone.ejemplo01.repositories.PersonaRelRepository;

@Component
public class PersonaRelDataSource {

	@Autowired private PersonaRelRepository personaRelRepository = null;
	
	public Iterable<PersonaRelEnity> buscar() {
		return personaRelRepository.findAll();
	}
}

package com.cairone.ejemplo01.datasources;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cairone.ejemplo01.entities.Persona;

@Component
public class PersonaService {

	public List<Persona> getAll() {
		List<Persona> personas = Arrays.asList(
			new Persona(1, "CAIRONE", "DIEGO"),
			new Persona(2, "RASPO", "FRANCO")
		);
		
		return personas;
	}
}

package com.cairone.ejemplo01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cairone.ejemplo01.modelo.Persona;
import com.cairone.ejemplo01.servicios.PersonaService;

@SpringBootApplication
public class App implements CommandLineRunner
{
	@Autowired
	private PersonaService personaService = null;
	
	@Override
	public void run(String... args) throws Exception {
		
		List<Persona> personas = personaService.getAll();
		personas.forEach(persona -> System.out.println(persona));
	}
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}

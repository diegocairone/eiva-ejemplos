package com.cairone.ejemplo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cairone.ejemplo01.datasources.LocalidadesDataSources;
import com.cairone.ejemplo01.datasources.PaisesDataSource;
import com.cairone.ejemplo01.datasources.PersonaRelDataSource;
import com.cairone.ejemplo01.datasources.ProvinciasDataSource;
import com.cairone.ejemplo01.datasources.UsuarioDataSource;
import com.cairone.ejemplo01.entities.PersonaRelEnity;
import com.cairone.ejemplo01.entities.UsuarioEntity;

@SpringBootApplication
public class App implements CommandLineRunner
{
	@Autowired private LocalidadesDataSources localidadesDataSources = null;
	@Autowired private ProvinciasDataSource provinciasDataSource = null;
	@Autowired private PaisesDataSource paisesDataSource = null;
	@Autowired private PersonaRelDataSource personaRelDataSource = null;
	@Autowired private UsuarioDataSource usuarioDataSource = null;
	
	@Override
	public void run(String... args) throws Exception {
		/*
		Iterable<PersonaRelEnity> personaRelEnities = personaRelDataSource.buscar();
		personaRelEnities.forEach(personaRelEnity -> {
			System.out.println(personaRelEnity.getPersona());
		});
		*/
		Iterable<UsuarioEntity> usuarioEntities = usuarioDataSource.buscar();
		usuarioEntities.forEach(usuarioEntity -> {
			System.out.println(usuarioEntity.getNombre());
		});
		
	}
	/*
	@Override
	public void run(String... args) throws Exception {

		//PaisEntity pais = paisesDataSource.buscarPorId(1); // ARGENTINA
		ProvinciaEntity provincia = provinciasDataSource.buscarPorId(1, 1); // SANTA FE
		Integer paisId = 1;
		String cp = null;
		String nombre = "CUALQUIER COSA";
		
		try
		{
			localidadesDataSources.nuevaLocalidad(paisId, cp, nombre, provincia);
		
		} catch (PaisException e) {
			System.out.println(e.getMessage());
			
		} catch (DataIntegrityViolationException e) {
			
			Throwable causa1 = e.getCause();
			if(causa1 != null && causa1 instanceof ConstraintViolationException) {
				Throwable causa2 = causa1.getCause();
				if(causa2 != null && causa2 instanceof SQLException) {
					System.out.println(causa2.getMessage());
				} else {
					System.out.println(causa1.getMessage());
				}
			} else {
				System.out.println(e.getMessage());
			}
		}
	}
	*/
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}

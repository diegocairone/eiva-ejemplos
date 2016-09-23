package com.cairone.ejemplo01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cairone.ejemplo01.datasources.ClientesDataSource;
import com.cairone.ejemplo01.datasources.LocalidadesDataSources;
import com.cairone.ejemplo01.datasources.PaisesDataSource;
import com.cairone.ejemplo01.datasources.PersonaRelDataSource;
import com.cairone.ejemplo01.datasources.ProvinciasDataSource;
import com.cairone.ejemplo01.datasources.UsuarioDataSource;
import com.cairone.ejemplo01.entities.UsuarioEntity;

@SpringBootApplication
public class App implements CommandLineRunner
{
	@Autowired private LocalidadesDataSources localidadesDataSources = null;
	@Autowired private ProvinciasDataSource provinciasDataSource = null;
	@Autowired private PaisesDataSource paisesDataSource = null;
	@Autowired private PersonaRelDataSource personaRelDataSource = null;
	@Autowired private UsuarioDataSource usuarioDataSource = null;
	@Autowired private ClientesDataSource clientesDataSource = null;
	
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	@Override
	public void run(String... args) throws Exception {
		
//		Iterable<PersonaRelEnity> personaRelEnities = personaRelDataSource.buscar();
//		personaRelEnities.forEach(personaRelEnity -> {
//			System.out.println(personaRelEnity.getPersona());
//		});
//		
		Iterable<UsuarioEntity> usuarioEntities = usuarioDataSource.buscar();
		usuarioEntities.forEach(usuarioEntity -> {
			LOG.info("USUARIO: {}", usuarioEntity);
		});
		
//		Iterable<ClienteEntity> clienteEntities = clientesDataSource.buscar();
//		clienteEntities.forEach(clienteEntity -> {
//			LOG.info("CLIENTE: {}", clienteEntity);
//		});
		
	}
	/*
	@Override
	public void run(String... args) throws Exception {

		ProvinciaEntity provincia = provinciasDataSource.buscarPorId(1, 1); // SANTA FE
		Integer paisId = 1;
		String cp = null;
		String nombre = "CUALQUIER COSA";
		
		try {
			localidadesDataSources.nuevaLocalidad(paisId, cp, nombre, provincia);
		} catch (RuntimeException e) {
			LOG.debug("OCURRIO EL SIGUIENTE ERROR: {}", e.getMessage());
		}
		
		LOG.info("Nueva localidad guardada!");
	}
	*/
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}

package com.cairone.ejemplo01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cairone.ejemplo01.datasources.LocalidadesDataSources;
import com.cairone.ejemplo01.datasources.PaisesDataSource;
import com.cairone.ejemplo01.datasources.ProvinciasDataSource;
import com.cairone.ejemplo01.entities.PaisEntity;
import com.cairone.ejemplo01.entities.ProvinciaEntity;

@SpringBootApplication
public class App implements CommandLineRunner
{
	@Autowired private LocalidadesDataSources localidadesDataSources = null;
	@Autowired private ProvinciasDataSource provinciasDataSource = null;
	@Autowired private PaisesDataSource paisesDataSource = null;
	
	@Override
	public void run(String... args) throws Exception {
		
		PaisEntity pais = paisesDataSource.buscarPorId(1); // ARGENTINA
		ProvinciaEntity provincia = provinciasDataSource.buscarPorId(1); // SANTA FE
		String cp = "6000";
		String nombre = "CUALQUIER COSA";
		
		localidadesDataSources.nuevaLocalidad(pais, cp, nombre, provincia);
		
	}
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}

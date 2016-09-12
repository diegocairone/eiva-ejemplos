package com.cairone.ejemplo01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cairone.ejemplo01.datasources.LocalidadesDataSources;
import com.cairone.ejemplo01.datasources.ProvinciasDataSource;
import com.cairone.ejemplo01.entities.LocalidadEntity;
import com.cairone.ejemplo01.entities.ProvinciaEntity;

@SpringBootApplication
public class App implements CommandLineRunner
{
	@Autowired
	private ProvinciasDataSource provinciasDataSource = null;
	
	@Autowired
	private LocalidadesDataSources localidadesDataSources = null;
	
	@Override
	public void run(String... args) throws Exception {
		
		//List<ProvinciaEntity> provincias = provinciasDataSource.getProvinciasCon("S");
		//provincias.forEach(provincia -> System.out.println(provincia));
		
		ProvinciaEntity provinciaEntity = provinciasDataSource.buscarPorId(1);
		
		List<LocalidadEntity> localidades = localidadesDataSources.buscarPorProvincia(provinciaEntity);
		localidades.forEach(localidad -> System.out.println(localidad));
		
		System.out.println("LISTO");
	}
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}

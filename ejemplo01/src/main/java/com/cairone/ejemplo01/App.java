package com.cairone.ejemplo01;

import java.sql.SQLException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataIntegrityViolationException;

import com.cairone.ejemplo01.datasources.LocalidadesDataSources;
import com.cairone.ejemplo01.datasources.PaisesDataSource;
import com.cairone.ejemplo01.datasources.ProvinciasDataSource;
import com.cairone.ejemplo01.entities.ProvinciaEntity;
import com.cairone.ejemplo01.exceptions.PaisException;

@SpringBootApplication
public class App implements CommandLineRunner
{
	@Autowired private LocalidadesDataSources localidadesDataSources = null;
	@Autowired private ProvinciasDataSource provinciasDataSource = null;
	@Autowired private PaisesDataSource paisesDataSource = null;
	
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
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}

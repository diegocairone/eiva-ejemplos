package com.cairone.ejemplo01.datasources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cairone.ejemplo01.entities.ClienteEntity;
import com.cairone.ejemplo01.repositories.ClienteRepository;

@Component
public class ClientesDataSource {

	@Autowired private ClienteRepository clienteRepository = null;
	
	public Iterable<ClienteEntity> buscar() {
		return clienteRepository.findAll();
	}
}

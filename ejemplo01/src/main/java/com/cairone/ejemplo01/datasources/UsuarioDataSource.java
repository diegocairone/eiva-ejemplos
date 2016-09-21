package com.cairone.ejemplo01.datasources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cairone.ejemplo01.entities.UsuarioEntity;
import com.cairone.ejemplo01.repositories.UsuarioRepository;

@Component
public class UsuarioDataSource {

	@Autowired private UsuarioRepository usuarioRepository = null;
	
	public Iterable<UsuarioEntity> buscar() {
		return usuarioRepository.findAll();
	}
}

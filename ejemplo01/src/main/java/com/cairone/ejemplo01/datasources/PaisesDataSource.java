package com.cairone.ejemplo01.datasources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cairone.ejemplo01.entities.PaisEntity;
import com.cairone.ejemplo01.repositories.PaisRepository;

@Component
public class PaisesDataSource {

	@Autowired private PaisRepository paisRepository = null;
	
	@Transactional(readOnly = true)
	public PaisEntity buscarPorId(Integer id) {
		return paisRepository.findOne(id);
	}
} 

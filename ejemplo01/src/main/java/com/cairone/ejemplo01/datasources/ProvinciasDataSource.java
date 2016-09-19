package com.cairone.ejemplo01.datasources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cairone.ejemplo01.entities.ProvinciaEntity;
import com.cairone.ejemplo01.entities.ProvinciaPKEntity;
import com.cairone.ejemplo01.entities.QProvinciaEntity;
import com.cairone.ejemplo01.repositories.ProvinciaRepository;
import com.mysema.query.types.expr.BooleanExpression;

@Component
public class ProvinciasDataSource {

	@Autowired
	private ProvinciaRepository provinciaRepository = null;
	
	@Transactional(readOnly = true)
	public List<ProvinciaEntity> getAll() {
		return provinciaRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public ProvinciaEntity buscarPorId(Integer paisId, Integer id) {
		return provinciaRepository.findOne(new ProvinciaPKEntity(paisId, id));
	}
	
	@Transactional(readOnly = true)
	public List<ProvinciaEntity> getProvinciasCon(String inicial) {
		
		if(inicial == null || inicial.trim().isEmpty()) {
			return null;
		}
		
		QProvinciaEntity q = QProvinciaEntity.provinciaEntity;
		BooleanExpression ex = q.nombre.startsWith(inicial.trim().toUpperCase());
		
		Iterable<ProvinciaEntity> resultado = provinciaRepository.findAll(ex);
		
		return (List<ProvinciaEntity>) resultado;
	}
}

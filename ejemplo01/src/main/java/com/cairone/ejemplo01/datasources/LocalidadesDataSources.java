package com.cairone.ejemplo01.datasources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cairone.ejemplo01.entities.LocalidadEntity;
import com.cairone.ejemplo01.entities.ProvinciaEntity;
import com.cairone.ejemplo01.entities.QLocalidadEntity;
import com.cairone.ejemplo01.repositories.LocalidadRepository;
import com.mysema.query.types.expr.BooleanExpression;

@Component
public class LocalidadesDataSources {

	@Autowired
	private LocalidadRepository localidadRepository = null;
	
	@Transactional(readOnly = true)
	public List<LocalidadEntity> buscarPorProvincia(ProvinciaEntity provinciaEntity) {
		QLocalidadEntity q = QLocalidadEntity.localidadEntity;
		BooleanExpression exp = q.provincia.eq(provinciaEntity);
		
		Iterable<LocalidadEntity> resultado = localidadRepository.findAll(exp);
		
		return (List<LocalidadEntity>) resultado;
	}
}

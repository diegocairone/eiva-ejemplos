package com.cairone.ejemplo01.datasources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cairone.ejemplo01.entities.LocalidadEntity;
import com.cairone.ejemplo01.entities.PaisEntity;
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
	
	@Transactional
	public void nuevaLocalidad(PaisEntity pais, String cp, String nombre, ProvinciaEntity provincia) {
		
		LocalidadEntity localidadEntity = new LocalidadEntity();
		
		localidadEntity.setPais(pais);
		localidadEntity.setCodigoPostal(cp);
		localidadEntity.setNombre(nombre);
		localidadEntity.setProvincia(provincia);
		
		localidadRepository.save(localidadEntity);
		
		localidadEntity.setNombre(nombre + " " + nombre);
		
		localidadRepository.save(localidadEntity);
	}
}

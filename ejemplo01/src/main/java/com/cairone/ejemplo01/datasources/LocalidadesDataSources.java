package com.cairone.ejemplo01.datasources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cairone.ejemplo01.entities.LocalidadEntity;
import com.cairone.ejemplo01.entities.PaisEntity;
import com.cairone.ejemplo01.entities.ProvinciaEntity;
import com.cairone.ejemplo01.entities.QLocalidadEntity;
import com.cairone.ejemplo01.exceptions.PaisException;
import com.cairone.ejemplo01.repositories.LocalidadRepository;
import com.cairone.ejemplo01.repositories.PaisRepository;
import com.mysema.query.types.expr.BooleanExpression;

@Component
public class LocalidadesDataSources {

	@Autowired private LocalidadRepository localidadRepository = null;
	@Autowired private PaisRepository paisRepository = null;
	
	@Transactional(readOnly = true)
	public List<LocalidadEntity> buscarPorProvincia(ProvinciaEntity provinciaEntity) {
		QLocalidadEntity q = QLocalidadEntity.localidadEntity;
		BooleanExpression exp = q.provincia.eq(provinciaEntity);
		
		Iterable<LocalidadEntity> resultado = localidadRepository.findAll(exp);
		
		return (List<LocalidadEntity>) resultado;
	}
	
	@Transactional(rollbackFor = PaisException.class)
	public void nuevaLocalidad(Integer paisID, String cp, String nombre, ProvinciaEntity provincia) throws Exception {

		PaisEntity paisEntity = new PaisEntity();
		paisEntity.setId(900);
		paisEntity.setNombre("NO GUARDAR");
		paisRepository.saveAndFlush(paisEntity);
		
		PaisEntity pais = paisRepository.findOne(paisID);
		
		if(pais == null) {
			throw new PaisException(1000, String.format("NO SE ENCUENTRA UN PAIS CON ID %s", paisID));
		}
		
		LocalidadEntity localidadEntity = new LocalidadEntity();
		
		localidadEntity.setPais(pais);
		localidadEntity.setCodigoPostal(cp);
		localidadEntity.setNombre(nombre);
		localidadEntity.setProvincia(provincia);
		
		localidadRepository.save(localidadEntity);
	}
}

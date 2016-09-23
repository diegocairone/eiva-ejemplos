package com.cairone.ejemplo01.datasources;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cairone.ejemplo01.entities.LocalidadEntity;
import com.cairone.ejemplo01.entities.PaisEntity;
import com.cairone.ejemplo01.entities.ProvinciaEntity;
import com.cairone.ejemplo01.entities.QLocalidadEntity;
import com.cairone.ejemplo01.repositories.LocalidadRepository;
import com.cairone.ejemplo01.repositories.PaisRepository;
import com.mysema.query.types.expr.BooleanExpression;

@Component
public class LocalidadesDataSources {

	private static final Logger LOG = LoggerFactory.getLogger(LocalidadesDataSources.class);
	
	@Autowired private LocalidadRepository localidadRepository = null;
	@Autowired private PaisRepository paisRepository = null;
	
	@Transactional(readOnly = true)
	public List<LocalidadEntity> buscarPorProvincia(ProvinciaEntity provinciaEntity) {
		QLocalidadEntity q = QLocalidadEntity.localidadEntity;
		BooleanExpression exp = q.provincia.eq(provinciaEntity);
		
		Iterable<LocalidadEntity> resultado = localidadRepository.findAll(exp);
		
		return (List<LocalidadEntity>) resultado;
	}
	
	@Transactional(rollbackFor = RuntimeException.class)
	public void nuevaLocalidad(Integer paisID, String cp, String nombre, ProvinciaEntity provincia) throws RuntimeException {

		PaisEntity paisEntity = new PaisEntity();
		paisEntity.setId(900);
		paisEntity.setNombre("NO GUARDAR");
		paisRepository.save(paisEntity);
	
		PaisEntity pais = paisRepository.findOne(paisID);
		
		if(pais == null) {
			LOG.info("OCURRIO EL SIGUIENTE ERROR: NO SE ENCUENTRA UN PAIS CON ID ", paisID);
		}
		
		LocalidadEntity localidadEntity = new LocalidadEntity();
		
		localidadEntity.setPais(pais);
		localidadEntity.setCodigoPostal(cp);
		localidadEntity.setNombre(nombre);
		localidadEntity.setProvincia(provincia);
		
		localidadRepository.save(localidadEntity);
		
		try {
			localidadRepository.flush();
			
		} catch (DataIntegrityViolationException e) {
			
			Throwable causa1 = e.getCause();
			if(causa1 != null && causa1 instanceof ConstraintViolationException) {
				Throwable causa2 = causa1.getCause();
				if(causa2 != null && causa2 instanceof SQLException) {
					throw new RuntimeException(causa2);
				} else {
					throw new RuntimeException(causa1.getMessage());
				}
			} else {
				throw new RuntimeException(e.getMessage());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}

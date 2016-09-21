package com.cairone.ejemplo01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.cairone.ejemplo01.entities.UsuarioEntity;
import com.cairone.ejemplo01.entities.UsuarioPKEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UsuarioPKEntity>, QueryDslPredicateExecutor<UsuarioEntity> {

}

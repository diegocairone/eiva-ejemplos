package com.cairone.ejemplo01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.cairone.ejemplo01.entities.LocalidadEntity;

public interface LocalidadRepository extends JpaRepository<LocalidadEntity, Integer>, QueryDslPredicateExecutor<LocalidadEntity> {

}

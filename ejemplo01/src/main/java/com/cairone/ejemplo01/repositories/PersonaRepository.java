package com.cairone.ejemplo01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.cairone.ejemplo01.entities.PersonaEntity;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer>, QueryDslPredicateExecutor<PersonaEntity> {

}

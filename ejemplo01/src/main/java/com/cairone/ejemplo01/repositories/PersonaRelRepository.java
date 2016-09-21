package com.cairone.ejemplo01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.cairone.ejemplo01.entities.PersonaRelEnity;
import com.cairone.ejemplo01.entities.PersonaRelPKEntity;

public interface PersonaRelRepository extends JpaRepository<PersonaRelEnity, PersonaRelPKEntity>, QueryDslPredicateExecutor<PersonaRelEnity> {

}

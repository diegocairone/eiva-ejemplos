package com.cairone.ejemplo01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.cairone.ejemplo01.entities.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer>, QueryDslPredicateExecutor<ClienteEntity> {

}

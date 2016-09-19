package com.cairone.ejemplo01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.cairone.ejemplo01.entities.ProvinciaEntity;
import com.cairone.ejemplo01.entities.ProvinciaPKEntity;

public interface ProvinciaRepository extends JpaRepository<ProvinciaEntity, ProvinciaPKEntity>, QueryDslPredicateExecutor<ProvinciaEntity> {

}


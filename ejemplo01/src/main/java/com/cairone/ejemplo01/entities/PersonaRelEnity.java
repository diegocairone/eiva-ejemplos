package com.cairone.ejemplo01.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity @Table(name="persona_rel")
public class PersonaRelEnity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EmbeddedId 
	private PersonaRelPKEntity id = null;

	@Column(name = "persona", length = 50)
	private String persona;

	public PersonaRelEnity() {}

	public PersonaRelPKEntity getId() {
		return this.id;
	}

	public void setId(PersonaRelPKEntity id) {
		this.id = id;
	}

	public String getPersona() {
		return this.persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

}
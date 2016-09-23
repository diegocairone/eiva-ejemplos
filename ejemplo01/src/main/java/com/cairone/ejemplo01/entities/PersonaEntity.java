package com.cairone.ejemplo01.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity @Table(name="Personas")
public class PersonaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id @Column(name="id_persona")
	private Integer id = null;

	@Column(name="apellido", length = 100)
	private String apellido = null;

	@Column(name="nombre", length = 100)
	private String nombre = null;

	public PersonaEntity() {}

	public int getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonaEntity other = (PersonaEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("[%s] %s %s", this.id, this.nombre, this.apellido);
	}
}
package com.cairone.ejemplo01.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class UsuarioPKEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private PersonaRelPKEntity personaRelPKEntity = null;

	@Transient
	private Integer perTipoUsu;

	@Transient
	private Integer perCodUsu;

	public UsuarioPKEntity() {
		this.personaRelPKEntity = new PersonaRelPKEntity();
	}

	public int getPerTipoUsu() {
		return perTipoUsu;
	}

	public void setPerTipoUsu(Integer perTipoUsu) {
		this.perTipoUsu = perTipoUsu;
		this.personaRelPKEntity.setPerTipo(perTipoUsu);
	}

	public int getPerCodUsu() {
		return perCodUsu;
	}

	public void setPerCodUsu(Integer perCodUsu) {
		this.perCodUsu = perCodUsu;
		this.personaRelPKEntity.setPerCod(perCodUsu);
	}

	public PersonaRelPKEntity getPersonaRelPKEntity() {
		return personaRelPKEntity;
	}

	public void setPersonaRelPKEntity(PersonaRelPKEntity personaRelPKEntity) {
		this.personaRelPKEntity = personaRelPKEntity;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((personaRelPKEntity == null) ? 0 : personaRelPKEntity
						.hashCode());
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
		UsuarioPKEntity other = (UsuarioPKEntity) obj;
		if (personaRelPKEntity == null) {
			if (other.personaRelPKEntity != null)
				return false;
		} else if (!personaRelPKEntity.equals(other.personaRelPKEntity))
			return false;
		return true;
	}

}

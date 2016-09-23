package com.cairone.ejemplo01.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UsuarioPKEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private PersonaRelPKEntity personaRelPKEntity = null;
	
	@Column(name="per_tipo_usu", insertable = false, updatable = false)
	private int perTipoUsu;

	@Column(name="per_cod_usu", insertable = false, updatable = false)
	private int perCodUsu;

	public UsuarioPKEntity() {
		this.personaRelPKEntity = new PersonaRelPKEntity();
	}

	public int getPerTipoUsu() {
		return perTipoUsu;
	}

	public void setPerTipoUsu(int perTipoUsu) {
		this.perTipoUsu = perTipoUsu;
		this.personaRelPKEntity.setPerTipo(perTipoUsu);
	}

	public int getPerCodUsu() {
		return perCodUsu;
	}

	public void setPerCodUsu(int perCodUsu) {
		this.perCodUsu = perCodUsu;
		this.personaRelPKEntity.setPerCod(perCodUsu);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + perCodUsu;
		result = prime * result + perTipoUsu;
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
		if (perCodUsu != other.perCodUsu)
			return false;
		if (perTipoUsu != other.perTipoUsu)
			return false;
		return true;
	}
	
}

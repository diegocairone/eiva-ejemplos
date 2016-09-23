package com.cairone.ejemplo01.entities;

import java.io.Serializable;

public class UsuarioAltPKEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer perTipoUsu = null;
	private Integer perCodUsu = null;

	public UsuarioAltPKEntity() {}

	public Integer getPerTipoUsu() {
		return perTipoUsu;
	}

	public void setPerTipoUsu(Integer perTipoUsu) {
		this.perTipoUsu = perTipoUsu;
	}

	public Integer getPerCodUsu() {
		return perCodUsu;
	}

	public void setPerCodUsu(Integer perCodUsu) {
		this.perCodUsu = perCodUsu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((perCodUsu == null) ? 0 : perCodUsu.hashCode());
		result = prime * result
				+ ((perTipoUsu == null) ? 0 : perTipoUsu.hashCode());
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
		UsuarioAltPKEntity other = (UsuarioAltPKEntity) obj;
		if (perCodUsu == null) {
			if (other.perCodUsu != null)
				return false;
		} else if (!perCodUsu.equals(other.perCodUsu))
			return false;
		if (perTipoUsu == null) {
			if (other.perTipoUsu != null)
				return false;
		} else if (!perTipoUsu.equals(other.perTipoUsu))
			return false;
		return true;
	}
}

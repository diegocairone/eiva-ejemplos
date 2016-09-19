package com.cairone.ejemplo01.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LocalidadPKEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_pais", nullable = false) private Integer paisID = null;
	@Column(name = "id_provincia", nullable = false) private Integer provinciaID = null;
	@Column(name = "cp", length = 5, nullable = false) private String cp = null;
	
	public LocalidadPKEntity() {}

	public LocalidadPKEntity(Integer paisID, Integer provinciaID, String cp) {
		super();
		this.paisID = paisID;
		this.provinciaID = provinciaID;
		this.cp = cp;
	}

	public Integer getProvinciaID() {
		return provinciaID;
	}

	public void setProvinciaID(Integer provinciaID) {
		this.provinciaID = provinciaID;
	}

	public Integer getPaisID() {
		return paisID;
	}

	public void setPaisID(Integer paisID) {
		this.paisID = paisID;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cp == null) ? 0 : cp.hashCode());
		result = prime * result + ((paisID == null) ? 0 : paisID.hashCode());
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
		LocalidadPKEntity other = (LocalidadPKEntity) obj;
		if (cp == null) {
			if (other.cp != null)
				return false;
		} else if (!cp.equals(other.cp))
			return false;
		if (paisID == null) {
			if (other.paisID != null)
				return false;
		} else if (!paisID.equals(other.paisID))
			return false;
		return true;
	}
	
}

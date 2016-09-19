package com.cairone.ejemplo01.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProvinciaPKEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "id_pais", nullable=false) private Integer paisID = null;
	@Column(name = "id_provincia", nullable=false) private Integer provinciaID = null;
	
	public ProvinciaPKEntity() {}

	public ProvinciaPKEntity(Integer paisID, Integer provinciaID) {
		super();
		this.paisID = paisID;
		this.provinciaID = provinciaID;
	}
	
	public ProvinciaPKEntity(LocalidadEntity localidadEntity) {
		this(localidadEntity.getPais().getId(), localidadEntity.getProvincia().getId());
	}
	
	public ProvinciaPKEntity(PaisEntity paisEntity, Integer provinciaID) {
		this(paisEntity.getId(), provinciaID);
	}

	public Integer getPaisID() {
		return paisID;
	}

	public void setPaisID(Integer paisID) {
		this.paisID = paisID;
	}

	public Integer getProvinciaID() {
		return provinciaID;
	}

	public void setProvinciaID(Integer provinciaID) {
		this.provinciaID = provinciaID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((paisID == null) ? 0 : paisID.hashCode());
		result = prime * result
				+ ((provinciaID == null) ? 0 : provinciaID.hashCode());
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
		ProvinciaPKEntity other = (ProvinciaPKEntity) obj;
		if (paisID == null) {
			if (other.paisID != null)
				return false;
		} else if (!paisID.equals(other.paisID))
			return false;
		if (provinciaID == null) {
			if (other.provinciaID != null)
				return false;
		} else if (!provinciaID.equals(other.provinciaID))
			return false;
		return true;
	}
	
}

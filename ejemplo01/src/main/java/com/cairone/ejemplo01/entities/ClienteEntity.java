package com.cairone.ejemplo01.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity @Table(name="Clientes")
public class ClienteEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id @Column(name = "id_cliente")
	private Integer id = null;
	
	@OneToOne @PrimaryKeyJoinColumn(name = "id_cliente", referencedColumnName = "id_persona")
	private PersonaEntity persona = null;

	@Column(name="alta", nullable = false) @Temporal(TemporalType.DATE)
	private Date alta = null;
	
	public ClienteEntity() {}

	public PersonaEntity getPersona() {
		return persona;
	}

	public void setPersona(PersonaEntity persona) {
		this.persona = persona;
		this.id = persona.getId();
	}

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
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
		ClienteEntity other = (ClienteEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.persona.toString();
	}
}

package com.cairone.ejemplo01.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity @Table(name="usuarios")
public class UsuarioEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId /*@AttributeOverrides( {
        @AttributeOverride(name="perTipoUsu", column=@Column(name="per_tipo", nullable=false, insertable = false, updatable = false) ), 
        @AttributeOverride(name="perCodUsu", column=@Column(name="per_cod", nullable=false, insertable = false, updatable = false) ) } )*/
	private UsuarioPKEntity pk = null;
/*
	@ManyToOne @MapsId("personaRelPKEntity") @JoinColumns({
		@JoinColumn(name = "per_tipo_usu", referencedColumnName = "per_tipo", insertable = false, updatable = false),
		@JoinColumn(name = "per_cod_usu", referencedColumnName = "per_cod", insertable = false, updatable = false)
	})*/
	@ManyToOne @MapsId("personaRelPKEntity") @JoinColumns({
		@JoinColumn(name = "per_tipo_usu", referencedColumnName = "per_tipo"),
		@JoinColumn(name = "per_cod_usu", referencedColumnName = "per_cod")
	})
	private PersonaRelEnity personaRel = null;

	private String nombre;

	public UsuarioEntity() {
		this.pk = new UsuarioPKEntity();
	}

	public PersonaRelEnity getPersonaRel() {
		return personaRel;
	}

	public void setPersonaRel(PersonaRelEnity personaRel) {
		this.personaRel = personaRel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pk == null) ? 0 : pk.hashCode());
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
		UsuarioEntity other = (UsuarioEntity) obj;
		if (pk == null) {
			if (other.pk != null)
				return false;
		} else if (!pk.equals(other.pk))
			return false;
		return true;
	}

}

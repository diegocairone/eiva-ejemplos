package com.cairone.ejemplo01.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name = "Localidades")
public class LocalidadEntity {

	@Id @Column(name = "id_localidad")
	private Integer id = null;
	
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre = null;

	@Column(name = "cp", length = 5, nullable = true)
	private String codigoPostal = null;

	@OneToOne @JoinColumn(name = "id_provincia", referencedColumnName = "id_provincia")
	private ProvinciaEntity provincia = null;
	
	public LocalidadEntity() {}

	public LocalidadEntity(Integer id, String nombre, String codigoPostal, ProvinciaEntity provincia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public ProvinciaEntity getProvincia() {
		return provincia;
	}

	public void setProvincia(ProvinciaEntity provincia) {
		this.provincia = provincia;
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
		LocalidadEntity other = (LocalidadEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("%s [%s] de %s", this.nombre, this.id, this.provincia);
	}
}

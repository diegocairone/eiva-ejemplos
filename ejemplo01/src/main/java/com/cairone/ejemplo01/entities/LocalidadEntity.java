package com.cairone.ejemplo01.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name = "Localidades")
public class LocalidadEntity {

	@EmbeddedId private LocalidadPKEntity pk = null;
	
	@OneToOne @JoinColumn(name = "id_pais", referencedColumnName = "id_pais", nullable = false, insertable = false, updatable = false)
	private PaisEntity pais = null;

	@Column(name = "cp", length = 5, nullable = false, insertable = false, updatable = false)
	private String codigoPostal = null;
	
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre = null;

	@OneToOne @JoinColumns({ 
		@JoinColumn(name = "id_pais", referencedColumnName = "id_pais", nullable = false, insertable = false, updatable = false),
		@JoinColumn(name = "id_provincia", referencedColumnName = "id_provincia", nullable = false, insertable = false, updatable = false) })
	private ProvinciaEntity provincia = null;
	
	public LocalidadEntity() {
		this.pk = new LocalidadPKEntity();
	}

	public LocalidadEntity(PaisEntity paisEntity, String codigoPostal, String nombre, ProvinciaEntity provincia) {
		super();
		this.pais = paisEntity;
		this.nombre = nombre;
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
		
		this.pk = new LocalidadPKEntity(paisEntity.getId(), provincia.getId(), codigoPostal);
	}

	public PaisEntity getPais() {
		return pais;
	}

	public void setPais(PaisEntity pais) {
		this.pais = pais;
		this.pk.setPaisID(pais.getId());
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
		this.pk.setCp(codigoPostal);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ProvinciaEntity getProvincia() {
		return provincia;
	}

	public void setProvincia(ProvinciaEntity provincia) {
		this.provincia = provincia;
		this.pk.setProvinciaID(provincia.getId());
	}
}

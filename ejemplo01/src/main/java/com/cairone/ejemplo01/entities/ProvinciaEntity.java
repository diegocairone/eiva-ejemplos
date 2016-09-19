package com.cairone.ejemplo01.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity @Table(name = "Provincias")
public class ProvinciaEntity {

	@EmbeddedId private ProvinciaPKEntity pk = null;
	
	@OneToOne @JoinColumn(name = "id_pais", nullable = false, insertable = false, updatable = false)
	private PaisEntity pais = null;
	
	@Id @Column(name = "id_provincia", nullable = false, insertable = false, updatable = false)
	private Integer id = null;
	
	@Column(name = "nombre", length = 100, nullable = false)
	private String nombre = null;
	
	public ProvinciaEntity() {
		this.pk = new ProvinciaPKEntity();
	}

	public ProvinciaEntity(PaisEntity pais, Integer id, String nombre) {
		super();
		this.pais = pais;
		this.id = id;
		this.nombre = nombre;
		
		this.pk = new ProvinciaPKEntity(pais, id);
	}

	public PaisEntity getPais() {
		return pais;
	}

	public void setPais(PaisEntity pais) {
		this.pais = pais;
		this.pk.setPaisID(pais.getId());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		this.pk.setProvinciaID(id);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

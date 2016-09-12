package com.cairone.ejemplo01.entities;

import java.util.Date;

public class Cliente extends Persona {

	private Date alta = null;
	
	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nombre, String apellido, Date alta) {
		super();
		this.alta = alta;
	}
	
	public Cliente(Integer id, String nombre, String apellido) {
		super(id, nombre, apellido);
		this.alta = new Date();
	}

	public Date getAlta() {
		return alta;
	}

	public void setAlta(Date alta) {
		this.alta = alta;
	}
}

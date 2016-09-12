package com.cairone.ejemplo01.entities;

public class Persona implements Comparable<Persona> {

	private Integer id = null;
	private String apellido = null;
	private String nombre = null;
	
	public Persona() {}

	public Persona(Integer id, String apellido, String nombre) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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
		Persona other = (Persona) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return String.format("[%s] %s", this.id, this.nombre);
	}

	@Override
	public int compareTo(Persona o) {
		return this.id.compareTo(o.getId());
	}
}

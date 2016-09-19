package com.cairone.ejemplo01.exceptions;

public class PaisException extends Exception {

	private static final long serialVersionUID = 1L;

	private Integer codigo = null;
	
	public PaisException(Integer codigo, String mensaje) {
		super(mensaje);
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	@Override
	public String getMessage() {
		return String.format("%s [%s]", super.getMessage(), codigo);
	}
}

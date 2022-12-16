package com.marcelo.main.entities;

public enum Categoria {
	Funilaria(0),
	Motor(1),
	Performance(2),
	Som(3);
	
	private int code;

	private Categoria(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
	public static Categoria valueOf(int code) {
		for (Categoria value : Categoria.values()) {	
			if (code == value.getCode())
				return value;
		}
		throw new IllegalArgumentException("Invalid argument 'Categoria' code");
		
	}
	
}

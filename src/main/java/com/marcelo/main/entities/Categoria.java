package com.marcelo.main.entities;

public enum Categoria {
	Funilaria(1),
	Motor(2),
	Performance(3),
	Som(4);
	
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

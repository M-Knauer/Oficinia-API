package com.marcelo.main.custom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ErroDeNegocioException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private String message;
	private HttpStatus cod;
	
	public ErroDeNegocioException(String message, HttpStatus cod) {
		this.message = message;
		this.cod = cod;
	}
	
	public ErroDeNegocioException() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getCod() {
		return cod;
	}

	public void setCod(HttpStatus cod) {
		this.cod = cod;
	}
	
}

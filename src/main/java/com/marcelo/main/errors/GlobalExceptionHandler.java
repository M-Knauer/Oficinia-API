package com.marcelo.main.errors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.marcelo.main.custom.exception.ErroDeNegocioException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ErroDeNegocioException.class)
	public ResponseEntity<String> erroDeNegocios(ErroDeNegocioException e) {

		return new ResponseEntity<String>(e.getMessage(), e.getCod());
	}
	
}

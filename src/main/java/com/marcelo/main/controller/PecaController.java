package com.marcelo.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.marcelo.main.entities.Peca;
import com.marcelo.main.entities.PecaDto;
import com.marcelo.main.services.PecasService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pecas")
public class PecaController {
	
	@Autowired
	PecasService ps;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void cadastrarPeca(@Valid @RequestBody Peca peca) {
		ps.cadastrarPeca(peca);
		
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<PecaDto> buscarPecas() {
		try {
			return ps.buscarPecas();
			
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@GetMapping(path = "{codBarra}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public PecaDto buscarPeca(@PathVariable Long codBarra) {
		return ps.buscarPeca(codBarra);
		
	}
	
	@PutMapping(path = "{codBarra}")
	public void alterarPeca(@Valid @PathVariable Long codBarra, @RequestBody Peca peca ) {
		ps.alterarPeca(codBarra, peca);
	}
	
	@DeleteMapping(path = "{codBarra}")
	public void removerPeca(@PathVariable Long codBarra) {
		ps.removerPeca(codBarra);
		
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
		
		Map<String, String> errors = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach(error ->{
			
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			
			errors.put(fieldName, errorMessage);
		});
		
		return errors;
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public String handleNotReadbleException(HttpMessageNotReadableException ex) {
		
		return ex.getMessage();
	}
	
}

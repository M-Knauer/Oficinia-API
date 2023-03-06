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

import com.marcelo.main.dto.GetPecaDto;
import com.marcelo.main.dto.PostPecaDto;
import com.marcelo.main.dto.UpdatePecaDto;
import com.marcelo.main.services.PecasService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/pecas")
public class PecaController {
	
	@Autowired
	PecasService ps;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void cadastrarPeca(@Valid @RequestBody PostPecaDto dto)  {
		ps.cadastrarPeca(dto);
		
	}
	
	@GetMapping
	public List<GetPecaDto> buscarPecas() {
		return ps.buscarPecas();
		
	}
	
	@GetMapping(path = "{codBarra}")
	public GetPecaDto buscarPeca(@PathVariable Long codBarra) {
		return ps.buscarPeca(codBarra);
		
	}
	
	@GetMapping(path = "{txt}/comeco")
	public List<GetPecaDto> buscarPorLetraInicial(@PathVariable String txt) {
		return ps.buscarPorLetraInicial(txt);
		
	}
	
	@GetMapping(path = "{modelo}/modelo")
	public List<GetPecaDto> buscarPorModelo(@PathVariable String modelo) {
		return ps.buscarPorModelo(modelo);
	}
	
	@GetMapping(path = "{categoria}/categoria")
	public List<GetPecaDto> buscarPorCategoria(@PathVariable Integer categoria) {
		return ps.buscarPorCategoria(categoria);
		
	}
	
	@PutMapping(path = "{codBarra}")
	public void alterarPeca(@Valid @PathVariable Long codBarra, @RequestBody UpdatePecaDto dto ) {
		ps.alterarPeca(codBarra, dto);
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

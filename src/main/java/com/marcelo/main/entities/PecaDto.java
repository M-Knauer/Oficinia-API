package com.marcelo.main.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

public class PecaDto {

	private Long codigoDeBarras;
	
	private String nome;
	
	private String modeloDoCarro;
	
	private String fabricante;

	private Integer categoria;
	
	private Double precoDeVenda;
	
	public PecaDto() {
		
	}

	public PecaDto(Long codigoDeBarras, String nome, String modeloDoCarro, String fabricante, Integer categoria,
			Double precoDeVenda) {
		this.codigoDeBarras = codigoDeBarras;
		this.nome = nome;
		this.modeloDoCarro = modeloDoCarro;
		this.fabricante = fabricante;
		this.categoria = categoria;
		this.precoDeVenda = precoDeVenda;
	}

	public Long getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(Long codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModeloDoCarro() {
		return modeloDoCarro;
	}

	public void setModeloDoCarro(String modeloDoCarro) {
		this.modeloDoCarro = modeloDoCarro;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Double getPrecoDeVenda() {
		return precoDeVenda;
	}

	public void setPrecoDeVenda(Double precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}
	
	public Categoria getCategoria() {
		return Categoria.valueOf(categoria);
	}

	public void setCategoria(Categoria categoria) {
		if (categoria != null) 
			this.categoria = categoria.getCode();
		
	}
	
	public static PecaDto toDto(Peca peca) {
		PecaDto dto = new PecaDto();
		BeanUtils.copyProperties(peca, dto);
		
		return dto;
	}
	
	public static List<PecaDto> toDto(List<Peca> pecas) {
		List<PecaDto> listDto = new ArrayList<>();
		
		pecas.forEach(peca -> {
			PecaDto dto = new PecaDto();
			BeanUtils.copyProperties(peca, dto);
			listDto.add(dto);
		});
		
		return listDto;
	}
}

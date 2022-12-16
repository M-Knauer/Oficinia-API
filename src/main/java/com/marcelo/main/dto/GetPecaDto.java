package com.marcelo.main.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.marcelo.main.entities.Categoria;
import com.marcelo.main.entities.Peca;

public class GetPecaDto {

	private Long codigoDeBarras;
	
	private String nome;
	
	private String modeloDoCarro;
	
	private String fabricante;
	
	private Integer qtdEstoque;

	private Integer categoria;
	
	private Double precoDeVenda;
	
	public GetPecaDto() {
		
	}

	public GetPecaDto(Long codigoDeBarras, String nome, String modeloDoCarro, String fabricante, Integer qtdEstoque, Integer categoria,
			Double precoDeVenda) {
		this.codigoDeBarras = codigoDeBarras;
		this.nome = nome;
		this.modeloDoCarro = modeloDoCarro;
		this.fabricante = fabricante;
		this.qtdEstoque = qtdEstoque;
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

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
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
	
	public static GetPecaDto toDto(Peca peca) {
		GetPecaDto dto = new GetPecaDto();
		BeanUtils.copyProperties(peca, dto);
		
		return dto;
	}
	
	public static List<GetPecaDto> toDto(List<Peca> pecas) {
		List<GetPecaDto> listDto = new ArrayList<>();
		
		pecas.forEach(peca -> {
			GetPecaDto dto = new GetPecaDto();
			BeanUtils.copyProperties(peca, dto);
			listDto.add(dto);
		});
		
		return listDto;
	}
}

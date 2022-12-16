package com.marcelo.main.dto;

import org.springframework.beans.BeanUtils;

import com.marcelo.main.entities.Categoria;
import com.marcelo.main.entities.Peca;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PostPecaDto {
	
	@NotNull
	private Long codigoDeBarras;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String modeloDoCarro;
	
	@NotBlank
	private String fabricante;
	
	@NotNull
	private Double precoDeCusto;
	
	@NotNull
	private Double precoDeVenda;
	
	@NotNull
	private Integer qtdEstoque;
	
	@NotNull
	private Integer categoria;
	
	public PostPecaDto() {
		
	}
	
	public PostPecaDto(Long codigoDeBarras, String nome, String modeloDoCarro, String fabricante, Double precoDeCusto,
			Double precoDeVenda, Integer qtdEstoque, Categoria categoria) {
		this.codigoDeBarras = codigoDeBarras;
		this.nome = nome;
		this.modeloDoCarro = modeloDoCarro;
		this.fabricante = fabricante;
		this.precoDeCusto = precoDeCusto;
		this.precoDeVenda = precoDeVenda;
		this.qtdEstoque = qtdEstoque;
		setCategoria(categoria);
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

	public Double getPrecoDeCusto() {
		return precoDeCusto;
	}

	public void setPrecoDeCusto(Double precoDeCusto) {
		this.precoDeCusto = precoDeCusto;
	}

	public Double getPrecoDeVenda() {
		return precoDeVenda;
	}

	public void setPrecoDeVenda(Double precoDeVenda) {
		this.precoDeVenda = precoDeVenda;
	}

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Categoria getCategoria() {
		return Categoria.valueOf(categoria);
	}

	public void setCategoria(Categoria categoria) {
		if (categoria != null) 
			this.categoria = categoria.getCode();
	}
	
	public static Peca toEntity(PostPecaDto dto) {
		Peca peca = new Peca();
		BeanUtils.copyProperties(dto, peca);
		
		return peca;
	}
	
}

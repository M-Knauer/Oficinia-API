package com.marcelo.main.dto;

import jakarta.validation.constraints.NotNull;

public class UpdatePecaDto {
	
	@NotNull(message = "Preço de custo não pode ser nulo")
	private Double precoDeCusto;
	
	@NotNull(message = "Preço de venda não pode ser nulo")
	private Double precoDeVenda;
	
	@NotNull(message = "Quantidade de estoque não pode ser nulo")
	private Integer qtdEstoque;
	
	public UpdatePecaDto() {
		
	}

	public UpdatePecaDto(Double precoDeCusto, Double precoDeVenda, Integer qtdEstoque) {
		this.precoDeCusto = precoDeCusto;
		this.precoDeVenda = precoDeVenda;
		this.qtdEstoque = qtdEstoque;
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
	
}

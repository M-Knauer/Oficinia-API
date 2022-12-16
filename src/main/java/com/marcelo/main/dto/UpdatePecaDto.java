package com.marcelo.main.dto;

public class UpdatePecaDto {
	
	private Double precoDeCusto;
	
	private Double precoDeVenda;
	
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

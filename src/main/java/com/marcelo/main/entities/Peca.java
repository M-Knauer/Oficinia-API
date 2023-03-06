package com.marcelo.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "pecas")
public class Peca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "codigo_de_barras", precision = 5, unique = true)
	private Long codigoDeBarras;
	
	
	@Column(nullable = false, length = 50)
	private String nome;
	
	
	@Column(name = "modelo_do_carro", length = 50)
	private String modeloDoCarro;
	
	
	@Column(length = 50)
	private String fabricante;
	
	
	@Column(name = "preco_de_custo", columnDefinition = "numeric", precision = 10, scale = 2)
	private Double precoDeCusto;
	
	
	@Column(name = "preco_de_venda", columnDefinition = "numeric", precision = 10, scale = 2, nullable = false)
	private Double precoDeVenda;
	
	
	@Column(name = "quantidade_em_estoque")
	private Integer qtdEstoque;
	
	private Integer categoria;
	
	public Peca() {
		
	}
	
	public Peca(Long codigoDeBarras, String nome, String modeloDoCarro, String fabricante, Double precoDeCusto,
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
	
}

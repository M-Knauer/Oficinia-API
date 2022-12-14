package com.marcelo.main.entities;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity(name = "pecas")
public class Peca {
	
	@Id
	@Column(name = "codigo_de_barras", precision = 5)
	@NotNull
	private Long codigoDeBarras;
	
	@NotBlank
	@Column(nullable = false, length = 50)
	private String nome;
	
	@NotBlank
	@Column(name = "modelo_do_carro", length = 50)
	private String modeloDoCarro;
	
	@NotBlank
	@Column(length = 50)
	private String fabricante;
	
	@NotNull
	@Column(name = "preco_de_custo", columnDefinition = "numeric", precision = 10, scale = 2)
	private Double precoDeCusto;
	
	@NotNull
	@Column(name = "preco_de_venda", columnDefinition = "numeric", precision = 10, scale = 2, nullable = false)
	private Double precoDeVenda;
	
	@NotNull
	@Max(value = 3)
	@Min(value =  0)
	private Integer categoria;
	
	public Peca() {
		
	}

	public Peca(Long codigoDeBarras, String nome, String modeloDoCarro, String fabricante, Double precoDeCusto,
			Double precoDeVenda, Categoria categoria) {
		this.codigoDeBarras = codigoDeBarras;
		this.nome = nome;
		this.modeloDoCarro = modeloDoCarro;
		this.fabricante = fabricante;
		this.precoDeCusto = precoDeCusto;
		this.precoDeVenda = precoDeVenda;
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

	public Categoria getCategoria() {
		return Categoria.valueOf(categoria);
	}

	public void setCategoria(Categoria categoria) {
		if (categoria != null) 
			this.categoria = categoria.getCode();
		
	}
	
}

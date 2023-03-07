package com.marcelo.main.dto;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.text.WordUtils;
import org.springframework.beans.BeanUtils;

import com.marcelo.main.entities.Categoria;
import com.marcelo.main.entities.Peca;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class GetPecaDto {

	private Long id;
	
	@NotNull(message = "Codigo barras não pode ser nulo")
	private Long codigoDeBarras;
	
	@NotBlank(message = "Nome não pode ser vazio")
	private String nome;
	
	@NotBlank(message = "Modelo do carro não pode ser vazio")
	private String modeloDoCarro;
	
	@NotBlank(message = "Fabricante não pode ser vazio")
	private String fabricante;
	
	@NotNull(message = "Quantidade de estoque não pode ser nulo")
	private Integer qtdEstoque;
	
	@NotNull(message = "Categoria não pode ser nulo")
	private Integer categoria;
	
	@NotNull(message = "Preço de venda não pode ser nulo")
	private Double precoDeVenda;
	
	public GetPecaDto() {
		
	}

	public GetPecaDto(Long id, Long codigoDeBarras, String nome, String modeloDoCarro, String fabricante,
			Double precoDeVenda, Integer qtdEstoque, Categoria categoria) {
		this.id = id;
		this.codigoDeBarras = codigoDeBarras;
		this.nome = WordUtils.capitalize(nome);
		this.modeloDoCarro = WordUtils.capitalizeFully(modeloDoCarro);
		this.fabricante = WordUtils.capitalize(fabricante);
		this.precoDeVenda = precoDeVenda;
		this.qtdEstoque = qtdEstoque;
		setCategoria(categoria);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		this.nome =  WordUtils.capitalize(nome, new char[] {});
	}

	public String getModeloDoCarro() {
		return modeloDoCarro;
	}

	public void setModeloDoCarro(String modeloDoCarro) {
		this.modeloDoCarro =  WordUtils.capitalizeFully(modeloDoCarro);
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante =  WordUtils.capitalizeFully(fabricante);
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

package com.marcelo.main.dto;

import org.springframework.beans.BeanUtils;

import com.marcelo.main.entities.Peca;

import jakarta.validation.constraints.NotNull;

public class PostPecaDto extends GetPecaDto {
	
	
	@NotNull(message = "Preço de custo não pode ser nulo")
	private Double precoDeCusto;
	
	public PostPecaDto() {
		
	}
	
	public PostPecaDto(Double precoDeCusto) {
		super();
		this.precoDeCusto = precoDeCusto;
	}

	public Double getPrecoDeCusto() {
		return precoDeCusto;
	}

	public void setPrecoDeCusto(Double precoDeCusto) {
		this.precoDeCusto = precoDeCusto;
	}

	
	public static Peca toEntity(PostPecaDto dto) {
		Peca peca = new Peca();
		BeanUtils.copyProperties(dto, peca);
		
		return peca;
	}
	
}

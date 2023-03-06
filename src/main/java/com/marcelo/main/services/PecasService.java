package com.marcelo.main.services;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.text.WordUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.marcelo.main.custom.exception.ErroDeNegocioException;
import com.marcelo.main.dto.GetPecaDto;
import com.marcelo.main.dto.PostPecaDto;
import com.marcelo.main.dto.UpdatePecaDto;
import com.marcelo.main.entities.Peca;
import com.marcelo.main.repositories.PecasRepository;

@Service
public class PecasService {

	
	@Autowired
	PecasRepository pr;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Transactional
	public void cadastrarPeca(PostPecaDto dto) throws ErroDeNegocioException {
		if (pr.existsByCodigoDeBarras(dto.getCodigoDeBarras()))
			throw new ErroDeNegocioException("Peça já existe!", HttpStatus.UNPROCESSABLE_ENTITY);
		
		// converte dto pra entidade
		Peca peca = modelMapper.map(dto, Peca.class);
		pr.save(peca);
		
	}
	
	@Transactional(readOnly = true)
	public List<GetPecaDto> buscarPecas() {
		
		//converte entidade pra dto e gera uma lista
		return pr.findAll().stream().map(peca -> 
		modelMapper.map(peca, GetPecaDto.class)).collect(Collectors.toList());
		
	}
	
	@Transactional(readOnly = true)
	public GetPecaDto buscarPeca(Long codBarra) throws ErroDeNegocioException {
		
		if (pr.existsByCodigoDeBarras(codBarra)) {
			Peca peca = pr.findByCodigoDeBarras(codBarra).get();
			return modelMapper.map(peca, GetPecaDto.class);
		}
		
		throw new ErroDeNegocioException("Peça não encontrada!", HttpStatus.NOT_FOUND);
	}
		

	@Transactional
	public void alterarPeca(Long codBarra, UpdatePecaDto dto) {
		if (pr.existsByCodigoDeBarras(codBarra)) {
			Peca peca = pr.findByCodigoDeBarras(codBarra).get();
			
			peca.setPrecoDeCusto(dto.getPrecoDeCusto());
			peca.setPrecoDeVenda(dto.getPrecoDeVenda());
			peca.setQtdEstoque(dto.getQtdEstoque());
			
			pr.save(peca);
			
			return;
					
		}
		
		throw new ErroDeNegocioException("Peça não existe!", HttpStatus.UNPROCESSABLE_ENTITY);
		
	}

	@Transactional
	public void removerPeca(Long codBarra) throws ErroDeNegocioException {
		
		if (pr.existsByCodigoDeBarras(codBarra)) {
			pr.deleteByCodigoDeBarras(codBarra);
			return;
		}
		throw new ErroDeNegocioException("Peça não existe!", HttpStatus.UNPROCESSABLE_ENTITY);
		
	}
	
	@Transactional(readOnly = true)
	public List<GetPecaDto> buscarPorLetraInicial(String txt) {
		return pr.findByNomeStartingWith(WordUtils.capitalize(txt)).stream().map(peca -> 
		modelMapper.map(peca, GetPecaDto.class)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<GetPecaDto> buscarPorModelo(String modelo) {
		return pr.findByModeloDoCarroContaining(WordUtils.capitalizeFully(modelo)).stream().map(peca -> 
		modelMapper.map(peca, GetPecaDto.class)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public List<GetPecaDto> buscarPorCategoria(Integer categoria) {
		try {
			return pr.findByCategoria(categoria).stream().map(peca -> modelMapper.map(peca, GetPecaDto.class)).toList();
		} catch (MethodArgumentTypeMismatchException e) {
			throw new ErroDeNegocioException("Só é permitido numeros inteiros para busca de categoria", HttpStatus.BAD_REQUEST);
		}
		
	}
}

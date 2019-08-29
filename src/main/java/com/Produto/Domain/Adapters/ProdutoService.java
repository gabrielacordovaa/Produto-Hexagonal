package com.Produto.Domain.Adapters;

import org.springframework.beans.factory.annotation.Autowired;

import com.Produto.Domain.Exceptions.ProdutoNotFoundException;
import com.Produto.Domain.Models.Produto;
import com.Produto.Domain.Ports.InterfaceProdutoRepository;
import com.Produto.Domain.Ports.InterfaceProdutoService;
import com.Produto.Domain.ValueObjects.Id;

public class ProdutoService implements InterfaceProdutoService {
	@Autowired
	private InterfaceProdutoRepository produtoRepository;
	
	@Override
	public Produto getProduto(Id id) throws ProdutoNotFoundException {
		Produto produto = produtoRepository.getProduto(id);
		if(produto.getId().equals(id))
			return produto;
		throw new ProdutoNotFoundException();
		
	}

	@Override
	public boolean addProduto(Produto produto) {
		try { 
			produto = produtoRepository.getProduto(produto.getId());
			return false;
		
		} catch (ProdutoNotFoundException e) {
			return false;
		}
		
		
	}

	@Override
	public boolean updateProduto(Produto produto) {
		if(produtoRepository.getProduto(produto.getId()) == null)
			return produtoRepository.updateProduto(produto);	
		return false;
	}

	@Override
	public boolean deleteProduto(Id id) {
		if(produtoRepository.getProduto(id) != null)
			return produtoRepository.deleteProduto(id);
		return false;
	}
}

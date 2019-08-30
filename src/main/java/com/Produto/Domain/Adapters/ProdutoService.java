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
		if(produto != null)
			return produto;
		
		throw new ProdutoNotFoundException();
		
	}

	@Override
	public boolean addProduto(Produto produto) {
		try { 
			getProduto(produto.getId());
			return false;
		}
		catch (ProdutoNotFoundException e) {
			return produtoRepository.addProduto(produto);
		}
	}

	@Override
	public boolean updateProduto(Produto produto) {
		try { 
			getProduto(produto.getId());
			return produtoRepository.updateProduto(produto);
		}
		catch (ProdutoNotFoundException e) {
			return false;
		}
	}
	@Override
	public boolean deleteProduto(Id id) {
		try { 
			getProduto(id);
			return produtoRepository.deleteProduto(id);
		}
		catch (ProdutoNotFoundException e) {
			return false;
		}
	}
}

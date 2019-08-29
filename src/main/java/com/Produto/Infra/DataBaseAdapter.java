package com.Produto.Infra;

import com.Produto.Domain.Models.Produto;
import com.Produto.Domain.Ports.InterfaceProdutoRepository;
import com.Produto.Domain.ValueObjects.Id;

public class DataBaseAdapter implements InterfaceProdutoRepository {

	@Override
	public Produto getProduto(Id id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addProduto(Produto produto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateProduto(Produto produto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduto(Id id) {
		// TODO Auto-generated method stub
		return false;
	}
	
}

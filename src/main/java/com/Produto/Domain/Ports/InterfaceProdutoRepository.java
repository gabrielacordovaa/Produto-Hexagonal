package com.Produto.Domain.Ports;

import com.Produto.Domain.Models.Produto;
import com.Produto.Domain.ValueObjects.Id;

public interface InterfaceProdutoRepository {
		
		Produto getProduto(Id id );
		boolean addProduto(Produto produto);
		boolean updateProduto(Produto produto);
		boolean deleteProduto(Id id);
}

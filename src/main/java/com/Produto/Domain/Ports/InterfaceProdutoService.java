package com.Produto.Domain.Ports;

import com.Produto.Domain.Exceptions.ProdutoNotFoundException;
import com.Produto.Domain.Models.Produto;
import com.Produto.Domain.ValueObjects.Id;

public interface InterfaceProdutoService {

	Produto getProduto(Id id) throws ProdutoNotFoundException;
	boolean addProduto(Produto produto);
	boolean updateProduto(Produto produto);
	boolean deleteProduto(Id id);
	void deleteSend(String message);
	void getProdutoKafka(String message);
}

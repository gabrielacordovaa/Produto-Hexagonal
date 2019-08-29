package com.Produto.Application;

import org.springframework.beans.factory.annotation.Autowired;

import com.Produto.Domain.Ports.InterfaceProdutoService;

public class ProdutoController {
	
	@Autowired
	private InterfaceProdutoService produtoService;
}

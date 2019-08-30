package com.Produto.Application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Produto.Domain.Adapters.ProdutoService;
import com.Produto.Domain.Ports.InterfaceProdutoRepository;
import com.Produto.Domain.Ports.InterfaceProdutoService;
import com.Produto.Infra.DataBaseAdapter;

@Configuration
public class ProdutoApplicationConfiguration {
	 
	@Bean
	public InterfaceProdutoService produtoService() {
		return new ProdutoService();
	}
	
	@Bean
	public InterfaceProdutoRepository produtoRepository() {
		return new DataBaseAdapter();
	}
}

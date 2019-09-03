package com.Produto.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Produto.Domain.Exceptions.ProdutoNotFoundException;
import com.Produto.Domain.Models.Produto;
import com.Produto.Domain.Ports.InterfaceProdutoService;
import com.Produto.Domain.ValueObjects.Id;

@RestController
public class ProdutoController {
	
	@Autowired
	private InterfaceProdutoService produtoService;
	
	@GetMapping("produto/{id}")
	public String buscaProduto(@PathVariable("id") final String number) {
		Id id = new Id(Integer.parseInt(number));
		try {
			return produtoService.getProduto(id).toString();
		} catch (ProdutoNotFoundException e) {
			return null;
		}
		
	}
	
	@PostMapping("/produto")
	public boolean criarProduto(@RequestBody Produto produto) {
		return produtoService.addProduto(produto);
	}
	@PutMapping("/produto")
	public boolean atualizarProduto(@RequestBody Produto produto) {
		return produtoService.updateProduto(produto);
	}
	@DeleteMapping("produto/{id}")
	public void deletarProduto(@PathVariable("id") final String number) {
		produtoService.deleteSend(number);
	}
}

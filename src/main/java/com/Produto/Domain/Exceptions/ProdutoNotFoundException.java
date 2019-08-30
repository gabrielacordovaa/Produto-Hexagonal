package com.Produto.Domain.Exceptions;

public class ProdutoNotFoundException extends Exception {

	private static final long serialVersionUID = -4796848326739303497L;

	public ProdutoNotFoundException() {
		super("Produto nao encontrado");
	}
}

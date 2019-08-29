package com.Produto.Domain.ValueObjects;

public class Valor {

	private double valor;
	
	public Valor(double valor) {
		setValor(valor);
	}
	public boolean equals(Valor valor) {
		if(this.valor == valor.getValor()) {
			return true;
		}
		return false;
	}
	
	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		if(valor < 0.0)
			valor = 0.0;
		this.valor = valor;
	}
}

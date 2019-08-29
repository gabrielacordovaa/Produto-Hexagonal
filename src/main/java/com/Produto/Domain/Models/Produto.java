package com.Produto.Domain.Models;

import com.Produto.Domain.ValueObjects.Id;
import com.Produto.Domain.ValueObjects.Nome;
import com.Produto.Domain.ValueObjects.Valor;

public class Produto {
	
		private Nome nome;
		private Id id;
		private Valor valor;
		
		@Override
		public boolean equals(Object o) {
			Produto produto = (Produto) o;
			if(produto.nome.equals(this.nome) &&
			   produto.id.equals(this.id)     &&
			   produto.valor.equals(this.valor)) {
				return true;
			}
			return false;
		}
		
		public Nome getNome() {
			return this.nome;
		}
		
		public void setNome(Nome nome) {
			this.nome = nome;
		}
		
		public Id getId() {
			return this.id;
		}
		public void setId(Id id) {
			this.id = id;
		}
		public Valor getValor() {
			return this.valor;
		}
		public void setValor(Valor valor) {
			this.valor = valor;
		}
				
}

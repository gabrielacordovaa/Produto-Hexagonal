package com.Produto.Domain.ValueObjects;

public class Nome {
		
		private String nome;
		
		public Nome(String nome) {
			setNome(nome);
		}

		public String getNome() {
			return nome;
		}

		private void setNome(String nome) {
			this.nome = nome;
		}
		
		public boolean equals(Nome nome) {
			if(nome.getNome() == this.nome)
				return true;
			return false;
		}
}

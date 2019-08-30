package com.Produto.Infra;

import com.Produto.Domain.Models.Produto;
import com.Produto.Domain.Ports.InterfaceProdutoRepository;
import com.Produto.Domain.ValueObjects.Id;
import com.Produto.Domain.ValueObjects.Nome;
import com.Produto.Domain.ValueObjects.Valor;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.querybuilder.Insert;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select.Where;

public class DataBaseAdapter implements InterfaceProdutoRepository {

	ConnectDataBase dataBase = new ConnectDataBase();
	
	@Override
	public Produto getProduto(Id id) {
		dataBase.connect("127.0.0.1");
		Where select = QueryBuilder.select().from("storagecontrol","produtos").where(QueryBuilder.eq("id", id.getId()));
		ResultSet result = dataBase.session.execute(select);
		Row row = result.one();
		Produto produto = null;
		dataBase.close();
		if(row != null) {
			Nome nome = new Nome(row.getString("nome"));
			Valor valor = new Valor(row.getFloat("valor"));
			id = new Id(row.getInt("id"));
			produto = new Produto(nome, id, valor);
			return produto;
		}
		return null;
	}

	@Override
	public boolean addProduto(Produto produto) {
		dataBase.connect("127.0.0.1");
		try {
			Insert insert = QueryBuilder.insertInto("StorageControl","produtos")
					.value("id", produto.getId().getId())
					.value("nome", produto.getNome().getNome())
					.value("valor", produto.getValor().getValor());
			dataBase.session.execute(insert);
			dataBase.close();
			return true;
			} catch (Exception e) {
				dataBase.close();
				return false;
			}
	}

	@Override
	public boolean updateProduto(Produto produto) {
		dataBase.connect("127.0.0.1");
		try{
			dataBase.session.execute("UPDATE StorageControl.produtos SET nome = \'" + produto.getNome().getNome() + "\', valor = " + produto.getValor().getValor() + " WHERE id = " + produto.getId().getId() + ";");
			dataBase.close();
			return true;
		} catch(Exception e) {
			dataBase.close();
			return false;
		}
	}

	@Override
	public boolean deleteProduto(Id id) {
		dataBase.connect("127.0.0.1");
		try {
			com.datastax.driver.core.querybuilder.Delete.Where delete = QueryBuilder.delete().from("StorageControl", "produtos").where(QueryBuilder.eq("id", id.getId()));
			dataBase.session.execute(delete);
			dataBase.close();
			return true;
		} catch(Exception e) {
			dataBase.close();
			return false;
		}
	}
	
}

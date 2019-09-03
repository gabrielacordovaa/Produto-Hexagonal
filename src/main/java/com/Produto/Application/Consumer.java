package com.Produto.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.Produto.Domain.Ports.InterfaceProdutoService;
import com.Produto.Domain.ValueObjects.Id;

@Component
public class Consumer {
	
	@Autowired
	private InterfaceProdutoService produtoService;
	
	@KafkaListener(topics = "Insert_Request", groupId = "group_id")
	public void Insert(String message) {
		produtoService.getProdutoKafka(message);
	}
	
	@KafkaListener(topics = "Delete_Response", groupId = "group_id")
	public void Delete(String message) {
		if(message.contains("-0")) {
			message = message.substring(0, message.length()-2);
			Id id = new Id(Integer.parseInt(message));
			produtoService.deleteProduto(id);
		}
	}
}

package com.Produto.Infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

import com.Produto.Domain.Ports.InterfaceProducer;

public class Producer implements InterfaceProducer{
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Override
	public void Insert(String message) {
		kafkaTemplate.send("Insert_Response", message);
	}

	@Override
	public void Delete(String message) {
		kafkaTemplate.send("Delete_Request", message);
	}

}

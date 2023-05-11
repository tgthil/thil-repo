package com.thil.kafka.consumer.controller;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {
	
	@KafkaListener(topics = "topic-demo", groupId = "consumer-group")
	public void consumer(String message) {
		System.out.println("Message Consumed: "+message);
		
	}

}

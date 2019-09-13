package com.metallica.rabbitmq;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.exchange-name}")
    private String exchange;

    @Value("${rabbitmq.routing-key}")
    private String routingKey;

    public void produceMsg(Object msg){
        log.info("Sending message to the queue using routingKey {}. Message= {}", routingKey, msg.toString());
        amqpTemplate.convertAndSend(exchange, routingKey, msg);
        log.info("The message has been sent to the queue.");
    }
}

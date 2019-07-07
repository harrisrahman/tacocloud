package org.study.pcfdevcert.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.study.pcfdevcert.OrderMessagingService;
import org.study.pcfdevcert.domain.Order;

@Service
public class OrderMessageProducerServiceImpl implements OrderMessagingService {

    private KafkaTemplate<String,Order> kafkaTemplate;

    @Autowired
    public OrderMessageProducerServiceImpl(KafkaTemplate<String,Order> kafkaTemplate){

        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendOrder(Order order) {

        kafkaTemplate.send("tacocloud.orders.topic",order);
    }
}

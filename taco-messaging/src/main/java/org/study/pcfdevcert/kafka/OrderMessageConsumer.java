package org.study.pcfdevcert.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.study.pcfdevcert.domain.Order;

@Component
public class OrderMessageConsumer {


    Logger log = LogManager.getLogger(OrderMessageConsumer.class);

    @KafkaListener(topics = {"tacocloud.orders.topic"},groupId = "tacoclient")
    public void kafkaConsumer(Order order, ConsumerRecord<String,Order> consumerRecord){
        log.info("***** Message Received ****");
        log.info(consumerRecord.timestamp() + "<< === >>" + consumerRecord.key());
        log.info(order.toString());
    }
}

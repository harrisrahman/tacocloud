package org.study.pcfdevcert.jms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.stereotype.Component;
import org.study.pcfdevcert.domain.Order;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.HashMap;
import java.util.Map;

@Component
public class OrderMessageReceive {

    private JmsTemplate jmsTemplate;

    private MappingJackson2MessageConverter messageConverter;

    @Autowired
    public OrderMessageReceive(MappingJackson2MessageConverter converter){
        this.messageConverter = converter;
    }


//    @JmsListener(destination = "tacocloud.order.queue")
    public void listenForOrderMesages(Order order) throws JMSException {

    }

    public Order receiveOrder() throws JMSException {
        Message message = jmsTemplate.receive("tacocloud.order.queue");
        Order order;
//        Order order = (Order) messageConverter.fromMessage(message);
        order = (Order) jmsTemplate.receiveAndConvert("tacocloud.order.queue");
        return  order;
    }
}

package org.study.pcfdevcert.jms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;
import org.study.pcfdevcert.OrderMessagingService;
import org.study.pcfdevcert.domain.Order;

import javax.jms.JMSException;
import javax.jms.Message;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderMessagingSend implements OrderMessagingService {

    private JmsTemplate jmsTemplate;


    @Autowired
    public OrderMessagingSend(JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendOrder(Order order) {
//        jmsTemplate.send(new MessageCreator() {
//            @Override
//            public Message createMessage(Session session) throws JMSException {
//                return session.createObjectMessage(order);
//            }
//        });

        jmsTemplate.send("tacocloud.order.queue",session -> session.createObjectMessage(order));

        jmsTemplate.convertAndSend("tacocloud.order.queue", order,
                message -> {message.setStringProperty("X_ORDER_SOURCE","WEB");
                            return message;});

        jmsTemplate.convertAndSend("tacocloud.order.queue",order,this::postProcessMessage);


//        jmsTemplate.convertAndSend("tacocloud.order.queue", order, new MessagePostProcessor() {
//            @Override
//            public Message postProcessMessage(Message message) throws JMSException {
//                return null;
//            }
//        });
    }

    public Message postProcessMessage(Message message) throws JMSException {
        message.setStringProperty("X_ORDER_SOURCE","WEB");
        return message;
    }

}

package org.study.pcfdevcert.jms;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.study.pcfdevcert.domain.Order;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MessagingConfig {

        @Bean
//    @Qualifier(value = "ReceivesideConverter")
    public MappingJackson2MessageConverter orderMessageConverter(){
        MappingJackson2MessageConverter messageConverter = new MappingJackson2MessageConverter();
        messageConverter.setTypeIdPropertyName("_typeID");
        Map<String,Class<?>> typeIdMapping = new HashMap<>();
        typeIdMapping.put("order", Order.class);
        messageConverter.setTypeIdMappings(typeIdMapping);
        return messageConverter;
    }

}

package io.huashili.consumer;

import io.huashili.StatisticsConfiguration;
import io.huashili.dto.LogClick;
import io.huashili.service.LogClickService;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConnectionFactory;

@Service
public class LogClickConsumer {
    public static final String CONNECTION_FACTORY = "";

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private LogClickService logClickService;

    @Bean
    public JmsListenerContainerFactory queueListener() {
        DefaultJmsListenerContainerFactory listenerContainerFactory = new DefaultJmsListenerContainerFactory();
        listenerContainerFactory.setPubSubDomain(false);
        listenerContainerFactory.setConnectionFactory(connectionFactory);
        return listenerContainerFactory;
    }

    @JmsListener(destination = StatisticsConfiguration.QUEUE_LOG_CLICK, containerFactory = "queueListener")
    public void logClickListener(@Payload LogClick logClick) {
        System.out.println("receive a message");
        logClickService.log(logClick);
    }
}

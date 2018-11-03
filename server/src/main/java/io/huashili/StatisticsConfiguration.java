package io.huashili;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import java.util.Arrays;

@Configuration
@EnableJms
public class StatisticsConfiguration {
    public static final String QUEUE_LOG_CLICK = "io.huashili.logclick";

    public static final String CONNECTION_URL = "tcp://localhost:61616";

    @Bean
    public ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(CONNECTION_URL);
        connectionFactory.setTrustedPackages(Arrays.asList("io.huashili.dto"));
        return connectionFactory;
    }

    @Bean
    public Queue logClickQueue() {
        return new ActiveMQQueue(QUEUE_LOG_CLICK);
    }
}

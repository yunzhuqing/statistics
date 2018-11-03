package io.huashili.consumer;

import io.huashili.StatisticsConfig;
import io.huashili.dto.LogClick;
import io.huashili.service.LogClickService;
import io.huashili.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;

@Service
public class LogClickConsumer {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private LogClickService logClickService;

    @Resource
    private RedisUtil redisUtil;

    @Bean
    public JmsListenerContainerFactory queueListener() {
        DefaultJmsListenerContainerFactory listenerContainerFactory = new DefaultJmsListenerContainerFactory();
        listenerContainerFactory.setPubSubDomain(false);
        listenerContainerFactory.setConnectionFactory(connectionFactory);
        return listenerContainerFactory;
    }

    @JmsListener(destination = StatisticsConfig.QUEUE_LOG_CLICK, containerFactory = "queueListener")
    public void logClickListener(@Payload LogClick logClick) {
        String key = "";
        if(!StringUtils.isEmpty(logClick.getTopic())) {
            key += logClick.getTopic();
        } else if(StringUtils.isEmpty(logClick.getGroup())) {
            key += "-" + logClick.getGroup();
        } else if(StringUtils.isEmpty(logClick.getComponent())) {
            key += "-" + logClick.getComponent();
        }

        if(!StringUtils.isEmpty(key)) {
            redisUtil.incr(key, 1);
        }
        logClickService.log(logClick);
    }
}

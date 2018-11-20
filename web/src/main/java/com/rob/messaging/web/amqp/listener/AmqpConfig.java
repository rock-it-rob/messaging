package com.rob.messaging.web.amqp.listener;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AmqpConfig configures the beans for messaging.
 *
 * @author Rob Benton
 */
@Configuration
public class AmqpConfig
{
    @Value("${rabbitmq.host}")
    private String rabbitHost;

    @Value("${rabbitmq.port}")
    private int rabbitPort;

    @Value("${exchange}")
    private String exchangeName;

    /**
     * Creates a {@link RabbitListenerContainerFactory} that uses a separate
     * {@link ConnectionFactory} from the one used for publishers.
     *
     * @return {@link RabbitListenerContainerFactory}
     */
    @Bean
    public RabbitListenerContainerFactory<SimpleMessageListenerContainer> simpleRabbitListenerContainerFactory()
    {
        SimpleRabbitListenerContainerFactory containerFactory = new SimpleRabbitListenerContainerFactory();
        containerFactory.setConnectionFactory(new CachingConnectionFactory(rabbitHost, rabbitPort));
        return containerFactory;
    }
}

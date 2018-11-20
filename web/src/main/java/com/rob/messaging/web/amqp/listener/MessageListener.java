package com.rob.messaging.web.amqp.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * MessageListener listens for AMQP messages.
 *
 * @author Rob Benton
 */
@Component
public class MessageListener
{
    private static final Logger log = LoggerFactory.getLogger(MessageListener.class);

    /**
     * Simple message listener.
     *
     * @param message Message
     * @throws IOException for data reading errors.
     */
    @RabbitListener(
        bindings = @QueueBinding(
            exchange = @Exchange("${exchange}"),
            value = @Queue("${queue}")
        )
    )
    public void readMessage(Message message) throws IOException
    {
        log.debug("Processing message");
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(message.getBody());
        log.info("Message received: " + baos.toString());
    }
}

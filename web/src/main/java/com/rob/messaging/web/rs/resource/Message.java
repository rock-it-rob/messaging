package com.rob.messaging.web.rs.resource;

import com.rob.messaging.web.rs.request.MessageRequest;
import com.rob.messaging.web.rs.response.SimpleResponse;
import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Message is a resource for sending messages to the configured message broker.
 * It supports a POST operation for sending a message.
 *
 * @author Rob Benton
 */
@Component
@Path(Message.PATH)
public class Message
{
    private static final Logger log = LoggerFactory.getLogger(Message.class);

    public static final String PATH = "message";

    @Value("${spring.rabbitmq.template.exchange}")
    private String exchangeName;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @PostConstruct
    private void postConstruct()
    {
        amqpAdmin.declareExchange(new DirectExchange(exchangeName));
    }

    /**
     * Sends a message to the configured message broker.
     *
     * @param messageRequest required message content
     * @return SimpleResponse containing an HTTP status code of whether the
     * operation was successful.
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public SimpleResponse sendMessage(final @NotNull(message = "message cannot be null") MessageRequest messageRequest)
    {
        amqpTemplate.send(
            MessageBuilder
                .withBody(messageRequest.getBody().getBytes())
                .build()
        );

        return () -> HttpStatus.OK_200;
    }
}

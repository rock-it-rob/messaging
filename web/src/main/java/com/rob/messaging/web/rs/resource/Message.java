package com.rob.messaging.web.rs.resource;

import com.rob.messaging.web.rs.request.MessageRequest;
import com.rob.messaging.web.rs.response.SimpleResponse;
import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
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

    @Value("${exchange}")
    private String exchangeName;

    @Value("${queue}")
    private String queueName;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * Initializes resources prior to use.
     *
     * <h1>RabbitMQ Exchange</h1>
     * Since this class sends messages to a RabbitMQ exchange, that exchange
     * is declared here.
     */
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
        // The direct exchange declared earlier in this class is bound to a
        // queue. Sending a message to that exchange without a routing key will
        // deliver it to the intended queue.
        amqpTemplate.send(
            exchangeName,
            null,
            MessageBuilder
                .withBody(messageRequest.getBody().getBytes())
                .build()
        );
        // The default exchange can be used with a routing key of the name of
        // the queue as well.
        amqpTemplate.send(
            null,
            queueName,
            MessageBuilder
                .withBody("Sending via default exchange".getBytes())
                .build()
        );

        return () -> HttpStatus.OK_200;
    }
}

package com.rob.messaging.web.rs.mapper;

import com.rob.messaging.web.rs.response.AmqpErrorResponse;
import org.eclipse.jetty.http.HttpStatus;
import org.springframework.amqp.AmqpException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * AmqpExceptionMapper catches {@link org.springframework.amqp.AmqpException}s
 * and translates them into a JAX-RS response.
 *
 * @author Rob Benton
 */
public final class AmqpExceptionMapper implements ExceptionMapper<AmqpException>
{
    @Override
    public Response toResponse(AmqpException exception)
    {
        final String reason = exception.getMessage();

        return Response
            .serverError()
            .entity(
                new AmqpErrorResponse()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR_500)
                    .entity(reason)
            )
            .build();
    }
}

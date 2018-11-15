package com.rob.messaging.web.rs.mapper;

import com.rob.messaging.web.rs.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 * WebApplicationExceptionMapper handles any {@link javax.ws.rs.WebApplicationException}
 * arising from a call to a Jersey JAX-RS resource endpoint.
 *
 * @author Rob Benton
 */
public final class WebApplicationExceptionMapper implements ExceptionMapper<WebApplicationException>
{
    private static final Logger log = LoggerFactory.getLogger(WebApplicationExceptionMapper.class);

    @Override
    public Response toResponse(WebApplicationException exception)
    {
        final int status = exception.getResponse().getStatus();
        final String message = exception.getMessage();

        return Response
            .status(status)
            .entity(new ErrorResponse().status(status).entity(message))
            .type(MediaType.APPLICATION_JSON)
            .build();
    }
}

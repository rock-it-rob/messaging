package com.rob.messaging.web.rs.mapper;

import com.rob.messaging.web.rs.response.ValidationErrorResponse;
import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.util.ArrayList;

/**
 * ConstraintViolationExceptionMapper translates validation errors into a
 * response.
 *
 * @author Rob Benton
 */
public final class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException>
{
    private static final Logger log = LoggerFactory.getLogger(ConstraintViolationExceptionMapper.class);

    @Override
    public Response toResponse(ConstraintViolationException exception)
    {
        ArrayList<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> v : exception.getConstraintViolations())
        {
            errors.add(v.getMessage());
        }

        return Response
            .status(HttpStatus.BAD_REQUEST_400)
            .type(MediaType.APPLICATION_JSON)
            .entity(
                new ValidationErrorResponse()
                    .status(HttpStatus.BAD_REQUEST_400)
                    .entity(errors)
            )
            .build();
    }
}

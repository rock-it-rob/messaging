package com.rob.messaging.web.rs;

import com.rob.messaging.web.rs.mapper.ConstraintViolationExceptionMapper;
import com.rob.messaging.web.rs.mapper.WebApplicationExceptionMapper;
import com.rob.messaging.web.rs.resource.Health;
import com.rob.messaging.web.rs.resource.Message;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

/**
 * JerseyResourceConfig is the main configuration class for registering
 * Jersey functionality.
 *
 * @author Rob Benton
 */
@Component
@ApplicationPath(JerseyResourceConfig.PATH)
public class JerseyResourceConfig extends ResourceConfig
{
    public static final String PATH = "rs";

    public JerseyResourceConfig()
    {
        // Resource classes
        register(Health.class);
        register(Message.class);

        // Exception mappers
        register(WebApplicationExceptionMapper.class);
        register(ConstraintViolationExceptionMapper.class);
    }
}

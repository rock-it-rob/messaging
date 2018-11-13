package com.rob.messaging.web.rs.resource;

import com.rob.messaging.web.rs.response.HealthResponse;
import com.rob.messaging.web.rs.response.entity.HealthEntity;
import org.springframework.http.HttpStatus;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Health shows the status of the application.
 *
 * @author Rob Benton
 */
@Path(Health.PATH)
public class Health
{
    public static final String PATH = "health";

    /**
     * Get method returns the current health status of the application.
     *
     * @return HealthResponse
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public HealthResponse get()
    {
        return new HealthResponse()
            .status(HttpStatus.OK.value())
            .entity(new HealthEntity(true));
    }
}

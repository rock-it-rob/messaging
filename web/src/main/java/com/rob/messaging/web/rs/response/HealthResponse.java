package com.rob.messaging.web.rs.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rob.messaging.web.rs.response.entity.HealthEntity;

/**
 * HealthResponse is a POJO for return from {@link com.rob.messaging.web.rs.resource.Health}
 * JAX-RS resource endpoints.
 *
 * @author Rob Benton
 */
public final class HealthResponse extends AbstractEntityResponse<HealthEntity>
{
    private static final String ENTITY_PROPERTY_NAME = "health";

    @Override
    @JsonProperty(ENTITY_PROPERTY_NAME)
    public HealthEntity getEntity()
    {
        return entity;
    }

    @Override
    public HealthResponse entity(HealthEntity entity)
    {
        this.entity = entity;
        return this;
    }

    @Override
    public HealthResponse status(int status)
    {
        this.status = status;
        return this;
    }
}

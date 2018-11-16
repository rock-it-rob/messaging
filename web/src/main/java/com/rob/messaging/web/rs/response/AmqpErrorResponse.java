package com.rob.messaging.web.rs.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * AmqpErrorResponse is used to translate errors encountered during an AMQP
 * operation into an HTTP error response entity.
 *
 * @author Rob Benton
 */
public final class AmqpErrorResponse extends AbstractEntityResponse<String>
{
    private static final String ENTITY_PROPERTY_NAME = "amqpError";

    @Override
    @JsonProperty(ENTITY_PROPERTY_NAME)
    public String getEntity()
    {
        return entity;
    }

    @Override
    public AmqpErrorResponse entity(String entity)
    {
        setEntity(entity);
        return this;
    }

    @Override
    public AmqpErrorResponse status(int status)
    {
        setStatus(status);
        return this;
    }
}

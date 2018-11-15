package com.rob.messaging.web.rs.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * ErrorResponse is the entity embedded in responses for errors.
 *
 * @author Rob Benton
 */
public final class ErrorResponse extends AbstractEntityResponse<String>
{
    private static final String ENTITY_PROPERTY_NAME = "error";

    @Override
    @JsonProperty(ENTITY_PROPERTY_NAME)
    public String getEntity()
    {
        return entity;
    }

    @Override
    public ErrorResponse entity(String entity)
    {
        setEntity(entity);
        return this;
    }

    @Override
    public ErrorResponse status(int status)
    {
        return this;
    }
}

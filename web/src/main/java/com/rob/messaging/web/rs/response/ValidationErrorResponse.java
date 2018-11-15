package com.rob.messaging.web.rs.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.*;

/**
 * ValidationErrorResponse is a response that includes an entity containing
 * errors from one or more {@link javax.validation.ConstraintViolation}s.
 *
 * @author Rob Benton
 */
public class ValidationErrorResponse extends AbstractEntityResponse<List<String>>
{
    @Override
    public void setEntity(List<String> entity)
    {
        this.entity = new ArrayList<>(entity);
    }

    @Override
    @JsonProperty("constraintViolations")
    public List<String> getEntity()
    {
        return entity;
    }

    @Override
    public ValidationErrorResponse entity(List<String> entity)
    {
        setEntity(entity);
        return this;
    }

    @Override
    public ValidationErrorResponse status(int status)
    {
        setStatus(status);
        return this;
    }
}

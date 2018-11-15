package com.rob.messaging.web.rs.response;

import java.util.Date;

/**
 * AbstractResponse creates a contract so that all JAX-RS response include a
 * minimum set of fields.
 *
 * @author Rob Benton
 */
public abstract class AbstractResponse implements SimpleResponse
{
    int status;
    Date generated;

    public AbstractResponse()
    {
        this.generated = new Date();
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    @Override
    public int getStatus()
    {
        return status;
    }

    public void setGenerated(Date generated)
    {
        this.generated = generated;
    }

    @Override
    public Date getGenerated()
    {
        return generated;
    }

    /**
     * Sets the status property and returns this instance.
     *
     * @param status http status code
     * @return this
     */
    public abstract AbstractResponse status(int status);
}

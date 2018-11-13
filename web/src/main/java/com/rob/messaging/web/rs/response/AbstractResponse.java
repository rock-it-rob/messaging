package com.rob.messaging.web.rs.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.TimeZone;

/**
 * AbstractResponse creates a contract so that all JAX-RS response include a
 * minimum set of fields.
 *
 * @author Rob Benton
 */
public abstract class AbstractResponse
{
    private static final String TIMEZONE = "CST";

    int status;
    Date generated;

    AbstractResponse()
    {
        this.generated = new Date();
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public int getStatus()
    {
        return status;
    }

    public void setGenerated(Date generated)
    {
        this.generated = generated;
    }

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss zzz", timezone = TIMEZONE)
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

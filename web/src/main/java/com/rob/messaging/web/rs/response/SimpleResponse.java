package com.rob.messaging.web.rs.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * SimpleResponse defines the base properties that are present on every
 * response from a JAX-RS resource.
 *
 * @author Rob Benton
 */
@FunctionalInterface
public interface SimpleResponse
{
    /**
     * Default timezone.
     */
    String TIMEZONE = "CST";

    /**
     * Default date format.
     */
    String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss zzz";

    /**
     * The HTTP status code.
     *
     * @return int corresponding to an HTTP status code.
     */
    int getStatus();

    /**
     * The time this response was generated. Set in the default timezone of
     * {@link #TIMEZONE}.
     * <p>
     * By default the current date and time is returned. This default is
     * provided to enable lambdas to work. Implementing classes should provide a
     * concrete implementation of this function so the date is not a moving
     * target.
     *
     * @return Date this response was created.
     */
    @JsonFormat(pattern = DATE_FORMAT, timezone = TIMEZONE)
    default Date getGenerated()
    {
        return new Date();
    }
}

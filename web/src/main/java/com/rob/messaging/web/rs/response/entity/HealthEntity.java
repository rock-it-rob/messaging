package com.rob.messaging.web.rs.response.entity;

/**
 * HealthEntity contains the properties of the health of the application.
 *
 * @author Rob Benton
 */
public class HealthEntity
{
    private Boolean up;

    public HealthEntity()
    {
    }

    public HealthEntity(boolean up)
    {
        this.up = up;
    }

    public Boolean isUp()
    {
        return up;
    }

    public void setUp(boolean up)
    {
        this.up = up;
    }
}

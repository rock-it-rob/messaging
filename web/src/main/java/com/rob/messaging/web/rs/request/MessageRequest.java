package com.rob.messaging.web.rs.request;

import com.rob.messaging.web.rs.resource.Message;

import javax.validation.constraints.NotEmpty;

/**
 * MessageRequest is a POJO for passing information through {@link Message}
 * resource endpoints.
 *
 * @author Rob Benton
 */
public final class MessageRequest
{
    @NotEmpty(message = "Message body is required")
    private String body;

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }
}

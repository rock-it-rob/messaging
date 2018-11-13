package com.rob.messaging.web.rs.response;

/**
 * AbstractEntityResponse is the base response object that contains an entity
 * object.
 *
 * @param <T> the object type contained in this response. The object should be
 *            one that can be converted to JSON.
 * @author Rob Benton
 */
public abstract class AbstractEntityResponse<T> extends AbstractResponse
{
    T entity;

    public void setEntity(T entity)
    {
        this.entity = entity;
    }

    /**
     * Gets the entity contained in the response.
     * <p>
     * Subclasses should override this method and also annotate it with
     * {@link com.fasterxml.jackson.annotation.JsonProperty} to give the
     * entity an appropriate property name for de/serialization.
     *
     * @return T
     */
    public abstract T getEntity();

    /**
     * Sets the entity property and returns this instance in a fluent manner.
     *
     * @param entity T
     * @return this
     */
    public abstract AbstractEntityResponse<T> entity(T entity);
}

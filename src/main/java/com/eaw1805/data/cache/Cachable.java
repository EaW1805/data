package com.eaw1805.data.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The generic cache interface.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Cachable {

    /**
     * The name of the cache to use.
     *
     * @return the name of the cache.
     */
    String cacheName();

}

package com.eaw1805.data.cache;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The ClientCachable interface.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ClientCachable {

    /**
     * The name of the cache to evict.
     *
     * @return the name of the cache.
     */
    String cacheName() default "";

    /**
     * The index of the argument containing the game ID.
     *
     * @return the index of the argument.
     */
    int gameId() default 0;

    /**
     * The index of the argument containing the nation ID.
     *
     * @return the index of the argument.
     */
    int nationId() default 0;

}

package com.eaw1805.data.managers.beans;

import org.hibernate.SessionFactory;

/**
 * Defines interface for all entity beans that persist in the database.
 */
public interface EntityBean {

    /**
     * a SessionFactory bean is injected by Spring.
     *
     * @param factory sessionFactory bean.
     */
    void setSessionFactory(final SessionFactory factory);

}

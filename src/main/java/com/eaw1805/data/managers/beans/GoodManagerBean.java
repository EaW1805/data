package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.economy.Good;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface GoodManagerBean extends EntityBean {

    /**
     * get the Good from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Good getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Good tha we want to add.
     */
    void add(final Good value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Good tha we want to update.
     */
    void update(final Good value);

    /**
     * Delete the input Good from the database.
     *
     * @param entity the Good tha we want to delete
     */
    void delete(Good entity);

    /**
     * Listing all the Goods from the database.
     *
     * @return a list of all the Goods that exist inside the table Avatar.
     */
    List<Good> list();

}

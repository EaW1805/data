package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.battles.field.Order;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface OrderManagerBean
        extends EntityBean {

    /**
     * get the Order from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Order getByID(final int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Order tha we want to add.
     */
    void add(final Order value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Order that we want to update.
     */
    void update(final Order value);

    /**
     * Delete the input Order from the database.
     *
     * @param value the Order tha we want to delete.
     */
    void delete(final Order value);

    /**
     * Listing all the Orders from the database.
     *
     * @return a list of all the Corps that exist inside the table.
     */
    List<Order> list();


}

package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.fleet.ShipType;

import java.util.List;

/**
 * The interface of the ShipTypeManager.
 */
public interface ShipTypeManagerBean extends EntityBean {

    /**
     * get the ShipType from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    ShipType getByID(final int entityID);

    /**
     * get the ShipType from the database that corresponds to the input type.
     *
     * @param entityType the type of the Entity object.
     * @return an Entity object.
     */
    ShipType getByType(final int entityType);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the ShipType tha we want to add.
     */
    void add(final ShipType value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the ShipType tha we want to update.
     */
    void update(final ShipType value);

    /**
     * Delete the input entity from the database.
     *
     * @param entity the entity that we want to delete.
     */
    void delete(final ShipType entity);

    /**
     * Listing all the ShipTypes from the database.
     *
     * @return a list of all the ShipTypes that exist inside the table Avatar.
     */
    List<ShipType> list();

}

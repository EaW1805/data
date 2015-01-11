package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.battles.field.FieldBattleSector;

import java.util.List;

/**
 * The interface of the FieldBattleSectorManagerBean.
 */
public interface FieldBattleSectorManagerBean extends EntityBean {

    /**
     * get the FieldBattleSector from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    FieldBattleSector getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the FieldBattleSector that we want to add.
     */
    void add(final FieldBattleSector value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Sector that we want to update.
     */
    void update(final FieldBattleSector value);

    /**
     * Delete the input Sector from the database.
     *
     * @param entity the FieldBattleSector that we want to delete
     */
    void delete(FieldBattleSector entity);

    /**
     * Listing all the Sectors from the database.
     *
     * @return a list of all the Sectors that exist inside the table Avatar.
     */
    List<FieldBattleSector> list();

}

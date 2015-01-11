package com.eaw1805.data.managers.beans;


import com.eaw1805.data.model.battles.field.FieldBattleTerrain;

import java.util.List;

/**
 * The interface of the FieldBattleTerrainManagerBean.
 * @author fragkakis
 */
public interface FieldBattleTerrainManagerBean extends EntityBean {

    /**
     * get the FieldBattleTerrain from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    FieldBattleTerrain getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the FieldBattleTerrain that we want to add.
     */
    void add(final FieldBattleTerrain value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the FieldBattleTerrain that we want to update.
     */
    void update(final FieldBattleTerrain value);

    /**
     * Delete the input FieldBattleTerrain from the database.
     *
     * @param entity the FieldBattleTerrain that we want to delete
     */
    void delete(FieldBattleTerrain entity);

    /**
     * Listing all the Terrains from the database.
     *
     * @return a list of all the FieldBattleTerrains that exist inside the table FieldBattleTerrain.
     */
    List<FieldBattleTerrain> list();

}

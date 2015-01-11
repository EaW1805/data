package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.battles.field.FieldBattleMap;

import java.util.List;

/**
 * The interface of the FieldBattleMapManagerBean.
 */
public interface FieldBattleMapManagerBean extends EntityBean {

    /**
     * get the FieldBattleMap from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    FieldBattleMap getByID(int entityID);
    
    /**
     * get the FieldBattleMap from the battle id of the battle it belongs to.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    FieldBattleMap getByBattleID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the FieldBattleMap that we want to add.
     */
    void add(final FieldBattleMap value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the field battle map that we want to update.
     */
    void update(final FieldBattleMap value);

    /**
     * Delete the input field battle map from the database.
     *
     * @param entity the FieldBattleMap that we want to delete
     */
    void delete(FieldBattleMap entity);

    /**
     * Listing all the field battle maps from the database.
     *
     * @return a list of all the field battle maps that exist inside the table.
     */
    List<FieldBattleMap> list();

}

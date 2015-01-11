package com.eaw1805.data.managers.beans;


import com.eaw1805.data.model.battles.field.FieldBattleMapExtraFeature;

import java.util.List;

/**
 * The interface of the FieldBattleMapExtraFeatureManagerBean.
 * @author fragkakis
 */
public interface FieldBattleMapExtraFeatureManagerBean extends EntityBean {

    /**
     * get the FieldBattleMapExtraFeature from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    FieldBattleMapExtraFeature getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the FieldBattleMapExtraFeature that we want to add.
     */
    void add(final FieldBattleMapExtraFeature value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the FieldBattleMapExtraFeature that we want to update.
     */
    void update(final FieldBattleMapExtraFeature value);

    /**
     * Delete the input FieldBattleMapExtraFeature from the database.
     *
     * @param entity the FieldBattleMapExtraFeature that we want to delete
     */
    void delete(FieldBattleMapExtraFeature entity);

    /**
     * Listing all the Terrains from the database.
     *
     * @return a list of all the FieldBattleTerrains that exist inside the table FieldBattleMapExtraFeature.
     */
    List<FieldBattleMapExtraFeature> list();

}

package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.map.Region;

import java.util.List;

/**
 * The interface of the RegionManagerBean.
 */
public interface RegionManagerBean extends EntityBean {

    /**
     * get the Region from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Region getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Region tha we want to add.
     */
    void add(final Region value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Region tha we want to update.
     */
    void update(final Region value);

    /**
     * Delete the input Region from the database.
     *
     * @param entity the Region tha we want to delete
     */
    void delete(Region entity);

    /**
     * Listing all the Regions from the database.
     *
     * @return a list of all the Regions that exist inside the table Avatar.
     */
    List<Region> list();

    /**
     * Listing all the Regions from the database for a game.
     *
     * @return a list of all the Regions that exist inside the table Avatar.
     */
    List<Region> list(final Game game);

    /**
     * This methods has all the deletion queries needed all
     * region associations created by the scenario editor.
     *
     * @param regionId The  region id to delete
     */
    void deleteScenarioRegionAssoc(final int regionId);
}


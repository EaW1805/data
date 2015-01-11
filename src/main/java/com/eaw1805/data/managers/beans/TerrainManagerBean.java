package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.map.Terrain;

import java.util.List;

/**
 * The interface of the TerrainManagerBean.
 */
public interface TerrainManagerBean extends EntityBean {

    /**
     * get the Terrain from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Terrain getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Terrain tha we want to add.
     */
    void add(final Terrain value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Terrain tha we want to update.
     */
    void update(final Terrain value);

    /**
     * Delete the input Terrain from the database.
     *
     * @param entity the Terrain tha we want to delete
     */
    void delete(Terrain entity);

    /**
     * Listing all the Terrains from the database.
     *
     * @return a list of all the Terrains that exist inside the table Avatar.
     */
    List<Terrain> list();

    /**
     * Get all the terrain(s) from the database that corresponds to the input
     * terrain char-code.
     *
     * @param terrainCode the terrain char-code.
     * @return a list of all the terrain(s) matching the code.
     */
    Terrain getByCode(char terrainCode);
}

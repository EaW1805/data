package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.economy.Warehouse;
import com.eaw1805.data.model.map.Region;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface WarehouseManagerBean extends EntityBean {

    /**
     * get the Warehouse from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Warehouse getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Warehouse tha we want to add.
     */
    void add(final Warehouse value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Warehouse tha we want to update.
     */
    void update(final Warehouse value);

    /**
     * Delete the input Warehouse from the database.
     *
     * @param entity the Warehouse tha we want to delete
     */
    void delete(Warehouse entity);

    /**
     * Listing all the Warehouses from the database.
     *
     * @return a list of all the Warehouses that exist inside the table Avatar.
     */
    List<Warehouse> list();

    /**
     * Listing all the Warehouses from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Warehouses.
     */
    List<Warehouse> listByGame(final Game thisGame);

    /**
     * Listing all the Warehouses from the database for the specified game and nation.
     *
     * @param thisGame   the game to select.
     * @param thisNation the nation's warehouse.
     * @return a list of all the Warehouses.
     */
    List<Warehouse> listByGameNation(final Game thisGame,
                                     final Nation thisNation);

    /**
     * Get the warehouses from the database that belongs to the specified
     * nation for the given region.
     *
     * @param thisGame   the game to select.
     * @param thisNation the nation's warehouse.
     * @param thisRegion the warehouse region.
     * @return a list of the nation's warehouses.
     */
    Warehouse getByNationRegion(final Game thisGame,
                                final Nation thisNation,
                                final Region thisRegion);
}

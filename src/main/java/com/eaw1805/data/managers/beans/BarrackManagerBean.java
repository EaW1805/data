package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.map.Barrack;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Region;
import com.eaw1805.data.model.map.Sector;

import java.util.List;


/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface BarrackManagerBean extends EntityBean {

    /**
     * get the Barrack from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Barrack getByID(int entityID);

    /**
     * get the Barrack from the database that corresponds to the input position.
     *
     * @param position the Position of the Barrack object.
     * @return an Barrack object.
     */
    Barrack getByPosition(final Position position);

    /**
     * get the Barrack from the database that corresponds to the input position.
     *
     * @param sector the Sector of the Barrack object.
     * @return an Barrack object.
     */
    Barrack getBySector(final Sector sector);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Barrack tha we want to add.
     */
    void add(final Barrack value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Barrack tha we want to update.
     */
    void update(final Barrack value);

    /**
     * Delete the input Barrack from the database.
     *
     * @param entity the Barrack tha we want to delete
     */
    void delete(Barrack entity);

    /**
     * Listing all the Barracks from the database.
     *
     * @return a list of all the Barracks that exist inside the table Avatar.
     */
    List<Barrack> list();

    /**
     * Listing all the Barracks from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Barracks.
     */
    List<Barrack> listByGame(final Game thisGame);

    /**
     * Listing all the Barracks from the database for the specified game and nation.
     *
     * @param thisGame   the game to select.
     * @param thisNation the nation's Barrack.
     * @return a list of all the Barracks.
     */
    List<Barrack> listByGameNation(final Game thisGame,
                                   final Nation thisNation);

    /**
     * Get the Barracks from the database that belongs to the specified
     * nation for the given region.
     *
     * @param thisGame   the game to select.
     * @param thisNation the nation's Barrack.
     * @param thisRegion the Barrack region.
     * @return a list of the nation's Barracks.
     */
    Barrack getByNationRegion(final Game thisGame,
                              final Nation thisNation,
                              final Region thisRegion);
}
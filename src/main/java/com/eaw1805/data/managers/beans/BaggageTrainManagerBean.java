package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.economy.BaggageTrain;
import com.eaw1805.data.model.map.Position;

import java.util.List;

/**
 * Manages for CRUD operations for the entity objects.
 */
public interface BaggageTrainManagerBean extends EntityBean {

    /**
     * get the BaggageTrain from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    BaggageTrain getByID(final int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the BaggageTrain tha we want to add.
     */
    void add(final BaggageTrain value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the BaggageTrain tha we want to update.
     */
    void update(final BaggageTrain value);

    /**
     * Delete the input BaggageTrain from the database.
     *
     * @param value the BaggageTrain tha we want to delete.
     */
    void delete(final BaggageTrain value);

    /**
     * Listing all the Spies from the database.
     *
     * @return a list of all the Spies that exist inside the table.
     */
    List<BaggageTrain> list();

    /**
     * Listing all the Spies from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Spies.
     */
    List<BaggageTrain> listByGame(final Game thisGame);

    /**
     * Listing all the Spies from the database at the specific position.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Spies.
     */
    List<BaggageTrain> listGameNation(final Game thisGame, final Nation nation);

    /**
     * List all baggage trains positioned at a given sector.
     *
     * @param position the position to check.
     * @return the list of baggage trains.
     */
    List<BaggageTrain> listAllByPosition(final Position position);

    /**
     * Listing all the trains from the database at the specific position owned by the specific nation.
     *
     * @param thisPosition the position to select.
     * @param nation       the nation to select.
     * @return a list of all the trains.
     */
    List<BaggageTrain> listByPositionNation(final Position thisPosition, final Nation nation);

}

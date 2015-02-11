package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.EngineProcess;

import java.util.List;
import java.util.Map;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface EngineProcessManagerBean extends EntityBean {

    /**
     * get the EngineProcess from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    EngineProcess getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the EngineProcess tha we want to add.
     */
    void add(final EngineProcess value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the EngineProcess tha we want to update.
     */
    void update(final EngineProcess value);

    /**
     * Delete the input EngineProcess from the database.
     *
     * @param entity the EngineProcess tha we want to delete
     */
    void delete(EngineProcess entity);

    /**
     * Listing all the EngineProcess from the database.
     *
     * @return a list of all the EngineProcess that exist inside the table Avatar.
     */
    List<EngineProcess> list();

    /**
     * Listing all the processes for a particular Game from the database that are ready to be processed.
     *
     * @param gameId     the game ID to look up.
     * @param scenarioID the scenario ID to look up.
     * @return a list of processes related to the particular game.
     */
    List<EngineProcess> listGame(final int gameId, final int scenarioID);

    /**
     * Listing all the processes for a particular Game from the database that are ready to be processed
     * within the ongoing week.
     *
     * @param gameId     the game ID to look up.
     * @param scenarioID the scenario ID to look up.
     * @return a list of processes related to the particular game.
     */
    List<EngineProcess> listGameWeekly(final int gameId, final int scenarioID);

    /**
     * get the latest EngineProcess from the database that corresponds to the input id.
     *
     * @param gameId     the game ID to look up.
     * @param scenarioID the scenario ID to look up.
     * @return an Entity object.
     */
    EngineProcess getLatest(final int gameId, final int scenarioID);

    /**
     * Inserts an entry to the database with ID = -1.
     */
    void addNegativeProcID();

    /**
     * Update the entry of the database with ID = -1.
     */
    void updateNegativeProcID();

    /**
     * Count the number of processes per each week of the year.
     *
     * @return a mapping of engine processing count to years/weeks.
     */
    Map<Integer, Map<Integer, Long>> countByWeek();

    /**
     * Count the number of orders issued per each week of the year.
     *
     * @return a mapping of orders count to years/weeks.
     */
    Map<Integer, Map<Integer, Long>> countByWeek(final int scenarioId);
}

package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.battles.FieldBattleReport;
import com.eaw1805.data.model.map.Position;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface FieldBattleReportManagerBean extends EntityBean {

    /**
     * get the FieldBattleReport from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    FieldBattleReport getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the FieldBattleReport tha we want to add.
     */
    void add(final FieldBattleReport value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the FieldBattleReport tha we want to update.
     */
    void update(final FieldBattleReport value);

    /**
     * Delete the input FieldBattleReport from the database.
     *
     * @param entity the FieldBattleReport tha we want to delete
     */
    void delete(FieldBattleReport entity);

    /**
     * Listing all FieldBattleReport from the database.
     *
     * @return a list of all the FieldBattleReport that exist inside the table Avatar.
     */
    List<FieldBattleReport> list();

    /**
     * Listing all FieldBattleReport from the database.
     *
     * @return a list of all the FieldBattleReport that exist inside the table Avatar.
     */
    List<FieldBattleReport> listScenario();

    /**
     * Listing all FieldBattleReport from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @return a list of all the Armies.
     */
    List<FieldBattleReport> listGame(final Game thisGame);

    /**
     * Listing all FieldBattleReport from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Armies.
     */
    List<FieldBattleReport> listGameNation(final Game thisGame, final Nation nation);

    FieldBattleReport listPositionTurn(final Position position, final int turn);

    /**
     * Count the number of reports issued.
     *
     * @return report count.
     */
    Object countReportsPerGame(final int gameId);

    /**
     * Listing all FieldBattleReport from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @param turn     the turn
     * @return a list of all the Armies.
     */
    List<FieldBattleReport> listGameNationTurn(final Game thisGame, final Nation nation, final int turn);


}


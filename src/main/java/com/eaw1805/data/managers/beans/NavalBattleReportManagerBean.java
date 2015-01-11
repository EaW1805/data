package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.battles.NavalBattleReport;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface NavalBattleReportManagerBean extends EntityBean {

    /**
     * get the NavalBattleReport from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    NavalBattleReport getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the NavalBattleReport tha we want to add.
     */
    void add(final NavalBattleReport value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the NavalBattleReport tha we want to update.
     */
    void update(final NavalBattleReport value);

    /**
     * Delete the input NavalBattleReport from the database.
     *
     * @param entity the NavalBattleReport tha we want to delete
     */
    void delete(NavalBattleReport entity);

    /**
     * Listing all NavalBattleReport from the database.
     *
     * @return a list of all the NavalBattleReport that exist inside the table Avatar.
     */
    List<NavalBattleReport> list();

    /**
     * Listing all NavalBattleReport from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @return a list of all the Battles.
     */
    List<NavalBattleReport> listGame(final Game thisGame);

    /**
     * Listing all NavalBattleReport from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Battles.
     */
    List<NavalBattleReport> listGameNation(final Game thisGame, final Nation nation);

    /**
     * Listing all NavalBattleReport from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Armies.
     */
    List<NavalBattleReport> listGameNationTurn(final Game thisGame, final Nation nation, final int turn);

    /**
     * Count the number of reports issued.
     *
     * @return reports count.
     */
    Object countReportsPerGame(final int gameId);

}


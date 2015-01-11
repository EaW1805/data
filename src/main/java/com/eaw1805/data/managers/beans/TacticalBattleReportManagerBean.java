package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.battles.TacticalBattleReport;
import com.eaw1805.data.model.map.Position;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface TacticalBattleReportManagerBean extends EntityBean {

    /**
     * get the TacticalBattleReport from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    TacticalBattleReport getByID(int entityID);

    /**
     * get the TacticalBattleReport from the database that corresponds to the input id.
     *
     * @param position the Position of the battle.
     * @param turn     the turn the battle was conducted.
     * @return an Entity object.
     */
    TacticalBattleReport getByPositionTurn(final Position position, final int turn);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the TacticalBattleReport tha we want to add.
     */
    void add(final TacticalBattleReport value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the TacticalBattleReport tha we want to update.
     */
    void update(final TacticalBattleReport value);

    /**
     * Delete the input TacticalBattleReport from the database.
     *
     * @param entity the TacticalBattleReport tha we want to delete
     */
    void delete(TacticalBattleReport entity);

    /**
     * Listing all TacticalBattleReport from the database.
     *
     * @return a list of all the TacticalBattleReport that exist inside the table Avatar.
     */
    List<TacticalBattleReport> list();

    /**
     * Listing all TacticalBattleReport from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @return a list of all the Armies.
     */
    List<TacticalBattleReport> listGame(final Game thisGame);

    /**
     * Listing all TacticalBattleReport from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Armies.
     */
    List<TacticalBattleReport> listGameNation(final Game thisGame, final Nation nation);


    /**
     * Listing all TacticalBattleReport from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Armies.
     */
    List<TacticalBattleReport> listGameNationTurn(final Game thisGame, final Nation nation, final int turn);

    /**
     * Count the number of reports issued.
     *
     * @return report count.
     */
    Object countReportsPerGame(final int gameId);

}


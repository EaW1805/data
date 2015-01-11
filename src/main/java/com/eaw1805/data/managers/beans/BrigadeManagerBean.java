package com.eaw1805.data.managers.beans;

import com.eaw1805.data.dto.web.army.ForeignArmyDTO;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.Brigade;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Region;
import com.eaw1805.data.model.map.Sector;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * The interface of the BrigadeManagerBean.
 */
public interface BrigadeManagerBean extends EntityBean {

    /**
     * get the Brigade from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Brigade getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Brigade tha we want to add.
     */
    void add(final Brigade value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Brigade tha we want to update.
     */
    void update(final Brigade value);

    /**
     * Delete the input Brigade from the database.
     *
     * @param entity the Brigade tha we want to delete
     */
    void delete(Brigade entity);

    /**
     * Listing all the Brigades from the database.
     *
     * @return a list of all the Brigades that exist inside the table Avatar.
     */
    List<Brigade> list();

    /**
     * Listing all the Brigades from the database for the specific game.
     *
     * @param thisGame the game to select.
     * @return a list of all the Brigades.
     */
    List<Brigade> listByGame(final Game thisGame);

    /**
     * Listing all the free Brigades from the database for the specific game.
     *
     * @param thisGame the game to select.
     * @return a list of all the Brigades.
     */
    List<Brigade> listFreeByGame(final Game thisGame);

    /**
     * Listing all the Brigades from the database at the specific position.
     *
     * @param thisPosition the position to select.
     * @return a list of all the Brigades.
     */
    List<Brigade> listByPosition(final Position thisPosition);

    /**
     * List all Brigades positioned at a given sector.
     *
     * @param thisPosition the position to check.
     * @return the list of Brigades.
     */
    List<Brigade> listAllBySector(final Position thisPosition);

    /**
     * Listing all the Brigades from the database at the specific position owned by the specific nation.
     *
     * @param thisPosition the position to select.
     * @param nation       the nation to select.
     * @return a list of all the Brigades.
     */
    List<Brigade> listByPositionNation(final Position thisPosition, final Nation nation);

    /**
     * Listing all the Brigades from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all free Brigades.
     */
    List<Brigade> listByGameNation(final Game thisGame, final Nation nation);

    List<Brigade> listByGameNationRegion(final Game thisGame, final Nation nation, final Region region);

    /**
     * List all games by game nation and position.
     *
     * @param thisGame The game.
     * @param nation The nation.
     * @param position The position.
     * @return A list of brigades.
     */
    List<Brigade> listByGameNationPosition(final Game thisGame, final Nation nation, final Position position);

    /**
     * Listing all the free Brigades from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all free Brigades.
     */
    List<Brigade> listFreeByGameNation(final Game thisGame, final Nation nation);

    /**
     * Listing all the free Brigades from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @param region   the region to select.
     * @return a list of all free Brigades.
     */
    List<Brigade> listFreeByGameNationRegion(final Game thisGame, final Nation nation, final Region region);

    /**
     * Listing all the Brigades from the database at the specific position.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @param region   the region to select.
     * @return a list of all the Brigades.
     */
    List<Brigade> listGameNationRegion(final Game thisGame, final Nation nation, final Region region);

    /**
     * Listing all the Brigades from the database members of the specific corp.
     *
     * @param thisGame the game to select.
     * @param corpId   the corp to select.
     * @return a list of all the Brigades.
     */
    List<Brigade> listByCorp(final Game thisGame, final int corpId);

    /**
     * Count the number of brigades in the 8 neighboring sectors of the given position based on their owner.
     *
     * @param thisPosition the position.
     * @return a mapping of brigade count to nations.
     */
    Map<Nation, BigInteger> countBrigadesByOwner(final Position thisPosition);

    /**
     * List all nations that have brigades in the given position.
     *
     * @param thisPosition the position.
     * @return a list of nations.
     */
    List<Nation> listOwners(final Position thisPosition);

    /**
     * Listing sectors with brigades belonging to more than 1 owner.
     *
     * @param thisGame the game to select.
     * @return a list of all the sectors.
     */
    List<Sector> listMultiOwners(final Game thisGame);

    /**
     * List all foreign armies located in a nations region.
     *
     * @param thisGame   the game to select.
     * @param thisNation the owner of the sectors.
     * @return list of foreign armies.
     */
    List<ForeignArmyDTO> listForeignArmies(final Game thisGame, final Nation thisNation);

}

package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.PlayerOrder;
import com.eaw1805.data.model.economy.TradeCity;
import com.eaw1805.data.model.fleet.Fleet;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface PlayerOrderManagerBean extends EntityBean {

    /**
     * get the PlayerOrder from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    PlayerOrder getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the PlayerOrder tha we want to add.
     */
    void add(final PlayerOrder value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the PlayerOrder tha we want to update.
     */
    void update(final PlayerOrder value);

    /**
     * Delete the input PlayerOrder from the database.
     *
     * @param entity the PlayerOrder tha we want to delete
     */
    void delete(PlayerOrder entity);

    /**
     * delete orders of a particular game, nation and type.
     *
     * @param thisGame   the game to look up.
     * @param thisNation the nation to look up.
     * @param turnId     the turn to look up.
     * @param lstTypes   a list of all order types.
     */
    void deleteByGameNationType(final int thisGame, final int thisNation, final int turnId, final Object[] lstTypes);

    /**
     * Listing all the PlayerOrders from the database.
     *
     * @return a list of all the PlayerOrders that exist inside the table PlayerOrders.
     */
    List<PlayerOrder> list();

    /**
     * looking for orders of a particular game.
     *
     * @param thisGame the game to look up.
     * @return a list of orders.
     */
    List<PlayerOrder> listByGame(final Game thisGame);

    /**
     * looking for orders of a particular game and nation.
     *
     * @param thisGame   the game to look up.
     * @param thisNation the nation to look up.
     * @param turnId     the turn to look up.
     * @return a list of orders.
     */
    List<PlayerOrder> listByGameNation(final Game thisGame, final Nation thisNation, final int turnId);

    /**
     * looking for orders of a particular game, nation and type.
     *
     * @param thisGame   the game to look up.
     * @param thisNation the nation to look up.
     * @param turnId     the turn to look up.
     * @param lstTypes   a list of all order types.
     * @return a list of orders.
     */
    List<PlayerOrder> listByGameNationType(final Game thisGame, final Nation thisNation, final int turnId,
                                           final Object[] lstTypes);

    /**
     * looking for orders of building class 3+ ships for a given game and turn.
     *
     * @param thisGame the game to look up.
     * @param turnId   the turn to look up.
     * @return a list of orders.
     */
    List<PlayerOrder> listByShipConstruction(final Game thisGame, final int turnId);

    /**
     * looking for orders of building class 3+ ships for a given game and turn.
     *
     * @param thisGame   the game to look up.
     * @param thisNation the nation to look up.
     * @param turnId     the turn to look up.
     * @return a list of orders.
     */
    List<PlayerOrder> listByShipConstruction(final Game thisGame, final Nation thisNation, final int turnId);

    /**
     * looking for relations orders of a particular game, nation and turn.
     *
     * @param thisGame     the game to look up.
     * @param thisNation   the nation to look up.
     * @param targetNation the nation to check for orders.
     * @return a list of orders.
     */
    List<PlayerOrder> listByRelations(final Game thisGame, final Nation thisNation, final Nation targetNation);

    /**
     * looking for harsh taxation orders of a particular game, nation and turn.
     *
     * @param thisGame   the game to look up.
     * @param thisNation the nation to look up.
     * @param turnId     the turn to look up.
     * @return a list of orders.
     */
    List<PlayerOrder> listByTaxOrders(final Game thisGame, final Nation thisNation, final int turnId);

    /**
     * looking for harsh taxation orders of a particular game, nation and turn.
     *
     * @param thisGame the game to look up.
     * @param turnId   the turn to look up.
     * @return a list of orders.
     */
    List<PlayerOrder> listTaxOrders(final Game thisGame, final int turnId);

    /**
     * looking for 1st phase trading orders of a particular game, nation and turn.
     *
     * @param thisGame the game to look up.
     * @return a list of orders.
     */
    List<PlayerOrder> listTradeFirstOrders(final Game thisGame);

    /**
     * looking for 1st phase trading orders of a particular game, nation and turn.
     *
     * @param thisGame the game to look up.
     * @return a list of orders.
     */
    List<PlayerOrder> listTradeSecondOrders(final Game thisGame);

    /**
     * looking for trading orders of a particular game, nation, trade city and turn.
     *
     * @param thisCity the city of trade
     * @return a list of orders.
     */
    List<PlayerOrder> listTradeOrders(final TradeCity thisCity);

    /**
     * looking for transfer orders of a particular game and turn.
     *
     * @param thisGame the game to look up.
     * @return a list of orders.
     */
    List<PlayerOrder> listTransferOrders(final Game thisGame);

    /**
     * looking for load/unload orders of a particular game, nation, fleet and turn.
     *
     * @param thisFleet the fleet trying to load/unload.
     * @return a list of orders.
     */
    List<PlayerOrder> listLoadUnloadOrders(final Fleet thisFleet);

    /**
     * looking for build fortress orders of a particular game and turn.
     *
     * @param thisGame the game to look up.
     * @param turnId   the turn to look up.
     * @return a list of orders.
     */
    List<PlayerOrder> listBuildFortress(final Game thisGame, final int turnId);

    /**
     * Count the number of orders issued for each game and turn.
     *
     * @return a mapping of a list of order counts per game.
     */
    Map<Object, List<BigInteger>> countOrders();

    /**
     * Count the number of orders issued for each game, nation and turn.
     *
     * @return a mapping of a list of order counts per turn and nation.
     */
    Map<Integer, Map<Integer, BigInteger>> countGameOrders(final int gameId);

    /**
     * Count the number of orders issued for each nation and turn.
     *
     * @param gameId   the game to look up.
     * @param nationId the nation to look up.
     * @return a mapping of a list of order counts per turn.
     */
    List<Long> countOrdersPerGameNation(final int gameId, final int nationId);

    /**
     * Count the number of orders issued.
     *
     * @return order counts.
     */
    Object countOrdersPerGame(final int gameId);

    /**
     * Result the outcome of the orders.
     *
     * @param gameId the game to look up.
     * @param turnId the turn to look up.
     */
    void resetOrderResult(final int gameId, final int turnId);

}

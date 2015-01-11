package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.economy.TradeCity;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Region;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface TradeCityManagerBean extends EntityBean {

    /**
     * get the TradeCity from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    TradeCity getByID(int entityID);

    /**
     * Get the TradeCity from the database that corresponds to the input entity.
     *
     * @param entity the coordinates.
     * @return an Entity object.
     */
    TradeCity getByPosition(final Position entity);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the TradeCity tha we want to add.
     */
    void add(final TradeCity value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the TradeCity tha we want to update.
     */
    void update(final TradeCity value);

    /**
     * Delete the input TradeCity from the database.
     *
     * @param entity the TradeCity tha we want to delete
     */
    void delete(TradeCity entity);

    /**
     * Listing all the TradeCitys from the database.
     *
     * @return a list of all the TradeCitys that exist inside the table Avatar.
     */
    List<TradeCity> list();

    /**
     * Listing all the TradeCitys from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the TradeCitys.
     */
    List<TradeCity> listByGame(final Game thisGame);

    /**
     * Listing all the TradeCities from the database along with their owners.
     *
     * @param thisGame the game to select.
     * @return a list of all the TradeCities.
     */
    List<Object[]> listOwnersByGame(final Game thisGame);

    /**
     * Count all the TradeCities from the database along with their owners.
     *
     * @param thisGame   the game to select.
     * @param thisNation the nation to select.
     * @param thisRegion the region to select.
     * @return a count.
     */
    int countGameOwner(final Game thisGame, final Nation thisNation, final Region thisRegion);
}

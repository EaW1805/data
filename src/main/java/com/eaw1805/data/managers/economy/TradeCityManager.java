package com.eaw1805.data.managers.economy;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.TradeCityManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.economy.TradeCity;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Region;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for warehouse objects.
 */
public class TradeCityManager
        extends AbstractManager<TradeCity>
        implements TradeCityManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static TradeCityManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public)
     * default constructor.
     */
    public TradeCityManager() {
        // Does nothing
        super();
    }

    /**
     * TradeCityManager is loaded on the first execution of
     * TradeCityManager.getInstance() or the first access to
     * TradeCityManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static TradeCityManagerBean getInstance() {
        synchronized (TradeCityManager.class) {
            if (ourInstance == null) {
                ourInstance = new TradeCityManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final TradeCityManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the TradeCity from the database that corresponds to the input id.
     *
     * @param TradeCityId the id of the TradeCity object.
     * @return an TradeCity object.
     */
    public TradeCity getByID(final int TradeCityId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(TradeCity.class);
        criteria.add(Restrictions.eq("cityId", TradeCityId));
        return (TradeCity) criteria.uniqueResult();
    }

    /**
     * Get the TradeCity from the database that corresponds to the input entity.
     *
     * @param entity the coordinates.
     * @return an Entity object.
     */
    public TradeCity getByPosition(final Position entity) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(TradeCity.class);
        criteria.add(Restrictions.eq("position", entity));

        return (TradeCity) criteria.uniqueResult();
    }

    /**
     * Delete the input TradeCity from the database.
     *
     * @param TradeCity the TradeCity tha we want to delete
     */
    public void delete(final TradeCity TradeCity) {
        super.delete(TradeCity, TradeCity.getCityId());
    }

    /**
     * Listing all the TradeCities from the database.
     *
     * @return a list of all the TradeCities.
     */
    public List<TradeCity> list() {
        return super.list(new TradeCity());
    }

    /**
     * Listing all the TradeCities from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the TradeCities.
     */
    @SuppressWarnings("unchecked")
    public List<TradeCity> listByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(TradeCity.class);
        criteria.add(Restrictions.eq("position.game", thisGame));

        return criteria.list();
    }

    /**
     * Listing all the TradeCities from the database along with their owners.
     *
     * @param thisGame the game to select.
     * @return a list of all the TradeCities.
     */
    @SuppressWarnings("unchecked")
    public List<Object[]> listOwnersByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT CITY_ID, INIT.NATION_ID AS INIT_NATION_ID, THISGAME.NATION_ID AS NATION_ID " +
                "FROM `TRADECITIES` , SECTORS AS INIT, SECTORS AS THISGAME " +
                "WHERE TRADECITIES.GAME_ID = " + thisGame.getGameId() + " " +
                "AND TRADECITIES.REGION_ID = 1 " +
                "AND THISGAME.GAME_ID = TRADECITIES.GAME_ID " +
                "AND INIT.GAME_ID = -1 " +
                "AND INIT.NATION_ID > 0 " +
                "AND TRADECITIES.REGION_ID = INIT.REGION_ID " +
                "AND TRADECITIES.x = INIT.x " +
                "AND TRADECITIES.y = INIT.y " +
                "AND TRADECITIES.REGION_ID = THISGAME.REGION_ID " +
                "AND TRADECITIES.x = THISGAME.x " +
                "AND TRADECITIES.y = THISGAME.y";

        return session.createSQLQuery(thisQuery).list();
    }

    /**
     * Count all the TradeCities from the database along with their owners.
     *
     * @param thisGame   the game to select.
     * @param thisNation the nation to select.
     * @param thisRegion the region to select.
     * @return a count.
     */
    @SuppressWarnings("unchecked")
    public int countGameOwner(final Game thisGame, final Nation thisNation, final Region thisRegion) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT CITY_ID " +
                "FROM `TRADECITIES` , SECTORS AS THISGAME " +
                "WHERE TRADECITIES.GAME_ID = " + thisGame.getGameId() + " " +
                "AND THISGAME.GAME_ID = TRADECITIES.GAME_ID " +
                "AND TRADECITIES.REGION_ID = " + thisRegion.getId() + " " +
                "AND TRADECITIES.REGION_ID = THISGAME.REGION_ID " +
                "AND THISGAME.NATION_ID = " + thisNation.getId() + " " +
                "AND TRADECITIES.x = THISGAME.x " +
                "AND TRADECITIES.y = THISGAME.y";

        return session.createSQLQuery(thisQuery).list().size();
    }

}
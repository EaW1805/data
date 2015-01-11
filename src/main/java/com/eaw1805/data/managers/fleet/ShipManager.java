package com.eaw1805.data.managers.fleet;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.ShipManagerBean;
import com.eaw1805.data.managers.map.SectorManager;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.fleet.Ship;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Region;
import com.eaw1805.data.model.map.Sector;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CRUD operations for Ship objects.
 */
public class ShipManager
        extends AbstractManager<Ship>
        implements ShipManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static ShipManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public ShipManager() {
        // Does nothing
        super();
    }

    /**
     * ShipManager is loaded on the first execution of
     * ShipManager.getInstance() or the first access to
     * ShipManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static ShipManagerBean getInstance() {
        synchronized (ShipManager.class) {
            if (ourInstance == null) {
                ourInstance = new ShipManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final ShipManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Ship from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public Ship getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Ship.class);
        criteria.add(Restrictions.eq("shipId", entityID));
        return (Ship)criteria.uniqueResult();
    }

    /**
     * Delete the input entity from the database.
     *
     * @param entity the entity that we want to delete.
     */
    public void delete(final Ship entity) {
        super.delete(entity, entity.getShipId());
    }

    /**
     * Listing all the Ships from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    public List<Ship> list() {
        return super.list(new Ship());
    }

    /**
     * Listing all the Ships from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Ships.
     */
    @SuppressWarnings("unchecked")
    public List<Ship> listByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Ship.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.addOrder(Order.asc("nation"));
        return criteria.list();
    }

    /**
     * Listing all the Ships from the database members of the specific fleet.
     *
     * @param thisGame the game to select.
     * @param fleet    the fleet to select.
     * @return a list of all the Brigades.
     */
    @SuppressWarnings("unchecked")
    public List<Ship> listByFleet(final Game thisGame, final int fleet) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Ship.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("fleet", fleet));
        return criteria.list();
    }

    /**
     * Listing all the Ships from the database at the specific position owned by the specific nation.
     *
     * @param thisPosition the position to select.
     * @param nation       the nation to select.
     * @return a list of all the Ships.
     */
    @SuppressWarnings("unchecked")
    public List<Ship> listByPositionNation(final Position thisPosition, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Ship.class);
        criteria.add(Restrictions.eq("nation", nation));
        criteria.add(Restrictions.eq("position.game", thisPosition.getGame()));
        criteria.add(Restrictions.eq("position.region", thisPosition.getRegion()));
        criteria.add(Restrictions.eq("position.x", thisPosition.getX()));
        criteria.add(Restrictions.eq("position.y", thisPosition.getY()));
        return criteria.list();
    }

    /**
     * Listing all the ships from the database that belongs in the specific game and nation.
     *
     * @param thisGame   The Game.
     * @param thisNation The Nation.
     * @return A list of all the Ships.
     */
    @SuppressWarnings("unchecked")
    public List<Ship> listGameNation(final Game thisGame, final Nation thisNation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Ship.class);
        criteria.add(Restrictions.eq("nation", thisNation));
        criteria.add(Restrictions.eq("position.game", thisGame));
        return criteria.list();
    }

    /**
     * Listing all the Ships from the database at the specific position.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @param region   the region to select.
     * @return a list of all the Ships.
     */
    @SuppressWarnings("unchecked")
    public List<Ship> listGameNationRegion(final Game thisGame, final Nation nation, final Region region) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Ship.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", region));
        criteria.add(Restrictions.eq("nation", nation));
        return criteria.list();
    }

    /**
     * List all ships in the specific position and game.
     *
     * @param position The position to list the ships that are on it.
     * @return A list of ships.
     */
    @SuppressWarnings("unchecked")
    public List<Ship> listByGamePosition(final Position position) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Ship.class);
        criteria.add(Restrictions.eq("position.game", position.getGame()));
        criteria.add(Restrictions.eq("position.region", position.getRegion()));
        criteria.add(Restrictions.eq("position.x", position.getX()));
        criteria.add(Restrictions.eq("position.y", position.getY()));
        criteria.addOrder(Order.asc("shipId"));
        return criteria.list();
    }

    /**
     * List all ships positioned at a given sector.
     *
     * @param thisPosition the position to check.
     * @return the list of ships.
     */
    @SuppressWarnings("unchecked")
    public List<Ship> listAllBySector(final Position thisPosition) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Ship.class);
        criteria.add(Restrictions.eq("position.game", thisPosition.getGame()));
        criteria.add(Restrictions.eq("position.region", thisPosition.getRegion()));
        criteria.add(Restrictions.eq("position.x", thisPosition.getX()));
        criteria.add(Restrictions.eq("position.y", thisPosition.getY()));
        criteria.add(Restrictions.eq("fleet", 0));
        return criteria.list();
    }

    /**
     * Listing all the free Ships from the database for a specific game.
     *
     * @param thisGame the game to select.
     * @return a list of all free Ships.
     */
    @SuppressWarnings("unchecked")
    public List<Ship> listFreeByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Ship.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("fleet", 0));
        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("position.y"));
        return criteria.list();
    }

    /**
     * Listing all the free Ships from the database owned by the specific nation..
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all free Ships.
     */
    @SuppressWarnings("unchecked")
    public List<Ship> listFreeByGameNation(final Game thisGame, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Ship.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("nation", nation));
        criteria.add(Restrictions.eq("fleet", 0));
        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("position.y"));
        return criteria.list();
    }

    /**
     * Listing all the free Ships from the database owned by the specific nation..
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @param region   the region to select.
     * @return a list of all free Ships.
     */
    @SuppressWarnings("unchecked")
    public List<Ship> listFreeByGameNationRegion(final Game thisGame, final Nation nation, final Region region) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Ship.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("nation", nation));
        criteria.add(Restrictions.eq("fleet", 0));
        criteria.add(Restrictions.eq("position.region", region));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("position.y"));
        return criteria.list();
    }

    /**
     * Listing sectors with brigades belonging to more than 1 owner.
     *
     * @param thisGame the game to select.
     * @return a list of all the sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listMultiOwners(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT REGION_ID, x,y, count(distinct NATION_ID)" +
                " FROM `SHIPS`" +
                " WHERE GAME_ID = " + thisGame.getGameId() +
                " GROUP BY REGION_ID, x, y" +
                " HAVING count(distinct NATION_ID) > 1";

        final List<Object[]> lstResults = session.createSQLQuery(thisQuery).list();

        // construct list
        final List<Sector> theList = new ArrayList<Sector>();

        // Iterate through results and populate map
        for (Object[] lstResult : lstResults) {
            final Position thisPosition = new Position();
            thisPosition.setGame(thisGame);
            thisPosition.setRegion((Region) session.get(Region.class, (Integer) lstResult[0]));
            thisPosition.setX((Integer) lstResult[1]);
            thisPosition.setY((Integer) lstResult[2]);
            theList.add(getByPosition(thisPosition));
        }

        return theList;
    }

    /**
     * Get the sector from the database that corresponds to the input entity.
     *
     * @param entity the coordinates.
     * @return an Entity object.
     */
    protected Sector getByPosition(final Position entity) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position", entity));

        return (Sector) criteria.uniqueResult();
    }

    /**
     * List all nations that have ships in the given position.
     *
     * @param thisPosition the position.
     * @return a list of nations.
     */
    @SuppressWarnings("unchecked")
    public List<Nation> listOwners(final Position thisPosition) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT NATION_ID " +
                "FROM `SHIPS` " +
                "WHERE GAME_ID = " + thisPosition.getGame().getGameId() +
                " AND REGION_ID = " + thisPosition.getRegion().getId() +
                " AND x = " + thisPosition.getX() +
                " AND y = " + thisPosition.getY() +
                " GROUP BY REGION_ID, x, y, NATION_ID";

        final List<Integer> lstResults = session.createSQLQuery(thisQuery).list();

        // construct map
        final List<Nation> theList = new ArrayList<Nation>();

        // Iterate through results and populate map
        for (Integer lstResult : lstResults) {
            theList.add((Nation) session.get(Nation.class, lstResult));
        }

        return theList;
    }

    /**
     * List the number of ships per sector for particular nation.
     *
     * @param thisGame   the Game .
     * @param thisNation the Nation owner.
     * @return a mapping of ships count to nations.
     */
    @SuppressWarnings("unchecked")
    public Map<Sector, BigInteger> countShips(final Game thisGame, final Nation thisNation) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT `SHIPS`.REGION_ID, x, y, count(*) " +
                "FROM `SHIPS` " +
                "WHERE `SHIPS`.GAME_ID = " + thisGame.getGameId() + " " +
                "AND `SHIPS`.NATION_ID = " + thisNation.getId() + " " +
                "GROUP BY `SHIPS`.REGION_ID, x, y";

        final List<Object[]> lstResults = session.createSQLQuery(thisQuery).list();

        // construct map
        final Map<Sector, BigInteger> theMap = new HashMap<Sector, BigInteger>();

        // Iterate through results and populate map
        for (Object[] lstResult : lstResults) {
            final Region thisRegion = (Region) session.get(Region.class, (Integer) lstResult[0]);
            final Position thisPos = new Position();
            thisPos.setGame(thisGame);
            thisPos.setRegion(thisRegion);
            thisPos.setX((Integer) lstResult[1]);
            thisPos.setY((Integer) lstResult[2]);
            final Sector thisSector = SectorManager.getInstance().getByPosition(thisPos);

            // Insert sector in map
            theMap.put(thisSector, (BigInteger) lstResult[3]);
        }

        return theMap;
    }

    /**
     * Count the number of ships at the given position based on their owner.
     *
     * @param thisPosition the position.
     * @param onlyMerchant true, count only Merchant, false count only warships.
     * @return a mapping of ships count to nations.
     */
    @SuppressWarnings("unchecked")
    public Map<Nation, BigInteger> countShipsByOwner(final Position thisPosition, final boolean onlyMerchant) {
        String shipClass = "TBL_SHIPTYPES.SC > 0";
        if (onlyMerchant) {
            shipClass = "TBL_SHIPTYPES.SC = 0";
        }

        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT NATION_ID, count(*) as SHIPS " +
                "FROM `SHIPS`, `TBL_SHIPTYPES` " +
                "WHERE `SHIPS`.TYPE_ID = `TBL_SHIPTYPES`.TYPE_ID" +
                " AND " + shipClass +
                " AND GAME_ID = " + thisPosition.getGame().getGameId() +
                " AND REGION_ID = " + thisPosition.getRegion().getId() +
                " AND x = " + thisPosition.getX() +
                " AND y = " + thisPosition.getY() +
                " GROUP BY REGION_ID, x, y, NATION_ID";

        final List<Object[]> lstResults = session.createSQLQuery(thisQuery).list();

        // construct map
        final Map<Nation, BigInteger> theMap = new HashMap<Nation, BigInteger>();

        // Iterate through results and populate map
        for (Object[] lstResult : lstResults) {
            theMap.put((Nation) session.get(Nation.class, (Integer) lstResult[0]), (BigInteger) lstResult[1]);
        }

        return theMap;
    }

    /**
     * Count the number of ships at the given position based on their owner.
     *
     * @param thisPosition the position.
     * @return a mapping of ships count to nations.
     */
    @SuppressWarnings("unchecked")
    public Map<Nation, BigInteger> countNearbyShipsByOwner(final Position thisPosition) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT NATION_ID, count(*) as SHIPS " +
                "FROM `SHIPS` " +
                "WHERE GAME_ID = " + thisPosition.getGame().getGameId() +
                " AND REGION_ID = " + thisPosition.getRegion().getId() +
                " AND ((x = " + (thisPosition.getX() - 1) + " AND y = " + (thisPosition.getY() - 1) + ") " +
                "      OR (x = " + (thisPosition.getX() - 1) + " AND y = " + (thisPosition.getY()) + ") " +
                "      OR (x = " + (thisPosition.getX() - 1) + " AND y = " + (thisPosition.getY() + 1) + ") " +
                "      OR (x = " + (thisPosition.getX()) + " AND y = " + (thisPosition.getY() - 1) + ") " +
                "      OR (x = " + (thisPosition.getX()) + " AND y = " + (thisPosition.getY() + 1) + ") " +
                "      OR (x = " + (thisPosition.getX() + 1) + " AND y = " + (thisPosition.getY() - 1) + ") " +
                "      OR (x = " + (thisPosition.getX() + 1) + " AND y = " + (thisPosition.getY()) + ") " +
                "      OR (x = " + (thisPosition.getX() + 1) + " AND y = " + (thisPosition.getY() + 1) + "))" +
                " GROUP BY REGION_ID, x, y, NATION_ID";

        final List<Object[]> lstResults = session.createSQLQuery(thisQuery).list();

        // construct map
        final Map<Nation, BigInteger> theMap = new HashMap<Nation, BigInteger>();

        // Iterate through results and populate map
        for (Object[] lstResult : lstResults) {
            theMap.put((Nation) session.get(Nation.class, (Integer) lstResult[0]), (BigInteger) lstResult[1]);
        }

        return theMap;
    }

    /**
     * Remove all the flags signifying participation in a naval battle.
     *
     * @param thisGame the game to select.
     */
    public void removeNavalFlag(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "UPDATE SHIPS SET `navalBattle` = 0 " +
                " WHERE GAME_ID = " + thisGame.getGameId() +
                " AND `navalBattle` = 1";

        session.createSQLQuery(thisQuery).executeUpdate();
    }

    /**
     * Remove all the flags signifying movement.
     *
     * @param thisGame the game to select.
     */
    public void removeHasMovedFlag(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "UPDATE SHIPS SET `hasMoved` = 0 " +
                " WHERE GAME_ID = " + thisGame.getGameId() +
                " AND `hasMoved` = 1";

        session.createSQLQuery(thisQuery).executeUpdate();
    }

}

package com.eaw1805.data.managers.army;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.BattalionManagerBean;
import com.eaw1805.data.managers.map.SectorManager;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.Battalion;
import com.eaw1805.data.model.army.Brigade;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Region;
import com.eaw1805.data.model.map.Sector;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * CRUD operations for Battalion objects.
 */
public class BattalionManager
        extends AbstractManager<Battalion>
        implements BattalionManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static BattalionManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public BattalionManager() {
        // Does nothing
        super();
    }

    /**
     * BattalionManager is loaded on the first execution of
     * BattalionManager.getInstance() or the first access to
     * BattalionManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static BattalionManagerBean getInstance() {
        synchronized (BattalionManager.class) {
            if (ourInstance == null) {
                ourInstance = new BattalionManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final BattalionManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Battalion from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public Battalion getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Battalion.class);
        criteria.add(Restrictions.eq("id", entityID));
        return (Battalion) criteria.uniqueResult();
    }

    /**
     * Delete the input entity from the database.
     *
     * @param entity the entity tha we want to delete
     */
    public void delete(final Battalion entity) {
        super.delete(entity, entity.getId());
    }

    /**
     * Listing all the Battalions from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    public List<Battalion> list() {
        return super.list(new Battalion());
    }

    /**
     * Listing all the battalions from the database for the specific game that have less than 40 headcount.
     *
     * @param thisGame the game to select.
     * @return a list of all the battalions.
     */
    @SuppressWarnings("unchecked")
    public List<Battalion> listSmallByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT BATTALIONS.BATTALION_ID " +
                " FROM `BATTALIONS`, BRIGADES " +
                " WHERE BATTALIONS.BRIGADE_ID = BRIGADES.BRIGADE_ID " +
                " AND BRIGADES.GAME_ID = " + thisGame.getGameId() +
                " AND BATTALIONS.HEADCOUNT < 40";

        final List<Integer> lstResults = session.createSQLQuery(thisQuery).list();

        // construct list
        final List<Battalion> theList = new ArrayList<Battalion>();

        // Iterate through results and populate map
        for (Integer thisResult : lstResults) {
            theList.add((Battalion) session.get(Battalion.class, thisResult));
        }

        return theList;
    }

    /**
     * Get all battalions that belong in one of the given brigades.
     *
     * @param brigades The brigades to search battalions for.
     * @return A list with Battalions.
     */
    @SuppressWarnings("unchecked")
    public List<Battalion> listByBrigades(final List<Brigade> brigades) {
        if (brigades.isEmpty()) {
            return new ArrayList<Battalion>();
        }
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(Battalion.class);
        criteria.add(Restrictions.in("brigade", brigades));
        return criteria.list();
    }

    /**
     * Listing all the battalions from the database with same type.
     *
     * @param thisBattalion the battalion to select.
     * @return a list of all the battalions.
     */
    @SuppressWarnings("unchecked")
    public List<Battalion> listByType(final Battalion thisBattalion) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT BATTALIONS.BATTALION_ID " +
                " FROM `BATTALIONS`, BRIGADES " +
                " WHERE BATTALIONS.BRIGADE_ID = BRIGADES.BRIGADE_ID " +
                " AND BRIGADES.GAME_ID = " + thisBattalion.getBrigade().getPosition().getGame().getGameId() +
                " AND BRIGADES.NATION_ID = " + thisBattalion.getBrigade().getNation().getId() +
                " AND BRIGADES.REGION_ID = " + thisBattalion.getBrigade().getPosition().getRegion().getId() +
                " AND BRIGADES.x = " + thisBattalion.getBrigade().getPosition().getX() +
                " AND BRIGADES.y = " + thisBattalion.getBrigade().getPosition().getY() +
                " AND BATTALIONS.TYPE_ID = " + thisBattalion.getType().getId();

        final List<Integer> lstResults = session.createSQLQuery(thisQuery).list();

        // construct list
        final List<Battalion> theList = new ArrayList<Battalion>();

        // Iterate through results and populate map
        for (Integer thisResult : lstResults) {
            theList.add((Battalion) session.get(Battalion.class, thisResult));
        }

        return theList;
    }

    /**
     * Get all battalions in the specific position.
     *
     * @param position The position to search for battalions.
     * @return The list of battalions being in the specific position.
     */
    @SuppressWarnings("unchecked")
    public List<Battalion> listByGamePosition(final Position position) {
        final Session session = getSessionFactory().getCurrentSession();

        final String thisQuery = "SELECT BATTALIONS.BATTALION_ID " +
                " FROM `BATTALIONS`, BRIGADES " +
                " WHERE BATTALIONS.BRIGADE_ID = BRIGADES.BRIGADE_ID " +
                " AND BRIGADES.GAME_ID = " + position.getGame().getGameId() +
                " AND BRIGADES.REGION_ID = " + position.getRegion().getId() +
                " AND BRIGADES.x = " + position.getX() +
                " AND BRIGADES.y = " + position.getY();

        final List<Integer> lstResults = session.createSQLQuery(thisQuery).list();

        // construct list
        final List<Battalion> theList = new ArrayList<Battalion>();

        // Iterate through results and populate map
        for (Integer thisResult : lstResults) {
            theList.add((Battalion) session.get(Battalion.class, thisResult));
        }

        return theList;
    }

    /**
     * Get all battalions in the specific position.
     *
     * @param position The position to search for battalions.
     * @param owner    The owner of the battalions.
     * @return The list of battalions being in the specific position.
     */
    @SuppressWarnings("unchecked")
    public List<Battalion> listByGamePosition(final Position position, final Nation owner) {
        final Session session = getSessionFactory().getCurrentSession();

        final String thisQuery = "SELECT BATTALIONS.BATTALION_ID " +
                " FROM `BATTALIONS`, BRIGADES " +
                " WHERE BATTALIONS.BRIGADE_ID = BRIGADES.BRIGADE_ID " +
                " AND BRIGADES.GAME_ID = " + position.getGame().getGameId() +
                " AND BRIGADES.REGION_ID = " + position.getRegion().getId() +
                " AND BRIGADES.x = " + position.getX() +
                " AND BRIGADES.y = " + position.getY() +
                " AND BRIGADES.NATION_ID = " + owner.getId();

        final List<Integer> lstResults = session.createSQLQuery(thisQuery).list();

        // construct list
        final List<Battalion> theList = new ArrayList<Battalion>();

        // Iterate through results and populate map
        for (Integer thisResult : lstResults) {
            theList.add((Battalion) session.get(Battalion.class, thisResult));
        }

        return theList;
    }

    /**
     * Count the number of battalions at the given position based on their owner.
     *
     * @param thisPosition the position.
     * @return a mapping of battalion count to nations.
     */
    @SuppressWarnings("unchecked")
    public Map<Nation, BigInteger> countBattalionsByOwner(final Position thisPosition) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT NATION_ID, count(*) as BATTALIONS " +
                " FROM `BRIGADES`, `BATTALIONS` " +
                " WHERE `BRIGADES`.BRIGADE_ID = `BATTALIONS`.BRIGADE_ID" +
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
     * List the number of battalions per sector.
     *
     * @param thisGame the Game .
     * @return a mapping of battalion count to nations.
     */
    @SuppressWarnings("unchecked")
    public Map<Sector, BigInteger> listBattalions(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT `BRIGADES`.REGION_ID, x, y, count(*) " +
                " FROM `BRIGADES`, `BATTALIONS` " +
                " WHERE `BRIGADES`.`BRIGADE_ID` = `BATTALIONS`.`BRIGADE_ID` " +
                " AND `BRIGADES`.GAME_ID = " + thisGame.getGameId() + " " +
                " GROUP BY `BRIGADES`.REGION_ID, x, y";

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
     * List the number of LC battalions per sector and nation.
     *
     * @param thisGame the Game .
     * @return a mapping of battalion count to nations.
     */
    @SuppressWarnings("unchecked")
    public Map<Nation, Map<Sector, BigInteger>> listLCBattalions(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT `BRIGADES`.NATION_ID, `BRIGADES`.REGION_ID, x, y, count(*) " +
                " FROM `BRIGADES`, `BATTALIONS`, `TBL_ARMYTYPES` " +
                " WHERE `BRIGADES`.`BRIGADE_ID` = `BATTALIONS`.`BRIGADE_ID` " +
                " AND `BATTALIONS`.`TYPE_ID` = `TBL_ARMYTYPES`.`TYPE_ID` " +
                " AND  `TBL_ARMYTYPES`.isLc=1 " +
                " AND  `BATTALIONS`.headcount>=500 " +
                " AND `BRIGADES`.GAME_ID = " + thisGame.getGameId() + " " +
                " GROUP BY `BRIGADES`.NATION_ID, `BRIGADES`.REGION_ID, x, y";

        final List<Object[]> lstResults = session.createSQLQuery(thisQuery).list();

        // construct map
        final Map<Nation, Map<Sector, BigInteger>> theMap = new HashMap<Nation, Map<Sector, BigInteger>>();

        // Iterate through results and populate map
        for (Object[] lstResult : lstResults) {
            final Nation thisNation = (Nation) session.get(Nation.class, (Integer) lstResult[0]);
            final Region thisRegion = (Region) session.get(Region.class, (Integer) lstResult[1]);
            final Position thisPos = new Position();
            thisPos.setGame(thisGame);
            thisPos.setRegion(thisRegion);
            thisPos.setX((Integer) lstResult[2]);
            thisPos.setY((Integer) lstResult[3]);
            final Sector thisSector = SectorManager.getInstance().getByPosition(thisPos);

            // Lookup if this is the first entry for the particular nation
            Map<Sector, BigInteger> thisMap;
            if (theMap.containsKey(thisNation)) {
                thisMap = theMap.get(thisNation);
            } else {
                thisMap = new HashMap<Sector, BigInteger>();
            }

            // Insert sector in nation's map
            thisMap.put(thisSector, (BigInteger) lstResult[4]);

            // Update main map
            theMap.put(thisNation, thisMap);
        }

        return theMap;
    }

    /**
     * List the number of battalions per sector for particular nation.
     *
     * @param thisGame   the Game .
     * @param thisNation the Nation owner.
     * @param limit      the headcount limit for taking into account a battalion.
     * @param notLost
     * @return a mapping of battalion count to sectors.
     */
    @SuppressWarnings("unchecked")
    public Map<Sector, BigInteger> countBattalions(final Game thisGame, final Nation thisNation, final int limit, boolean notLost) {
        final Session session = getSessionFactory().getCurrentSession();
        final StringBuilder thisQuery = new StringBuilder();

        thisQuery.append("SELECT `BRIGADES`.REGION_ID, x, y, count(*) ");
        thisQuery.append("FROM `BRIGADES`, `BATTALIONS` ");
        thisQuery.append("WHERE `BRIGADES`.`BRIGADE_ID` = `BATTALIONS`.`BRIGADE_ID` ");
        thisQuery.append("AND `BRIGADES`.GAME_ID = " + thisGame.getGameId() + " ");
        thisQuery.append("AND `BRIGADES`.NATION_ID = " + thisNation.getId() + " ");
        thisQuery.append("AND  `BATTALIONS`.headcount >= " + limit + " ");

        if (notLost) {
            thisQuery.append(" AND `BATTALIONS`.hasLost = 0 ");
        }

        thisQuery.append("GROUP BY `BRIGADES`.REGION_ID, x, y");

        final List<Object[]> lstResults = session.createSQLQuery(thisQuery.toString()).list();

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
     * Remove all the flags signifying movement.
     *
     * @param thisGame the game to select.
     */
    public void removeHasMovedFlag(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();

        final String thisQuery = "SELECT BATTALIONS.BATTALION_ID " +
                " FROM `BATTALIONS`, BRIGADES " +
                " WHERE BATTALIONS.BRIGADE_ID = BRIGADES.BRIGADE_ID " +
                " AND BRIGADES.GAME_ID = " + thisGame.getGameId() +
                " AND BATTALIONS.hasMoved = 1";

        final List<Integer> lstResults = session.createSQLQuery(thisQuery).list();

        if (lstResults.isEmpty()) {
            // nothing to update
            return;
        }

        // construct query
        final StringBuilder strBuilder = new StringBuilder();

        strBuilder.append("UPDATE BATTALIONS SET `hasMoved` = 0, `hasEngagedBattle` = 0 ");
        strBuilder.append(" WHERE BATTALION_ID IN (");

        // Iterate through results and populate map
        for (Integer thisResult : lstResults) {
            strBuilder.append(thisResult);
            strBuilder.append(", ");
        }

        final String thisUpdateQuery = strBuilder.substring(0, strBuilder.length() - 2) + ")";
        session.createSQLQuery(thisUpdateQuery).executeUpdate();
    }

    /**
     * Remove all the flags signifying losing a battle.
     *
     * @param thisGame the game to select.
     */
    public void removeHasLostFlag(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();

        final String thisQuery = "SELECT BATTALIONS.BATTALION_ID " +
                " FROM `BATTALIONS`, BRIGADES " +
                " WHERE BATTALIONS.BRIGADE_ID = BRIGADES.BRIGADE_ID " +
                " AND BRIGADES.GAME_ID = " + thisGame.getGameId() +
                " AND BATTALIONS.hasLost = 1";

        final List<Integer> lstResults = session.createSQLQuery(thisQuery).list();

        if (lstResults.isEmpty()) {
            // nothing to update
            return;
        }

        // construct query
        final StringBuilder strBuilder = new StringBuilder();

        strBuilder.append("UPDATE BATTALIONS SET `hasLost` = 0 ");
        strBuilder.append(" WHERE BATTALION_ID IN (");

        // Iterate through results and populate map
        for (Integer thisResult : lstResults) {
            strBuilder.append(thisResult);
            strBuilder.append(", ");
        }

        final String thisUpdateQuery = strBuilder.substring(0, strBuilder.length() - 2) + ")";
        session.createSQLQuery(thisUpdateQuery).executeUpdate();
    }

}


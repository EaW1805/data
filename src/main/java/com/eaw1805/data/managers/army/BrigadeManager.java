package com.eaw1805.data.managers.army;

import com.eaw1805.data.dto.web.army.ForeignArmyDTO;
import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.BrigadeManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.Brigade;
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
 * CRUD operations for Brigade objects.
 */
public class BrigadeManager
        extends AbstractManager<Brigade>
        implements BrigadeManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static BrigadeManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public BrigadeManager() {
        // Does nothing
        super();
    }

    /**
     * BrigadeManager is loaded on the first execution of
     * BrigadeManager.getInstance() or the first access to
     * BrigadeManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static BrigadeManagerBean getInstance() {
        synchronized (BrigadeManager.class) {
            if (ourInstance == null) {
                ourInstance = new BrigadeManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final BrigadeManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Brigade from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public Brigade getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Brigade.class);
        criteria.add(Restrictions.eq("brigadeId", entityID));
        return (Brigade) criteria.uniqueResult();
    }

    /**
     * Delete the input entity from the database.
     *
     * @param entity the entity that we want to delete.
     */
    public void delete(final Brigade entity) {
        super.delete(entity, entity.getBrigadeId());
    }

    /**
     * Listing all the Brigades from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    public List<Brigade> list() {
        return super.list(new Brigade());
    }

    /**
     * Listing all the Brigades from the database for the specific game.
     *
     * @param thisGame the game to select.
     * @return a list of all the Brigades.
     */
    @SuppressWarnings("unchecked")
    public List<Brigade> listByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Brigade.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("position.y"));

        return criteria.list();
    }

    public List<Brigade> listFreeByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Brigade.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.or(Restrictions.eq("corp", 0), Restrictions.isNull("corp")));
        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("position.y"));

        return criteria.list();
    }

    /**
     * Listing all the Brigades from the database at the specific position.
     *
     * @param thisPosition the position to select.
     * @return a list of all the Brigades.
     */
    @SuppressWarnings("unchecked")
    public List<Brigade> listByPosition(final Position thisPosition) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Brigade.class);
        criteria.add(Restrictions.eq("position.game", thisPosition.getGame()));
        criteria.add(Restrictions.eq("position.region", thisPosition.getRegion()));
        criteria.add(Restrictions.eq("position.x", thisPosition.getX()));
        criteria.add(Restrictions.eq("position.y", thisPosition.getY()));
        return criteria.list();
    }

    /**
     * List all Brigades positioned at a given sector.
     *
     * @param thisPosition the position to check.
     * @return the list of Brigades.
     */
    @SuppressWarnings("unchecked")
    public List<Brigade> listAllBySector(final Position thisPosition) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Brigade.class);
        criteria.add(Restrictions.eq("position.game", thisPosition.getGame()));
        criteria.add(Restrictions.eq("position.region", thisPosition.getRegion()));
        criteria.add(Restrictions.eq("position.x", thisPosition.getX()));
        criteria.add(Restrictions.eq("position.y", thisPosition.getY()));
        criteria.add(Restrictions.or(Restrictions.eq("corp", 0), Restrictions.isNull("corp")));
        return criteria.list();
    }

    /**
     * Listing all the Brigades from the database at the specific position owned by the specific nation.
     *
     * @param thisPosition the position to select.
     * @param nation       the nation to select.
     * @return a list of all the Brigades.
     */
    @SuppressWarnings("unchecked")
    public List<Brigade> listByPositionNation(final Position thisPosition, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Brigade.class);
        criteria.add(Restrictions.eq("nation", nation));
        if (thisPosition.getGame() == null) {
            criteria.add(Restrictions.isNull("position.game"));
        } else {
            criteria.add(Restrictions.eq("position.game", thisPosition.getGame()));
        }
        criteria.add(Restrictions.eq("position.region", thisPosition.getRegion()));
        criteria.add(Restrictions.eq("position.x", thisPosition.getX()));
        criteria.add(Restrictions.eq("position.y", thisPosition.getY()));
        return criteria.list();
    }

    /**
     * Listing all the Brigades from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all free Brigades.
     */
    @SuppressWarnings("unchecked")
    public List<Brigade> listByGameNation(final Game thisGame, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Brigade.class);
        if (thisGame == null) {
            criteria.add(Restrictions.isNull("position.game"));
        } else {
            criteria.add(Restrictions.eq("position.game", thisGame));
        }

        criteria.add(Restrictions.eq("nation", nation));
        return criteria.list();
    }

    public List<Brigade> listByGameNationRegion(final Game thisGame, final Nation nation, final Region region) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Brigade.class);
        if (thisGame == null) {
            criteria.add(Restrictions.isNull("position.game"));
        } else {
            criteria.add(Restrictions.eq("position.game", thisGame));
        }
        criteria.add(Restrictions.eq("position.region", region));

        criteria.add(Restrictions.eq("nation", nation));
        return criteria.list();
    }

    /**
     * List all games by game nation and position.
     *
     * @param thisGame The game.
     * @param nation The nation.
     * @param position The position.
     * @return A list of brigades.
     */
    public List<Brigade> listByGameNationPosition(final Game thisGame, final Nation nation, final Position position) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Brigade.class);
        if (thisGame == null) {
            criteria.add(Restrictions.isNull("position.game"));
        } else {
            criteria.add(Restrictions.eq("position.game", thisGame));
        }

        criteria.add(Restrictions.eq("position.x", position.getX()));
        criteria.add(Restrictions.eq("position.y", position.getY()));
        criteria.add(Restrictions.eq("position.region", position.getRegion()));
        criteria.add(Restrictions.eq("nation", nation));
        return criteria.list();
    }

    /**
     * Listing all the free Brigades from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all free Brigades.
     */
    @SuppressWarnings("unchecked")
    public List<Brigade> listFreeByGameNation(final Game thisGame, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Brigade.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("nation", nation));
        criteria.add(Restrictions.or(Restrictions.eq("corp", 0), Restrictions.isNull("corp")));
        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("position.y"));
        return criteria.list();
    }

    /**
     * Listing all the free Brigades from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @param region   the region to select.
     * @return a list of all free Brigades.
     */
    @SuppressWarnings("unchecked")
    public List<Brigade> listFreeByGameNationRegion(final Game thisGame, final Nation nation, final Region region) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Brigade.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("nation", nation));
        criteria.add(Restrictions.eq("position.region", region));
        criteria.add(Restrictions.or(Restrictions.eq("corp", 0), Restrictions.isNull("corp")));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("position.y"));
        return criteria.list();
    }

    /**
     * Listing all the Brigades from the database at the specific position.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @param region   the region to select.
     * @return a list of all the Brigades.
     */
    @SuppressWarnings("unchecked")
    public List<Brigade> listGameNationRegion(final Game thisGame, final Nation nation, final Region region) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Brigade.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", region));
        criteria.add(Restrictions.eq("nation", nation));
        return criteria.list();
    }

    /**
     * Listing all the Brigades from the database members of the specific corp.
     *
     * @param thisGame the game to select.
     * @param corpId   the corp to select.
     * @return a list of all the Brigades.
     */
    @SuppressWarnings("unchecked")
    public List<Brigade> listByCorp(final Game thisGame, final int corpId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Brigade.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("corp", corpId));
        return criteria.list();
    }

    /**
     * Count the number of brigades in the 8 neighboring sectors of the given position based on their owner.
     *
     * @param thisPosition the position.
     * @return a mapping of brigade count to nations.
     */
    @SuppressWarnings("unchecked")
    public Map<Nation, BigInteger> countBrigadesByOwner(final Position thisPosition) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT NATION_ID, count(*) as TOT_BRIGADES " +
                "FROM `BRIGADES` " +
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
     * List all nations that have brigades in the given position.
     *
     * @param thisPosition the position.
     * @return a list of nations.
     */
    @SuppressWarnings("unchecked")
    public List<Nation> listOwners(final Position thisPosition) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT NATION_ID " +
                "FROM `BRIGADES` " +
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
     * Listing sectors with brigades belonging to more than 1 owner.
     *
     * @param thisGame the game to select.
     * @return a list of all the sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listMultiOwners(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT REGION_ID, x,y, count(distinct NATION_ID)" +
                " FROM `BRIGADES`" +
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
     * List all foreign armies located in a nations region.
     *
     * @param thisGame   the game to select.
     * @param thisNation the owner of the sectors.
     * @return list of foreign armies.
     */
    @SuppressWarnings("unchecked")
    public List<ForeignArmyDTO> listForeignArmies(final Game thisGame, final Nation thisNation) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT BRIGADES.REGION_ID, BRIGADES.x, BRIGADES.y, BRIGADES.NATION_ID, count(DISTINCT BRIGADES.BRIGADE_ID) as totBrigades, count(BATTALIONS.BATTALION_ID) as totBattalions " +
                "FROM BRIGADES, SECTORS, BATTALIONS " +
                "WHERE BRIGADES.GAME_ID = " + thisGame.getGameId() + " " +
                "AND SECTORS.NATION_ID = " + thisNation.getId() + " " +
                "AND BRIGADES.GAME_ID = `SECTORS`.GAME_ID " +
                "AND BRIGADES.REGION_ID = SECTORS.REGION_ID " +
                "AND BRIGADES.x = SECTORS.x " +
                "AND BRIGADES.y = SECTORS.y " +
                "AND BRIGADES.NATION_ID <> SECTORS.NATION_ID " +
                "AND BRIGADES.BRIGADE_ID = BATTALIONS.BRIGADE_ID " +
                "GROUP BY BRIGADES.REGION_ID, BRIGADES.x, BRIGADES.y, BRIGADES.NATION_ID";

        final List<Object[]> lstResults = session.createSQLQuery(thisQuery).list();

        // construct list
        final List<ForeignArmyDTO> theList = new ArrayList<ForeignArmyDTO>();

        // Iterate through results and populate map
        for (Object[] lstResult : lstResults) {
            final ForeignArmyDTO thisArmy = new ForeignArmyDTO();
            thisArmy.setRegionId((Integer) lstResult[0]);
            thisArmy.setX((Integer) lstResult[1]);
            thisArmy.setY((Integer) lstResult[2]);
            thisArmy.setNationId((Integer) lstResult[3]);
            thisArmy.setTotBrigades(((BigInteger) lstResult[4]).intValue());
            thisArmy.setTotBattalions(((BigInteger) lstResult[5]).intValue());

            theList.add(thisArmy);
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

}


package com.eaw1805.data.managers;

import com.eaw1805.data.constants.ArmyConstants;
import com.eaw1805.data.constants.OrderConstants;
import com.eaw1805.data.constants.ProductionSiteConstants;
import com.eaw1805.data.managers.beans.PlayerOrderManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.PlayerOrder;
import com.eaw1805.data.model.economy.TradeCity;
import com.eaw1805.data.model.fleet.Fleet;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * CRUD operations for PlayerOrder objects.
 */
public class PlayerOrderManager
        extends AbstractManager<PlayerOrder>
        implements PlayerOrderManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static PlayerOrderManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public) default
     * constructor.
     */
    public PlayerOrderManager() {
        // Does nothing
        super();
    }

    /**
     * PlayerOrderManager is loaded on the first execution of
     * PlayerOrderManager.getInstance() or the first access to
     * PlayerOrderManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static PlayerOrderManagerBean getInstance() {
        synchronized (PlayerOrderManager.class) {
            if (ourInstance == null) {
                ourInstance = new PlayerOrderManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final PlayerOrderManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the PlayerOrder from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public PlayerOrder getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PlayerOrder.class);
        criteria.add(Restrictions.eq("orderId", entityID));
        return (PlayerOrder) criteria.uniqueResult();
    }

    /**
     * Delete the input PlayerOrder from the database.
     *
     * @param order the PlayerOrder tha we want to delete
     */
    public void delete(final PlayerOrder order) {
        super.delete(order, order.getOrderId());
    }

    /**
     * delete orders of a particular game, nation and type.
     *
     * @param thisGame   the game to look up.
     * @param thisNation the nation to look up.
     * @param turnId     the turn to look up.
     * @param lstTypes   a list of all order types.
     */
    @SuppressWarnings("unchecked")
    public void deleteByGameNationType(final int thisGame, final int thisNation, final int turnId,
                                       final Object[] lstTypes) {
        final Session session = getSessionFactory().getCurrentSession();
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DELETE FROM `ORDERS` WHERE GAME_ID=");
        stringBuilder.append(thisGame);
        stringBuilder.append(" AND NATION_ID=");
        stringBuilder.append(thisNation);
        stringBuilder.append(" AND turn=");
        stringBuilder.append(turnId);
        stringBuilder.append(" AND type IN (");

        for (Object lstType : lstTypes) {
            stringBuilder.append(lstType);
            stringBuilder.append(",");
        }

        stringBuilder.replace(stringBuilder.length() - 1, stringBuilder.length(), ")");

        session.createSQLQuery(stringBuilder.toString()).executeUpdate();
    }

    /**
     * Listing all the Orders from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    public List<PlayerOrder> list() {
        return super.list(new PlayerOrder());
    }

    /**
     * looking for orders of a particular game.
     *
     * @param thisGame the game to look up.
     * @return a list of orders.
     */
    @SuppressWarnings("unchecked")
    public List<PlayerOrder> listByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PlayerOrder.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.eq("turn", thisGame.getTurn()));
        criteria.addOrder(Order.asc("type"));
        criteria.addOrder(Order.asc("position"));
        criteria.addOrder(Order.asc("orderId"));

        return criteria.list();
    }

    /**
     * looking for orders of a particular game, nation and type.
     *
     * @param thisGame   the game to look up.
     * @param thisNation the nation to look up.
     * @param turnId     the turn to look up.
     * @param lstTypes   a list of all order types.
     * @return a list of orders.
     */
    @SuppressWarnings("unchecked")
    public List<PlayerOrder> listByGameNationType(final Game thisGame, final Nation thisNation, final int turnId,
                                                  final Object[] lstTypes) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PlayerOrder.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.eq("turn", turnId));
        criteria.add(Restrictions.eq("nation", thisNation));
        criteria.add(Restrictions.in("type", lstTypes));
        criteria.addOrder(Order.asc("type"));
        criteria.addOrder(Order.asc("position"));
        criteria.addOrder(Order.asc("orderId"));

        return criteria.list();
    }

    /**
     * looking for orders of building class 3+ ships for a given game and turn.
     *
     * @param thisGame the game to look up.
     * @param turnId   the turn to look up.
     * @return a list of orders.
     */
    @SuppressWarnings("unchecked")
    public List<PlayerOrder> listByShipConstruction(final Game thisGame, final int turnId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PlayerOrder.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.le("turn", turnId - 1));
        criteria.add(Restrictions.ge("turn", turnId - 2));
        criteria.add(Restrictions.ge("result", 3));
        criteria.add(Restrictions.eq("type", OrderConstants.ORDER_B_SHIP));
        criteria.addOrder(Order.asc("procOrder"));
        criteria.addOrder(Order.asc("position"));
        criteria.addOrder(Order.asc("orderId"));

        return criteria.list();
    }


    public List<PlayerOrder> listByShipConstruction(final Game thisGame, final Nation thisNation, final int turnId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PlayerOrder.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.le("turn", turnId - 1));
        criteria.add(Restrictions.ge("turn", turnId - 2));
//        criteria.add(Restrictions.ge("result", 3));
        criteria.add(Restrictions.eq("type", OrderConstants.ORDER_B_SHIP));
        criteria.add(Restrictions.eq("nation", thisNation));
        criteria.addOrder(Order.asc("procOrder"));
        criteria.addOrder(Order.asc("position"));
        criteria.addOrder(Order.asc("orderId"));

        return criteria.list();
    }

    /**
     * looking for orders of a particular game and nation.
     *
     * @param thisGame   the game to look up.
     * @param thisNation the nation to look up.
     * @param turnId     the turn to look up.
     * @return a list of orders.
     */
    @SuppressWarnings("unchecked")
    public List<PlayerOrder> listByGameNation(final Game thisGame, final Nation thisNation, final int turnId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PlayerOrder.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.eq("turn", turnId));
        criteria.add(Restrictions.eq("nation", thisNation));
        criteria.addOrder(Order.asc("type"));
        criteria.addOrder(Order.asc("position"));
        criteria.addOrder(Order.asc("orderId"));

        return criteria.list();
    }

    /**
     * looking for relations orders of a particular game, nation and turn.
     *
     * @param thisGame     the game to look up.
     * @param thisNation   the nation to look up.
     * @param targetNation the nation to check for orders.
     * @return a list of orders.
     */
    @SuppressWarnings("unchecked")
    public List<PlayerOrder> listByRelations(final Game thisGame, final Nation thisNation, final Nation targetNation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PlayerOrder.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.ge("turn", thisGame.getTurn()));
        criteria.add(Restrictions.eq("nation", thisNation));
        criteria.add(Restrictions.eq("type", OrderConstants.ORDER_POLITICS));
        criteria.add(Restrictions.eq("parameter1", String.valueOf(targetNation.getId())));

        return criteria.list();
    }

    /**
     * looking for harsh taxation orders of a particular game, nation and turn.
     *
     * @param thisGame   the game to look up.
     * @param thisNation the nation to look up.
     * @param turnId     the turn to look up.
     * @return a list of orders.
     */
    @SuppressWarnings("unchecked")
    public List<PlayerOrder> listByTaxOrders(final Game thisGame, final Nation thisNation, final int turnId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PlayerOrder.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.ge("turn", turnId - 2));
        criteria.add(Restrictions.eq("nation", thisNation));
        criteria.add(Restrictions.eq("result", 1));
        criteria.add(Restrictions.eq("type", OrderConstants.ORDER_TAXATION));
        criteria.add(Restrictions.eq("parameter1", String.valueOf(OrderConstants.TAX_HARSH)));

        return criteria.list();
    }

    /**
     * looking for light/harsh taxation orders of a particular game, nation and turn.
     *
     * @param thisGame the game to look up.
     * @param turnId   the turn to look up.
     * @return a list of orders.
     */
    @SuppressWarnings("unchecked")
    public List<PlayerOrder> listTaxOrders(final Game thisGame, final int turnId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PlayerOrder.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.eq("turn", turnId));
        criteria.add(Restrictions.eq("type", OrderConstants.ORDER_TAXATION));
        criteria.add(Restrictions.eq("result", 1));

        return criteria.list();
    }

    /**
     * looking for 1st phase trading orders of a particular game, nation and turn.
     *
     * @param thisGame the game to look up.
     * @return a list of orders.
     */
    @SuppressWarnings("unchecked")
    public List<PlayerOrder> listTradeFirstOrders(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PlayerOrder.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.eq("turn", thisGame.getTurn()));
        criteria.add(Restrictions.eq("type", OrderConstants.ORDER_EXCHF));
        criteria.add(Restrictions.eq("result", 1));
        criteria.add(Restrictions.or(Restrictions.eq("parameter1", String.valueOf(ArmyConstants.TRADECITY)),
                Restrictions.eq("parameter3", String.valueOf(ArmyConstants.TRADECITY))));

        return criteria.list();
    }

    /**
     * looking for 1st phase trading orders of a particular game, nation and turn.
     *
     * @param thisGame the game to look up.
     * @return a list of orders.
     */
    @SuppressWarnings("unchecked")
    public List<PlayerOrder> listTradeSecondOrders(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PlayerOrder.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.eq("turn", thisGame.getTurn()));
        criteria.add(Restrictions.eq("type", OrderConstants.ORDER_EXCHS));
        criteria.add(Restrictions.eq("result", 1));
        criteria.add(Restrictions.or(Restrictions.eq("parameter1", String.valueOf(ArmyConstants.TRADECITY)),
                Restrictions.eq("parameter3", String.valueOf(ArmyConstants.TRADECITY))));

        return criteria.list();
    }

    /**
     * looking for trading orders of a particular game, nation, trade city and turn.
     *
     * @param thisCity the city of trade
     * @return a list of orders.
     */
    @SuppressWarnings("unchecked")
    public List<PlayerOrder> listTradeOrders(final TradeCity thisCity) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PlayerOrder.class);
        criteria.add(Restrictions.eq("game", thisCity.getPosition().getGame()));
        criteria.add(Restrictions.eq("turn", thisCity.getPosition().getGame().getTurn()));
        criteria.add(Restrictions.eq("result", 1));
        criteria.add(Restrictions.or(Restrictions.eq("type", OrderConstants.ORDER_EXCHF), Restrictions.eq("type", OrderConstants.ORDER_EXCHS)));

        final LogicalExpression first = Restrictions.and(Restrictions.eq("parameter1", String.valueOf(ArmyConstants.TRADECITY)), Restrictions.eq("parameter2", Integer.toString(thisCity.getCityId())));
        final LogicalExpression second = Restrictions.and(Restrictions.eq("parameter3", String.valueOf(ArmyConstants.TRADECITY)), Restrictions.eq("parameter4", Integer.toString(thisCity.getCityId())));
        criteria.add(Restrictions.or(first, second));

        return criteria.list();
    }

    /**
     * looking for transfer orders of a particular game and turn.
     *
     * @param thisGame the game to look up.
     * @return a list of orders.
     */
    @SuppressWarnings("unchecked")
    public List<PlayerOrder> listTransferOrders(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PlayerOrder.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.eq("turn", thisGame.getTurn()));
        criteria.add(Restrictions.eq("result", 1));
        criteria.add(Restrictions.or(Restrictions.eq("type", OrderConstants.ORDER_EXCHF), Restrictions.eq("type", OrderConstants.ORDER_EXCHS)));

        criteria.add(Restrictions.or(Restrictions.eq("parameter1", String.valueOf(ArmyConstants.BARRACK)), Restrictions.eq("parameter3", String.valueOf(ArmyConstants.BARRACK))));

        return criteria.list();
    }

    /**
     * looking for load/unload orders of a particular game, nation, fleet and turn.
     *
     * @param thisFleet the fleet trying to load/unload.
     * @return a list of orders.
     */
    @SuppressWarnings("unchecked")
    public List<PlayerOrder> listLoadUnloadOrders(final Fleet thisFleet) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PlayerOrder.class);
        criteria.add(Restrictions.eq("game", thisFleet.getPosition().getGame()));
        criteria.add(Restrictions.eq("turn", thisFleet.getPosition().getGame().getTurn()));
        criteria.add(Restrictions.eq("result", 1));
        criteria.add(Restrictions.or(Restrictions.or(Restrictions.eq("type", OrderConstants.ORDER_LOAD_TROOPSF), Restrictions.eq("type", OrderConstants.ORDER_LOAD_TROOPSS)),
                Restrictions.or(Restrictions.eq("type", OrderConstants.ORDER_UNLOAD_TROOPSF), Restrictions.eq("type", OrderConstants.ORDER_UNLOAD_TROOPSS))));

        final LogicalExpression first = Restrictions.and(Restrictions.eq("parameter1", String.valueOf(ArmyConstants.FLEET)), Restrictions.eq("parameter2", Integer.toString(thisFleet.getFleetId())));
        final LogicalExpression second = Restrictions.and(Restrictions.eq("parameter3", String.valueOf(ArmyConstants.FLEET)), Restrictions.eq("parameter4", Integer.toString(thisFleet.getFleetId())));
        criteria.add(Restrictions.or(first, second));

        return criteria.list();
    }

    /**
     * looking for build fortress orders of a particular game and turn.
     *
     * @param thisGame the game to look up.
     * @param turnId   the turn to look up.
     * @return a list of orders.
     */
    @SuppressWarnings("unchecked")
    public List<PlayerOrder> listBuildFortress(final Game thisGame, final int turnId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PlayerOrder.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.ge("turn", turnId));
        criteria.add(Restrictions.eq("result", 1));
        criteria.add(Restrictions.eq("type", OrderConstants.ORDER_B_PRODS));

        final String[] values = new String[4];
        values[0] = String.valueOf(ProductionSiteConstants.PS_BARRACKS_FS);
        values[1] = String.valueOf(ProductionSiteConstants.PS_BARRACKS_FM);
        values[2] = String.valueOf(ProductionSiteConstants.PS_BARRACKS_FL);
        values[3] = String.valueOf(ProductionSiteConstants.PS_BARRACKS_FH);

        final LogicalExpression r1 = Restrictions.or(Restrictions.eq("parameter2", values[0]), Restrictions.eq("parameter2", values[1]));
        final LogicalExpression r2 = Restrictions.or(Restrictions.eq("parameter2", values[2]), Restrictions.eq("parameter2", values[3]));

        final LogicalExpression rr = Restrictions.or(r1, r2);

        criteria.add(rr);

        return criteria.list();
    }

    /**
     * Count the number of orders issued for each game and turn.
     *
     * @return a mapping of a list of order counts per game.
     */
    @SuppressWarnings("unchecked")
    public Map<Object, List<BigInteger>> countOrders() {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT GAME_ID, turn, count(*) " +
                "FROM `ORDERS` " +
                "GROUP BY GAME_ID, turn ORDER BY GAME_ID, turn";

        final List<Object[]> lstResults = session.createSQLQuery(thisQuery).list();

        // construct map
        final Map<Object, List<BigInteger>> theMap = new HashMap<Object, List<BigInteger>>();

        // Iterate through results and populate map
        for (Object[] lstResult : lstResults) {
            List<BigInteger> thisGameStats;
            if (theMap.containsKey(lstResult[0])) {
                thisGameStats = theMap.get(lstResult[0]);
            } else {
                thisGameStats = new ArrayList<BigInteger>();
                theMap.put(lstResult[0], thisGameStats);
            }

            thisGameStats.add((BigInteger) lstResult[2]);
        }

        return theMap;
    }

    /**
     * Count the number of orders issued for each game, nation and turn.
     *
     * @return a mapping of a list of order counts per turn and nation.
     */
    @SuppressWarnings("unchecked")
    public Map<Integer, Map<Integer, BigInteger>> countGameOrders(final int gameId) {
        final Session session = getSessionFactory().getCurrentSession();

        // Retrieve count of player orders
        final String thisQuery = "SELECT turn, NATION_ID, count(*) " +
                "FROM ORDERS " +
                "WHERE GAME_ID=" + gameId + " " +
                "GROUP BY turn, NATION_ID ORDER BY turn, NATION_ID";

        final List<Object[]> lstResults = session.createSQLQuery(thisQuery).list();

        // construct map
        final Map<Integer, Map<Integer, BigInteger>> theMap = new HashMap<Integer, Map<Integer, BigInteger>>();

        // Iterate through results and populate map
        for (Object[] lstResult : lstResults) {
            final int turn = (Integer) lstResult[0];
            final int nation = (Integer) lstResult[1];

            final Map<Integer, BigInteger> turnStats;
            if (theMap.containsKey(turn)) {
                turnStats = theMap.get(turn);

            } else {
                turnStats = new HashMap<Integer, BigInteger>();
                theMap.put(turn, turnStats);
            }

            turnStats.put(nation, (BigInteger) lstResult[2]);
        }

        return theMap;
    }

    /**
     * Count the number of orders issued for each nation and turn.
     *
     * @return a mapping of a list of order counts per turn.
     */
    @SuppressWarnings("unchecked")
    public List<Long> countOrdersPerGameNation(final int gameId, final int nationId) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT turn, count(*) " +
                "FROM `ORDERS` WHERE GAME_ID=" + gameId + " AND NATION_ID=" + nationId + " " +
                "GROUP BY turn ORDER BY turn";

        final List<Object[]> stats = session.createSQLQuery(thisQuery).list();

        // Retrieve game info
        final Criteria criteria = session.createCriteria(Game.class);
        criteria.add(Restrictions.eq("gameId", gameId));
        final Game thisGame = (Game) criteria.uniqueResult();

        // initialize map
        final Map<Integer, BigInteger> turnStats = new HashMap<Integer, BigInteger>();
        for (int varTurn = 0; varTurn <= thisGame.getTurn(); varTurn++) {
            turnStats.put(varTurn, BigInteger.valueOf((long) 0));
        }

        // fill in values
        for (Object[] stat : stats) {
            turnStats.put((Integer) stat[0], (BigInteger) stat[1]);
        }

        final List<Long> completeStats = new ArrayList<Long>();
        for (BigInteger bigInteger : turnStats.values()) {
            completeStats.add(bigInteger.longValue());
        }

        return completeStats;
    }

    /**
     * Count the number of orders issued.
     *
     * @return order counts.
     */
    @SuppressWarnings("unchecked")
    public Object countOrdersPerGame(final int gameId) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT count(*) " +
                "FROM `ORDERS` WHERE GAME_ID=" + gameId +
                " GROUP BY GAME_ID";

        return session.createSQLQuery(thisQuery).uniqueResult();
    }

    /**
     * Result the outcome of the orders.
     *
     * @param gameId the game to look up.
     * @param turnId the turn to look up.
     */
    public void resetOrderResult(final int gameId, final int turnId) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "UPDATE ORDERS SET result= 0, explanation='' " +
                " WHERE GAME_ID = " + gameId + " AND TURN = " + turnId;

        session.createSQLQuery(thisQuery).executeUpdate();
    }

}

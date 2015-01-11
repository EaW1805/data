package com.eaw1805.data.managers;

import com.eaw1805.data.managers.beans.PaymentHistoryManagerBean;
import com.eaw1805.data.model.PaymentHistory;
import com.eaw1805.data.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * CRUD operations for PaymentHistory objects.
 */
public class PaymentHistoryManager extends AbstractManager<PaymentHistory>
        implements PaymentHistoryManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static PaymentHistoryManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public PaymentHistoryManager() {
        // Does nothing
        super();
    }

    /**
     * GameManager is loaded on the first execution of GameManager.getInstance()
     * or the first access to GameManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static PaymentHistoryManagerBean getInstance() {
        synchronized (PaymentHistoryManager.class) {
            if (ourInstance == null) {
                ourInstance = new PaymentHistoryManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final PaymentHistoryManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the User from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public PaymentHistory getByID(final int entityID) {
        return super.getByID(new PaymentHistory(), entityID);
    }

    /**
     * Delete the input UserGame from the database.
     *
     * @param paymentHistory the UserGame tha we want to delete
     */
    public void delete(final PaymentHistory paymentHistory) {
        super.delete(paymentHistory, paymentHistory.getPaymentHistoryId());
    }

    /**
     * Listing all the UserGames from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    public List<PaymentHistory> list() {
        return super.list(new PaymentHistory());
    }

    @SuppressWarnings("unchecked")
    public List<PaymentHistory> list(final User user) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PaymentHistory.class);
        criteria.add(Restrictions.eq("user", user))
                .addOrder(Order.desc("date"));
        return criteria.list();
    }

    /**
     * Total credits charged per each week of the year.
     *
     * @param chargeType the type of charges to summarize.
     * @return a mapping of credits charged to years/weeks.
     */
    @SuppressWarnings("unchecked")
    public Map<Integer, Map<Integer, Long>> chargesByWeek(final String chargeType) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT year( date ) , week( date ) , sum( abs( chargeBought + chargeFree + chargeTransferred ) ) " +
                "FROM `PAYMENT_HISTORY` " +
                "WHERE TYPE = \"" + chargeType + "\" " +
                "GROUP BY year( date ) , week( date )";

        final List<Object[]> lstResults = session.createSQLQuery(thisQuery).list();

        // construct map
        final Map<Integer, Map<Integer, Long>> theMap = new TreeMap<Integer, Map<Integer, Long>>();

        // Iterate through results and populate map
        for (Object[] lstResult : lstResults) {
            final int year = (Integer) lstResult[0];
            final int week = (Integer) lstResult[1];
            final long users = ((BigDecimal) lstResult[2]).longValue();
            final Map<Integer, Long> yearMap;
            if (!theMap.containsKey(year)) {
                yearMap = new TreeMap<Integer, Long>();
                theMap.put(year, yearMap);

            } else {
                yearMap = theMap.get(year);
            }

            yearMap.put(week, users);
        }

        return theMap;
    }

    /**
     * Total credits charged per each week of the year for games.
     *
     * @return a mapping of credits charged to years/weeks.
     */
    @SuppressWarnings("unchecked")
    public Map<Integer, Map<Integer, Long>> playerChargesByWeek(final String type) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT year, week, COUNT( * ) \n" +
                "FROM (\n" +
                "SELECT YEAR( DATE ) AS year, WEEK( DATE ) AS week, COUNT( * ) AS countRows\n" +
                "FROM  `PAYMENT_HISTORY` \n" +
                "WHERE  `type` LIKE  'game'\n" +
                "GROUP BY YEAR( DATE ) , WEEK( DATE ) , USER_ID\n" +
                ") AS t1\n" +
                "GROUP BY year, week";

        final List<Object[]> lstResults = session.createSQLQuery(thisQuery).list();

        // construct map
        final Map<Integer, Map<Integer, Long>> theMap = new TreeMap<Integer, Map<Integer, Long>>();

        // Iterate through results and populate map
        for (Object[] lstResult : lstResults) {
            final int year = (Integer) lstResult[0];
            final int week = (Integer) lstResult[1];
            final long users = ((BigInteger) lstResult[2]).longValue();
            final Map<Integer, Long> yearMap;
            if (!theMap.containsKey(year)) {
                yearMap = new TreeMap<Integer, Long>();
                theMap.put(year, yearMap);

            } else {
                yearMap = theMap.get(year);
            }

            yearMap.put(week, users);
        }

        return theMap;
    }

    /**
     * Deletes a users payment history.
     *
     * @param user The user to delete the payment history for.
     */
    public void delete(final User user) {
        final Session session = getSessionFactory().getCurrentSession();
        //delete paypal transactions
        String thisQuery = "DELETE " +
                "FROM `PAYPAL_TRANSACTION` WHERE PAYER_ID IN (SELECT PROFILE_ID FROM `PAYPAL_USER_PROFILE` WHERE USER_ID=" + user.getUserId() + ")";
        session.createSQLQuery(thisQuery).executeUpdate();
        //delete paypal profiles
        thisQuery = "DELETE " +
                "FROM `PAYPAL_USER_PROFILE` WHERE USER_ID=" + user.getUserId();
        session.createSQLQuery(thisQuery).executeUpdate();
        //delete payment history
        thisQuery = "DELETE " +
                "FROM `PAYMENT_HISTORY` WHERE USER_ID=" + user.getUserId();
        session.createSQLQuery(thisQuery).executeUpdate();
    }

}

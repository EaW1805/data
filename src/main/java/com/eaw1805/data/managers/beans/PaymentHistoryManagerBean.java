package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.PaymentHistory;
import com.eaw1805.data.model.User;

import java.util.List;
import java.util.Map;

/**
 * CRUD operations for PaymentHistory objects.
 */
public interface PaymentHistoryManagerBean extends EntityBean {
    /**
     * get the UserGame from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    PaymentHistory getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the PaymentHistory tha we want to add.
     */
    void add(final PaymentHistory value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the PaymentHistory tha we want to update.
     */
    void update(final PaymentHistory value);

    /**
     * Delete the input PaymentHistory from the database.
     *
     * @param entity the PaymentHistory tha we want to delete
     */
    void delete(PaymentHistory entity);

    /**
     * Listing all the UserGames from the database.
     *
     * @return a list of all the PaymentHistory that exist inside the table Avatar.
     */
    List<PaymentHistory> list();

    /**
     * Listing all the UserGames from the database for this particular user.
     *
     * @param user the particular user to examine.
     * @return a list of all the PaymentHistory that exist inside the table Avatar.
     */
    List<PaymentHistory> list(final User user);

    /**
     * Listing all the UserGames from the database for this particular user made during the current week.
     *
     * @param user the particular user to examine.
     * @return a list of all the PaymentHistory that exist inside the table Avatar.
     */
    List<PaymentHistory> listWeekly(final User user);

    /**
     * Total credits charged per each week of the year.
     *
     * @param chargeType the type of charges to summarize.
     * @return a mapping of credits charged to years/weeks.
     */
    Map<Integer, Map<Integer, Long>> chargesByWeek(final String chargeType);

    /**
     * Total credits charged per each week of the year for games.
     *
     * @return a mapping of credits charged to years/weeks.
     */
    Map<Integer, Map<Integer, Long>> playerChargesByWeek(final String type);

    void delete(final User user);
}

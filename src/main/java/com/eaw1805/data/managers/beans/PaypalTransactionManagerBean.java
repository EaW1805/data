package com.eaw1805.data.managers.beans;


import com.eaw1805.data.model.paypal.PaypalTransaction;
import com.eaw1805.data.model.paypal.PaypalUserProfile;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface PaypalTransactionManagerBean extends EntityBean {

    /**
     * get the Paypal Transaction from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    PaypalTransaction getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the PaypalTransaction that we want to add.
     */
    void add(final PaypalTransaction value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the PaypalTransaction tha we want to update.
     */
    void update(final PaypalTransaction value);

    /**
     * Delete the input PaypalTransaction from the database.
     *
     * @param entity the PaypalTransaction tha we want to delete
     */
    void delete(PaypalTransaction entity);

    /**
     * Listing all the PaypalTransaction from the database.
     *
     * @return a list of all the PaypalTransaction that exist inside the table Avatar.
     */
    List<PaypalTransaction> list();

    /**
     * get the Paypal Transaction from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    PaypalTransaction getByPayerID(PaypalUserProfile entityID);

    /**
     * get the Paypal Transaction from the database that corresponds to the input id.
     *
     * @param entityID the String of the Entity object.
     * @return an Entity object.
     */
    PaypalTransaction getByPaypalTransactionlID(String entityID);

}

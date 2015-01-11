package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.paypal.PaypalUserProfile;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface PaypalUserManagerBean extends EntityBean {

    /**
     * get the Paypal User Profile from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    PaypalUserProfile getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the PaypalUserProfile tha we want to add.
     */
    void add(final PaypalUserProfile value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the PaypalUserProfile tha we want to update.
     */
    void update(final PaypalUserProfile value);

    /**
     * Delete the input PaypalUserProfile from the database.
     *
     * @param entity the PaypalUserProfile tha we want to delete
     */
    void delete(PaypalUserProfile entity);

    /**
     * Listing all the PaypalUserProfiles from the database.
     *
     * @return a list of all the PaypalUserProfiles that exist inside the table Avatar.
     */
    List<PaypalUserProfile> list();

    /**
     * get the Paypal User Profile from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    PaypalUserProfile getByUserID(int entityID);

    /**
     * get the Paypal User Profile from the database that corresponds to the input id.
     *
     * @param entityID the String of the Entity object.
     * @return an Entity object.
     */
    PaypalUserProfile getByPaypalID(String entityID);
}


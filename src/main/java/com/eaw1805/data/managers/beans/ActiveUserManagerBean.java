package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.ActiveUser;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface ActiveUserManagerBean extends EntityBean {

    /**
     * get the ActiveUser from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    ActiveUser getByID(final int entityID);

    /**
     * get the ActiveUser from the database that corresponds to the input username.
     *
     * @param userName the username of the Entity object.
     * @return an Entity object.
     */
    ActiveUser getByUserName(final String userName);

    /**
     * Get the ActiveUser from the database that corresponds to the input session id.
     *
     * @param sessionID the session id.
     * @return an Entity object.
     */
    ActiveUser getBySessionId(final String sessionID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the ActiveUser tha we want to add.
     */
    void add(final ActiveUser value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the ActiveUser tha we want to update.
     */
    void update(final ActiveUser value);

    /**
     * Delete the input ActiveUser from the database.
     *
     * @param value the ActiveUser tha we want to delete.
     */
    void delete(final ActiveUser value);

    /**
     * Delete ActiveUser based on the session id..
     *
     * @param sessionId the session id of the user we want to delete.
     */
    void delete(final String sessionId);

    /**
     * Delete ActiveUser based on the username..
     *
     * @param username the username of the user we want to delete.
     */
    void deleteByUsername(final String username);

    /**
     * Listing all the ActiveUsers from the database.
     *
     * @return a list of all the ActiveUsers that exist inside the table.
     */
    List<ActiveUser> list();
}

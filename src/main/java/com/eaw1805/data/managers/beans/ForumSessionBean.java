package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.forum.ForumSessions;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface ForumSessionBean extends EntityBean {

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the ForumSessions tha we want to add.
     */
    void add(final ForumSessions value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the ForumSessions tha we want to update.
     */
    void update(final ForumSessions value);

    /**
     * Delete the input ForumSessions from the database.
     *
     * @param entity the ForumSessions tha we want to delete
     */
    void delete(ForumSessions entity);

    /**
     * Listing all the ForumSessions from the database.
     *
     * @return a list of all the ForumSessions that exist inside the table phpbb_sessions.
     */
    List<ForumSessions> list();

    /**
     * Delete the Session for the input user id.
     *
     * @param userID the user id.
     */
    void delete(int userID);

}

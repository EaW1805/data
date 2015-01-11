package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.PostMessage;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface PostMessageManagerBean extends EntityBean {

    /**
     * get the PostMessage from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    PostMessage getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the PostMessage tha we want to add.
     */
    void add(final PostMessage value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the PostMessage tha we want to update.
     */
    void update(final PostMessage value);

    /**
     * Delete the input PostMessage from the database.
     *
     * @param entity the PostMessage tha we want to delete
     */
    void delete(PostMessage entity);

    /**
     * Listing all the NationsPostMessage from the database.
     *
     * @return a list of all the NationsPostMessage that exist inside the table Avatar.
     */
    List<PostMessage> list();


    List<PostMessage> listByUser(final int userId);
}

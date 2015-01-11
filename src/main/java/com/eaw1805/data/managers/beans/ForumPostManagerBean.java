package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.User;
import com.eaw1805.data.model.forum.ForumPost;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface ForumPostManagerBean extends EntityBean {

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the ForumPost tha we want to add.
     */
    void add(final ForumPost value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the ForumPost tha we want to update.
     */
    void update(final ForumPost value);

    /**
     * Delete the input ForumPost from the database.
     *
     * @param entity the ForumPost tha we want to delete
     */
    void delete(ForumPost entity);

    /**
     * Listing all the ForumPost from the database.
     *
     * @return a list of all the ForumPost that exist inside the table phpbb_posts.
     */
    List<ForumPost> list();

    /**
     * Returning the number of Forum Posts for a specific user from the database.
     *
     * @param user the input user.
     * @return an int with the number of posts.
     */
    int getNumberOfPosts(User user);
}


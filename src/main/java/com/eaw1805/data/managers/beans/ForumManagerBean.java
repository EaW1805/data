package com.eaw1805.data.managers.beans;


import com.eaw1805.data.model.User;
import com.eaw1805.data.model.forum.Forum;

import java.util.List;

public interface ForumManagerBean extends EntityBean {

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Forum tha we want to add.
     */
    void add(final Forum value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Forum tha we want to update.
     */
    void update(final Forum value);

    /**
     * Delete the input Forum from the database.
     *
     * @param entity the Forum tha we want to delete
     */
    void delete(Forum entity);

    /**
     * Listing all the Forum from the database.
     *
     * @return a list of all the Forum that exist inside the table phpbb_posts.
     */
    List<Forum> list();

    /**
     * Get a forum by its forum id.
     *
     * @param forumId The forum to search for.
     * @return The forum.
     */
    Forum getById(int forumId);

    int getMaxRight();

    /**
     * This method updates the forum groups for a forum.
     *
     * @param forumId The id of the forum.
     */
    void updateForumGroups(int forumId);

    /**
     * Fix forums left and right id.
     *
     * @param forumId The new forum.
     * @param leftId The new forum left id.
     * @param rightId The new forum right id.
     */
    void updateLeftRightIds(int forumId, final int leftId, final int rightId);

    void reset(final User user);
}



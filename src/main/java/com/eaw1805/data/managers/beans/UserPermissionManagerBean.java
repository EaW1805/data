package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.User;
import com.eaw1805.data.model.forum.UserPermissions;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface UserPermissionManagerBean extends EntityBean {

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the UserPermission tha we want to add.
     */
    void add(final UserPermissions value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the UserPermission tha we want to update.
     */
    void update(final UserPermissions value);

    /**
     * Delete the input UserPermission from the database.
     *
     * @param entity the UserPermission tha we want to delete
     */
    void delete(UserPermissions entity);

    /**
     * Listing all the UserPermissions from the database.
     *
     * @return a list of all the UserPermissions that exist inside the table phpbb_acl_users.
     */
    List<UserPermissions> list();

    /**
     * Listing all the UserPermissions for a specific user from the database.
     *
     * @param user the input user.
     * @return a list of all the UserPermissions that exist inside the table phpbb_acl_users.
     */
    List<UserPermissions> list(User user);

    /**
     * Returning the UserPermission for a specific user and forum from the database.
     *
     * @param user    the input user.
     * @param forumId the forum id.
     * @return the UserPermission, if exists inside the table phpbb_acl_users.
     */
    UserPermissions getForumPermissions(User user, int forumId);

}


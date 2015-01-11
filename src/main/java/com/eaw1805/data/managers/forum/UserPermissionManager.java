package com.eaw1805.data.managers.forum;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.UserPermissionManagerBean;
import com.eaw1805.data.model.User;
import com.eaw1805.data.model.forum.UserPermissions;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for UserPermissions objects.
 */
public class UserPermissionManager extends AbstractManager<UserPermissions>
        implements UserPermissionManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static UserPermissionManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public) default constructor.
     */
    public UserPermissionManager() {
        // Does nothing
        super();
    }

    /**
     * GameManager is loaded on the first execution of UserPermissionManager.getInstance()
     * or the first access to UserPermissionManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static UserPermissionManagerBean getInstance() {
        synchronized (UserPermissionManager.class) {
            if (ourInstance == null) {
                ourInstance = new UserPermissionManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final UserPermissionManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * Delete the input UserPermission Entity from the database.
     *
     * @param userPermissions the UserPermission Entity that we want to delete
     */
    public void delete(final UserPermissions userPermissions) {
        super.delete(userPermissions, userPermissions.getId());
    }

    /**
     * Listing all the UserPermissions from the database.
     *
     * @return a list of all the UserPermissions that exist inside the table Users.
     */
    public List<UserPermissions> list() {
        return super.list(new UserPermissions());
    }

    /**
     * Listing all the UserPermissions for a specific user from the database.
     *
     * @param user the input user.
     * @return a list of all the UserPermissions that exist inside the table phpbb_acl_users.
     */
    @Override
    public List<UserPermissions> list(final User user) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserPermissions.class);
        criteria.add(Restrictions.eq("user", user));
        return criteria.list();
    }

    /**
     * Returning the UserPermission for a specific user and forum from the database.
     *
     * @param user    the input user.
     * @param forumId the forum id.
     * @return the UserPermission, if exists inside the table phpbb_acl_users.
     */
    @Override
    public UserPermissions getForumPermissions(final User user, final int forumId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserPermissions.class);
        criteria.add(Restrictions.eq("user", user));
        criteria.add(Restrictions.eq("forumId", forumId));
        return (UserPermissions) criteria.uniqueResult();
    }
}



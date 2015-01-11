package com.eaw1805.data.managers;

import com.eaw1805.data.managers.beans.ActiveUserManagerBean;
import com.eaw1805.data.model.ActiveUser;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for ActiveUser objects.
 */
public class ActiveUserManager
        extends AbstractManager<ActiveUser>
        implements ActiveUserManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static ActiveUserManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public ActiveUserManager() {
        // Does nothing
        super();
    }

    /**
     * GameManager is loaded on the first execution of ActiveUserManager.getInstance()
     * or the first access to ActiveUserManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static ActiveUserManagerBean getInstance() {
        synchronized (ActiveUserManager.class) {
            if (ourInstance == null) {
                ourInstance = new ActiveUserManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final ActiveUserManagerBean thisInstance) {
        ourInstance = thisInstance;
    }


    /**
     * get the ActiveUser from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public ActiveUser getByID(final int entityID) {
        return super.getByID(new com.eaw1805.data.model.ActiveUser(), entityID);
    }

    /**
     * get the ActiveUser from the database that corresponds to the input username.
     *
     * @param userName the username of the Entity object.
     * @return an Entity object.
     */
    public ActiveUser getByUserName(final String userName) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(ActiveUser.class);
        criteria.add(Restrictions.eq("username", userName));
        return (ActiveUser) criteria.uniqueResult();
    }

    /**
     * Get the ActiveUser from the database that corresponds to the input session id.
     *
     * @param sessionID the session id.
     * @return an Entity object.
     */
    public ActiveUser getBySessionId(final String sessionID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(ActiveUser.class);
        criteria.add(Restrictions.eq("sessionId", sessionID));
        return (ActiveUser) criteria.uniqueResult();
    }

    /**
     * Delete the input ActiveUser entry from the database.
     *
     * @param entry the ActiveUser entry tha we want to delete.
     */
    public void delete(final ActiveUser entry) {
        super.delete(entry, entry.getActiveUserId());
    }

    /**
     * Delete ActiveUser based on the session id..
     *
     * @param sessionId the session id of the user we want to delete.
     */
    public void delete(final String sessionId) {
        final Session session = getSessionFactory().getCurrentSession();
        session.createSQLQuery("DELETE FROM ACTIVE_USERS WHERE sessionId=\'" + sessionId + "\'")
                .executeUpdate();
    }

    /**
     * Delete ActiveUser based on the username.
     *
     * @param username the username of the user we want to delete.
     */
    public void deleteByUsername(final String username) {
        final Session session = getSessionFactory().getCurrentSession();
        session.createSQLQuery("DELETE FROM ACTIVE_USERS WHERE username=\'" + username + "\'")
                .executeUpdate();
    }

    /**
     * Listing all ActiveUser from the database.
     *
     * @return a list of all the ActiveUser entries that exist inside the table ActiveUser.
     */
    public List<ActiveUser> list() {
        return super.list(new com.eaw1805.data.model.ActiveUser());
    }

}

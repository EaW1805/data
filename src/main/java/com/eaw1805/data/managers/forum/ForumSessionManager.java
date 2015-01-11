package com.eaw1805.data.managers.forum;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.ForumSessionBean;
import com.eaw1805.data.model.forum.ForumSessions;
import org.hibernate.Session;

import java.util.List;

/**
 * CRUD operations for ForumSessions objects.
 */
public class ForumSessionManager extends AbstractManager<ForumSessions>
        implements ForumSessionBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static ForumSessionBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public) default constructor.
     */
    public ForumSessionManager() {
        // Does nothing
        super();
    }

    /**
     * ForumSessionsManager is loaded on the first execution of ForumSessionsManager.getInstance()
     * or the first access to ForumSessionsManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static ForumSessionBean getInstance() {
        synchronized (ForumSessionManager.class) {
            if (ourInstance == null) {
                ourInstance = new ForumSessionManager();
            }
        }

        return ourInstance;
    }

    /**
     * Delete the input ForumSessions from the database.
     *
     * @param entity the ForumSessions tha we want to delete
     */
    @Override
    public void delete(final ForumSessions entity) {
        final Session session = getSessionFactory().getCurrentSession();
        final Object entity2 = session.load(entity.getClass(), entity.getSessionId());
        session.delete(entity2);
    }

    /**
     * Listing all the ForumSessions from the database.
     *
     * @return a list of all the ForumSessions that exist inside the table phpbb_sessions.
     */
    @Override
    public List<ForumSessions> list() {
        return super.list(new ForumSessions());
    }

    /**
     * Delete the Session for the input user id.
     *
     * @param userID the user id.
     */
    public void delete(final int userID) {
        final Session session = getSessionFactory().getCurrentSession();
        session.createSQLQuery("DELETE FROM phpbb_sessions WHERE session_user_id=" + userID)
                .executeUpdate();
    }
}

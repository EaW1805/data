package com.eaw1805.data.managers;

import com.eaw1805.data.managers.beans.PostMessageManagerBean;
import com.eaw1805.data.model.PostMessage;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for PostMessage objects.
 */
public class PostMessageManager
        extends AbstractManager<PostMessage>
        implements PostMessageManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static PostMessageManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public)
     * default constructor.
     */
    public PostMessageManager() {
        // Does nothing
        super();
    }

    /**
     * PostMessageManager is loaded on the first execution of
     * PostMessageManager.getInstance() or the first access to
     * PostMessageManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static PostMessageManagerBean getInstance() {
        synchronized (PostMessageManager.class) {
            if (ourInstance == null) {
                ourInstance = new PostMessageManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final PostMessageManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the PostMessage from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public PostMessage getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PostMessage.class);
        criteria.add(Restrictions.eq("postMessageId", entityID));
        return (PostMessage) criteria.uniqueResult();
    }


    /**
     * Delete the input PostMessage from the database.
     *
     * @param relation the PostMessage tha we want to delete
     */
    public void delete(final PostMessage relation) {
        super.delete(relation, relation.getPostMessageId());
    }

    /**
     * Listing all the PostMessage from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    public List<PostMessage> list() {
        return super.list(new PostMessage());
    }

    public List<PostMessage> listByUser(final int userId) {
        Session session = getSessionFactory().getCurrentSession();
        Criteria criteria = session.createCriteria(PostMessage.class);
        criteria.add(Restrictions.eq("userId", userId));
        return criteria.list();
    }


}

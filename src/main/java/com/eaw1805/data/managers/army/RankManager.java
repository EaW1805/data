package com.eaw1805.data.managers.army;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.RankManagerBean;
import com.eaw1805.data.model.army.Rank;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for Rank objects.
 */
public class RankManager
        extends AbstractManager<Rank>
        implements RankManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static RankManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public RankManager() {
        // Does nothing
        super();
    }

    /**
     * RankManager is loaded on the first execution of
     * RankManager.getInstance() or the first access to
     * RankManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static RankManagerBean getInstance() {
        synchronized (RankManager.class) {
            if (ourInstance == null) {
                ourInstance = new RankManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final RankManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Rank from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public Rank getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Rank.class);
        criteria.add(Restrictions.eq("rankId", entityID));
        return (Rank)criteria.uniqueResult();
    }

    /**
     * get the Rank from the database that corresponds to the input name.
     *
     * @param entityName the name of the Entity object.
     * @return an Entity object.
     */
    public Rank getByName(final String entityName) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Rank.class);
        criteria.add(Restrictions.eq("name", entityName));

        return (Rank) criteria.uniqueResult();
    }

    /**
     * Delete the input entity from the database.
     *
     * @param entity the entity that we want to delete.
     */
    public void delete(final Rank entity) {
        super.delete(entity, entity.getRankId());
    }

    /**
     * Listing all the Ranks from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    public List<Rank> list() {
        return super.list(new Rank());
    }
}

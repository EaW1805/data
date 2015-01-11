package com.eaw1805.data.managers;

import com.eaw1805.data.managers.beans.NationManagerBean;
import com.eaw1805.data.model.Nation;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for Nation objects.
 */
public class NationManager
        extends com.eaw1805.data.managers.AbstractManager<Nation>
        implements NationManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static NationManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public) default
     * constructor.
     */
    protected NationManager() {
        // Does nothing
        super();
    }

    /**
     * NationManager is loaded on the first execution of
     * NationManager.getInstance() or the first access to
     * NationManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static NationManagerBean getInstance() {
        synchronized (NationManager.class) {
            if (ourInstance == null) {
                ourInstance = new NationManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final NationManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Nation from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public Nation getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Nation.class);
        criteria.add(Restrictions.eq("id", entityID));
        return (Nation)criteria.uniqueResult();
    }

    /**
     * Get all the nation from the database that corresponds to the input
     * terrain char-code.
     *
     * @param nationCode the terrain char-code.
     * @return an Entity object.
     */
    public Nation getByCode(final char nationCode) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Nation.class);
        criteria.add(Restrictions.eq("code", nationCode));

        return (Nation) criteria.uniqueResult();
    }

    /**
     * Delete the input Nation from the database.
     *
     * @param nation the nation tha we want to delete
     */
    //@TriggersRemove(cacheName = CONSTANT_CACHE, when = When.AFTER_METHOD_INVOCATION, removeAll = true)
    public void delete(final Nation nation) {
        super.delete(nation, nation.getId());
    }

    /**
     * Listing all the Nations from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    @SuppressWarnings("unchecked")
    public List<Nation> list() {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Nation.class);
        criteria.addOrder(Order.asc("id"));
        return criteria.list();
    }

    /**
     * Inserts an entry to the database with ID = -1.
     */
    public void addNegativeNationID() {
        final Session session = getSessionFactory().getCurrentSession();
        session.createSQLQuery("INSERT INTO TBL_NATIONS(NATION_ID, code, name, taxRate, politicalSphere, color, morale, vpInit, vpWin, cost) " +
                "VALUES(-1,'?', \"Free\", 0, \"?\", \"e8e8e8\", 0, 0, 0, 0);").executeUpdate();
    }

}

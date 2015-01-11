package com.eaw1805.data.managers.economy;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.GoodManagerBean;
import com.eaw1805.data.model.economy.Good;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Class responsible for the GRUD operations on the table GOODS.
 */
public class GoodManager
        extends AbstractManager<Good>
        implements GoodManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static GoodManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public) default
     * constructor.
     */
    public GoodManager() {
        // Does nothing
        super();
    }

    /**
     * GoodManager is loaded on the first execution of
     * GoodManager.getInstance() or the first access to
     * GoodManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static GoodManagerBean getInstance() {
        synchronized (GoodManager.class) {
            if (ourInstance == null) {
                ourInstance = new GoodManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final GoodManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * Get the good from the database that corresponds to the input id.
     *
     * @param entityID the id of the good object.
     * @return an Good object.
     */
    public Good getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Good.class);
        criteria.add(Restrictions.eq("goodId", entityID));
        return (Good)criteria.uniqueResult();
    }

    /**
     * Deletes the input good from the table Good.
     *
     * @param good the good that we want to delete.
     */
    public void delete(final Good good) {
        super.delete(good, good.getGoodId());
    }

    /**
     * Listing all the goods from the database.
     *
     * @return a list of all the goods that exist inside the table GOODS.
     */
    public List<Good> list() {
        return super.list(new Good());
    }

}

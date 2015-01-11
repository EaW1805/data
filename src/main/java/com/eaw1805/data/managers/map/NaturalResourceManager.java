package com.eaw1805.data.managers.map;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.NaturalResourceManagerBean;
import com.eaw1805.data.model.map.NaturalResource;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * GRUD operations for NaturalResource Object on NATURAL_RESOURCE table.
 */
public class NaturalResourceManager
        extends AbstractManager<NaturalResource>
        implements NaturalResourceManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static NaturalResourceManagerBean ourInstance = null;

    /**
     * Public constructor.
     */
    public NaturalResourceManager() {
        // Does nothing
        super();
    }

    /**
     * NaturalResourceManager is loaded on the first execution of
     * NaturalResourceManager.getInstance() or the first access to
     * NaturalResourceManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static NaturalResourceManagerBean getInstance() {
        synchronized (NaturalResourceManager.class) {
            if (ourInstance == null) {
                ourInstance = new NaturalResourceManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final NaturalResourceManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * Get the natural resource from the database that corresponds to the input
     * id.
     *
     * @param entityID the id of the natural resource object.
     * @return an NaturalResource object.
     */
    public NaturalResource getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(NaturalResource.class);
        criteria.add(Restrictions.eq("id", entityID));
        return (NaturalResource)criteria.uniqueResult();
    }

    /**
     * Get the natural resources from the database that corresponds to
     * the input natural resources char-code.
     *
     * @param param the natural resources char-code.
     * @return an NaturalResource object.
     */
    public NaturalResource getByCode(final char param) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(NaturalResource.class);
        criteria.add(Restrictions.eq("code", param));

        return (NaturalResource) criteria.uniqueResult();
    }

    /**
     * Deletes the input natural resource from the table NATURAL_RESOURCE.
     *
     * @param param the natural resource that we want to delete.
     */
    public void delete(final NaturalResource param) {
        super.delete(param, param.getId());
    }

    /**
     * Listing all the natural resources from the database.
     *
     * @return a list of all the natural resources that exist inside the table
     *         NATURAL_RESOURCE.
     */
    public List<NaturalResource> list() {
        return super.list(new NaturalResource());
    }

}

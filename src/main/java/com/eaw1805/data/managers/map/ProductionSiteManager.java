package com.eaw1805.data.managers.map;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.ProductionSiteManagerBean;
import com.eaw1805.data.model.map.ProductionSite;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * GRUD operations for ProductionSite Objects.
 */
public class ProductionSiteManager
        extends AbstractManager<ProductionSite>
        implements ProductionSiteManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static ProductionSiteManagerBean ourInstance = null;

    /**
     * public constructor.
     */
    public ProductionSiteManager() {
        // Does nothing
        super();
    }

    /**
     * ProductionSiteManager is loaded on the first execution of
     * ProductionSiteManager.getInstance() or the first access to
     * ProductionSiteManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static ProductionSiteManagerBean getInstance() {
        synchronized (ProductionSiteManager.class) {
            if (ourInstance == null) {
                ourInstance = new ProductionSiteManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final ProductionSiteManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * Get the natural resource from the database that corresponds to the input
     * id.
     *
     * @param entityID the id of the natural resource object.
     * @return an ProductionSite object.
     */
    public ProductionSite getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(ProductionSite.class);
        criteria.add(Restrictions.eq("id", entityID));
        return (ProductionSite)criteria.uniqueResult();
    }

    /**
     * Get the natural resources from the database that corresponds to
     * the input natural resources char-code.
     *
     * @param entity the natural resources char-code.
     * @return an ProductionSite object.
     */
    public ProductionSite getByCode(final char entity) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(ProductionSite.class);
        criteria.add(Restrictions.eq("code", entity));

        return (ProductionSite) criteria.uniqueResult();
    }

    /**
     * Deletes the input natural resource from the table NATURAL_RESOURCE.
     *
     * @param entity the natural resource that we want to delete.
     */
    public void delete(final ProductionSite entity) {
        super.delete(entity, entity.getId());
    }

    /**
     * Listing all the natural resources from the database.
     *
     * @return a list of all the natural resources that exist inside the table
     *         NATURAL_RESOURCE.
     */
    public List<ProductionSite> list() {
        return super.list(new ProductionSite());
    }

}

package com.eaw1805.data.managers.economy;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.WarehouseManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.economy.Warehouse;
import com.eaw1805.data.model.map.Region;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for warehouse objects.
 */
public class WarehouseManager
        extends AbstractManager<Warehouse>
        implements WarehouseManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static WarehouseManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public)
     * default constructor.
     */
    public WarehouseManager() {
        // Does nothing
        super();
    }

    /**
     * WarehouseManager is loaded on the first execution of
     * WarehouseManager.getInstance() or the first access to
     * WarehouseManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static WarehouseManagerBean getInstance() {
        synchronized (WarehouseManager.class) {
            if (ourInstance == null) {
                ourInstance = new WarehouseManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final WarehouseManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the warehouse from the database that corresponds to the input id.
     *
     * @param warehouseId the id of the warehouse object.
     * @return an warehouse object.
     */
    public Warehouse getByID(final int warehouseId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Warehouse.class);
        criteria.add(Restrictions.eq("id", warehouseId));
        return (Warehouse)criteria.uniqueResult();
    }

    /**
     * Delete the input warehouse from the database.
     *
     * @param warehouse the warehouse tha we want to delete
     */
    public void delete(final Warehouse warehouse) {
        super.delete(warehouse, warehouse.getId());
    }

    /**
     * Listing all the Warehouses from the database.
     *
     * @return a list of all the Warehouses.
     */
    public List<Warehouse> list() {
        return super.list(new Warehouse());
    }

    /**
     * Listing all the Warehouses from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Warehouses.
     */
    @SuppressWarnings("unchecked")
    public List<Warehouse> listByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Warehouse.class);
        criteria.add(Restrictions.eq("game", thisGame));

        return criteria.list();
    }

    /**
     * Listing all the Warehouses from the database for the specified game and nation.
     *
     * @param thisGame   the game to select.
     * @param thisNation the nation's warehouse.
     * @return a list of all the Warehouses.
     */
    @SuppressWarnings("unchecked")
    public List<Warehouse> listByGameNation(final Game thisGame,
                                            final Nation thisNation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Warehouse.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.eq("nation", thisNation));

        return criteria.list();
    }

    /**
     * Get the warehouses from the database that belongs to the specified
     * nation for the given region.
     *
     * @param thisGame   the game to select.
     * @param thisNation the nation's warehouse.
     * @param thisRegion the warehouse region.
     * @return a list of the nation's warehouses.
     */
    public Warehouse getByNationRegion(final Game thisGame,
                                       final Nation thisNation,
                                       final Region thisRegion) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Warehouse.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.eq("nation", thisNation));
        criteria.add(Restrictions.eq("region", thisRegion));

        return (Warehouse) criteria.uniqueResult();
    }

}

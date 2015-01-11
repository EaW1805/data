package com.eaw1805.data.managers.field;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.OrderManagerBean;
import com.eaw1805.data.model.battles.field.Order;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for Sector objects.
 */
public class FieldBattleOrderManager
        extends AbstractManager<Order>
        implements OrderManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static FieldBattleOrderManager ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public)
     * default constructor.
     */
    public FieldBattleOrderManager() {
        // Does nothing
        super();
    }

    /**
     * SectorManager is loaded on the first execution of
     * SectorManager.getInstance() or the first access to
     * SectorManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static FieldBattleOrderManager getInstance() {
        synchronized (FieldBattleOrderManager.class) {
            if (ourInstance == null) {
                ourInstance = new FieldBattleOrderManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final FieldBattleOrderManager thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Sector from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public Order getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Order.class);
        criteria.add(Restrictions.eq("id", entityID));
        return (Order)criteria.uniqueResult();
    }

    /**
     * Delete the input FieldBattleSector from the database.
     *
     * @param entity the FieldBattleSector that we want to delete
     */
    public void delete(final Order entity) {
        super.delete(entity, entity.getId());
    }

    /**
     * Listing all the Sectors from the database.
     *
     * @return a list of all the FieldBattleSectors that exist inside the table.
     */
    public List<Order> list() {
        return super.list(new Order());
    }
}

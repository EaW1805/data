package com.eaw1805.data.managers.fleet;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.ShipTypeManagerBean;
import com.eaw1805.data.model.fleet.ShipType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for ShipType objects.
 */
public class ShipTypeManager
        extends AbstractManager<ShipType>
        implements ShipTypeManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static ShipTypeManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public ShipTypeManager() {
        // Does nothing
        super();
    }

    /**
     * ShipTypeManager is loaded on the first execution of
     * ShipTypeManager.getInstance() or the first access to
     * ShipTypeManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static ShipTypeManagerBean getInstance() {
        synchronized (ShipTypeManager.class) {
            if (ourInstance == null) {
                ourInstance = new ShipTypeManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final ShipTypeManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the ShipType from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public ShipType getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(ShipType.class);
        criteria.add(Restrictions.eq("typeId", entityID));
        return (ShipType)criteria.uniqueResult();
    }

    /**
     * get the ShipType from the database that corresponds to the input type.
     *
     * @param entityType the type of the Entity object.
     * @return an Entity object.
     */
    public ShipType getByType(final int entityType) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(ShipType.class);
        criteria.add(Restrictions.eq("intId", entityType));

        return (ShipType) criteria.uniqueResult();
    }

    /**
     * Delete the input entity from the database.
     *
     * @param entity the entity that we want to delete.
     */
    public void delete(final ShipType entity) {
        super.delete(entity, entity.getTypeId());
    }

    /**
     * Listing all the ShipTypes from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    public List<ShipType> list() {
        return super.list(new ShipType());
    }

}

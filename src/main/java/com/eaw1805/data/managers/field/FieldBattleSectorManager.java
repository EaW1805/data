package com.eaw1805.data.managers.field;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.FieldBattleSectorManagerBean;
import com.eaw1805.data.model.battles.field.FieldBattleSector;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for Sector objects.
 */
public class FieldBattleSectorManager
        extends AbstractManager<FieldBattleSector>
        implements FieldBattleSectorManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static FieldBattleSectorManager ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public)
     * default constructor.
     */
    public FieldBattleSectorManager() {
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
    public static FieldBattleSectorManager getInstance() {
        synchronized (FieldBattleSectorManager.class) {
            if (ourInstance == null) {
                ourInstance = new FieldBattleSectorManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final FieldBattleSectorManager thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Sector from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public FieldBattleSector getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(FieldBattleSector.class);
        criteria.add(Restrictions.eq("id", entityID));
        return (FieldBattleSector)criteria.uniqueResult();
    }

    /**
     * Delete the input FieldBattleSector from the database.
     *
     * @param entity the FieldBattleSector that we want to delete
     */
    public void delete(final FieldBattleSector entity) {
        super.delete(entity, entity.getId());
    }

    /**
     * Listing all the Sectors from the database.
     *
     * @return a list of all the FieldBattleSectors that exist inside the table.
     */
    public List<FieldBattleSector> list() {
        return super.list(new FieldBattleSector());
    }
}

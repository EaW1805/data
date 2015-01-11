package com.eaw1805.data.managers.field;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.FieldBattleMapManagerBean;
import com.eaw1805.data.model.battles.field.FieldBattleMap;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for Sector objects.
 */
public class FieldBattleMapManager
        extends AbstractManager<FieldBattleMap>
        implements FieldBattleMapManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static FieldBattleMapManager ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public)
     * default constructor.
     */
    public FieldBattleMapManager() {
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
    public static FieldBattleMapManager getInstance() {
        synchronized (FieldBattleMapManager.class) {
            if (ourInstance == null) {
                ourInstance = new FieldBattleMapManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final FieldBattleMapManager thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Sector from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public FieldBattleMap getByID(final int entityID) {
        return super.getByID(new FieldBattleMap(), entityID);
    }

    /**
     * Delete the input FieldBattleSector from the database.
     *
     * @param entity the FieldBattleSector that we want to delete
     */
    public void delete(final FieldBattleMap entity) {
        super.delete(entity, entity.getId());
    }

    /**
     * Listing all the Sectors from the database.
     *
     * @return a list of all the FieldBattleSectors that exist inside the table.
     */
    public List<FieldBattleMap> list() {
        return super.list(new FieldBattleMap());
    }

    @Override
    public FieldBattleMap getByBattleID(int battleId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(FieldBattleMap.class);
        criteria.add(Restrictions.eq("battleId", battleId));
        return (FieldBattleMap) criteria.uniqueResult();
    }
}

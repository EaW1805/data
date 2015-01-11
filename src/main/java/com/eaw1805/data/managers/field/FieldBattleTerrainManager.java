package com.eaw1805.data.managers.field;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.FieldBattleTerrainManagerBean;
import com.eaw1805.data.model.battles.field.FieldBattleTerrain;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for FieldBattleTerrain objects.
 */
public class FieldBattleTerrainManager
        extends AbstractManager<FieldBattleTerrain>
        implements FieldBattleTerrainManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static FieldBattleTerrainManager ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public)
     * default constructor.
     */
    private FieldBattleTerrainManager() {
        // Does nothing
    }

    /**
     * FieldBattleTerrainManager is loaded on the first execution of
     * FieldBattleTerrainManager.getInstance() or the first access to
     * FieldBattleTerrainManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static FieldBattleTerrainManager getInstance() {
        synchronized (FieldBattleTerrainManager.class) {
            if (ourInstance == null) {
                ourInstance = new FieldBattleTerrainManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final FieldBattleTerrainManager thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the FieldBattleTerrain from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    @Override
    public FieldBattleTerrain getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(FieldBattleTerrain.class);
        criteria.add(Restrictions.eq("id", entityID));
        return (FieldBattleTerrain)criteria.uniqueResult();
    }

    /**
     * Delete the input FieldBattleTerrain from the database.
     *
     * @param entity the FieldBattleTerrain tha we want to delete
     */
    @Override
    public void delete(final FieldBattleTerrain entity) {
        super.delete(entity, entity.getId());
    }

    /**
     * Listing all the Terrains from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    @Override
    public List<FieldBattleTerrain> list() {
        return super.list(new FieldBattleTerrain());
    }

}

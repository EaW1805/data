package com.eaw1805.data.managers.field;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.FieldBattleMapExtraFeatureManagerBean;
import com.eaw1805.data.model.battles.field.FieldBattleMapExtraFeature;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for FieldBattleMapExtraFeature objects.
 */
public class FieldBattleMapExtraFeatureManager
        extends AbstractManager<FieldBattleMapExtraFeature>
        implements FieldBattleMapExtraFeatureManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static FieldBattleMapExtraFeatureManager ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public)
     * default constructor.
     */
    private FieldBattleMapExtraFeatureManager() {
        // Does nothing
    }

    /**
     * FieldBattleTerrainManager is loaded on the first execution of
     * FieldBattleTerrainManager.getInstance() or the first access to
     * FieldBattleTerrainManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static FieldBattleMapExtraFeatureManager getInstance() {
        synchronized (FieldBattleMapExtraFeatureManager.class) {
            if (ourInstance == null) {
                ourInstance = new FieldBattleMapExtraFeatureManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final FieldBattleMapExtraFeatureManager thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the FieldBattleMapExtraFeature from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    @Override
    public FieldBattleMapExtraFeature getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(FieldBattleMapExtraFeature.class);
        criteria.add(Restrictions.eq("id", entityID));
        return (FieldBattleMapExtraFeature)criteria.uniqueResult();
    }

    /**
     * Delete the input FieldBattleMapExtraFeature from the database.
     *
     * @param entity the FieldBattleMapExtraFeature tha we want to delete
     */
    @Override
    public void delete(final FieldBattleMapExtraFeature entity) {
        super.delete(entity, entity.getId());
    }

    /**
     * Listing all the Terrains from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    @Override
    public List<FieldBattleMapExtraFeature> list() {
        return super.list(new FieldBattleMapExtraFeature());
    }

}

package com.eaw1805.data.managers.map;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.TerrainManagerBean;
import com.eaw1805.data.model.map.Terrain;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for Terrain objects.
 */
public class TerrainManager
        extends AbstractManager<Terrain>
        implements TerrainManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static TerrainManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public)
     * default constructor.
     */
    public TerrainManager() {
        // Does nothing
        super();
    }

    /**
     * TerrainManager is loaded on the first execution of
     * TerrainManager.getInstance() or the first access to
     * TerrainManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static TerrainManagerBean getInstance() {
        synchronized (TerrainManager.class) {
            if (ourInstance == null) {
                ourInstance = new TerrainManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final TerrainManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Terrain from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    @Override
    public Terrain getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Terrain.class);
        criteria.add(Restrictions.eq("id", entityID));
        return (Terrain)criteria.uniqueResult();
    }

    /**
     * Delete the input Terrain from the database.
     *
     * @param entity the Terrain tha we want to delete
     */
    @Override
    public void delete(final Terrain entity) {
        super.delete(entity, entity.getId());
    }

    /**
     * Listing all the Terrains from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    @Override
    public List<Terrain> list() {
        return super.list(new Terrain());
    }

    /**
     * Get all the terrain(s) from the database that corresponds to the input
     * terrain char-code.
     *
     * @param terrainCode the terrain char-code.
     * @return a list of all the terrain(s) matching the code.
     */
    @Override
    public Terrain getByCode(final char terrainCode) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Terrain.class);
        criteria.add(Restrictions.eq("code", terrainCode));

        return (Terrain) criteria.uniqueResult();
    }

}

package com.eaw1805.data.managers.army;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.SpyManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.Spy;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Region;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for Spy objects.
 */
public class SpyManager
        extends AbstractManager<Spy>
        implements SpyManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static SpyManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public SpyManager() {
        // Does nothing
        super();
    }

    /**
     * SpyManager is loaded on the first execution of
     * SpyManager.getInstance() or the first access to
     * SpyManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static SpyManagerBean getInstance() {
        synchronized (SpyManager.class) {
            if (ourInstance == null) {
                ourInstance = new SpyManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final SpyManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Spy from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public Spy getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Spy.class);
        criteria.add(Restrictions.eq("spyId", entityID));
        return (Spy)criteria.uniqueResult();
    }

    /**
     * Delete the input entity from the database.
     *
     * @param entity the entity that we want to delete.
     */
    public void delete(final Spy entity) {
        super.delete(entity, entity.getSpyId());
    }

    /**
     * Listing all the Spies from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    public List<Spy> list() {
        return super.list(new Spy());
    }

    /**
     * Listing all the Spies from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Spies.
     */
    @SuppressWarnings("unchecked")
    public List<Spy> listByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Spy.class);
        criteria.add(Restrictions.eq("position.game", thisGame));

        return criteria.list();
    }

    /**
     * Listing all the Spies from the database at the specific position.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Spies.
     */
    @SuppressWarnings("unchecked")
    public List<Spy> listGameNation(final Game thisGame, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Spy.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("nation", nation));
        return criteria.list();
    }

    /**
     * Listing all the Spies from the database at the specific position.
     *
     * @param thisGame the game to select.
     * @param region   the region to select.
     * @param nation   the nation to select.
     * @return a list of all the Spies.
     */
    @SuppressWarnings("unchecked")
    public List<Spy> listGameRegionNation(final Game thisGame, final Region region, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Spy.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", region));
        criteria.add(Restrictions.eq("nation", nation));
        return criteria.list();
    }

    /**
     * List all Spies positioned at a given sector.
     *
     * @param thisPosition the position to check.
     * @return the list of Spies.
     */
    @SuppressWarnings("unchecked")
    public List<Spy> listAllByPosition(final Position thisPosition) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Spy.class);
        criteria.add(Restrictions.eq("position.game", thisPosition.getGame()));
        criteria.add(Restrictions.eq("position.region", thisPosition.getRegion()));
        criteria.add(Restrictions.eq("position.x", thisPosition.getX()));
        criteria.add(Restrictions.eq("position.y", thisPosition.getY()));
        return criteria.list();
    }
}

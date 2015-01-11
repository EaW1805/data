package com.eaw1805.data.managers.fleet;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.FleetManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.fleet.Fleet;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Region;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Manages for CRUD operations for the entity objects.
 */
public class FleetManager
        extends AbstractManager<Fleet>
        implements FleetManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static FleetManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public FleetManager() {
        // Does nothing
        super();
    }

    /**
     * FleetTypeManager is loaded on the first execution of
     * FleetTypeManager.getInstance() or the first access to
     * FleetTypeManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static FleetManagerBean getInstance() {
        synchronized (FleetManager.class) {
            if (ourInstance == null) {
                ourInstance = new FleetManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final FleetManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Fleet from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public Fleet getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Fleet.class);
        criteria.add(Restrictions.eq("fleetId", entityID));
        return (Fleet)criteria.uniqueResult();
    }

    /**
     * Delete the input Fleet from the database.
     *
     * @param value the Fleet tha we want to delete.
     */
    public void delete(final Fleet value) {
        super.delete(value, value.getFleetId());
    }

    /**
     * Listing all the Armies from the database.
     *
     * @return a list of all the Corps that exist inside the table.
     */
    public List<Fleet> list() {
        return super.list(new Fleet());
    }

    /**
     * Listing all the Armies from the database for a specific game.
     *
     * @param thisGame the game to select.
     * @return a list of all the Armies.
     */
    @SuppressWarnings("unchecked")
    public List<Fleet> listGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Fleet.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("position.y"));
        return criteria.list();
    }

    /**
     * Listing all the Armies from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Armies.
     */
    @SuppressWarnings("unchecked")
    public List<Fleet> listGameNation(final Game thisGame, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Fleet.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("nation", nation));
        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("position.y"));
        return criteria.list();
    }

    /**
     * Listing all the Fleets from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param region   the region to select.
     * @param nation   the nation to select.
     * @return a list of all the Fleets.
     */
    @SuppressWarnings("unchecked")
    public List<Fleet> listGameNationRegion(final Game thisGame, final Nation nation, final Region region) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Fleet.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("nation", nation));
        criteria.add(Restrictions.eq("position.region", region));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("position.y"));
        return criteria.list();
    }

    /**
     * List all fleets positioned at a given sector.
     *
     * @param thisPosition the position to check.
     * @return the list of fleets.
     */
    @SuppressWarnings("unchecked")
    public List<Fleet> listAllByPosition(final Position thisPosition) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Fleet.class);
        criteria.add(Restrictions.eq("position.game", thisPosition.getGame()));
        criteria.add(Restrictions.eq("position.region", thisPosition.getRegion()));
        criteria.add(Restrictions.eq("position.x", thisPosition.getX()));
        criteria.add(Restrictions.eq("position.y", thisPosition.getY()));
        return criteria.list();
    }

    public List<Fleet> listByGame(final Game game) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Fleet.class);
        criteria.add(Restrictions.eq("position.game", game));
        criteria.addOrder(Order.asc("nation"));
        return criteria.list();
    }

}

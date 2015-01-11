package com.eaw1805.data.managers.army;

import com.eaw1805.data.constants.RegionConstants;
import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.ArmyManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.Army;
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
public class ArmyManager
        extends AbstractManager<Army>
        implements ArmyManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static ArmyManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public ArmyManager() {
        // Does nothing
        super();
    }

    /**
     * ArmyTypeManager is loaded on the first execution of
     * ArmyTypeManager.getInstance() or the first access to
     * ArmyTypeManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static ArmyManagerBean getInstance() {
        synchronized (ArmyManager.class) {
            if (ourInstance == null) {
                ourInstance = new ArmyManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final ArmyManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Army from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public Army getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Army.class);
        criteria.add(Restrictions.eq("armyId", entityID));
        return (Army)criteria.uniqueResult();
    }

    /**
     * Delete the input Army from the database.
     *
     * @param value the Army tha we want to delete.
     */
    public void delete(final Army value) {
        super.delete(value, value.getArmyId());
    }

    /**
     * Listing all the Armies from the database.
     *
     * @return a list of all the Corps that exist inside the table.
     */
    public List<Army> list() {
        return super.list(new Army());
    }

    /**
     * Listing all the Armies from the database for a specific game.
     *
     * @param thisGame the game to select.
     * @return a list of all the Armies.
     */
    @SuppressWarnings("unchecked")
    public List<Army> listGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Army.class);
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
    public List<Army> listGameNation(final Game thisGame, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Army.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("nation", nation));
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
     * @param region   the region to select.
     * @return a list of all the Armies.
     */
    @SuppressWarnings("unchecked")
    public List<Army> listGameNationRegion(final Game thisGame, final Nation nation, final Region region) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Army.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("nation", nation));
        criteria.add(Restrictions.eq("position.region", region));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("position.y"));
        return criteria.list();
    }

    /**
     * Listing all the Armies from the database located in the colonies.
     *
     * @param thisGame the game to select.
     * @return a list of all the Armies.
     */
    @SuppressWarnings("unchecked")
    public List<Army> listColonies(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Region europe = (Region) session.get(Region.class, RegionConstants.EUROPE);
        final Criteria criteria = session.createCriteria(Army.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.ne("position.region", europe));
        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("position.y"));
        return criteria.list();
    }

    /**
     * List all Armies positioned at a given sector.
     *
     * @param thisPosition the position to check.
     * @return the list of Armies.
     */
    @SuppressWarnings("unchecked")
    public List<Army> listAllBySector(final Position thisPosition) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Army.class);
        criteria.add(Restrictions.eq("position.game", thisPosition.getGame()));
        criteria.add(Restrictions.eq("position.region", thisPosition.getRegion()));
        criteria.add(Restrictions.eq("position.x", thisPosition.getX()));
        criteria.add(Restrictions.eq("position.y", thisPosition.getY()));
        return criteria.list();
    }

}

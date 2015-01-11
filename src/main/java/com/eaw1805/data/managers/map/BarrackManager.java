package com.eaw1805.data.managers.map;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.BarrackManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.map.Barrack;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Region;
import com.eaw1805.data.model.map.Sector;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for Barrack objects.
 */
public class BarrackManager
        extends AbstractManager<Barrack>
        implements BarrackManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static BarrackManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public)
     * default constructor.
     */
    public BarrackManager() {
        // Does nothing
        super();
    }

    /**
     * BarrackManager is loaded on the first execution of
     * BarrackManager.getInstance() or the first access to
     * BarrackManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static BarrackManagerBean getInstance() {
        synchronized (BarrackManager.class) {
            if (ourInstance == null) {
                ourInstance = new BarrackManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final BarrackManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Barrack from the database that corresponds to the input id.
     *
     * @param BarrackId the id of the Barrack object.
     * @return an Barrack object.
     */
    public Barrack getByID(final int BarrackId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Barrack.class);
        criteria.add(Restrictions.eq("id", BarrackId));
        return (Barrack)criteria.uniqueResult();
    }

    /**
     * get the Barrack from the database that corresponds to the input position.
     *
     * @param position the Position of the Barrack object.
     * @return an Barrack object.
     */
    public Barrack getByPosition(final Position position) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Barrack.class);
        criteria.add(Restrictions.eq("position", position));

        return (Barrack) criteria.uniqueResult();
    }

    /**
     * get the Barrack from the database that corresponds to the input position.
     *
     * @param sector the Sector of the Barrack object.
     * @return an Barrack object.
     */
    public Barrack getBySector(final Sector sector) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Barrack.class);
        criteria.add(Restrictions.eq("position", sector.getPosition()));

        return (Barrack) criteria.uniqueResult();
    }

    /**
     * Delete the input Barrack from the database.
     *
     * @param Barrack the Barrack tha we want to delete
     */
    public void delete(final Barrack Barrack) {
        super.delete(Barrack, Barrack.getId());
    }

    /**
     * Listing all the Barracks from the database.
     *
     * @return a list of all the Barracks.
     */
    public List<Barrack> list() {
        return super.list(new Barrack());
    }

    /**
     * Listing all the Barracks from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Barracks.
     */
    @SuppressWarnings("unchecked")
    public List<Barrack> listByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Barrack.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));

        return criteria.list();
    }

    /**
     * Listing all the Barracks from the database for the specified game and nation.
     *
     * @param thisGame   the game to select.
     * @param thisNation the nation's Barrack.
     * @return a list of all the Barracks.
     */
    @SuppressWarnings("unchecked")
    public List<Barrack> listByGameNation(final Game thisGame,
                                          final Nation thisNation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Barrack.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("nation", thisNation));
        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("position.y"));
        return criteria.list();
    }

    /**
     * Get the Barracks from the database that belongs to the specified
     * nation for the given region.
     *
     * @param thisGame   the game to select.
     * @param thisNation the nation's Barrack.
     * @param thisRegion the Barrack region.
     * @return a list of the nation's Barracks.
     */
    public Barrack getByNationRegion(final Game thisGame,
                                     final Nation thisNation,
                                     final Region thisRegion) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Barrack.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", thisRegion));
        criteria.add(Restrictions.eq("nation", thisNation));
        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("position.y"));
        return (Barrack) criteria.uniqueResult();
    }

}

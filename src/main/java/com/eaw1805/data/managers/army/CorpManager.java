package com.eaw1805.data.managers.army;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.CorpManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.Commander;
import com.eaw1805.data.model.army.Corp;
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
public class CorpManager
        extends AbstractManager<Corp>
        implements CorpManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static CorpManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public CorpManager() {
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
    public static CorpManagerBean getInstance() {
        synchronized (CorpManager.class) {
            if (ourInstance == null) {
                ourInstance = new CorpManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final CorpManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Corp from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public Corp getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Corp.class);
        criteria.add(Restrictions.eq("corpId", entityID));
        return (Corp) criteria.uniqueResult();
    }

    /**
     * Delete the input Corp from the database.
     *
     * @param value the Corp tha we want to delete.
     */
    public void delete(final Corp value) {
        super.delete(value, value.getCorpId());
    }

    /**
     * Listing all the Corps from the database.
     *
     * @return a list of all the Corps that exist inside the table.
     */
    public List<Corp> list() {
        return super.list(new Corp());
    }

    /**
     * Listing all the Corps from the database for a specific game.
     *
     * @param thisGame the game to select.
     * @return a list of all the Corps.
     */
    @SuppressWarnings("unchecked")
    public List<Corp> listGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Corp.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        return criteria.list();
    }

    /**
     * Listing all the Corps from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Corps.
     */
    @SuppressWarnings("unchecked")
    public List<Corp> listGameNation(final Game thisGame, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Corp.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("nation", nation));
        return criteria.list();
    }

    public List<Corp> listFreeByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Corp.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.or(Restrictions.eq("army", 0), Restrictions.isNull("army")));
        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("position.y"));
        return criteria.list();
    }

    /**
     * Listing all the free Corps from the database owned by the specific nation..
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all free Corps.
     */
    @SuppressWarnings("unchecked")
    public List<Corp> listFreeByGameNation(final Game thisGame, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Corp.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("nation", nation));
        criteria.add(Restrictions.or(Restrictions.eq("army", 0), Restrictions.isNull("army")));
        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("position.y"));
        return criteria.list();
    }

    /**
     * Listing all the free Corps from the database owned by the specific nation..
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @param region   the region to select.
     * @return a list of all free Corps.
     */
    @SuppressWarnings("unchecked")
    public List<Corp> listFreeByGameNationRegion(final Game thisGame, final Nation nation, final Region region) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Corp.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("nation", nation));
        criteria.add(Restrictions.eq("position.region", region));
        criteria.add(Restrictions.or(Restrictions.eq("army", 0), Restrictions.isNull("army")));
        criteria.addOrder(Order.asc("position.x"));
        criteria.addOrder(Order.asc("position.y"));
        return criteria.list();
    }

    /**
     * Listing all Corps from the database members of the specific army.
     *
     * @param thisGame the game to select.
     * @param armyId   the army to select.
     * @return a list of all the Commanders.
     */
    @SuppressWarnings("unchecked")
    public List<Corp> listByArmy(final Game thisGame, final int armyId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Corp.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("army", armyId));
        return criteria.list();
    }

    /**
     * List all corps with a specific commander.
     *
     * @param commander The commander to get the corps.
     * @return The list of corps with the given commander.
     */
    @SuppressWarnings("unchecked")
    public List<Corp> listByCommander(final Game thisGame, final Commander commander) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Corp.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("commander", commander));
        return criteria.list();
    }

    /**
     * List all corps positioned at a given sector.
     *
     * @param thisPosition the position to check.
     * @return the list of corps.
     */
    @SuppressWarnings("unchecked")
    public List<Corp> listAllBySector(final Position thisPosition) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Corp.class);
        criteria.add(Restrictions.eq("position.game", thisPosition.getGame()));
        criteria.add(Restrictions.eq("position.region", thisPosition.getRegion()));
        criteria.add(Restrictions.eq("position.x", thisPosition.getX()));
        criteria.add(Restrictions.eq("position.y", thisPosition.getY()));
        criteria.add(Restrictions.or(Restrictions.eq("army", 0), Restrictions.isNull("army")));
        return criteria.list();
    }

}

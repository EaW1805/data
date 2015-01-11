package com.eaw1805.data.managers.army;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.CommanderManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.Commander;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.Region;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for Commander objects.
 */
public class CommanderManager
        extends AbstractManager<Commander>
        implements CommanderManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static CommanderManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public CommanderManager() {
        // Does nothing
        super();
    }

    /**
     * CommanderManager is loaded on the first execution of
     * CommanderManager.getInstance() or the first access to
     * CommanderManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static CommanderManagerBean getInstance() {
        synchronized (CommanderManager.class) {
            if (ourInstance == null) {
                ourInstance = new CommanderManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final CommanderManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Commander from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public Commander getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Commander.class);
        criteria.add(Restrictions.eq("id", entityID));
        return (Commander)criteria.uniqueResult();
    }

    /**
     * Delete the input entity from the database.
     *
     * @param entity the entity that we want to delete.
     */
    public void delete(final Commander entity) {
        super.delete(entity, entity.getId());
    }

    /**
     * Inserts an entry to the database with ID = -1.
     */
    public void addNegativeCommanderID() {
        final Session session = getSessionFactory().getCurrentSession();
        session.createSQLQuery("INSERT INTO COMMANDERS(COMMANDER_ID, NATION_ID, intId, x, y, REGION_ID, GAME_ID, RANK_ID, name, mps, comc, strc, corp, army, dead, pool, transit, inTransit, supreme, sick, carrierType, carrierId) " +
                "VALUES(-1, -1, 0, 0, 0, 1, -1, 1, \"Unknown\", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);").executeUpdate();
    }

    /**
     * Listing all the Commanders from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    public List<Commander> list() {
        return super.list(new Commander());
    }

    /**
     * Listing all the Commanders from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Commanders.
     */
    @SuppressWarnings("unchecked")
    public List<Commander> listByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Commander.class);
        criteria.add(Restrictions.eq("position.game", thisGame));

        return criteria.list();
    }

    public List<Commander> getByGameNationIntId(final Game thisGame, final Nation thisNation, final int intId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Commander.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("nation", thisNation));
        criteria.add(Restrictions.eq("intId", intId));
        criteria.addOrder(Order.asc("intId"));
        return criteria.list();
    }

    /**
     * Listing all the Commanders from the database members of the specific corp.
     *
     * @param thisGame the game to select.
     * @param corpId   the corp to select.
     * @return a list of all the Commanders.
     */
    @SuppressWarnings("unchecked")
    public List<Commander> listByCorp(final Game thisGame, final int corpId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Commander.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("corp", corpId));
        criteria.addOrder(Order.asc("intId"));
        return criteria.list();
    }

    /**
     * Listing all the Commanders from the database members of the specific army.
     *
     * @param thisGame the game to select.
     * @param armyId   the army to select.
     * @return a list of all the Commanders.
     */
    @SuppressWarnings("unchecked")
    public List<Commander> listByArmy(final Game thisGame, final int armyId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Commander.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("army", armyId));
        criteria.addOrder(Order.asc("intId"));
        return criteria.list();
    }

    /**
     * Listing all the Commanders from the database at the specific position.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Commanders.
     */
    @SuppressWarnings("unchecked")
    public List<Commander> listGameNation(final Game thisGame, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Commander.class);
        if (thisGame == null) {
            criteria.add(Restrictions.isNull("position.game"));
        } else {
            criteria.add(Restrictions.eq("position.game", thisGame));
        }
        criteria.add(Restrictions.eq("nation", nation));
        criteria.addOrder(Order.asc("intId"));
        return criteria.list();
    }

    /**
     * Listing all the alive Commanders from the database at the specific position.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the Commanders.
     */
    @SuppressWarnings("unchecked")
    public List<Commander> listGameNationAlive(final Game thisGame, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Commander.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("nation", nation));
        criteria.add(Restrictions.eq("dead", false));
        criteria.addOrder(Order.asc("intId"));
        return criteria.list();
    }

    /**
     * Listing all the Commanders from the database at the specific position.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @param region   the region to select.
     * @return a list of all the Commanders.
     */
    @SuppressWarnings("unchecked")
    public List<Commander> listGameNationRegion(final Game thisGame, final Nation nation, final Region region) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Commander.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", region));
        criteria.add(Restrictions.eq("nation", nation));
        criteria.addOrder(Order.asc("intId"));
        return criteria.list();
    }

    /**
     * Listing all the Commanders from the database at the specific position owned by the specific nation.
     *
     * @param thisPosition the position to select.
     * @param nation       the nation to select.
     * @return a list of all the Commanders.
     */
    @SuppressWarnings("unchecked")
    public List<Commander> listByPositionNation(final Position thisPosition, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Commander.class);
        criteria.add(Restrictions.eq("nation", nation));
        if (thisPosition.getGame() == null) {
            criteria.add(Restrictions.isNull("position.game"));
        } else {
            criteria.add(Restrictions.eq("position.game", thisPosition.getGame()));
        }

        criteria.add(Restrictions.eq("position.region", thisPosition.getRegion()));
        criteria.add(Restrictions.eq("position.x", thisPosition.getX()));
        criteria.add(Restrictions.eq("position.y", thisPosition.getY()));
        criteria.addOrder(Order.asc("intId"));
        return criteria.list();
    }

    /**
     * List all Commanders positioned at a given sector.
     *
     * @param thisPosition the position to check.
     * @return the list of Commanders.
     */
    @SuppressWarnings("unchecked")
    public List<Commander> listAllByPosition(final Position thisPosition) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Commander.class);
        criteria.add(Restrictions.eq("position.game", thisPosition.getGame()));
        criteria.add(Restrictions.eq("position.region", thisPosition.getRegion()));
        criteria.add(Restrictions.eq("position.x", thisPosition.getX()));
        criteria.add(Restrictions.eq("position.y", thisPosition.getY()));
        return criteria.list();
    }

    public List<Commander> listCapturedByGameNation(final Game thisGame, final Nation thisNation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Commander.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.ne("nation", thisNation));
        criteria.add(Restrictions.eq("captured", thisNation));
        return criteria.list();
    }

}

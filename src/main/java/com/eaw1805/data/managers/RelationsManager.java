package com.eaw1805.data.managers;

import com.eaw1805.data.constants.RelationConstants;
import com.eaw1805.data.managers.beans.RelationsManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.NationsRelation;
import org.apache.logging.log4j.*;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for NationsRelation objects.
 */
public class RelationsManager
        extends AbstractManager<NationsRelation>
        implements RelationsManagerBean {

    /**
     * a log4j logger to print messages.
     */
    private static final Logger LOGGER = LogManager.getLogger(RelationsManager.class);

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static RelationsManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public)
     * default constructor.
     */
    public RelationsManager() {
        // Does nothing
        super();
    }

    /**
     * RelationsManager is loaded on the first execution of
     * RelationsManager.getInstance() or the first access to
     * RelationsManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static RelationsManagerBean getInstance() {
        synchronized (RelationsManager.class) {
            if (ourInstance == null) {
                ourInstance = new RelationsManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final RelationsManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the NationsRelation from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public NationsRelation getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(NationsRelation.class);
        criteria.add(Restrictions.eq("id", entityID));
        return (NationsRelation)criteria.uniqueResult();
    }

    /**
     * Get the Report from the database that corresponds to the input
     * parameters.
     *
     * @param game   the Game of the Report object.
     * @param owner  the Owner of the Report object.
     * @param target the Target of the Report object.
     * @return an Entity object.
     */
    public NationsRelation getByNations(final Game game, final Nation owner, final Nation target) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(NationsRelation.class);
        criteria.add(Restrictions.eq("game", game));
        criteria.add(Restrictions.eq("nation", owner));
        criteria.add(Restrictions.eq("target", target));

        return (NationsRelation) criteria.uniqueResult();
    }

    /**
     * Get the Report from the database that corresponds to the input
     * parameters.
     *
     * @param game   the Game of the Report object.
     * @param owner  the Owner of the Report object.
     * @param target the Target of the Report object.
     * @return an Entity object.
     */
    public NationsRelation getByNations(final Game game, final int owner, final int target) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(NationsRelation.class);
        criteria.add(Restrictions.eq("game", game));
        criteria.add(Restrictions.eq("nation.id", owner));
        criteria.add(Restrictions.eq("target.id", target));
        final NationsRelation result = (NationsRelation) criteria.uniqueResult();

        if (result == null) {
            LOGGER.error("session =" + session.toString());
            LOGGER.error(session);
        }

        return result;
    }

    /**
     * Delete the input NationsRelation from the database.
     *
     * @param relation the NationsRelation tha we want to delete
     */
    public void delete(final NationsRelation relation) {
        super.delete(relation, relation.getId());
    }

    /**
     * Listing all the Relations from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    public List<NationsRelation> list() {
        return super.list(new NationsRelation());
    }

    /**
     * Listing all the NationsRelations from the database for a particular game.
     *
     * @param thisGame the game to select.
     * @return a list of all the NationsRelations.
     */
    @SuppressWarnings("unchecked")
    public List<NationsRelation> listByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(NationsRelation.class);
        criteria.add(Restrictions.eq("game", thisGame));

        return criteria.list();
    }

    /**
     * Listing all the NationsRelations from the database for a particular game and nation.
     *
     * @param thisGame the game to select.
     * @param owner    the Owner of the Report object.
     * @return a list of all the NationsRelations.
     */
    @SuppressWarnings("unchecked")
    public List<NationsRelation> listByGameNation(final Game thisGame, final Nation owner) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(NationsRelation.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.eq("nation", owner));
        criteria.addOrder(Order.asc("target.id"));

        return criteria.list();
    }

    /**
     * Listing all allied Nations from the database for a particular game and nation.
     *
     * @param thisGame the game to select.
     * @param owner    the Owner of the Report object.
     * @return a list of all the NationsRelations.
     */
    @SuppressWarnings("unchecked")
    public List<NationsRelation> listAlliesByGameNation(final Game thisGame, final Nation owner) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(NationsRelation.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.eq("nation", owner));
        criteria.add(Restrictions.eq("relation", RelationConstants.REL_ALLIANCE));

        return criteria.list();
    }

}

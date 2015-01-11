package com.eaw1805.data.managers.economy;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.BaggageTrainManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.economy.BaggageTrain;
import com.eaw1805.data.model.map.Position;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for BaggageTrain objects.
 */
public class BaggageTrainManager
        extends AbstractManager<BaggageTrain>
        implements BaggageTrainManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static BaggageTrainManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public BaggageTrainManager() {
        // Does nothing
        super();
    }

    /**
     * BaggageTrainManager is loaded on the first execution of
     * BaggageTrainManager.getInstance() or the first access to
     * BaggageTrainManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static BaggageTrainManagerBean getInstance() {
        synchronized (BaggageTrainManager.class) {
            if (ourInstance == null) {
                ourInstance = new BaggageTrainManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final BaggageTrainManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the BaggageTrain from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public BaggageTrain getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(BaggageTrain.class);
        criteria.add(Restrictions.eq("baggageTrainId", entityID));
        return (BaggageTrain)criteria.uniqueResult();
    }

    /**
     * Delete the input entity from the database.
     *
     * @param entity the entity that we want to delete.
     */
    public void delete(final BaggageTrain entity) {
        super.delete(entity, entity.getBaggageTrainId());
    }

    /**
     * Listing all the Spies from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    public List<BaggageTrain> list() {
        return super.list(new BaggageTrain());
    }

    /**
     * Listing all the Spies from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Spies.
     */
    @SuppressWarnings("unchecked")
    public List<BaggageTrain> listByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(BaggageTrain.class);
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
    public List<BaggageTrain> listGameNation(final Game thisGame, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(BaggageTrain.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("nation", nation));
        return criteria.list();
    }

    /**
     * List all baggage trains positioned at a given sector.
     *
     * @param thisPosition the position to check.
     * @return the list of baggage trains.
     */
    @SuppressWarnings("unchecked")
    public List<BaggageTrain> listAllByPosition(final Position thisPosition) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(BaggageTrain.class);
        criteria.add(Restrictions.eq("position.game", thisPosition.getGame()));
        criteria.add(Restrictions.eq("position.region", thisPosition.getRegion()));
        criteria.add(Restrictions.eq("position.x", thisPosition.getX()));
        criteria.add(Restrictions.eq("position.y", thisPosition.getY()));
        return criteria.list();
    }

    /**
     * Listing all the trains from the database at the specific position owned by the specific nation.
     *
     * @param thisPosition the position to select.
     * @param nation       the nation to select.
     * @return a list of all the trains.
     */
    @SuppressWarnings("unchecked")
    public List<BaggageTrain> listByPositionNation(final Position thisPosition, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(BaggageTrain.class);
        criteria.add(Restrictions.eq("nation", nation));
        criteria.add(Restrictions.eq("position.game", thisPosition.getGame()));
        criteria.add(Restrictions.eq("position.region", thisPosition.getRegion()));
        criteria.add(Restrictions.eq("position.x", thisPosition.getX()));
        criteria.add(Restrictions.eq("position.y", thisPosition.getY()));
        return criteria.list();
    }
}

package com.eaw1805.data.managers.field;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.UserFieldBattleManagerBean;
import com.eaw1805.data.model.battles.field.UserFieldBattle;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for UserFieldBattle objects.
 */
public class UserFieldBattleManager
        extends AbstractManager<UserFieldBattle>
        implements UserFieldBattleManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static UserFieldBattleManager ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public)
     * default constructor.
     */
    private UserFieldBattleManager() {
        // Does nothing
    }

    /**
     * UserFieldBattleManager is loaded on the first execution of
     * UserFieldBattleManager.getInstance() or the first access to
     * UserFieldBattleManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static UserFieldBattleManager getInstance() {
        synchronized (UserFieldBattleManager.class) {
            if (ourInstance == null) {
                ourInstance = new UserFieldBattleManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final UserFieldBattleManager thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the UserFieldBattle from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    @Override
    public UserFieldBattle getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserFieldBattle.class);
        criteria.add(Restrictions.eq("id", entityID));
        return (UserFieldBattle)criteria.uniqueResult();
    }

    /**
     * Delete the input UserFieldBattle from the database.
     *
     * @param entity the UserFieldBattle tha we want to delete
     */
    @Override
    public void delete(final UserFieldBattle entity) {
        super.delete(entity, entity.getUserFieldBattleId());
    }

    /**
     * Listing all the Terrains from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    @Override
    public List<UserFieldBattle> list() {
        return super.list(new UserFieldBattle());
    }

    public UserFieldBattle getByBattleNation(final int battleId, final int nationId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserFieldBattle.class);
        criteria.add(Restrictions.eq("battleId", battleId));
        criteria.add(Restrictions.eq("nationId", nationId));
        List<UserFieldBattle> result = criteria.list();
        if (result.isEmpty()) {
            return null;
        } else {
            return result.get(0);
        }
    }

    public List<UserFieldBattle> listByBattleId(final int battleId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserFieldBattle.class);
        criteria.add(Restrictions.eq("battleId", battleId));
        return criteria.list();
    }

    public List<UserFieldBattle> listByUser(final int userId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserFieldBattle.class);
        criteria.add(Restrictions.eq("userId", userId));
        return criteria.list();
    }

    /**
     * Get user field battle for a battle and user.
     *
     * @param battleId The battle.
     * @param userId The user.
     * @return A user field battle object.
     */
    public UserFieldBattle getByBattleUser(final int battleId, final int userId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserFieldBattle.class);
        criteria.add(Restrictions.eq("userId", userId));
        criteria.add(Restrictions.eq("battleId", battleId));
        List<UserFieldBattle> userField = criteria.list();
        if (userField.isEmpty()) {
            return null;
        }
        return userField.get(0);
    }

    /**
     * Get all pending fieldbattles for current user.
     *
     * @param facebookId The facebook id for this user.
     * @return A list of pending user fieldbattles.
     */
    public List<UserFieldBattle> listPending(final String facebookId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(UserFieldBattle.class);
        criteria.add(Restrictions.eq("facebookId", facebookId));
        criteria.add(Restrictions.eq("userId", 2));
        return criteria.list();
    }
}

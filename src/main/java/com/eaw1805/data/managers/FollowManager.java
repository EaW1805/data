package com.eaw1805.data.managers;

import com.eaw1805.data.managers.beans.FollowManagerBean;
import com.eaw1805.data.model.Follow;
import com.eaw1805.data.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations related to following players / followers of a player.
 */
public class FollowManager
        extends AbstractManager<Follow>
        implements FollowManagerBean {
    /**
     * static instance(ourInstance) initialized as null.
     */
    private static FollowManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public) default constructor.
     */
    public FollowManager() {
        // Does nothing
        super();
    }

    /**
     * GameManager is loaded on the first execution of GameManager.getInstance()
     * or the first access to GameManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static FollowManagerBean getInstance() {
        synchronized (FollowManager.class) {
            if (ourInstance == null) {
                ourInstance = new FollowManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final FollowManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the User from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public Follow getByID(final int entityID) {
        return super.getByID(new Follow(), entityID);
    }


    /**
     * Delete the input User from the database.
     *
     * @param follow the user tha we want to delete
     */
    public void delete(final Follow follow) {
        super.delete(follow, follow.getFollowId());
    }

    /**
     * Listing all the Users from the database.
     *
     * @return a list of all the Avatars that exist inside the table Users.
     */
    public List<Follow> list() {
        return super.list(new Follow());
    }

    /**
     * Listing all follows by the person being followed.
     *
     * @param user         the user to inspect.
     * @param sortByFollower to sort the entries by the name of the follower, or by the ID of the entry.
     * @return a list of follow objects matching the criteria.
     */
    @SuppressWarnings("unchecked")
    public List<Follow> listByLeader(final User user, final boolean sortByFollower) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Follow.class);
        criteria.add(Restrictions.eq("leader", user));
        if (sortByFollower) {
            criteria.addOrder(Order.asc("follower"));

        } else {
            criteria.addOrder(Order.desc("followId"));
        }
        return criteria.list();
    }

    /**
     * Listing all follows by follower.
     *
     * @param user         the user to inspect.
     * @param sortByLeader to sort the entries by the name of the leader, or by the ID of the entry.
     * @return a list of follow objects matching the criteria.
     */
    @SuppressWarnings("unchecked")
    public List<Follow> listByFollower(final User user, final boolean sortByLeader) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Follow.class);
        criteria.add(Restrictions.eq("follower", user));
        if (sortByLeader) {
            criteria.addOrder(Order.asc("leader"));

        } else {
            criteria.addOrder(Order.desc("followId"));
        }

        return criteria.list();
    }

    /**
     * Identify a leader/follower relation.
     *
     * @param leader   the user object that is leading.
     * @param follower the user object that is following.
     * @return the Follow object matching the criteria.
     */
    @SuppressWarnings("unchecked")
    public List<Follow> getByLeaderFollower(final User leader, final User follower) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Follow.class);
        criteria.add(Restrictions.eq("leader", leader));
        criteria.add(Restrictions.eq("follower", follower));
        return criteria.list();
    }

    public void delete(final User user) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "DELETE " +
                "FROM `FOLLOWS` WHERE LEADER_ID=" + user.getUserId() +
                " OR FOLLOWER_ID=" + user.getUserId();

        session.createSQLQuery(thisQuery).executeUpdate();
    }

}

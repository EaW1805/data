package com.eaw1805.data.managers;

import com.eaw1805.data.constants.ProfileConstants;
import com.eaw1805.data.managers.beans.ProfileManagerBean;
import com.eaw1805.data.model.Profile;
import com.eaw1805.data.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * CRUD operations for Player Profile entries.
 */
public class ProfileManager
        extends AbstractManager<Profile>
        implements ProfileManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static ProfileManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public)
     * default constructor.
     */
    public ProfileManager() {
        // Does nothing
        super();
    }

    /**
     * ReportManager is loaded on the first execution of
     * ReportManager.getInstance() or the first access to
     * ReportManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static ProfileManagerBean getInstance() {
        synchronized (ProfileManager.class) {
            if (ourInstance == null) {
                ourInstance = new ProfileManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final ProfileManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Profile from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public Profile getByID(final int entityID) {
        return super.getByID(new Profile(), entityID);
    }

    /**
     * Get the Profile from the database that corresponds to the input
     * parameters.
     *
     * @param owner the Owner of the Profile object.
     * @param key   the Key of the Profile object.
     * @return an Entity object.
     */
    public Profile getByOwnerKey(final User owner, final String key) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.eq("user", owner));
        criteria.add(Restrictions.eq("key", key));

        return (Profile) criteria.uniqueResult();
    }

    /**
     * Delete the input Profile from the database.
     *
     * @param entity the Profile tha we want to delete
     */
    public void delete(final Profile entity) {
        super.delete(entity, entity.getId());
    }

    /**
     * Listing all the Profiles from the database.
     *
     * @return a list of all the Profiles that exist inside the table Avatar.
     */
    public List<Profile> list() {
        return super.list(new Profile());
    }

    /**
     * List al the Profile from the database that corresponds to the input
     * parameters.
     *
     * @param owner the Owner of the Profile object.
     * @return an Entity object.
     */
    @SuppressWarnings("unchecked")
    public List<Profile> listByOwner(final User owner) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.eq("user", owner));
        criteria.addOrder(Order.asc("key"));

        return criteria.list();
    }

    /**
     * List al the Profile from the database that corresponds to the input
     * parameters.
     *
     * @param key the key of the Profile object.
     * @return an Entity object.
     */
    @SuppressWarnings("unchecked")
    public List<Profile> listByKey(final String key) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Profile.class);
        criteria.add(Restrictions.eq("key", key));
        criteria.addOrder(Order.desc("value"));
        return criteria.list();
    }

    /**
     * List the number of achievement points per user.
     *
     * @return The number of achievement points earned.
     */
    public List<Profile> listAchievements() {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT USER_ID, sum(achievementPoints) " +
                "FROM `ACHIEVEMENTS` GROUP BY USER_ID ORDER BY sum(achievementPoints) DESC";

        final List<Object[]> lstResults = session.createSQLQuery(thisQuery).list();

        // construct result
        final List<Profile> theList = new ArrayList<Profile>();

        // Iterate through results and populate map
        for (Object[] lstResult : lstResults) {
            final int userID = (Integer) lstResult[0];
            final long achievements = ((BigDecimal) lstResult[1]).longValue();
            final Profile profile = new Profile();
            profile.setUser((User) session.get(User.class, userID));
            profile.setKey(ProfileConstants.ACHIEVEMENTS);
            profile.setValue((int) achievements);
            theList.add(profile);
        }

        return theList;
    }

    /**
     * Delete all profiles for this user.
     *
     * @param user The user to delete the profiles.
     */
    public void delete(final User user) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "DELETE " +
                "FROM `USER_PROFILES` WHERE USER_ID=" + user.getUserId();

        session.createSQLQuery(thisQuery).executeUpdate();
    }
}

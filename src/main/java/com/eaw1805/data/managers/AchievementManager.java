package com.eaw1805.data.managers;

import com.eaw1805.data.managers.beans.AchievementManagerBean;
import com.eaw1805.data.model.Achievement;
import com.eaw1805.data.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for Achievement objects.
 */
public class AchievementManager extends AbstractManager<Achievement>
        implements AchievementManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static AchievementManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public AchievementManager() {
        // Does nothing
        super();
    }

    /**
     * AchievementManager is loaded on the first execution of AchievementManager.getInstance()
     * or the first access to AchievementManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static AchievementManagerBean getInstance() {
        synchronized (AchievementManager.class) {
            if (ourInstance == null) {
                ourInstance = new AchievementManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final AchievementManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Achievement from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public Achievement getByID(int entityID) {
        return super.getByID(new Achievement(), entityID);
    }

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Achievement tha we want to add.
     */
    public void add(final Achievement value) {
        super.add(value);
    }

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Achievement tha we want to update.
     */
    public void update(final Achievement value) {
        super.update(value);
    }

    /**
     * Delete the input Achievement from the database.
     *
     * @param entity the Achievement tha we want to delete
     */
    public void delete(final Achievement entity) {
        super.delete(entity, entity.getAchievementID());
    }

    /**
     * Listing all the Users from the database.
     *
     * @return a list of all the Users that exist inside the table Avatar.
     */
    public List<Achievement> list() {
        return super.list(new Achievement());
    }

    /**
     * Listing all the User's Achievements from the database.
     *
     * @return a list of all the User's Achievements.
     */
    @SuppressWarnings("unchecked")
    public List<Achievement> list(final int userId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Achievement.class);
        criteria.add(Restrictions.eq("user.userId", userId));
        criteria.addOrder(Order.asc("achievementID"));
        return criteria.list();
    }

    /**
     * List achievements by category.
     *
     * @param category The category.
     * @return All achievements in a category.
     */
    public List<Achievement> listCategory(final int category) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Achievement.class);
        criteria.add(Restrictions.eq("category", category));
        criteria.addOrder(Order.asc("achievementID"));
        return criteria.list();
    }

    /**
     * Listing all the User's Achievements from the database.
     *
     * @return a list of all the User's Achievements.
     */
    @SuppressWarnings("unchecked")
    public List<Achievement> listRecent(final int userId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Achievement.class);
        criteria.add(Restrictions.eq("user.userId", userId));
        criteria.add(Restrictions.ne("category", 1));
        criteria.addOrder(Order.desc("achievementID"));
        criteria.setMaxResults(8);
        return criteria.list();
    }

    /**
     * Listing all the User's Achievements from the database.
     *
     * @return a list of all the User's Achievements.
     */
    @SuppressWarnings("unchecked")
    public List<Achievement> listRecentHonour(final int userId, final int maxResults) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Achievement.class);
        criteria.add(Restrictions.eq("user.userId", userId));
        criteria.add(Restrictions.eq("category", 1));
        criteria.addOrder(Order.desc("achievementID"));
        criteria.setMaxResults(maxResults);
        return criteria.list();
    }

    /**
     * List all user achievements with a specific category, level and description.
     *
     * @param userId The user to get the achievements for.
     * @param category The category of the achievement.
     * @param level The level of the achievements.
     * @param description The description of the achievements.
     * @return A list of achievements.
     */
    public List<Achievement> list(final int userId,
                                  final int category,
                                  final int level,
                                  final String description) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Achievement.class);
        criteria.add(Restrictions.eq("user.userId", userId));
        criteria.add(Restrictions.eq("category", category));
        criteria.add(Restrictions.eq("level", level));
        criteria.add(Restrictions.like("description", description));
        criteria.addOrder(Order.desc("achievementID"));
        return criteria.list();
    }

    /**
     * Listing all the new  User's Achievements from the database.
     *
     * @return a list of all the User's Achievements.
     */
    @SuppressWarnings("unchecked")
    public List<Achievement> listNew(final int userId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Achievement.class);
        criteria.add(Restrictions.eq("user.userId", userId));
        criteria.add(Restrictions.eq("firstLoad", false));
        criteria.add(Restrictions.ne("category", 1));
        return criteria.list();
    }

    /**
     * Check if the User has received the particular achievement.
     *
     * @param user     the user to check.
     * @param category the category to check.
     * @param level    the level to check.
     * @return true, if the achievement has been reached.
     */
    public boolean checkPlayerCategoryLevel(final User user, final int category, final int level) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Achievement.class);
        criteria.add(Restrictions.eq("user", user));
        criteria.add(Restrictions.eq("category", category));
        criteria.add(Restrictions.eq("level", level));
        return !criteria.list().isEmpty();
    }

    /**
     * Get the number of achievement points for this user.
     *
     * @param user The user to search for.
     * @return The number of achievement points earned.
     */
    public Object sumPoints(final User user) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT sum(achievementPoints) " +
                "FROM `ACHIEVEMENTS` WHERE USER_ID=" + user.getUserId() +
                " GROUP BY USER_ID";

        return session.createSQLQuery(thisQuery).uniqueResult();
    }

    public void delete(User user) {
        final Session session = getSessionFactory().getCurrentSession();

        final String thisQuery = "DELETE " +
                "FROM `ACHIEVEMENTS` WHERE USER_ID=" + user.getUserId();

        session.createSQLQuery(thisQuery).executeUpdate();
    }

}

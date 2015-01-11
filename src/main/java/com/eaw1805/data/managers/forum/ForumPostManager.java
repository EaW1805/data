package com.eaw1805.data.managers.forum;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.ForumPostManagerBean;
import com.eaw1805.data.model.User;
import com.eaw1805.data.model.forum.ForumPost;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;


/**
 * CRUD operations for UserPermissions objects.
 */
public class ForumPostManager extends AbstractManager<ForumPost>
        implements ForumPostManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static ForumPostManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public) default constructor.
     */
    public ForumPostManager() {
        // Does nothing
        super();
    }

    /**
     * ForumPostManager is loaded on the first execution of ForumPostManager.getInstance()
     * or the first access to ForumPostManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static ForumPostManagerBean getInstance() {
        synchronized (ForumPostManager.class) {
            if (ourInstance == null) {
                ourInstance = new ForumPostManager();
            }
        }

        return ourInstance;
    }

    /**
     * Delete the input ForumPost from the database.
     *
     * @param entity the ForumPost tha we want to delete
     */
    @Override
    public void delete(final ForumPost entity) {
        super.delete(entity, entity.getId());
    }

    /**
     * Listing all the ForumPost from the database.
     *
     * @return a list of all the ForumPost that exist inside the table phpbb_posts.
     */
    @Override
    public List<ForumPost> list() {
       return super.list(new ForumPost());
    }
    /**
     * Returning the number of Forum Posts for a specific user from the database.
     *
     * @param user the input user.
     * @return an int with the number of posts.
     */
    @Override
    public int getNumberOfPosts(final User user) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(ForumPost.class);
        criteria.setProjection(Projections.rowCount());
        criteria.add(Restrictions.eq("user", user));
        return (Integer)criteria.list().get(0);
    }
}

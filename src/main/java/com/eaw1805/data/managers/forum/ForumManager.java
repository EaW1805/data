package com.eaw1805.data.managers.forum;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.ForumManagerBean;
import com.eaw1805.data.model.User;
import com.eaw1805.data.model.forum.Forum;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import java.util.List;


public class ForumManager extends AbstractManager<Forum>
        implements ForumManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static ForumManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public) default constructor.
     */
    public ForumManager() {
        // Does nothing
        super();
    }

    /**
     * ForumManager is loaded on the first execution of ForumManager.getInstance()
     * or the first access to ForumManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static ForumManagerBean getInstance() {
        synchronized (ForumManager.class) {
            if (ourInstance == null) {
                ourInstance = new ForumManager();
            }
        }

        return ourInstance;
    }

    /**
     * Delete the input Forum from the database.
     *
     * @param entity the Forum tha we want to delete
     */
    @Override
    public void delete(final Forum entity) {
        super.delete(entity, entity.getForumId());
    }

    /**
     * Listing all the Forum from the database.
     *
     * @return a list of all the Forum that exist inside the table phpbb_posts.
     */
    @Override
    public List<Forum> list() {
        return super.list(new Forum());
    }

    /**
     * Get a forum by its forum id.
     *
     * @param forumId The forum to search for.
     * @return The forum.
     */
    public Forum getById(int forumId) {
        return super.getByID(new Forum(), forumId);
    }

    public int getMaxRight() {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Forum.class);
        criteria.addOrder(Order.desc("rightId"));
        List<Forum> forums = criteria.list();
        if (forums.isEmpty()) {
            return 0;
        }
        return forums.get(0).getRightId();
    }

    /**
     * This method updates the forum groups for a forum.
     *
     * @param forumId The id of the forum.
     */
    public void updateForumGroups(int forumId) {
        final Session session = getSessionFactory().getCurrentSession();
        //clear any previous groups for this forum
        String deleteQuery = "DELETE FROM `phpbb_acl_groups` where forum_id = " + forumId +";";
        session.createSQLQuery(deleteQuery).executeUpdate();
        //insert the new groups for this forum.
        String sqlQuery = "INSERT INTO `phpbb_acl_groups` " +
                "(group_id, forum_id, auth_option_id, auth_role_id, auth_setting) VALUES " +
                "(1, " + forumId + ", 0, 16, 0)," +
                "(2, " + forumId + ", 0, 17, 0)," +
                "(4, " + forumId + ", 0, 14, 0)," +
                "(5, " + forumId + ", 0, 14, 0);";
        session.createSQLQuery(sqlQuery).executeUpdate();
    }

    /**
     * Fix forums left and right id.
     *
     * @param forumId The new forum.
     * @param leftId The new forum left id.
     * @param rightId The new forum right id.
     */
    public void updateLeftRightIds(int forumId, final int leftId, final int rightId) {
        final Session session = getSessionFactory().getCurrentSession();
        String query1 = "UPDATE phpbb_forums SET left_id = left_id + 2 where left_id >= " + leftId + "";
        session.createSQLQuery(query1).executeUpdate();
        String query2 = "UPDATE phpbb_forums SET right_id = right_id + 2 where right_id >= " + leftId + "";
        session.createSQLQuery(query2).executeUpdate();
        String query3 = "UPDATE phpbb_forums SET left_id=" + leftId + ", right_id = " + rightId + " where forum_id = " + forumId + "";
        session.createSQLQuery(query3).executeUpdate();
    }

    public void reset(final User user) {
        final Session session = getSessionFactory().getCurrentSession();
        session.createSQLQuery("UPDATE phpbb_acl_users SET user_id=2 where user_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("UPDATE phpbb_bots SET user_id=2 where user_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("UPDATE phpbb_drafts SET user_id=2 where user_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("DELETE FROM phpbb_forums_access where user_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("DELETE FROM phpbb_forums_track where user_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("DELETE FROM phpbb_forums_watch WHERE user_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("UPDATE phpbb_log SET user_id=2 where user_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("UPDATE phpbb_login_attempts SET user_id=2 where user_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("UPDATE phpbb_moderator_cache SET user_id=2 where user_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("UPDATE phpbb_poll_votes SET vote_user_id=2 where vote_user_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("UPDATE phpbb_privmsgs_folder SET user_id=2 where user_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("UPDATE phpbb_privmsgs_rules SET user_id=2 where user_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("UPDATE phpbb_privmsgs_rules SET rule_user_id=2 where rule_user_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("UPDATE phpbb_privmsgs_to SET user_id=2 where user_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("UPDATE phpbb_reports SET user_id=2 where user_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("UPDATE phpbb_topics_posted SET user_id=2 where user_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("UPDATE phpbb_topics_track SET user_id=2 where user_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("UPDATE phpbb_topics_watch SET user_id=2 where user_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("UPDATE phpbb_user_group SET user_id=2 where user_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("UPDATE phpbb_posts SET poster_id=2 where poster_id = " + user.getUserId() + "").executeUpdate();
        session.createSQLQuery("DELETE FROM phpbb_warnings WHERE user_id = " + user.getUserId() + "").executeUpdate();
    }


}

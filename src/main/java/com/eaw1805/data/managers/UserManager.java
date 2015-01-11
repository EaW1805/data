package com.eaw1805.data.managers;

import com.eaw1805.data.managers.beans.UserManagerBean;
import com.eaw1805.data.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * CRUD operations for Game objects.
 */
public class UserManager
        extends AbstractManager<User>
        implements UserManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static UserManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public) default constructor.
     */
    public UserManager() {
        // Does nothing
        super();
    }

    /**
     * GameManager is loaded on the first execution of GameManager.getInstance()
     * or the first access to GameManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static UserManagerBean getInstance() {
        synchronized (UserManager.class) {
            if (ourInstance == null) {
                ourInstance = new UserManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final UserManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the User from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public User getByID(final int entityID) {
        return super.getByID(new User(), entityID);
    }

    /**
     * get the User from the database that corresponds to the input username.
     *
     * @param userName the username of the Entity object.
     * @return an Entity object.
     */
    @SuppressWarnings("unchecked")
    public User getByUserName(final String userName) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", userName));
        return (User) criteria.uniqueResult();
    }

    /**
     * Delete the input User from the database.
     *
     * @param user the user tha we want to delete
     */
    public void delete(final User user) {
        super.delete(user, user.getUserId());
    }

    public void markDeleted(final User user) {
        user.setUsername("Deleted");
        user.setFullname("Deleted User");
        user.setEmail("dead@eaw1805.com");
        try {
            user.setPassword(convertToMD5("something@you!will^never&guess&o-e-o*"));
            user.setEmailEncoded(convertToMD5("dead@eaw1805.com"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        user.setDeletionDate(new Date());
        update(user);
    }

    /**
     * Listing all the Users from the database.
     *
     * @return a list of all the Avatars that exist inside the table Users.
     */
    @SuppressWarnings("unchecked")
    public List<User> list() {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.ne("userType", 1));
        criteria.add(Restrictions.ne("userType", 2));
        return criteria.list();
    }

    /**
     * Listing all the Users from the database.
     *
     * @return a list of all the Avatars that exist inside the table Users.
     */
    @SuppressWarnings("unchecked")
    public List<User> list(final String userName, final String userPwd) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", userName));
        criteria.add(Restrictions.eq("password", userPwd));
        criteria.add(Restrictions.ne("userType", 1));
        criteria.add(Restrictions.ne("userType", 2));
        return criteria.list();
    }

    /**
     * Search for the user with the specified email.
     *
     * @param email The email to search for.
     * @return The user with that email.
     */
    @SuppressWarnings("unchecked")
    public List<User> searchByEmail(final String email) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        criteria.add(Restrictions.ne("userType", 1));
        criteria.add(Restrictions.ne("userType", 2));
        return criteria.list();
    }


    /**
     * Search for the user with the spesified facebook id.
     *
     * @param fbId The facebook id for.
     * @return The user with that facebook id.
     */
    @SuppressWarnings("unchecked")
    public List<User> searchByFacebookId(final String fbId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("facebookId", fbId));
        return criteria.list();
    }

    /**
     * Count the number of users registered per each week of the year.
     *
     * @return a mapping of user count to years/weeks.
     */
    @SuppressWarnings("unchecked")
    public Map<Integer, Map<Integer, Long>> countByWeek() {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT year( FROM_UNIXTIME( user_regdate ) ) , week( FROM_UNIXTIME( user_regdate ) ) , count( * ) " +
                "FROM `USERS` " +
                "WHERE year( FROM_UNIXTIME( user_regdate ) ) >= 2012 " +
                "GROUP BY year( FROM_UNIXTIME( user_regdate ) ) , week( FROM_UNIXTIME( user_regdate ) )";

        final List<Object[]> lstResults = session.createSQLQuery(thisQuery).list();

        // construct map
        final Map<Integer, Map<Integer, Long>> theMap = new TreeMap<Integer, Map<Integer, Long>>();

        // Iterate through results and populate map
        for (Object[] lstResult : lstResults) {
            final int year = (Integer) lstResult[0];
            final int week = (Integer) lstResult[1];
            final long users = ((BigInteger) lstResult[2]).longValue();
            final Map<Integer, Long> yearMap;
            if (!theMap.containsKey(year)) {
                yearMap = new TreeMap<Integer, Long>();
                theMap.put(year, yearMap);

            } else {
                yearMap = theMap.get(year);
            }

            yearMap.put(week, users);
        }

        return theMap;
    }

    /**
     * Reset forum permissions for all users.
     * Is needed when creating a new game and a new forum is constructed.
     */
    public void resetAllUsersForumPrivilege() {
        final Session session = getSessionFactory().getCurrentSession();
        final String sqlQuery = "UPDATE USERS SET user_permissions = '';";
        session.createSQLQuery(sqlQuery).executeUpdate();
    }

    /**
     * Insert a new user to the database respecting all external fields.
     *
     * @param thisUser the user to insert.
     */
    public void addUser(final User thisUser) {
        final int timeStamp = (int) (new Date().getTime() / 1000);
        final Session session = getSessionFactory().getCurrentSession();

        // Insert User
        final StringBuilder strQuery = new StringBuilder();
        strQuery.append("INSERT INTO USERS ");
        strQuery.append("(`user_id`, `user_type`, `group_id`, `user_permissions`, `user_perm_from`, ");
        strQuery.append("`user_ip`, ");
        strQuery.append("`user_regdate`, ");
        strQuery.append("`username`, ");
        strQuery.append("`username_clean`,");
        strQuery.append("`user_password`, ");
        strQuery.append("`user_passchg`, `user_pass_convert`, ");
        strQuery.append("`user_email`, `user_email_hash`, `user_birthday`, ");
        strQuery.append("`user_lastvisit`, `user_lastmark`, ");
        strQuery.append("`user_lastpost_time`, `user_lastpage`, `user_last_confirm_key`, `user_last_search`, `user_warnings`, `user_last_warning`, `user_login_attempts`, ");
        strQuery.append("`user_inactive_reason`, `user_inactive_time`, `user_posts`, `user_lang`, `user_timezone`, ");
        strQuery.append("`user_dst`, `user_dateformat`, `user_style`, `user_rank`, `user_colour`, `user_new_privmsg`, ");
        strQuery.append("`user_unread_privmsg`, `user_last_privmsg`, `user_message_rules`, `user_full_folder`, ");
        strQuery.append("`user_emailtime`, `user_topic_show_days`, `user_topic_sortby_type`, `user_topic_sortby_dir`, ");
        strQuery.append("`user_post_show_days`, `user_post_sortby_type`, `user_post_sortby_dir`, `user_notify`, ");
        strQuery.append("`user_notify_pm`, `user_notify_type`, `user_allow_pm`, `user_allow_viewonline`, ");
        strQuery.append("`user_allow_viewemail`, `user_allow_massemail`, `user_options`, `user_avatar`, `user_avatar_type`, ");
        strQuery.append("`user_avatar_width`, `user_avatar_height`, `user_sig`, `user_sig_bbcode_uid`, ");
        strQuery.append("`user_sig_bbcode_bitfield`, `user_from`, `user_icq`, `user_aim`, `user_yim`, `user_msnm`, ");
        strQuery.append("`user_jabber`, `user_website`, `user_occ`, `user_interests`, `user_actkey`, `user_newpasswd`, ");
        strQuery.append("`user_form_salt`, `user_new`, `user_reminded`, `user_reminded_time`, `fullname`, `location`, ");
        strQuery.append("`creditFree`, `creditTransferred`, `creditBought`, `enableNotifications`, `publicMail`, ");
        strQuery.append("`inboxThreadSize`, `twitterStatus`, `facebookStatus`, `facebookId`, `facebookAccessToken`, `helpSent`) ");
        strQuery.append("VALUES (NULL, '0', '2', '', '0', ");
        strQuery.append("'");
        strQuery.append(thisUser.getRemoteAddress());
        strQuery.append("', '");
        strQuery.append(timeStamp);
        strQuery.append("', '");
        strQuery.append(thisUser.getUsername());
        strQuery.append("', '");
        strQuery.append(thisUser.getUsername().toLowerCase());
        strQuery.append("', '");
        strQuery.append(thisUser.getPassword());
        strQuery.append("', '");
        strQuery.append(timeStamp);
        strQuery.append("', '0', '");
        strQuery.append(thisUser.getEmail());
        strQuery.append("', '");
        strQuery.append(thisUser.getEmailEncoded());
        strQuery.append("', '', '");
        strQuery.append(timeStamp);
        strQuery.append("', '");
        strQuery.append(timeStamp);
        strQuery.append("', '0', '', '', '0', '0', '0', '0', ");
        strQuery.append("'0', '0', '0', 'en', '");
        strQuery.append(thisUser.getTimezone());
        strQuery.append("', '0', 'D M d, Y g:i a', '2', '0', '', '0', ");
        strQuery.append("'0', '0', '0', '-3', ");
        strQuery.append("'0', '0', 't', 'd', ");
        strQuery.append("'0', 't', 'a', '0', ");
        strQuery.append("'1', '0', '1', '1', ");
        strQuery.append("'1', '1', '230271', '', '0', ");
        strQuery.append("'0', '0', '', '', ");
        strQuery.append("'', '', '', '', '', '', ");
        strQuery.append("'', '', '', '', '', '', ");
        strQuery.append("'', '1', '0', '0', '");
        strQuery.append(thisUser.getFullname());
        strQuery.append("', '");
        strQuery.append(thisUser.getLocation());
        strQuery.append("',");
        strQuery.append(thisUser.getCreditFree());
        strQuery.append(",");
        strQuery.append(thisUser.getCreditTransferred());
        strQuery.append(",");
        strQuery.append(thisUser.getCreditBought());
        strQuery.append(", 1, 0, ");
        strQuery.append("6, 0, 0");

        strQuery.append(",'");
        if (thisUser.getFacebookId() != null) {
            strQuery.append(thisUser.getFacebookId());
        }
        strQuery.append("'");
        strQuery.append(",'");
        if (thisUser.getFacebookAccessToken() != null) {
            strQuery.append(thisUser.getFacebookAccessToken());
        }
        strQuery.append("', 0); ");

        session.createSQLQuery(strQuery.toString()).executeUpdate();

        // Retrieve new user to get ID
        final User newUser = getByUserName(thisUser.getUsername());
        newUser.setLastProcDate(new Date());
        update(newUser);

        // Insert Group
        final Session sessionGrp = getSessionFactory().getCurrentSession();
        final StringBuilder strQueryGrp = new StringBuilder();
        strQueryGrp.append("INSERT INTO `empire`.`phpbb_user_group` (`group_id`, `user_id`, `group_leader`, `user_pending`) ");
        strQueryGrp.append("VALUES ('2', '");
        strQueryGrp.append(newUser.getUserId());
        strQueryGrp.append("', '0', '0');");

        sessionGrp.createSQLQuery(strQueryGrp.toString()).executeUpdate();
    }

    /**
     * Get a user by his facebook id.
     *
     * @param facebookId the facebook id of the user.
     * @return The user with the given facebook id.
     */
    public User getByFacebookId(final String facebookId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("facebookId", facebookId));
        final List<User> users = criteria.list();
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    /**
     * Retrieve the user that has the corresponding uuid for the questionnaire.
     *
     * @param uuid The uuid to find the user for.
     * @return The user.
     */
    public User getByQuestionnaireUUID(String uuid) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("questionnaireUUID", uuid));
        final List<User> users = criteria.list();
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    /**
     * Encrypts the password string of the new user.
     *
     * @param password the password inserted to the form
     * @return the encrypted password.
     * @throws java.security.NoSuchAlgorithmException
     *          No encryption algorithm exception.
     */
    protected String convertToMD5(final String password) throws NoSuchAlgorithmException {

        final MessageDigest messageDialect = MessageDigest.getInstance("MD5");
        messageDialect.update(password.getBytes());

        final byte byteData[] = messageDialect.digest();

        //convert the byte to hex format
        final StringBuilder hexString = new StringBuilder();

        for (final byte singleByte : byteData) {
            final String hex = Integer.toHexString(0xff & singleByte);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}

package com.eaw1805.data.managers.test;

import com.eaw1805.data.HibernateUtil;
import com.eaw1805.data.managers.UserManager;
import com.eaw1805.data.managers.forum.ForumPostManager;
import com.eaw1805.data.model.User;
import junit.framework.TestCase;
import org.apache.logging.log4j.*;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Test cases for the ForumPost Manager.
 */
public class TestForumPostManager extends TestCase {

    /**
     * a log4j logger to print messages.
     */
    private static final Logger LOGGER = LogManager.getLogger(TestForumPostManager.class);

    /**
     * Setup the Tester.
     */
    @Before
    public void setUp() {
        // Do nothing for now
        HibernateUtil.connectEntityManagers(HibernateUtil.DB_S1);
    }

    @Test
    public void testCountPosts() throws Exception {
        final Transaction trans = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession().beginTransaction();

        final List<User> users = UserManager.getInstance().list();

        for (final User user : users) {
            LOGGER.info(user.getUsername() + " -- " + ForumPostManager.getInstance().getNumberOfPosts(user));
        }
        trans.rollback();
    }

}



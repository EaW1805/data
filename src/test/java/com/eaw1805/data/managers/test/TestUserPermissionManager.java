package com.eaw1805.data.managers.test;

import com.eaw1805.data.HibernateUtil;
import com.eaw1805.data.managers.UserManager;
import com.eaw1805.data.managers.forum.UserPermissionManager;
import com.eaw1805.data.model.User;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for user permission manager.
 */
public class TestUserPermissionManager {


    /**
     * Setup the Tester.
     */
    @Before
    public void setUp() {
        // Do nothing for now
        HibernateUtil.connectEntityManagers(HibernateUtil.DB_S1);
    }

    /**
     * Tests add user.
     */
    @Test
    public void listPermissions() throws Exception {
        final Transaction trans = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession().beginTransaction();

        final User user = UserManager.getInstance().getByUserName("akribopo");
        /*UserPermissions userPermissions = new UserPermissions();

        userPermissions.setUser(user);
        userPermissions.setForumId(8);
        userPermissions.setAuthRoleId(ForumRoleConstants.ROLE_FORUM_LIMITED_POLLS);*/
        System.out.println(UserPermissionManager.getInstance().getForumPermissions(user, 8));

        trans.commit();
    }

}

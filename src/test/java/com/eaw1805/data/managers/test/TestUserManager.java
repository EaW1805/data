package com.eaw1805.data.managers.test;

import com.eaw1805.data.HibernateUtil;
import com.eaw1805.data.model.User;
import junit.framework.TestCase;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

/**
 * Test cases for user manager.
 */
public class TestUserManager extends TestCase {

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
    public void testInsertUser() throws Exception {
        final Transaction trans = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_S1).getCurrentSession().beginTransaction();
        final User newUser1 = new User();
        newUser1.setUsername("marlog");
        newUser1.setFullname("Marios Logaras");
        newUser1.setEmail("logaras@gmail.com");
        newUser1.setEmailEncoded(passwordMD5(newUser1.getEmail()));
        newUser1.setLocation("Greece");
        newUser1.setPassword(passwordMD5("mar123"));
        newUser1.setDateJoin((new Date()).getTime());
        newUser1.setTimezone(1.0);
        newUser1.setRemoteAddress("10.0.0.1");
        //UserManager.getInstance().addUser(newUser1);

        //EmailManager.getInstance().sendWelcome(newUser1);

        trans.commit();
    }

/*
    */
/**
 * Tests add user.
 *//*

    public void testAddUser() throws Exception {
        final Transaction trans = HibernateUtil.getInstance().getSessionFactory().getCurrentSession().beginTransaction();
        final User newUser1 = new User();
        newUser1.setUsername("ichatz");
        newUser1.setFullname("Ioannis Chatzigiannakis");
        newUser1.setEmail("ichatz@gmail.com");
        newUser1.setLocation("Patras, Greece");
        newUser1.setPassword(passwordMD5("eaw123"));
        newUser1.setEmailEncoded(passwordMD5(newUser1.getEmail()));
        newUser1.setDateJoin((new Date()).getTime());
        UserManager.getInstance().add(newUser1);

        final User newUser2 = new User();
        newUser2.setUsername("bitoulis");
        newUser2.setFullname("Laertes Papaspyrou");
        newUser2.setEmail("bitoulis@btopenworld.com");
        newUser2.setLocation("Athens, Greece");
        newUser2.setPassword(passwordMD5("eaw123"));
        newUser2.setEmailEncoded(passwordMD5(newUser2.getEmail()));
        newUser2.setDateJoin((new Date()).getTime());
        UserManager.getInstance().add(newUser2);

        final User newUser3 = new User();
        newUser3.setUsername("makis");
        newUser3.setFullname("Makis Xiroyannis");
        newUser3.setEmail("makis.xiroyannis@gmail.com");
        newUser3.setLocation("Athens, Greece");
        newUser3.setPassword(passwordMD5("eaw123"));
        newUser3.setEmailEncoded(passwordMD5(newUser3.getEmail()));
        newUser3.setDateJoin((new Date()).getTime());
        UserManager.getInstance().add(newUser3);

        final User newUser4 = new User();
        newUser4.setUsername("mitro");
        newUser4.setFullname("Ioannis Mitropoulos");
        newUser4.setEmail("yiannis_mitropoulos@hotmail.com");
        newUser4.setLocation("Athens, Greece");
        newUser4.setPassword(passwordMD5("eaw123"));
        newUser4.setEmailEncoded(passwordMD5(newUser4.getEmail()));
        newUser4.setDateJoin((new Date()).getTime());
        UserManager.getInstance().add(newUser4);

        final User newUser5 = new User();
        newUser5.setUsername("kataras");
        newUser5.setFullname("Thanos Kataras");
        newUser5.setEmail("tsaky@hotmail.com");
        newUser5.setLocation("Athens, Greece");
        newUser5.setPassword(passwordMD5("eaw123"));
        newUser5.setEmailEncoded(passwordMD5(newUser5.getEmail()));
        newUser5.setDateJoin((new Date()).getTime());
        UserManager.getInstance().add(newUser5);

        final User newUser6 = new User();
        newUser6.setUsername("karavias");
        newUser6.setFullname("Dimitris Karavias");
        newUser6.setEmail("karavias@cti.gr");
        newUser6.setLocation("Athens, Greece");
        newUser6.setPassword(passwordMD5("eaw123"));
        newUser6.setEmailEncoded(passwordMD5(newUser6.getEmail()));
        newUser6.setDateJoin((new Date()).getTime());
        UserManager.getInstance().add(newUser6);

        final User newUser7 = new User();
        newUser7.setUsername("marily");
        newUser7.setFullname("Marily Nika");
        newUser7.setLocation("Athens, Greece");
        newUser7.setEmail("marily.nika@gmail.com");
        newUser7.setPassword(passwordMD5("eaw123"));
        newUser7.setEmailEncoded(passwordMD5(newUser7.getEmail()));
        newUser7.setDateJoin((new Date()).getTime());
        UserManager.getInstance().add(newUser7);

        trans.rollback();
    }
*/

    /**
     * Encrypts the password string of the new user.
     *
     * @param password the password inserted to the form
     * @return the encrypted password.
     * @throws java.security.NoSuchAlgorithmException
     *          No encryption algorithm exception.
     */
    private String passwordMD5(final String password) throws NoSuchAlgorithmException {

        final MessageDigest messageDialect = MessageDigest.getInstance("MD5");
        messageDialect.update(password.getBytes());

        final byte byteData[] = messageDialect.digest();

        //convert the byte to hex format
        final StringBuffer hexString = new StringBuffer();

        for (byte singleByte : byteData) {
            final String hex = Integer.toHexString(0xff & singleByte);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}

package com.eaw1805.data.managers.test;

import com.eaw1805.data.HibernateUtil;
import com.eaw1805.data.managers.MessageManager;
import com.eaw1805.data.model.Message;
import junit.framework.TestCase;
import org.apache.logging.log4j.*;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

/**
 * Test cases for the Message Manager.
 */
public class TestMessageManager extends TestCase {

    /**
     * a log4j logger to print messages.
     */
    private static final Logger LOGGER = LogManager.getLogger(TestReportManager.class);

    /**
     * Setup the Tester.
     */
    @Before
    public void setUp() {
        // Do nothing for now
        HibernateUtil.connectEntityManagers(HibernateUtil.DB_MAIN);
    }

    /**
     * Test Message Manager.
     */
    /*@Test*/
    public void testMarkAllMessagesOpened() throws Exception {
        /*final Transaction trans = HibernateUtil.getInstance().getSessionFactory().getCurrentSession().beginTransaction();
        MessageManager.getInstance().setSessionFactory(HibernateUtil.getInstance().getSessionFactory());
        MessageManager.getInstance().updateAllMessagesToOpened(18);

        trans.rollback();*/
    }

    @Test
    public void testgetRootMessage() throws Exception {
        final Transaction trans = HibernateUtil.getInstance().getSessionFactory(HibernateUtil.DB_MAIN).getCurrentSession().beginTransaction();

        final Message thisMessage = MessageManager.getInstance().getByID(13);
        int thisRootId = thisMessage.getRootId();
        if (thisRootId == 0) {
            thisRootId = thisMessage.getMessageId();
        }
        MessageManager.getInstance().deleteMessageThread(54, 13);

        trans.rollback();
    }

}


package com.eaw1805.data.managers;

import com.eaw1805.data.managers.beans.MessageManagerBean;
import com.eaw1805.data.model.Message;
import com.eaw1805.data.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * CRUD operations for Message objects.
 */
public class MessageManager extends AbstractManager<Message>
        implements MessageManagerBean {

    /**
     * a log4j logger to print messages.
     */
    private static final Logger LOGGER = LogManager.getLogger(MessageManager.class);

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static MessageManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public) default constructor.
     */
    public MessageManager() {
        // Does nothing
        super();
    }

    /**
     * GameManager is loaded on the first execution of GameManager.getInstance()
     * or the first access to GameManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static MessageManagerBean getInstance() {
        synchronized (MessageManager.class) {
            if (ourInstance == null) {
                ourInstance = new MessageManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final MessageManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the User from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public Message getByID(final int entityID) {
        return super.getByID(new Message(), entityID);
    }


    /**
     * Delete the input User from the database.
     *
     * @param message the user tha we want to delete
     */
    public void delete(final Message message) {
        super.delete(message, message.getMessageId());
    }

    /**
     * Listing all the Users from the database.
     *
     * @return a list of all the Avatars that exist inside the table Users.
     */
    public List<Message> list() {
        return super.list(new Message());
    }

    @SuppressWarnings("unchecked")
    public List<Message> listByReceiver(final User user) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Message.class);
        criteria.add(Restrictions.eq("receiver", user));
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Message> listBySender(final User user) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Message.class);
        criteria.add(Restrictions.eq("sender", user));
        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Message> retrieveHistory(final int rootId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Message.class);

        criteria.add(Restrictions.or(
                Restrictions.eq("rootId", rootId),
                Restrictions.eq("messageId", rootId)
        )).addOrder(Order.asc("date"));

        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Message> retrieveHistoryDesc(final int rootId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Message.class);

        criteria.add(Restrictions.or(
                Restrictions.eq("rootId", rootId),
                Restrictions.eq("messageId", rootId)
        )).addOrder(Order.desc("date"));

        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Message> retrieveUserHistory(final int userId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Message.class);

        criteria.add(
                Restrictions.or(
                        Restrictions.and(
                                Restrictions.eq("receiver.userId", userId),
                                Restrictions.eq("deletedReceiver", false)
                        ),
                        Restrictions.and(
                                Restrictions.eq("sender.userId", userId),
                                Restrictions.eq("deletedSender", false)
                        )
                )).add(Restrictions.eq("rootId", 0)
        );

        final ProjectionList proList = Projections.projectionList();
        proList.add(Projections.property("messageId"));
        criteria.setProjection(proList);

        final List<Integer> list = (List<Integer>) criteria.list();
        if (list.isEmpty()) {
            return new ArrayList<Message>();
        } else {
            final Criteria anotherCriter = session.createCriteria(Message.class);

            anotherCriter.add(Restrictions.or(
                    Restrictions.in("rootId", list),
                    Restrictions.in("messageId", list)
            )).addOrder(Order.desc("date"));

            return anotherCriter.list();
        }
    }

    /**
     * Get the number of unread messages for this user.
     *
     * @param user The user to search for.
     * @return The number of unread messages.
     */
    public int countUnreadMessagesByReceiver(final User user) {
        if (user != null && user.getUserId() > 0) {
            final Session session = getSessionFactory().getCurrentSession();
            final Criteria criteria = session.createCriteria(Message.class);
            criteria.add(Restrictions.eq("receiver", user))
                    .add(Restrictions.eq("opened", false));
            return criteria.list().size();
        } else {
            return 0;
        }
    }

    public void updateAllMessagesToOpened(final int userId) {
        final Session session = getSessionFactory().getCurrentSession();
        session.createSQLQuery("UPDATE MESSAGES SET opened=true WHERE RECEIVER_ID=" + userId).executeUpdate();
    }

    public Message getRootMessage(final int userAid, final int userBid, final String subject) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Message.class);

        criteria.add(Restrictions.or(
                Restrictions.eq("receiver.userId", userAid),
                Restrictions.eq("sender.userId", userAid)))
                .add(Restrictions.or(
                        Restrictions.eq("receiver.userId", userBid),
                        Restrictions.eq("sender.userId", userBid)))
                .add(Restrictions.eq("subject", subject))
                .add(Restrictions.eq("rootId", 0));

        return (Message) criteria.uniqueResult();
    }

    /**
     * Delete a Message Thread.
     *
     * @param thisUser the user Id
     * @param rootId   the root id of the thread
     */
    @Override
    public void deleteMessageThread(final int thisUser, final int rootId) {
        //Message thread should be deleted.
        final Session session = getSessionFactory().getCurrentSession();

        final Message rootMessage = getByID(rootId);

        if (!rootMessage.getDeletedSender().equals(rootMessage.getDeletedReceiver())) {
            session.createSQLQuery("DELETE FROM MESSAGES WHERE rootId=" + rootId + " OR MESSAGE_ID=" + rootId)
                    .executeUpdate();
        } else {
            //Update the boolean variables
            if (rootMessage.getSender().getUserId() == thisUser) {
                rootMessage.setDeletedSender(true);
            } else if (rootMessage.getReceiver().getUserId() == thisUser) {
                rootMessage.setDeletedReceiver(true);
            }
            update(rootMessage);
        }
    }

    /**
     * Reset user messages, this happens when you delete a user.
     * Sets all user messages as admin messages.
     *
     * @param user The user to reset the messages.
     */
    public void reset(final User user) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "UPDATE " +
                "`MESSAGES` SET SENDER_ID = 2 WHERE SENDER_ID=" + user.getUserId();
        session.createSQLQuery(thisQuery).executeUpdate();
        final String thisQuery2 = "UPDATE " +
                "`MESSAGES` SET RECEIVER_ID = 2 WHERE RECEIVER_ID=" + user.getUserId();
        session.createSQLQuery(thisQuery2).executeUpdate();
    }
}

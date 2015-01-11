package com.eaw1805.data.managers;

import com.eaw1805.data.managers.beans.ChatMessageManagerBean;
import com.eaw1805.data.model.ChatMessage;
import com.eaw1805.data.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.Collections;
import java.util.Date;
import java.util.List;


public class ChatMessageManager
        extends AbstractManager<ChatMessage>
        implements ChatMessageManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static ChatMessageManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public) default constructor.
     */
    public ChatMessageManager() {
        // Does nothing
        super();
    }

    /**
     * GameManager is loaded on the first execution of GameManager.getInstance()
     * or the first access to GameManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static ChatMessageManagerBean getInstance() {
        synchronized (MessageManager.class) {
            if (ourInstance == null) {
                ourInstance = new ChatMessageManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final ChatMessageManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the User from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public ChatMessage getByID(final int entityID) {
        return super.getByID(new ChatMessage(), entityID);
    }

    /**
     * Delete the input User from the database.
     *
     * @param message the user tha we want to delete
     */
    public void delete(final ChatMessage message) {
        super.delete(message, message.getChatMessageId());
    }

    /**
     * Listing all the Users from the database.
     *
     * @return a list of all the Avatars that exist inside the table Users.
     */
    public List<ChatMessage> list() {
        return super.list(new ChatMessage());
    }

    /**
     * Listing all the chat messages by receiver.
     *
     * @return The list of messages the user received.
     */
    @SuppressWarnings("unchecked")
    public List<ChatMessage> listByNationGame(final int user, final int gameId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(ChatMessage.class);
        criteria.add(
                Restrictions.or(
                        Restrictions.and(
                                Restrictions.eq("sender", user), Restrictions.eq("game", gameId)),
                        Restrictions.or(
                                Restrictions.or(
                                        Restrictions.and(Restrictions.eq("receiver", user), Restrictions.eq("game", gameId))
                                        , Restrictions.and(Restrictions.eq("receiver", 0), Restrictions.eq("game", gameId))
                                ), Restrictions.and(Restrictions.eq("receiver", 0), Restrictions.eq("game", 0)))
                ));

        return criteria.addOrder(Order.asc("chatMessageId")).list();
    }

    public List<ChatMessage> listByNationGameFromDate(int user, int gameId, Date date) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(ChatMessage.class);
        criteria.add(
                Restrictions.and(Restrictions.ge("sentDate", date),
                Restrictions.or(
                        Restrictions.and(
                                Restrictions.eq("sender", user), Restrictions.eq("game", gameId)),
                        Restrictions.or(
                                Restrictions.or(
                                        Restrictions.and(Restrictions.eq("receiver", user), Restrictions.eq("game", gameId))
                                        , Restrictions.and(Restrictions.eq("receiver", 0), Restrictions.eq("game", gameId))
                                ), Restrictions.and(Restrictions.eq("receiver", 0), Restrictions.eq("game", 0)))
                )));

        return criteria.addOrder(Order.asc("chatMessageId")).list();
    }

    /**
     * Listing Global chat messages.
     *
     * @return The list of messages.
     */
    public List<ChatMessage> listGlobal() {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(ChatMessage.class);
        criteria.add(Restrictions.eq("game", 0));
        criteria.setMaxResults(50);
        final List<ChatMessage> list = criteria.addOrder(Order.desc("chatMessageId")).list();
        Collections.reverse(list);
        return list;
    }

    /**
     * Delete all profiles for this user.
     *
     * @param user The user to delete the profiles.
     */
    public void delete(final User user) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "DELETE " +
                "FROM `CHAT_MESSAGES` WHERE user_id=" + user.getUserId();

        session.createSQLQuery(thisQuery).executeUpdate();
    }

}


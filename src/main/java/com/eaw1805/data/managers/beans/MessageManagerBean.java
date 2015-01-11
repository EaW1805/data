package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Message;
import com.eaw1805.data.model.User;

import java.util.List;

public interface MessageManagerBean extends EntityBean{
    /**
     * get the User from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Message getByID(int entityID);


    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the User tha we want to add.
     */
    void add(final Message value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the User tha we want to update.
     */
    void update(final Message value);

    /**
     * Delete the input User from the database.
     *
     * @param entity the User tha we want to delete
     */
    void delete(Message entity);

    /**
     * Listing all the Users from the database.
     *
     * @return a list of all the Users that exist inside the table Avatar.
     */
    List<Message> list();

    List<Message> listByReceiver(final User user);

    List<Message> listBySender(final User user);

    List<Message> retrieveHistory(final int rootId);

    List<Message> retrieveHistoryDesc(final int rootId);

    List<Message> retrieveUserHistory(final int userId);

    int countUnreadMessagesByReceiver(final User user);
    
    void updateAllMessagesToOpened(final int userId);

    Message getRootMessage(final int userAid, final int userBid, final String subject);
    
    void deleteMessageThread(final int userId, final int rootId);

    void reset(final User user);
}


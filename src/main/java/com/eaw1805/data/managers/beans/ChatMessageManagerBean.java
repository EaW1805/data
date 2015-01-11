package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.ChatMessage;
import com.eaw1805.data.model.User;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: karavias
 * Date: 4/29/12
 * Time: 5:27 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ChatMessageManagerBean extends EntityBean {
    /**
     * get the User from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    ChatMessage getByID(int entityID);


    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the User tha we want to add.
     */
    void add(final ChatMessage value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the User tha we want to update.
     */
    void update(final ChatMessage value);

    /**
     * Delete the input User from the database.
     *
     * @param entity the User tha we want to delete
     */
    void delete(ChatMessage entity);

    /**
     * Listing all the Users from the database.
     *
     * @return a list of all the Users that exist inside the table Avatar.
     */
    List<ChatMessage> list();

    /**
     * Listing all the chat messages by sender.
     *
     * @return The list of messages the user sent.
     */
    List<ChatMessage> listByNationGame(int user, int gameId);

    /**
     * Listing all chat messages from a date and beyond.
     *
     * @param user The user to search for messages.
     * @param gameId The game to search for messages.
     * @param date The date to search for messages.
     * @return A list of messages.
     */
    List<ChatMessage> listByNationGameFromDate(int user, int gameId, Date date);

    /**
     * Listing Global chat messages.
     *
     * @return The list of messages.
     */
    List listGlobal();

    void delete(final User user);
}


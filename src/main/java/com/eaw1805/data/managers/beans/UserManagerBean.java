package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.User;

import java.util.List;
import java.util.Map;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface UserManagerBean extends EntityBean {

    /**
     * get the User from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    User getByID(int entityID);

    /**
     * get the User from the database that corresponds to the input username.
     *
     * @param username the username of the Entity object.
     * @return an Entity object.
     */
    User getByUserName(String username);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the User tha we want to add.
     */
    void add(final User value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the User tha we want to update.
     */
    void update(final User value);

    /**
     * Delete the input User from the database.
     *
     * @param entity the User tha we want to delete
     */
    void delete(User entity);

    void markDeleted(User entity);

    /**
     * Listing all the Users from the database.
     *
     * @return a list of all the Users that exist inside the table Avatar.
     */
    List<User> list();

    /**
     * Listing all the Users from the database.
     *
     * @return a list of all the Avatars that exist inside the table Users.
     */
    List<User> list(final String userName, final String userPwd);

    /**
     * Search for the user with the specified email.
     *
     * @param email The email to search for.
     * @return The user with that email.
     */
    List<User> searchByEmail(final String email);

    /**
     * Search for the user with the spesified facebook id.
     *
     * @param id The facebook id for.
     * @return The user with that facebook id.
     */
    List<User> searchByFacebookId(final String id);

    /**
     * Count the number of users registered per each week of the year.
     *
     * @return a mapping of user count to years/weeks.
     */
    Map<Integer, Map<Integer, Long>> countByWeek();

    /**
     * Reset forum permissions for all users.
     * Is needed when creating a new game and a new forum is constructed.
     */
    void resetAllUsersForumPrivilege();

    /**
     * Insert a new user to the database respecting all external fields.
     *
     * @param thisUser the user to insert.
     */
    void addUser(final User thisUser);


    /**
     * Get a user by his facebook id.
     *
     * @param facebookId the facebook id of the user.
     * @return The user with the given facebook id.
     */
    User getByFacebookId(final String facebookId);

    /**
     * Retrieve the user that has the corresponding uuid for the questionnaire.
     *
     * @param uuid The uuid to find the user for.
     * @return The user.
     */
    User getByQuestionnaireUUID(String uuid);

}

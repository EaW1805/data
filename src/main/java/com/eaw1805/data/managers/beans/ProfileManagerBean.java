package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Profile;
import com.eaw1805.data.model.User;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the player profile objects.
 */
public interface ProfileManagerBean extends EntityBean {

    /**
     * get the Profile from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Profile getByID(int entityID);

    /**
     * Get the Profile from the database that corresponds to the input
     * parameters.
     *
     * @param owner the Owner of the Profile object.
     * @param key   the Key of the Profile object.
     * @return an Entity object.
     */
    Profile getByOwnerKey(final User owner, final String key);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Profile tha we want to add.
     */
    void add(final Profile value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Profile tha we want to update.
     */
    void update(final Profile value);

    /**
     * Delete the input Profile from the database.
     *
     * @param entity the Profile tha we want to delete
     */
    void delete(Profile entity);

    /**
     * Listing all the Profiles from the database.
     *
     * @return a list of all the Profiles that exist inside the table Avatar.
     */
    List<Profile> list();

    /**
     * List al the Profile from the database that corresponds to the input
     * parameters.
     *
     * @param owner the Owner of the Profile object.
     * @return an Entity object.
     */
    List<Profile> listByOwner(final User owner);

    /**
     * List al the Profile from the database that corresponds to the input
     * parameters.
     *
     * @param key the key of the Profile object.
     * @return an Entity object.
     */
    List<Profile> listByKey(final String key);

    /**
     * List the number of achievement points per user.
     *
     * @return The number of achievement points earned.
     */
    List<Profile> listAchievements();

    void delete(final User user);

}

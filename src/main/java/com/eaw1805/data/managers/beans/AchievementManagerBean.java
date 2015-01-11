package com.eaw1805.data.managers.beans;


import com.eaw1805.data.model.Achievement;
import com.eaw1805.data.model.User;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface AchievementManagerBean extends EntityBean {

    /**
     * get the Achievement from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Achievement getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Achievement tha we want to add.
     */
    void add(final Achievement value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Achievement tha we want to update.
     */
    void update(final Achievement value);

    /**
     * Delete the input Achievement from the database.
     *
     * @param entity the Achievement tha we want to delete
     */
    void delete(Achievement entity);

    /**
     * Listing all the Users from the database.
     *
     * @return a list of all the Users that exist inside the table Avatar.
     */
    List<Achievement> list();

    /**
     * Listing all the User's Achievements from the database.
     *
     * @return a list of all the User's Achievements.
     */
    List<Achievement> list(final int userId);

    /**
     * List achievements by category.
     *
     * @param category The category.
     * @return All achievements in a category.
     */
    List<Achievement> listCategory(final int category);

    /**
     * Listing all the User's Achievements from the database.
     *
     * @return a list of all the User's Achievements.
     */
    List<Achievement> listRecent(final int userId);

    /**
     * Listing all the User's Achievements from the database.
     *
     * @return a list of all the User's Achievements.
     */
    List<Achievement> listRecentHonour(final int userId, final int maxResults);

    /**
     * List all user achievements with a specific category, level and description.
     *
     * @param userId The user to get the achievements for.
     * @param category The category of the achievement.
     * @param level The level of the achievements.
     * @param description The description of the achievements.
     * @return A list of achievements.
     */
    List<Achievement> list(final int userId, final int category, final int level, final String description);

    /**
     * Listing all the new User's Achievements from the database.
     *
     * @return a list of all the User's Achievements.
     */
    List<Achievement> listNew(final int userId);

    /**
     * Check if the User has received the particular achievement.
     *
     * @param user     the user to check.
     * @param category the category to check.
     * @param level    the level to check.
     * @return true, if the achievement has been reached.
     */
    boolean checkPlayerCategoryLevel(final User user, final int category, final int level);

    /**
     * Get the number of achievement points for this user.
     *
     * @param user The user to search for.
     * @return The number of achievement points earned.
     */
    Object sumPoints(final User user);

    void delete(User user);

}

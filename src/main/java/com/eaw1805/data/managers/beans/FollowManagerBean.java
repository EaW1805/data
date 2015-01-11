package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Follow;
import com.eaw1805.data.model.User;

import java.util.List;

/**
 * CRUD operations related to following players / followers of a player.
 */
public interface FollowManagerBean
        extends EntityBean {

    /**
     * get the User from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Follow getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the User tha we want to add.
     */
    void add(final Follow value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the User tha we want to update.
     */
    void update(final Follow value);

    /**
     * Delete the input User from the database.
     *
     * @param entity the User tha we want to delete
     */
    void delete(Follow entity);

    /**
     * Listing all the Users from the database.
     *
     * @return a list of all the Users that exist inside the table Avatar.
     */
    List<Follow> list();

    /**
     * Listing all follows by the person being followed.
     *
     * @param user         the user to inspect.
     * @param sortByFollower to sort the entries by the name of the leader, or by the ID of the entry.
     * @return a list of follow objects matching the criteria.
     */
    List<Follow> listByLeader(User user, boolean sortByFollower);

    /**
     * Listing all follows by follower.
     *
     * @param user         the user to inspect.
     * @param sortByLeader to sort the entries by the name of the leader, or by the ID of the entry.
     * @return a list of follow objects matching the criteria.
     */
    List<Follow> listByFollower(User user, boolean sortByLeader);

    /**
     * Identify a leader/follower relation.
     *
     * @param leader   the user object that is leading.
     * @param follower the user object that is following.
     * @return the Follow object matching the criteria.
     */
    List<Follow> getByLeaderFollower(User leader, User follower);

    void delete(final User user);

}

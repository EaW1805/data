package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.army.Rank;

import java.util.List;

/**
 * The interface of the RankManagerBean.
 */
public interface RankManagerBean extends EntityBean {

    /**
     * get the Rank from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    Rank getByID(int entityID);

    /**
     * get the Rank from the database that corresponds to the input name.
     *
     * @param entityName the name of the Entity object.
     * @return an Entity object.
     */
    Rank getByName(final String entityName);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Rank tha we want to add.
     */
    void add(final Rank value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Rank tha we want to update.
     */
    void update(final Rank value);

    /**
     * Delete the input Rank from the database.
     *
     * @param entity the Rank tha we want to delete
     */
    void delete(Rank entity);

    /**
     * Listing all the Ranks from the database.
     *
     * @return a list of all the Ranks that exist inside the table Avatar.
     */
    List<Rank> list();

}

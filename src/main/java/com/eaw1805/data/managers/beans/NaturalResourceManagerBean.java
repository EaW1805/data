package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.map.NaturalResource;

import java.util.List;

/**
 * The interface for NaturalResourceManagerBean.
 */
public interface NaturalResourceManagerBean extends EntityBean {

    /**
     * get the NaturalResource from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    NaturalResource getByID(int entityID);

    /**
     * Get the natural resources from the database that corresponds to
     * the input natural resources char-code.
     *
     * @param param the natural resources char-code.
     * @return an NaturalResource object.
     */
    NaturalResource getByCode(final char param);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the NaturalResource tha we want to add.
     */
    void add(final NaturalResource value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the NaturalResource tha we want to update.
     */
    void update(final NaturalResource value);

    /**
     * Delete the input NaturalResource from the database.
     *
     * @param entity the NaturalResource tha we want to delete
     */
    void delete(NaturalResource entity);

    /**
     * Listing all the NaturalResources from the database.
     *
     * @return a list of all the NaturalResources that exist inside the table Avatar.
     */
    List<NaturalResource> list();
}

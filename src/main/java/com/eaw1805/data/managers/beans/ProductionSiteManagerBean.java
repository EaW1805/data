package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.map.ProductionSite;

import java.util.List;

/**
 * The interface of the ProductionSiteManagerBean.
 */
public interface ProductionSiteManagerBean extends EntityBean {

    /**
     * get the ProductionSite from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    ProductionSite getByID(int entityID);

    /**
     * Get the natural resources from the database that corresponds to
     * the input natural resources char-code.
     *
     * @param entity the natural resources char-code.
     * @return an ProductionSite object.
     */
    ProductionSite getByCode(final char entity);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the ProductionSite tha we want to add.
     */
    void add(final ProductionSite value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the ProductionSite tha we want to update.
     */
    void update(final ProductionSite value);

    /**
     * Delete the input ProductionSite from the database.
     *
     * @param entity the ProductionSite tha we want to delete
     */
    void delete(ProductionSite entity);

    /**
     * Listing all the ProductionSites from the database.
     *
     * @return a list of all the ProductionSites that exist inside the table Avatar.
     */
    List<ProductionSite> list();

}

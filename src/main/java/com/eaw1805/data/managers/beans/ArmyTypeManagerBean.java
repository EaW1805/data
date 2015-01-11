package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.ArmyType;

import java.util.List;

/**
 * The interface of the ArmyTypeManager.
 */
public interface ArmyTypeManagerBean extends EntityBean {

    /**
     * get the ArmyType from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    ArmyType getByID(final int entityID);

    /**
     * get the ArmyType from the database that corresponds to the input short-name and nation.
     *
     * @param entityShortName the name of the Entity object.
     * @param entityNation    the nation of the Entity object.
     * @return an Entity object.
     */
    ArmyType getByShortName(final String entityShortName, final Nation entityNation);

    /**
     * get the ArmyType from the database that corresponds to the input short-name and nation.
     *
     * @param intID        the internal ID of the Entity object.
     * @param entityNation the nation of the Entity object.
     * @return an Entity object.
     */
    ArmyType getByIntID(final int intID, final Nation entityNation);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the ArmyType tha we want to add.
     */
    void add(final ArmyType value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the ArmyType tha we want to update.
     */
    void update(final ArmyType value);

    /**
     * Delete the input ArmyType from the database.
     *
     * @param value the ArmyType tha we want to delete.
     */
    void delete(final ArmyType value);

    /**
     * Listing all the ArmyTypes from the database.
     *
     * @return a list of all the ArmyTypes that exist inside the table.
     */
    List<ArmyType> list();

    /**
     * Listing all the ArmyTypes from the database for the particular nation.
     *
     * @param entityNation the nation of the Entity object.
     * @return a list of all the ArmyTypes that exist inside the table TBL_ARMYTYPES.
     */
    List<ArmyType> list(final Nation entityNation);

}

package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.map.JumpOff;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: karavias
 * Date: 12/23/13
 * Time: 12:12 PM
 * To change this template use File | Settings | File Templates.
 */
public interface JumpOffManagerBean  extends EntityBean {

    /**
     * get the Barrack from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    JumpOff getByID(int entityID);



    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the Barrack tha we want to add.
     */
    void add(final JumpOff value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Barrack tha we want to update.
     */
    void update(final JumpOff value);

    /**
     * Delete the input Barrack from the database.
     *
     * @param entity the Barrack tha we want to delete
     */
    void delete(JumpOff entity);

    /**
     * Listing all the Barracks from the database.
     *
     * @return a list of all the Barracks that exist inside the table Avatar.
     */
    List<JumpOff> list();

    /**
     * Listing all the Barracks from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Barracks.
     */
    List<JumpOff> listByGame(final Game thisGame);


}


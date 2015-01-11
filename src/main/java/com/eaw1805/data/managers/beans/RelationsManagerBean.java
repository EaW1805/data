package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.NationsRelation;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface RelationsManagerBean extends EntityBean {

    /**
     * get the NationsRelation from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    NationsRelation getByID(int entityID);

    /**
     * Get the Relations from the database that corresponds to the input
     * parameters.
     *
     * @param game   the Game of the Report object.
     * @param owner  the Owner of the Report object.
     * @param target the Target of the Report object.
     * @return an Entity object.
     */
    public NationsRelation getByNations(final Game game, final Nation owner, final Nation target);

    /**
     * Get the Relations from the database that corresponds to the input
     * parameters.
     *
     * @param game   the Game of the Report object.
     * @param owner  the Owner of the Report object.
     * @param target the Target of the Report object.
     * @return an Entity object.
     */
    public NationsRelation getByNations(final Game game, final int owner, final int target);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the NationsRelation tha we want to add.
     */
    void add(final NationsRelation value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the NationsRelation tha we want to update.
     */
    void update(final NationsRelation value);

    /**
     * Delete the input NationsRelation from the database.
     *
     * @param entity the NationsRelation tha we want to delete
     */
    void delete(NationsRelation entity);

    /**
     * Listing all the NationsRelations from the database.
     *
     * @return a list of all the NationsRelations that exist inside the table Avatar.
     */
    List<NationsRelation> list();

    /**
     * Listing all the NationsRelations from the database for a particular game.
     *
     * @param thisGame the game to select.
     * @return a list of all the NationsRelations.
     */
    List<NationsRelation> listByGame(final Game thisGame);

    /**
     * Listing all the NationsRelations from the database for a particular game and nation.
     *
     * @param thisGame the game to select.
     * @param owner    the Owner of the Report object.
     * @return a list of all the NationsRelations.
     */
    List<NationsRelation> listByGameNation(final Game thisGame, final Nation owner);

    /**
     * Listing all allied Nations from the database for a particular game and nation.
     *
     * @param thisGame the game to select.
     * @param owner    the Owner of the Report object.
     * @return a list of all the NationsRelations.
     */
    List<NationsRelation> listAlliesByGameNation(final Game thisGame, final Nation owner);

}

package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.News;
import com.eaw1805.data.model.UserGame;

import java.util.List;

/**
 * Defines the interface for managing for CRUD operations of the entity objects.
 */
public interface NewsManagerBean extends EntityBean {

    /**
     * get the News from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    News getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the News tha we want to add.
     */
    void add(final News value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the News tha we want to update.
     */
    void update(final News value);

    /**
     * Delete the input News from the database.
     *
     * @param entity the News tha we want to delete
     */
    void delete(News entity);

    /**
     * Listing all News from the database.
     *
     * @return a list of all the News that exist inside the table Avatar.
     */
    List<News> list();

    /**
     * Listing all News from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param turn     the turn to select.
     * @param nation   the nation to select.
     * @return a list of all the news entries.
     */
    List<News> listGameNation(final Game thisGame, final int turn, final Nation nation);

    /**
     * Listing all News from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of all the news entries.
     */
    List<News> listGameNationType(final Game thisGame, final Nation nation, final int type);

    /**
     * Listing all News from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param turn     the turn to select.
     * @param nation   the nation to select.
     * @return a list of all the news entries.
     */
    List<News> listGameNationAnnouncements(final Game thisGame, final int turn, final Nation nation);

    /**
     * Listing all Public News from the database for the specific turn.
     *
     * @param thisGame the game to select.
     * @param turn     the turn to select.
     * @return a list of all the news entries.
     */
    List<News> listGame(final Game thisGame, final int turn);

    /**
     * Listing all Public News from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the news entries.
     */
    List<News> listPublic(final Game thisGame);

    /**
     * Listing all News from the database children by the specific baseNewsId.
     *
     * @param thisGame   the game to select.
     * @param baseNewsId the base news Id to select.
     * @return a list of all the news entries children to baseNewsId.
     */
    List<News> listBase(final Game thisGame, final int baseNewsId);

    /**
     * Return the total number of newsletters posted by a User.
     *
     * @param userGames the User Games.
     * @return the total number of newsletters.
     */
    int countNewsletter(final List<UserGame> userGames);

}


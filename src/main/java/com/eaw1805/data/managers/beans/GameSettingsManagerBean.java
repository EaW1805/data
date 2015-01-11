package com.eaw1805.data.managers.beans;


import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.GameSettings;
import com.eaw1805.data.model.Nation;

import java.util.List;

public interface GameSettingsManagerBean extends EntityBean {

    /**
     * get the UserGame from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    GameSettings getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the UserGame tha we want to add.
     */
    void add(final GameSettings value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the UserGame tha we want to update.
     */
    void update(final GameSettings value);

    /**
     * Delete the input UserGame from the database.
     *
     * @param entity the UserGame tha we want to delete
     */
    void delete(GameSettings entity);

    /**
     * Listing all the UserGames from the database.
     *
     * @return a list of all the UserGames that exist inside the table Avatar.
     */
    List<GameSettings> list();

    /**
     * Get settings by game and nation.
     *
     * @param game   The game.
     * @param nation The nation.
     * @return The settings.
     */
    List<GameSettings> getByGameNation(final Game game, final Nation nation);
}

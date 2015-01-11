package com.eaw1805.data.managers;

import com.eaw1805.data.managers.beans.GameSettingsManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.GameSettings;
import com.eaw1805.data.model.Nation;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for Game Settings objects.
 */
public class GameSettingsManager extends AbstractManager<GameSettings>
        implements GameSettingsManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static GameSettingsManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public GameSettingsManager() {
        // Does nothing
        super();
    }

    /**
     * GameSettingsManager is loaded on the first execution of GameSettingsManager.getInstance()
     * or the first access to GameSettingsManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static GameSettingsManagerBean getInstance() {
        synchronized (GameSettingsManager.class) {
            if (ourInstance == null) {
                ourInstance = new GameSettingsManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final GameSettingsManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Game/User Settings from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public GameSettings getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(GameSettings.class);
        criteria.add(Restrictions.eq("gameSettingsId", entityID));
        return (GameSettings)criteria.uniqueResult();
    }

    /**
     * Delete the input Game/User Settings from the database.
     *
     * @param value the Game/User Settings that we want to delete
     */
    public void delete(final GameSettings value) {
        super.delete(value, value.getGameSettingsId());
    }

    /**
     * Listing all the Game/User Settings from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    public List<GameSettings> list() {
        return super.list(new GameSettings());
    }

    /**
     * Get the Game/User Settings per Game and Nation.
     *
     * @param game   The game.
     * @param nation The nation.
     * @return a list of GameSettings objects;
     */
    @SuppressWarnings("unchecked")
    public List<GameSettings> getByGameNation(final Game game, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(GameSettings.class);
        criteria.add(Restrictions.eq("game", game));
        criteria.add(Restrictions.eq("nation", nation));
        return criteria.list();
    }


}

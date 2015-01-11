package com.eaw1805.data.managers.army;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.CommanderNameManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.CommanderName;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for CommanderName objects.
 */
public class CommanderNameManager
        extends AbstractManager<CommanderName>
        implements CommanderNameManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static CommanderNameManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public CommanderNameManager() {
        // Does nothing
        super();
    }

    /**
     * CommanderNameManager is loaded on the first execution of
     * CommanderNameManager.getInstance() or the first access to
     * CommanderNameManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static CommanderNameManagerBean getInstance() {
        synchronized (CommanderNameManager.class) {
            if (ourInstance == null) {
                ourInstance = new CommanderNameManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final CommanderNameManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the CommanderName from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public CommanderName getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(CommanderName.class);
        criteria.add(Restrictions.eq("nameId", entityID));
        return (CommanderName)criteria.uniqueResult();
    }

    /**
     * Delete the input entity from the database.
     *
     * @param entity the entity that we want to delete.
     */
    public void delete(final CommanderName entity) {
        super.delete(entity, entity.getNameId());
    }

    /**
     * Listing all the CommanderNames from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    public List<CommanderName> list() {
        return super.list(new CommanderName());
    }

    /**
     * Listing all the CommanderNames from the database owned by the specific nation.
     *
     * @param nation the nation to select.
     * @return a list of all the CommanderNames.
     */
    @SuppressWarnings("unchecked")
    public List<CommanderName> listNation(final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(CommanderName.class);
        criteria.add(Restrictions.eq("nation", nation));
        criteria.addOrder(Order.asc("position"));

        return criteria.list();
    }

    /**
     * Listing all the CommanderNames from the database owned by the specific game.
     *
     * @param game the game to select.
     * @return a list of all the CommanderNames.
     */
    public List<CommanderName> listGame(final Game game) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(CommanderName.class);
        criteria.add(Restrictions.eq("game", game));
        criteria.addOrder(Order.asc("position"));

        return criteria.list();
    }

}

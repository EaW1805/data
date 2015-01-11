package com.eaw1805.data.managers.army;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.ArmyTypeManagerBean;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.army.ArmyType;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for ArmyType objects.
 */
public class ArmyTypeManager
        extends AbstractManager<ArmyType>
        implements ArmyTypeManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static ArmyTypeManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public ArmyTypeManager() {
        // Does nothing
        super();
    }

    /**
     * ArmyTypeManager is loaded on the first execution of
     * ArmyTypeManager.getInstance() or the first access to
     * ArmyTypeManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static ArmyTypeManagerBean getInstance() {
        synchronized (ArmyTypeManager.class) {
            if (ourInstance == null) {
                ourInstance = new ArmyTypeManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final ArmyTypeManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the ArmyType from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public ArmyType getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(ArmyType.class);
        criteria.add(Restrictions.eq("id", entityID));
        return (ArmyType)criteria.uniqueResult();
    }

    /**
     * get the ArmyType from the database that corresponds to the input short-name and nation.
     *
     * @param entityShortName the name of the Entity object.
     * @param entityNation    the nation of the Entity object.
     * @return an Entity object.
     */
    @SuppressWarnings("unchecked")
    public ArmyType getByShortName(final String entityShortName, final Nation entityNation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(ArmyType.class);
        criteria.add(Restrictions.eq("shortName", entityShortName));
        criteria.add(Restrictions.eq("nation", entityNation));

        return (ArmyType) criteria.uniqueResult();
    }

    /**
     * get the ArmyType from the database that corresponds to the input short-name and nation.
     *
     * @param intID        the internal ID of the Entity object.
     * @param entityNation the nation of the Entity object.
     * @return an Entity object.
     */
    @SuppressWarnings("unchecked")
    public ArmyType getByIntID(final int intID, final Nation entityNation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(ArmyType.class);
        criteria.add(Restrictions.eq("intId", intID));
        criteria.add(Restrictions.eq("nation", entityNation));

        return (ArmyType) criteria.uniqueResult();
    }

    /**
     * Delete the input type from the database.
     *
     * @param type the type tha we want to delete
     */
    public void delete(final ArmyType type) {
        super.delete(type, type.getId());
    }

    /**
     * Listing all the ArmyTypes from the database.
     *
     * @return a list of all the ArmyTypes that exist inside the table TBL_ARMYTYPES.
     */
    public List<ArmyType> list() {
        return super.list(new ArmyType());
    }

    /**
     * Listing all the ArmyTypes from the database for the particular nation.
     *
     * @param entityNation the nation of the Entity object.
     * @return a list of all the ArmyTypes that exist inside the table TBL_ARMYTYPES.
     */
    @SuppressWarnings("unchecked")
    public List<ArmyType> list(final Nation entityNation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(ArmyType.class);
        criteria.add(Restrictions.eq("nation", entityNation));
        criteria.addOrder(Order.asc("intId"));

        return criteria.list();
    }
}

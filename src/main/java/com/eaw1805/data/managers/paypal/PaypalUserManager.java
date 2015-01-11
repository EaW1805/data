package com.eaw1805.data.managers.paypal;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.PaypalUserManagerBean;
import com.eaw1805.data.model.paypal.PaypalUserProfile;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for PaypalUserProfile objects.
 */
public class PaypalUserManager extends AbstractManager<PaypalUserProfile>
        implements PaypalUserManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static PaypalUserManager ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public) default constructor.
     */
    public PaypalUserManager() {
        // Does nothing
        super();
    }

    /**
     * PaypalUserManager is loaded on the first execution of PaypalUserManager.getInstance()
     * or the first access to PaypalUserManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static PaypalUserManager getInstance() {
        synchronized (PaypalUserManager.class) {
            if (ourInstance == null) {
                ourInstance = new PaypalUserManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final PaypalUserManager thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the PaypalUserProfile from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public PaypalUserProfile getByID(final int entityID) {
        return super.getByID(new PaypalUserProfile(), entityID);
    }

    /**
     * get the PaypalUserProfile from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    @Override
    public PaypalUserProfile getByUserID(int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PaypalUserProfile.class);
        criteria.add(Restrictions.eq("user.userId", entityID));
        return (PaypalUserProfile) criteria.uniqueResult();
    }

    /**
     * get the PaypalUserProfile from the database that corresponds to the input id.
     *
     * @param entityID the String of the Entity object.
     * @return an Entity object.
     */
    @Override
    public PaypalUserProfile getByPaypalID(final String entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PaypalUserProfile.class);
        criteria.add(Restrictions.eq("payerID", entityID));
        return (PaypalUserProfile) criteria.uniqueResult();
    }

    /**
     * Delete the input PaypalUserProfile from the database.
     *
     * @param user the PaypalUserProfile tha we want to delete
     */
    public void delete(final PaypalUserProfile user) {
        super.delete(user, user.getId());
    }

    /**
     * Listing all the Users from the database.
     *
     * @return a list of all the Avatars that exist inside the table Users.
     */
    @SuppressWarnings("unchecked")
    public List<PaypalUserProfile> list() {
        return super.list(new PaypalUserProfile());
    }
}

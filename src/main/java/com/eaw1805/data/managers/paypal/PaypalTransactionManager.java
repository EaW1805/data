package com.eaw1805.data.managers.paypal;


import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.PaypalTransactionManagerBean;
import com.eaw1805.data.model.paypal.PaypalTransaction;
import com.eaw1805.data.model.paypal.PaypalUserProfile;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for PaypalTransaction objects.
 */
public class PaypalTransactionManager extends AbstractManager<PaypalTransaction>
        implements PaypalTransactionManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static PaypalTransactionManager ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public) default constructor.
     */
    public PaypalTransactionManager() {
        // Does nothing
        super();
    }

    /**
     * PaypalTransactionManager is loaded on the first execution of PaypalTransactionManager.getInstance()
     * or the first access to PaypalTransactionManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static PaypalTransactionManager getInstance() {
        synchronized (PaypalUserManager.class) {
            if (ourInstance == null) {
                ourInstance = new PaypalTransactionManager();
            }
        }

        return ourInstance;
    }

    /**
     * get the Paypal Transaction from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    @Override
    public PaypalTransaction getByID(int entityID){
        return super.getByID(new PaypalTransaction(), entityID);
    }

    /**
     * Delete the input PaypalTransaction from the database.
     *
     * @param entity the PaypalTransaction tha we want to delete
     */
    @Override
    public void delete(PaypalTransaction entity){
        super.delete(entity, entity.getId());
    }

    /**
     * Listing all the PaypalTransaction from the database.
     *
     * @return a list of all the PaypalTransaction that exist inside the table Avatar.
     */
    @Override
    public List<PaypalTransaction> list(){
        return super.list(new PaypalTransaction());
    }

    /**
     * get the Paypal Transaction from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    @Override
    public PaypalTransaction getByPayerID(final PaypalUserProfile entityID){
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PaypalTransaction.class);
        criteria.add(Restrictions.eq("payer", entityID));
        return (PaypalTransaction) criteria.uniqueResult();
    }

    /**
     * get the Paypal Transaction from the database that corresponds to the input id.
     *
     * @param entityID the String of the Entity object.
     * @return an Entity object.
     */
    @Override
    public  PaypalTransaction getByPaypalTransactionlID(final String entityID){
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(PaypalTransaction.class);
        criteria.add(Restrictions.eq("transactionId", entityID));
        return (PaypalTransaction) criteria.uniqueResult();
    }



}

package com.eaw1805.data.managers.map;

import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.JumpOffManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.map.JumpOff;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;


public class JumpOffManager extends AbstractManager<JumpOff>
        implements JumpOffManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static JumpOffManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public)
     * default constructor.
     */
    public JumpOffManager() {
        // Does nothing
        super();
    }

    /**
     * BarrackManager is loaded on the first execution of
     * BarrackManager.getInstance() or the first access to
     * BarrackManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static JumpOffManagerBean getInstance() {
        synchronized (JumpOffManager.class) {
            if (ourInstance == null) {
                ourInstance = new JumpOffManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final JumpOffManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Barrack from the database that corresponds to the input id.
     *
     * @param jumpOffId the id of the Barrack object.
     * @return an Barrack object.
     */
    public JumpOff getByID(final int jumpOffId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(JumpOff.class);
        criteria.add(Restrictions.eq("id", jumpOffId));
        return (JumpOff)criteria.uniqueResult();
    }



    /**
     * Delete the input Barrack from the database.
     *
     * @param jumpOff the Barrack tha we want to delete
     */
    public void delete(final JumpOff jumpOff) {
        super.delete(jumpOff, jumpOff.getJumpOffId());
    }

    /**
     * Listing all the Barracks from the database.
     *
     * @return a list of all the Barracks.
     */
    public List<JumpOff> list() {
        return super.list(new JumpOff());
    }

    /**
     * Listing all the Barracks from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Barracks.
     */
    @SuppressWarnings("unchecked")
    public List<JumpOff> listByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(JumpOff.class);
        criteria.add(Restrictions.eq("departure.game", thisGame));
        criteria.addOrder(Order.asc("departure.region"));
        criteria.addOrder(Order.asc("departure.y"));
        criteria.addOrder(Order.asc("departure.x"));

        return criteria.list();
    }


}

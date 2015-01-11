package com.eaw1805.data.managers;

import com.eaw1805.data.constants.NewsConstants;
import com.eaw1805.data.managers.beans.NewsManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.News;
import com.eaw1805.data.model.UserGame;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * CRUD operations for News objects.
 */
public class NewsManager
        extends AbstractManager<News>
        implements NewsManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static NewsManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public NewsManager() {
        // Does nothing
        super();
    }

    /**
     * GameManager is loaded on the first execution of NewsManager.getInstance()
     * or the first access to NewsManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static NewsManagerBean getInstance() {
        synchronized (NewsManager.class) {
            if (ourInstance == null) {
                ourInstance = new NewsManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final NewsManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the News from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public News getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(News.class);
        criteria.add(Restrictions.eq("newsId", entityID));
        return (News)criteria.uniqueResult();
    }

    /**
     * Delete the input News entry from the database.
     *
     * @param entry the News entry tha we want to delete.
     */
    public void delete(final News entry) {
        super.delete(entry, entry.getNewsId());
    }

    /**
     * Listing all News from the database.
     *
     * @return a list of all the News entries that exist inside the table NEWS.
     */
    public List<News> list() {
        return super.list(new com.eaw1805.data.model.News());
    }

    /**
     * Listing all News from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param turn     the turn to select.
     * @param nation   the nation to select.
     * @return a list of news entries.
     */
    @SuppressWarnings("unchecked")
    public List<News> listGameNation(final Game thisGame, final int turn, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(News.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.eq("turn", turn));
        //criteria.add(Restrictions.or(Restrictions.eq("nation", nation), Restrictions.eq("announcement", true)));
        criteria.add(Restrictions.eq("nation", nation));
        criteria.addOrder(Order.asc("type"));
        criteria.addOrder(Order.asc("newsId"));
        return criteria.list();
    }

    /**
     * Listing all News from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param nation   the nation to select.
     * @return a list of news entries.
     */
    @SuppressWarnings("unchecked")
    public List<News> listGameNationType(final Game thisGame, final Nation nation, final int type) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(News.class);
        criteria.add(Restrictions.eq("game", thisGame));
        //criteria.add(Restrictions.or(Restrictions.eq("nation", nation), Restrictions.eq("announcement", true)));
        criteria.add(Restrictions.eq("nation", nation));
        criteria.add(Restrictions.eq("type", type));
        criteria.addOrder(Order.asc("type"));
        criteria.addOrder(Order.asc("newsId"));
        return criteria.list();
    }

    /**
     * Listing all News from the database owned by the specific nation.
     *
     * @param thisGame the game to select.
     * @param turn     the turn to select.
     * @param nation   the nation to select.
     * @return a list of news entries.
     */
    @SuppressWarnings("unchecked")
    public List<News> listGameNationAnnouncements(final Game thisGame, final int turn, final Nation nation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(News.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.eq("turn", turn));
        criteria.add(Restrictions.eq("nation", nation));
        criteria.add(Restrictions.eq("subject", nation));
        criteria.addOrder(Order.asc("newsId"));
        return criteria.list();
    }

    /**
     * Listing all News from the database for the specific game.
     *
     * @param thisGame the game to select.
     * @param turn     the turn to select.
     * @return a list of news entries.
     */
    @SuppressWarnings("unchecked")
    public List<News> listGame(final Game thisGame, final int turn) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(News.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.eq("turn", turn));
        criteria.add(Restrictions.eq("global", true));
        criteria.addOrder(Order.asc("newsId"));
        return criteria.list();
    }

    /**
     * Listing all Public News from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the news entries.
     */
    @SuppressWarnings("unchecked")
    public List<News> listPublic(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(News.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.eq("global", true));
        criteria.addOrder(Order.asc("newsId"));
        return criteria.list();
    }

    /**
     * Listing all News from the database children by the specific baseNewsId.
     *
     * @param thisGame   the game to select.
     * @param baseNewsId the base news Id to select.
     * @return a list of all the news entries children to baseNewsId.
     */
    @SuppressWarnings("unchecked")
    public List<News> listBase(final Game thisGame, final int baseNewsId) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(News.class);
        criteria.add(Restrictions.eq("game", thisGame));
        criteria.add(Restrictions.eq("baseNewsId", baseNewsId));
        criteria.addOrder(Order.asc("newsId"));
        return criteria.list();
    }

    /**
     * Return the total number of newsletters posted by a User.
     *
     * @param userGames the User Games.
     * @return the total number of newsletters.
     */
    public int countNewsletter(final List<UserGame> userGames) {
        int count = 0;
        for (final UserGame userGame : userGames) {
            final Session session = getSessionFactory().getCurrentSession();
            final Criteria criteria = session.createCriteria(News.class);
            criteria.add(Restrictions.eq("nation.id", -1));
            criteria.add(Restrictions.eq("type", NewsConstants.NEWS_LETTER));
            criteria.add(Restrictions.eq("game", userGame.getGame()));
            criteria.add(Restrictions.eq("subject", userGame.getNation()));

            final int pickup = userGame.getTurnPickUp();
            int drop = userGame.getTurnDrop();
            if (drop == 0) {
                drop = userGame.getGame().getTurn();
            }
            final List<Integer> turnsPlayed = new ArrayList<Integer>();
            for (int i = pickup; i < drop; i++) {
                turnsPlayed.add(i);
            }
            if (turnsPlayed.size() > 0) {
                criteria.add(Restrictions.in("turn", turnsPlayed));
            }

            count += criteria.list().size();

        }
        return count;
    }

}


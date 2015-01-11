package com.eaw1805.data.managers.map;

import com.eaw1805.data.managers.beans.RegionManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.map.Region;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * CRUD operations for Region objects.
 */
public class RegionManager
        extends com.eaw1805.data.managers.AbstractManager<Region>
        implements RegionManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static RegionManagerBean ourInstance = null;

    /**
     * Public constructor .
     */
    public RegionManager() {
        // Does nothing
        super();
    }

    /**
     * RegionManager is loaded on the first execution of
     * RegionManager.getInstance() or the first access to
     * RegionManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static RegionManagerBean getInstance() {
        synchronized (RegionManager.class) {
            if (ourInstance == null) {
                ourInstance = new RegionManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final RegionManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Region from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public Region getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Region.class);
        criteria.add(Restrictions.eq("id", entityID));
        return (Region)criteria.uniqueResult();
    }

    /**
     * Delete the input region from the database.
     *
     * @param region the region tha we want to delete
     */
    public void delete(final Region region) {
        super.delete(region, region.getId());
    }

    /**
     * Listing all the Regions from the database.
     *
     * @return a list of all the entries that exist inside the table Region.
     */
    public List<Region> list() {
        return super.list(new Region());
    }

    /**
     * Listing all the Regions from the database for a game.
     *
     * @return a list of all the Regions that exist inside the table Avatar.
     */
    public List<Region> list(final Game game) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Region.class);
        criteria.add(Restrictions.eq("game", game));
        return criteria.addOrder(Order.asc("id")).list();
    }

    /**
     * This methods has all the deletion queries needed all
     * region associations created by the scenario editor.
     *
     * !!This doesn't deletes the Region object, only the meta data!!
     *
     * @param regionId The  region id to delete
     */
    public void deleteScenarioRegionAssoc(final int regionId) {
        final Session session = getSessionFactory().getCurrentSession();

        session.createSQLQuery("DELETE FROM WAREHOUSE_GOODS WHERE WAREHOUSE_GOODS.WAREHOUSE_ID IN (SELECT WAREHOUSE_ID FROM WAREHOUSES WHERE REGION_ID = " + regionId + ");").executeUpdate();
        session.createSQLQuery("DELETE FROM WAREHOUSES WHERE REGION_ID = " + regionId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM BAGGAGETRAINS_GOODS WHERE BAGGAGETRAINS_GOODS.BAGGAGETRAIN_ID IN (SELECT BAGGAGETRAIN_ID FROM BAGGAGETRAINS WHERE REGION_ID = " + regionId + ");").executeUpdate();
        session.createSQLQuery("DELETE FROM BAGGAGETRAINS WHERE REGION_ID = " + regionId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM BARRACKS WHERE REGION_ID = " + regionId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM BATTALIONS WHERE BATTALIONS.BRIGADE_ID IN (SELECT BRIGADE_ID FROM BRIGADES WHERE REGION_ID = " + regionId + ");").executeUpdate();
        session.createSQLQuery("DELETE FROM BRIGADES WHERE REGION_ID = " + regionId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM CORPS WHERE REGION_ID = " + regionId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM ARMIES WHERE REGION_ID = " + regionId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM COMMANDERS WHERE REGION_ID = " + regionId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM SHIPS_GOODS WHERE SHIPS_GOODS.SHIP_ID IN (SELECT SHIP_ID FROM SHIPS WHERE REGION_ID = " + regionId + ");").executeUpdate();
        session.createSQLQuery("DELETE FROM SHIPS WHERE REGION_ID = " + regionId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM FLEETS WHERE REGION_ID = " + regionId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM SPIES WHERE REGION_ID = " + regionId + ";").executeUpdate();
//        session.createSQLQuery("DELETE FROM SECTORS WHERE REGION_ID = " + regionId + ";").executeUpdate();
        session.createSQLQuery("DELETE FROM JUMPOFF_POINTS WHERE REGION_DEP = " + regionId + " OR REGION_DEST = " + regionId + ";").executeUpdate();

    }


}

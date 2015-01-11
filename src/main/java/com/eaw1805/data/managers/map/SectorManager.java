package com.eaw1805.data.managers.map;

import com.eaw1805.data.constants.NaturalResourcesConstants;
import com.eaw1805.data.constants.ProductionSiteConstants;
import com.eaw1805.data.constants.RegionConstants;
import com.eaw1805.data.constants.TerrainConstants;
import com.eaw1805.data.managers.AbstractManager;
import com.eaw1805.data.managers.beans.SectorManagerBean;
import com.eaw1805.data.model.Game;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.map.Position;
import com.eaw1805.data.model.map.ProductionSite;
import com.eaw1805.data.model.map.Region;
import com.eaw1805.data.model.map.Sector;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.List;

/**
 * CRUD operations for Sector objects.
 */
public class SectorManager
        extends AbstractManager<Sector>
        implements SectorManagerBean {

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static SectorManagerBean ourInstance = null;

    /**
     * Private constructor suppresses generation of a (public)
     * default constructor.
     */
    public SectorManager() {
        // Does nothing
        super();
    }

    /**
     * SectorManager is loaded on the first execution of
     * SectorManager.getInstance() or the first access to
     * SectorManager.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static SectorManagerBean getInstance() {
        synchronized (SectorManager.class) {
            if (ourInstance == null) {
                ourInstance = new SectorManager();
            }
        }

        return ourInstance;
    }

    /**
     * Set the global instance of the manager. Used for the integration with Spring.
     *
     * @param thisInstance the manager bean.
     */
    public static void setInstance(final SectorManagerBean thisInstance) {
        ourInstance = thisInstance;
    }

    /**
     * get the Sector from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    public Sector getByID(final int entityID) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("id", entityID));
        return (Sector) criteria.uniqueResult();
    }

    /**
     * Get the sector from the database that corresponds to the input entity.
     *
     * @param entity the coordinates.
     * @return an Entity object.
     */
    public Sector getByPosition(final Position entity) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Sector.class);
        if (entity.getGame() == null) {
            criteria.add(Restrictions.isNull("position.game"));
        } else {
            criteria.add(Restrictions.eq("position.game", entity.getGame()));
        }
        criteria.add(Restrictions.eq("position.region", entity.getRegion()));
        criteria.add(Restrictions.eq("position.x", entity.getX()));
        criteria.add(Restrictions.eq("position.y", entity.getY()));

        return (Sector) criteria.uniqueResult();
    }

    /**
     * Get the sector from the database that corresponds to the input position.
     *
     * @param entity the Region.
     * @return an Entity object.
     */
    public Sector getByRegion(final Region entity) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("region", entity));

        return (Sector) criteria.uniqueResult();
    }

    /**
     * Delete the input Sector from the database.
     *
     * @param entity the Sector that we want to delete
     */
    public void delete(final Sector entity) {
        super.delete(entity, entity.getId());
    }

    /**
     * Listing all the Sectors from the database.
     *
     * @return a list of all the Avatars that exist inside the table Avatar.
     */
    public List<Sector> list() {
        return super.list(new Sector());
    }

    /**
     * Listing all the Sectors from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        return criteria.list();
    }

    /**
     * Listing all sea Sectors from the database that with fish and without storms
     *
     * @param thisGame the game to select.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listSeaByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("terrain.id", TerrainConstants.TERRAIN_O));
        criteria.add(Restrictions.eq("naturalResource.id", NaturalResourcesConstants.NATRES_FISH));
        criteria.add(Restrictions.eq("storm", 0));
        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        return criteria.list();
    }

    /**
     * Listing all the Sectors from the database.
     *
     * @param thisGame   the game to select.
     * @param thisRegion the region to select.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listByGameRegion(final Game thisGame, final Region thisRegion) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", thisRegion));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        return criteria.list();
    }

    /**
     * Listing all land Sectors from the database that have not any epidemic on them.
     *
     * @param thisGame   the game to select.
     * @param thisRegion the region to select.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listLandByGameRegion(final Game thisGame, final Region thisRegion) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", thisRegion));
        criteria.add(Restrictions.ne("terrain.id", TerrainConstants.TERRAIN_O));
        criteria.add(Restrictions.eq("epidemic", false));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        return criteria.list();
    }

    /**
     * Listing all sea Sectors from the database that have not any storm on them.
     *
     * @param thisGame      the game to select.
     * @param thisRegion    the region to select.
     * @param includeStorms true, to include storm sectors in the list.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listSeaByGameRegion(final Game thisGame, final Region thisRegion, final boolean includeStorms) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", thisRegion));
        criteria.add(Restrictions.eq("terrain.id", TerrainConstants.TERRAIN_O));
        if (!includeStorms) {
            criteria.add(Restrictions.eq("storm", 0));
        }
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        return criteria.list();
    }

    /**
     * Listing all sea Sectors adjacent to a sector.
     *
     * @param thisPosition the position to select.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listAdjacentSea(final Position thisPosition) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT SECTOR_ID FROM `SECTORS` " +
                "WHERE GAME_ID = " + thisPosition.getGame().getGameId() +
                " AND REGION_ID = " + thisPosition.getRegion().getId() +
                " AND TERRAIN_ID = " + TerrainConstants.TERRAIN_O +
                " AND ((x = " + (thisPosition.getX() - 1) + " AND y = " + (thisPosition.getY() - 1) + ") " +
                "      OR (x = " + (thisPosition.getX() - 1) + " AND y = " + (thisPosition.getY()) + ") " +
                "      OR (x = " + (thisPosition.getX() - 1) + " AND y = " + (thisPosition.getY() + 1) + ") " +
                "      OR (x = " + (thisPosition.getX()) + " AND y = " + (thisPosition.getY() - 1) + ") " +
                "      OR (x = " + (thisPosition.getX()) + " AND y = " + (thisPosition.getY() + 1) + ") " +
                "      OR (x = " + (thisPosition.getX() + 1) + " AND y = " + (thisPosition.getY() - 1) + ") " +
                "      OR (x = " + (thisPosition.getX() + 1) + " AND y = " + (thisPosition.getY()) + ") " +
                "      OR (x = " + (thisPosition.getX() + 1) + " AND y = " + (thisPosition.getY() + 1) + "))";

        final List<Integer> lstResults = session.createSQLQuery(thisQuery).list();

        // construct list
        final List<Sector> theList = new ArrayList<Sector>();

        // Iterate through results and populate map
        for (Integer sectorId : lstResults) {
            theList.add(getByID(sectorId));
        }

        return theList;
    }

    /**
     * Listing all land Sectors adjacent to a sector.
     *
     * @param thisPosition the position to select.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listAdjacentLand(final Position thisPosition) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT SECTOR_ID FROM `SECTORS` " +
                "WHERE GAME_ID = " + thisPosition.getGame().getGameId() +
                " AND REGION_ID = " + thisPosition.getRegion().getId() +
                " AND TERRAIN_ID <> " + TerrainConstants.TERRAIN_O +
                " AND ((x = " + (thisPosition.getX() - 1) + " AND y = " + (thisPosition.getY() - 1) + ") " +
                "      OR (x = " + (thisPosition.getX() - 1) + " AND y = " + (thisPosition.getY()) + ") " +
                "      OR (x = " + (thisPosition.getX() - 1) + " AND y = " + (thisPosition.getY() + 1) + ") " +
                "      OR (x = " + (thisPosition.getX()) + " AND y = " + (thisPosition.getY() - 1) + ") " +
                "      OR (x = " + (thisPosition.getX()) + " AND y = " + (thisPosition.getY() + 1) + ") " +
                "      OR (x = " + (thisPosition.getX() + 1) + " AND y = " + (thisPosition.getY() - 1) + ") " +
                "      OR (x = " + (thisPosition.getX() + 1) + " AND y = " + (thisPosition.getY()) + ") " +
                "      OR (x = " + (thisPosition.getX() + 1) + " AND y = " + (thisPosition.getY() + 1) + "))";

        final List<Integer> lstResults = session.createSQLQuery(thisQuery).list();

        // construct list
        final List<Sector> theList = new ArrayList<Sector>();

        // Iterate through results and populate map
        for (Integer sectorId : lstResults) {
            theList.add(getByID(sectorId));
        }

        return theList;
    }

    /**
     * Listing all arctic sea Sectors from the database that have not any storm on them.
     *
     * @param thisGame the game to select.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listArcSeaByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Region europe = (Region) session.get(Region.class, RegionConstants.EUROPE);
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", europe));
        criteria.add(Restrictions.eq("terrain.id", TerrainConstants.TERRAIN_O));
        criteria.add(Restrictions.eq("storm", 0));
        criteria.add(Restrictions.le("position.y", 10));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        return criteria.list();
    }

    /**
     * Listing all central sea Sectors from the database that have not any storm on them.
     *
     * @param thisGame the game to select.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listCentralSeaByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Region europe = (Region) session.get(Region.class, RegionConstants.EUROPE);
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", europe));
        criteria.add(Restrictions.eq("terrain.id", TerrainConstants.TERRAIN_O));
        criteria.add(Restrictions.eq("storm", 0));
        criteria.add(Restrictions.between("position.y", 11, 35));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        return criteria.list();
    }

    /**
     * Listing all mediterranean sea Sectors from the database that have not any storm on them.
     *
     * @param thisGame the game to select.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listMedSeaByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Region europe = (Region) session.get(Region.class, RegionConstants.EUROPE);
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", europe));
        criteria.add(Restrictions.eq("terrain.id", TerrainConstants.TERRAIN_O));
        criteria.add(Restrictions.eq("storm", 0));
        criteria.add(Restrictions.ge("position.y", 36));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        return criteria.list();
    }

    /**
     * Listing all the Sectors from the database.
     *
     * @param thisGame   the game to select.
     * @param thisRegion the region to select.
     * @param minX       the top-left X coordinate.
     * @param minY       the top-left Y coordinate.
     * @param maxX       the bottom-right X coordinate.
     * @param maxY       the bottom-right Y coordinate.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listByGameRegion(final Game thisGame, final Region thisRegion,
                                         final int minX, final int minY,
                                         final int maxX, final int maxY) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", thisRegion));
        criteria.add(Restrictions.ge("position.x", minX));
        criteria.add(Restrictions.le("position.x", maxX));
        criteria.add(Restrictions.ge("position.y", minY));
        criteria.add(Restrictions.le("position.y", maxY));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        return criteria.list();
    }

    /**
     * Listing all the Sectors from the database.
     *
     * @param thisGame   the game to select.
     * @param thisRegion the region to select.
     * @param minX       the top-left X coordinate.
     * @param minY       the top-left Y coordinate.
     * @param maxX       the bottom-right X coordinate.
     * @param maxY       the bottom-right Y coordinate.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listLandByGameRegion(final Game thisGame, final Region thisRegion,
                                             final int minX, final int minY,
                                             final int maxX, final int maxY) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.ne("terrain.id", TerrainConstants.TERRAIN_O));
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", thisRegion));
        criteria.add(Restrictions.ge("position.x", minX));
        criteria.add(Restrictions.le("position.x", maxX));
        criteria.add(Restrictions.ge("position.y", minY));
        criteria.add(Restrictions.le("position.y", maxY));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        return criteria.list();
    }

    /**
     * Listing all the Sectors from the database.
     *
     * @param thisGame   the game to select.
     * @param thisNation the owner of the sector.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listByGameNation(final Game thisGame,
                                         final Nation thisNation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("nation", thisNation));
        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        return criteria.list();
    }

    /**
     * Listing all the Sectors from the database.
     *
     * @param thisGame   the game to select.
     * @param thisRegion the region to select.
     * @param thisNation the owner of the sector.
     * @param tradeCity  if the sector is a economy city.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listByGameRegionNation(final Game thisGame,
                                               final Region thisRegion,
                                               final Nation thisNation,
                                               final boolean tradeCity) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", thisRegion));
        criteria.add(Restrictions.eq("nation", thisNation));
        criteria.add(Restrictions.eq("tradeCity", tradeCity));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        return criteria.list();
    }

    /**
     * Listing all the Sectors from the database.
     *
     * @param thisGame   the game to select.
     * @param thisRegion the region to select.
     * @param thisNation the owner of the sector.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listByGameRegionNation(final Game thisGame,
                                               final Region thisRegion,
                                               final Nation thisNation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", thisRegion));
        criteria.add(Restrictions.eq("nation", thisNation));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        return criteria.list();
    }

    /**
     * Listing all the Sectors from the database that contain a barrack or ship yard..
     *
     * @param thisGame   the game to select.
     * @param thisRegion the region to select.
     * @param thisNation the nation to select.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listBarracksByGameRegionNation(final Game thisGame, final Region thisRegion, final Nation thisNation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", thisRegion));
        criteria.add(Restrictions.eq("nation", thisNation));

        final ProductionSite[] values = new ProductionSite[5];
        values[0] = (ProductionSite) session.get(ProductionSite.class, ProductionSiteConstants.PS_BARRACKS);
        values[1] = (ProductionSite) session.get(ProductionSite.class, ProductionSiteConstants.PS_BARRACKS_FS);
        values[2] = (ProductionSite) session.get(ProductionSite.class, ProductionSiteConstants.PS_BARRACKS_FM);
        values[3] = (ProductionSite) session.get(ProductionSite.class, ProductionSiteConstants.PS_BARRACKS_FL);
        values[4] = (ProductionSite) session.get(ProductionSite.class, ProductionSiteConstants.PS_BARRACKS_FH);

        final LogicalExpression r1 = Restrictions.or(Restrictions.eq("productionSite", values[0]), Restrictions.eq("productionSite", values[1]));
        final LogicalExpression r2 = Restrictions.or(Restrictions.eq("productionSite", values[2]), Restrictions.eq("productionSite", values[3]));

        final LogicalExpression rr1 = Restrictions.or(Restrictions.eq("productionSite", values[4]), r1);

        final LogicalExpression rrr = Restrictions.or(rr1, r2);

        criteria.add(rrr);

        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));

        return criteria.list();
    }

    /**
     * Listing all the Sectors from the database that contain a barrack or ship yard..
     *
     * @param thisGame   the game to select.
     * @param thisNation the nation to select.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listBarracksByGameNation(final Game thisGame, final Nation thisNation) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("nation", thisNation));

        final ProductionSite[] values = new ProductionSite[5];
        values[0] = (ProductionSite) session.get(ProductionSite.class, ProductionSiteConstants.PS_BARRACKS);
        values[1] = (ProductionSite) session.get(ProductionSite.class, ProductionSiteConstants.PS_BARRACKS_FS);
        values[2] = (ProductionSite) session.get(ProductionSite.class, ProductionSiteConstants.PS_BARRACKS_FM);
        values[3] = (ProductionSite) session.get(ProductionSite.class, ProductionSiteConstants.PS_BARRACKS_FL);
        values[4] = (ProductionSite) session.get(ProductionSite.class, ProductionSiteConstants.PS_BARRACKS_FH);

        final LogicalExpression r1 = Restrictions.or(Restrictions.eq("productionSite", values[0]), Restrictions.eq("productionSite", values[1]));
        final LogicalExpression r2 = Restrictions.or(Restrictions.eq("productionSite", values[2]), Restrictions.eq("productionSite", values[3]));

        final LogicalExpression rr1 = Restrictions.or(Restrictions.eq("productionSite", values[4]), r1);

        final LogicalExpression rrr = Restrictions.or(rr1, r2);

        criteria.add(rrr);

        criteria.addOrder(Order.asc("position.region"));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));

        return criteria.list();
    }

    /**
     * Remove all conquer counters from a specific game.
     *
     * @param thisGame the game to select.
     */
    public void removeConquer(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "UPDATE SECTORS SET `conquered` = 0, `TEMP_NATION_ID`=`NATION_ID` " +
                " WHERE SECTORS.GAME_ID = " + thisGame.getGameId();

        session.createSQLQuery(thisQuery).executeUpdate();
    }

    /**
     * Remove all the epidemics and rebellions from a specific game.
     *
     * @param thisGame the game to select.
     */
    public void removeEpidemics(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "UPDATE SECTORS SET `epidemic` = 0, `rebelled`= 0 " +
                " WHERE SECTORS.GAME_ID = " + thisGame.getGameId();

        session.createSQLQuery(thisQuery).executeUpdate();
    }

    /**
     * Listing all the Storm centers from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listStormsByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("storm", 2));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        return criteria.list();
    }

    /**
     * Listing all the arctic Storm centers from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listArcStormsByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Region europe = (Region) session.get(Region.class, RegionConstants.EUROPE);
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", europe));
        criteria.add(Restrictions.eq("storm", 2));
        criteria.add(Restrictions.le("position.y", 10));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        return criteria.list();
    }

    /**
     * Listing all the central Storm centers from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listCentralStormsByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Region europe = (Region) session.get(Region.class, RegionConstants.EUROPE);
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", europe));
        criteria.add(Restrictions.eq("storm", 2));
        criteria.add(Restrictions.between("position.y", 11, 35));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        return criteria.list();
    }

    /**
     * Listing all the Mediterranean Storm centers from the database.
     *
     * @param thisGame the game to select.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listMedStormsByGame(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final Region europe = (Region) session.get(Region.class, RegionConstants.EUROPE);
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", europe));
        criteria.add(Restrictions.eq("storm", 2));
        criteria.add(Restrictions.ge("position.y", 36));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        return criteria.list();
    }

    /**
     * Listing all the Storm centers from the database.
     *
     * @param thisGame   the game to select.
     * @param thisRegion the region to select.
     * @return a list of all the Sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listStormsByGameRegion(final Game thisGame,
                                               final Region thisRegion) {
        final Session session = getSessionFactory().getCurrentSession();
        final Criteria criteria = session.createCriteria(Sector.class);
        criteria.add(Restrictions.eq("position.game", thisGame));
        criteria.add(Restrictions.eq("position.region", thisRegion));
        criteria.add(Restrictions.eq("storm", 2));
        criteria.addOrder(Order.asc("position.y"));
        criteria.addOrder(Order.asc("position.x"));
        return criteria.list();
    }

    /**
     * Remove all the storms from a specific game except the storm centers.
     *
     * @param thisGame the game to select.
     */
    public void removeStorms(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "UPDATE SECTORS SET `storm` = 0 " +
                " WHERE SECTORS.GAME_ID = " + thisGame.getGameId() +
                " AND `storm` = 1";

        session.createSQLQuery(thisQuery).executeUpdate();
    }

    /**
     * Remove all fog of war elements for a particular game.
     *
     * @param thisGame the game to select.
     */
    public void removeFOW(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "UPDATE SECTORS SET `fow` = '*' " +
                " WHERE SECTORS.GAME_ID = " + thisGame.getGameId();

        session.createSQLQuery(thisQuery).executeUpdate();
    }

    /**
     * Determine if the given position is adjacent to a coastal tile owned by the given nation.
     *
     * @param thisPosition the position.
     * @param thisNation   the nation.
     * @return if the given position is next to a coastal tile or not.
     */
    public boolean checkNationCoastal(final Position thisPosition, final Nation thisNation) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT * FROM `SECTORS` " +
                "WHERE GAME_ID = " + thisPosition.getGame().getGameId() +
                " AND REGION_ID = " + thisPosition.getRegion().getId() +
                " AND NATION_ID = " + thisNation.getId() +
                " AND TERRAIN_ID <> " + TerrainConstants.TERRAIN_O +
                " AND ((x = " + (thisPosition.getX() - 1) + " AND y = " + (thisPosition.getY() - 1) + ") " +
                "      OR (x = " + (thisPosition.getX() - 1) + " AND y = " + (thisPosition.getY()) + ") " +
                "      OR (x = " + (thisPosition.getX() - 1) + " AND y = " + (thisPosition.getY() + 1) + ") " +
                "      OR (x = " + (thisPosition.getX()) + " AND y = " + (thisPosition.getY() - 1) + ") " +
                "      OR (x = " + (thisPosition.getX()) + " AND y = " + (thisPosition.getY() + 1) + ") " +
                "      OR (x = " + (thisPosition.getX() + 1) + " AND y = " + (thisPosition.getY() - 1) + ") " +
                "      OR (x = " + (thisPosition.getX() + 1) + " AND y = " + (thisPosition.getY()) + ") " +
                "      OR (x = " + (thisPosition.getX() + 1) + " AND y = " + (thisPosition.getY() + 1) + "))" +
                " GROUP BY REGION_ID, x, y, NATION_ID";

        final List lstResults = session.createSQLQuery(thisQuery).list();

        return (lstResults != null && lstResults.size() > 0);
    }

    /**
     * Determine if the given position is a coastal tile.
     *
     * @param thisPosition the position.
     * @return if the given position is a coastal tile.
     */
    public boolean checkCoastal(final Position thisPosition) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT * FROM `SECTORS` " +
                "WHERE GAME_ID = " + thisPosition.getGame().getGameId() +
                " AND REGION_ID = " + thisPosition.getRegion().getId() +
                " AND TERRAIN_ID <> " + TerrainConstants.TERRAIN_O +
                " AND ((x = " + (thisPosition.getX() - 1) + " AND y = " + (thisPosition.getY() - 1) + ") " +
                "      OR (x = " + (thisPosition.getX() - 1) + " AND y = " + (thisPosition.getY()) + ") " +
                "      OR (x = " + (thisPosition.getX() - 1) + " AND y = " + (thisPosition.getY() + 1) + ") " +
                "      OR (x = " + (thisPosition.getX()) + " AND y = " + (thisPosition.getY() - 1) + ") " +
                "      OR (x = " + (thisPosition.getX()) + " AND y = " + (thisPosition.getY() + 1) + ") " +
                "      OR (x = " + (thisPosition.getX() + 1) + " AND y = " + (thisPosition.getY() - 1) + ") " +
                "      OR (x = " + (thisPosition.getX() + 1) + " AND y = " + (thisPosition.getY()) + ") " +
                "      OR (x = " + (thisPosition.getX() + 1) + " AND y = " + (thisPosition.getY() + 1) + "))" +
                " GROUP BY REGION_ID, x, y, NATION_ID";

        final List lstResults = session.createSQLQuery(thisQuery).list();

        return (lstResults != null && lstResults.size() > 0);
    }

    /**
     * List all sectors conquered by another nation.
     *
     * @param thisGame the game.
     * @return a list of sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listConquered(final Game thisGame) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT SECTOR_ID " +
                "FROM `SECTORS`, TBL_NATIONS " +
                "WHERE SECTORS.NATION_ID = TBL_NATIONS.NATION_ID " +
                "AND SECTORS.GAME_ID = " + thisGame.getGameId() + " " +
                "AND SECTORS.NATION_ID <> -1 " +
                "AND SECTORS.REGION_ID = 1 " +
                "AND TBL_NATIONS.code <> SECTORS.politicalSphere " +
                "AND SECTORS.politicalSphere <> '1' " +
                "AND SECTORS.politicalSphere <> '2' " +
                "AND SECTORS.politicalSphere <> '3' " +
                "AND SECTORS.politicalSphere <> '4' " +
                "AND SECTORS.politicalSphere <> '5' " +
                "AND SECTORS.politicalSphere <> '6' " +
                "AND SECTORS.politicalSphere <> '7'";

        final List<Integer> lstResults = session.createSQLQuery(thisQuery).list();

        // construct list
        final List<Sector> theList = new ArrayList<Sector>();

        // Iterate through results and populate map
        for (Integer sectorId : lstResults) {
            theList.add(getByID(sectorId));
        }

        return theList;
    }


    /**
     * List all home sectors.
     *
     * @param thisGame   the game.
     * @param thisNation the nation.
     * @return a list of sectors.
     */
    @SuppressWarnings("unchecked")
    public List<Sector> listHomeSectors(final Game thisGame, final Nation thisNation) {
        final Session session = getSessionFactory().getCurrentSession();
        final String thisQuery = "SELECT SECTOR_ID " +
                "FROM `SECTORS`, TBL_NATIONS " +
                "WHERE SECTORS.NATION_ID = TBL_NATIONS.NATION_ID " +
                "AND SECTORS.GAME_ID = " + thisGame.getGameId() + " " +
                "AND SECTORS.NATION_ID = " + thisNation.getId() + " " +
                "AND SECTORS.REGION_ID = 1 " +
                "AND LCASE(SECTORS.politicalSphere) = LCASE(TBL_NATIONS.code)";

        final List<Integer> lstResults = session.createSQLQuery(thisQuery).list();

        // construct list
        final List<Sector> theList = new ArrayList<Sector>();

        // Iterate through results and populate map
        for (Integer sectorId : lstResults) {
            theList.add(getByID(sectorId));
        }

        return theList;
    }
}

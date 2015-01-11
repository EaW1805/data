package com.eaw1805.data;

import com.eaw1805.data.managers.AchievementManager;
import com.eaw1805.data.managers.ActiveUserManager;
import com.eaw1805.data.managers.ChatMessageManager;
import com.eaw1805.data.managers.EngineProcessManager;
import com.eaw1805.data.managers.FollowManager;
import com.eaw1805.data.managers.GameManager;
import com.eaw1805.data.managers.MessageManager;
import com.eaw1805.data.managers.NationManager;
import com.eaw1805.data.managers.NewsManager;
import com.eaw1805.data.managers.PaymentHistoryManager;
import com.eaw1805.data.managers.PlayerOrderManager;
import com.eaw1805.data.managers.ProfileManager;
import com.eaw1805.data.managers.QuestionnaireManager;
import com.eaw1805.data.managers.RelationsManager;
import com.eaw1805.data.managers.ReportManager;
import com.eaw1805.data.managers.UserGameManager;
import com.eaw1805.data.managers.UserManager;
import com.eaw1805.data.managers.WatchGameManager;
import com.eaw1805.data.managers.army.ArmyManager;
import com.eaw1805.data.managers.army.ArmyTypeManager;
import com.eaw1805.data.managers.army.BattalionManager;
import com.eaw1805.data.managers.army.BrigadeManager;
import com.eaw1805.data.managers.army.CommanderManager;
import com.eaw1805.data.managers.army.CommanderNameManager;
import com.eaw1805.data.managers.army.CorpManager;
import com.eaw1805.data.managers.army.RankManager;
import com.eaw1805.data.managers.army.SpyManager;
import com.eaw1805.data.managers.battles.FieldBattleReportManager;
import com.eaw1805.data.managers.battles.NavalBattleReportManager;
import com.eaw1805.data.managers.battles.TacticalBattleReportManager;
import com.eaw1805.data.managers.economy.BaggageTrainManager;
import com.eaw1805.data.managers.economy.GoodManager;
import com.eaw1805.data.managers.economy.TradeCityManager;
import com.eaw1805.data.managers.economy.WarehouseManager;
import com.eaw1805.data.managers.field.FieldBattleMapExtraFeatureManager;
import com.eaw1805.data.managers.field.FieldBattleMapManager;
import com.eaw1805.data.managers.field.FieldBattleOrderManager;
import com.eaw1805.data.managers.field.FieldBattleSectorManager;
import com.eaw1805.data.managers.field.FieldBattleTerrainManager;
import com.eaw1805.data.managers.field.UserFieldBattleManager;
import com.eaw1805.data.managers.fleet.FleetManager;
import com.eaw1805.data.managers.fleet.ShipManager;
import com.eaw1805.data.managers.fleet.ShipTypeManager;
import com.eaw1805.data.managers.forum.ForumPostManager;
import com.eaw1805.data.managers.forum.ForumSessionManager;
import com.eaw1805.data.managers.forum.UserPermissionManager;
import com.eaw1805.data.managers.map.BarrackManager;
import com.eaw1805.data.managers.map.NaturalResourceManager;
import com.eaw1805.data.managers.map.ProductionSiteManager;
import com.eaw1805.data.managers.map.RegionManager;
import com.eaw1805.data.managers.map.SectorManager;
import com.eaw1805.data.managers.map.TerrainManager;
import com.eaw1805.data.managers.paypal.PaypalTransactionManager;
import com.eaw1805.data.managers.paypal.PaypalUserManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility functions for accessing hibernate.
 */
public final class HibernateUtil {

    public final static int DB_MAIN = 0;

    public final static int DB_FIELDBATTLE = -3;

    public final static int DB_EDITOR = -2;

    /**
     * Scenario 1804.
     */
    public final static int DB_FREE = -1;

    /**
     * Scenario 1802.
     */
    public final static int DB_S1 = 1;

    /**
     * Scenario 1805.
     */
    public final static int DB_S2 = 2;

    /**
     * Scenario 1808.
     */
    public final static int DB_S3 = 3;

    /**
     * First Scenario.
     */
    public final static int DB_FIRST = DB_S1;

    /**
     * Last Scenario.
     */
    public final static int DB_LAST = DB_S3;

    /**
     * a log4j logger to print messages.
     */
    private static final Logger LOGGER = LogManager.getLogger(HibernateUtil.class);

    /**
     * static instance(ourInstance) initialized as null.
     */
    private static HibernateUtil ourInstance = null;

    /**
     * A static SessionFactory variable for each DB.
     */
    private final transient Map<Integer, SessionFactory> sessionFactory;

    /**
     * The Configuration of hibernate for each DB.
     */
    private final transient Map<Integer, Configuration> configuration;

    /**
     * Private constructor suppresses generation of a (public) default constructor.
     */
    private HibernateUtil() {
        try {
            LOGGER.error("Configuring Hibernate");

            // load configuration file
            configuration = new HashMap<Integer, Configuration>();
            sessionFactory = new HashMap<Integer, SessionFactory>();

            LOGGER.debug("Configuring Hibernate MAIN");
            configuration.put(DB_MAIN, new Configuration().configure("hibernate.cfg.xml"));

            LOGGER.debug("Configuring Hibernate FIELDBATTLE");
            configuration.put(DB_FIELDBATTLE, new Configuration().configure("hibernate-fieldbattle.cfg.xml"));

            LOGGER.debug("Configuring Hibernate EDITOR");
            configuration.put(DB_EDITOR, new Configuration().configure("hibernate-editor.cfg.xml"));

            LOGGER.debug("Configuring Hibernate FREE");
            configuration.put(DB_FREE, new Configuration().configure("hibernate-free.cfg.xml"));

            LOGGER.debug("Configuring Hibernate S1");
            configuration.put(DB_S1, new Configuration().configure("hibernate-s1.cfg.xml"));

            LOGGER.debug("Configuring Hibernate S2");
            configuration.put(DB_S2, new Configuration().configure("hibernate-s2.cfg.xml"));

            LOGGER.debug("Configuring Hibernate S3");
            configuration.put(DB_S3, new Configuration().configure("hibernate-s3.cfg.xml"));

            // Configure credentials and setup session factory
            LOGGER.error("Setting up Session Factories.");
            for (Map.Entry<Integer, Configuration> entry : configuration.entrySet()) {
                final Configuration config = entry.getValue();
                config.setProperty("hibernate.connection.username", System.getProperty("dbusername"));
                config.setProperty("hibernate.connection.password", System.getProperty("dbpassword"));

                sessionFactory.put(entry.getKey(), createSessionFactory(config));
            }

            LOGGER.error("Hibernate Session Factories ready.");

        } catch (Exception ex) {
            // Make sure you log the exception, as it might be swallowed
            LOGGER.error("Initial SessionFactory creation failed. " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * HibernateUtil is loaded on the first execution of HibernateUtili.getInstance()
     * or the first access to HibernateUtili.ourInstance, not before.
     *
     * @return ourInstance
     */
    public static HibernateUtil getInstance() {
        synchronized (HibernateUtil.class) {
            if (ourInstance == null) {
                ourInstance = new HibernateUtil();
            }
        }

        return ourInstance;
    }

    /**
     * Returns the current Session.
     *
     * @return the current Session
     */
    public Session getSession(final int type) {
        synchronized (HibernateUtil.class) {
            Session ses = sessionFactory.get(type).getCurrentSession();

            if (!ses.isOpen()) {
                ses = sessionFactory.get(type).openSession();
            }

            return ses;
        }
    }

    public Transaction beginTransaction(final int type) {
        return getSession(type).beginTransaction();
    }

    /**
     * Returns the current Session factory.
     *
     * @return the current Session Factory.
     */
    public SessionFactory getSessionFactory(final int type) {
        return sessionFactory.get(type);
    }

    /**
     * Try to create a SessionFactory.
     *
     * @return the SessionFactory
     */
    public SessionFactory createSessionFactory(final Configuration thisConfig) {
        SessionFactory sFactory = null;

        try {
            // Create the SessionFactory from hibernateMM.cfg.xml
            final StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(thisConfig.getProperties());
            sFactory = thisConfig.buildSessionFactory(ssrb.build());

        } catch (Exception ex) {
            // Make sure you log the exception, as it might be swallowed
            LOGGER.error("Initial SessionFactory creation failed. ", ex);
            throw new ExceptionInInitializerError(ex);
        }

        return sFactory;
    }

    /**
     * Connect entity stores to Hibernate SessionFactory
     */
    public static void connectEntityManagers(final int type) {
        // Set the session factories to all stores
        LOGGER.info("Connecting Entity Managers to Hibernate SessionFactory");

        final SessionFactory thisFactory = HibernateUtil.getInstance().getSessionFactory(DB_MAIN);
        connectEntityManagersMain(thisFactory);

        if (type != DB_MAIN) {
            final SessionFactory thatFactory = HibernateUtil.getInstance().getSessionFactory(type);
            connectEntityManagersScenario(thatFactory);
        }
    }

    /**
     * Connect entity stores to Hibernate SessionFactory
     *
     * @param thisFactory the SessionFactory to attach to each manager.
     */
    public static void connectEntityManagersMain(final SessionFactory thisFactory) {
        LOGGER.info("Connecting Main Entity Managers to " + thisFactory.toString());

        // Set the session factories to all stores
        EngineProcessManager.getInstance().setSessionFactory(thisFactory);

        // User related
        UserManager.getInstance().setSessionFactory(thisFactory);
        ProfileManager.getInstance().setSessionFactory(thisFactory);
        PaymentHistoryManager.getInstance().setSessionFactory(thisFactory);
        FollowManager.getInstance().setSessionFactory(thisFactory);
        MessageManager.getInstance().setSessionFactory(thisFactory);

        //Forum Managers
        UserPermissionManager.getInstance().setSessionFactory(thisFactory);
        ForumPostManager.getInstance().setSessionFactory(thisFactory);
        ForumSessionManager.getInstance().setSessionFactory(thisFactory);

        //Paypal Managers
        PaypalUserManager.getInstance().setSessionFactory(thisFactory);
        PaypalTransactionManager.getInstance().setSessionFactory(thisFactory);

        ActiveUserManager.getInstance().setSessionFactory(thisFactory);
        ChatMessageManager.getInstance().setSessionFactory(thisFactory);
        AchievementManager.getInstance().setSessionFactory(thisFactory);

        QuestionnaireManager.getInstance().setSessionFactory(thisFactory);
    }

    /**
     * Connect entity stores to Hibernate SessionFactory
     *
     * @param thisFactory the SessionFactory to attach to each manager.
     */
    public static void connectEntityManagersScenario(final SessionFactory thisFactory) {
        LOGGER.info("Connecting Scenario Entity Managers to " + thisFactory.toString());

        // Set the session factories to all stores
        GameManager.getInstance().setSessionFactory(thisFactory);
        NationManager.getInstance().setSessionFactory(thisFactory);
        NewsManager.getInstance().setSessionFactory(thisFactory);
        PlayerOrderManager.getInstance().setSessionFactory(thisFactory);
        RelationsManager.getInstance().setSessionFactory(thisFactory);
        ReportManager.getInstance().setSessionFactory(thisFactory);

        // User related
        UserGameManager.getInstance().setSessionFactory(thisFactory);
        WatchGameManager.getInstance().setSessionFactory(thisFactory);

        // map stores
        BarrackManager.getInstance().setSessionFactory(thisFactory);
        RegionManager.getInstance().setSessionFactory(thisFactory);
        NaturalResourceManager.getInstance().setSessionFactory(thisFactory);
        ProductionSiteManager.getInstance().setSessionFactory(thisFactory);
        SectorManager.getInstance().setSessionFactory(thisFactory);
        TerrainManager.getInstance().setSessionFactory(thisFactory);

        // army stores
        ArmyManager.getInstance().setSessionFactory(thisFactory);
        ArmyTypeManager.getInstance().setSessionFactory(thisFactory);
        BattalionManager.getInstance().setSessionFactory(thisFactory);
        BrigadeManager.getInstance().setSessionFactory(thisFactory);
        CommanderManager.getInstance().setSessionFactory(thisFactory);
        CommanderNameManager.getInstance().setSessionFactory(thisFactory);
        CorpManager.getInstance().setSessionFactory(thisFactory);
        RankManager.getInstance().setSessionFactory(thisFactory);
        SpyManager.getInstance().setSessionFactory(thisFactory);
        TacticalBattleReportManager.getInstance().setSessionFactory(thisFactory);

        // fleet stores
        FleetManager.getInstance().setSessionFactory(thisFactory);
        ShipManager.getInstance().setSessionFactory(thisFactory);
        ShipTypeManager.getInstance().setSessionFactory(thisFactory);
        NavalBattleReportManager.getInstance().setSessionFactory(thisFactory);

        // Economy stores
        BaggageTrainManager.getInstance().setSessionFactory(thisFactory);
        GoodManager.getInstance().setSessionFactory(thisFactory);
        TradeCityManager.getInstance().setSessionFactory(thisFactory);
        WarehouseManager.getInstance().setSessionFactory(thisFactory);

        // Field Battle stores
        FieldBattleMapManager.getInstance().setSessionFactory(thisFactory);
        FieldBattleSectorManager.getInstance().setSessionFactory(thisFactory);
        FieldBattleTerrainManager.getInstance().setSessionFactory(thisFactory);
        FieldBattleMapExtraFeatureManager.getInstance().setSessionFactory(thisFactory);
        FieldBattleReportManager.getInstance().setSessionFactory(thisFactory);
        FieldBattleOrderManager.getInstance().setSessionFactory(thisFactory);
        UserFieldBattleManager.getInstance().setSessionFactory(thisFactory);
    }

    public void closeSessions() {
//        for (SessionFactory factory : sessionFactory.values()) {
//            factory.close();
//        }
    }

}

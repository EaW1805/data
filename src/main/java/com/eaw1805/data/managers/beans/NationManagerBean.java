package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.Nation;

import java.util.List;

/**
 * The interface of the NationManagerBean.
 */
public interface NationManagerBean extends EntityBean {

    /**
     * get the Nation from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
//    @Cacheable(cacheName = CONSTANT_CACHE,
//            keyGenerator = @KeyGenerator(
//                    name = "ListCacheKeyGenerator",
//                    properties = {
//                            @Property(name = "useReflection", value = "true"),
//                            @Property(name = "checkforCycles", value = "true"),
//                            @Property(name = "includeMethod", value = "false")
//                    }
//            )
//    )
    Nation getByID(final int entityID);

    /**
     * Get all the nation from the database that corresponds to the input
     * terrain char-code.
     *
     * @param nationCode the terrain char-code.
     * @return an Entity object.
     */
//    @Cacheable(cacheName = CONSTANT_CACHE,
//            keyGenerator = @KeyGenerator(
//                    name = "ListCacheKeyGenerator",
//                    properties = {
//                            @Property(name = "useReflection", value = "true"),
//                            @Property(name = "checkforCycles", value = "true"),
//                            @Property(name = "includeMethod", value = "false")
//                    }
//            )
//    )
    Nation getByCode(final char nationCode);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param nation the nation tha we want to add.
     */
    //@TriggersRemove(cacheName = CONSTANT_CACHE, when = When.AFTER_METHOD_INVOCATION, removeAll = true)
    void add(final Nation nation);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param nation the nation tha we want to update.
     */
    //@TriggersRemove(cacheName = CONSTANT_CACHE, when = When.AFTER_METHOD_INVOCATION, removeAll = true)
    void update(final Nation nation);

    /**
     * Delete the input Nation from the database.
     *
     * @param nation the nation tha we want to delete.
     */
    //@TriggersRemove(cacheName = CONSTANT_CACHE, when = When.AFTER_METHOD_INVOCATION, removeAll = true)
    void delete(final Nation nation);

    /**
     * Listing all the Nations from the database.
     *
     * @return a list of all the nations that exist inside the table.
     */
//    @Cacheable(cacheName = CONSTANT_CACHE,
//            keyGenerator = @KeyGenerator(
//                    name = "ListCacheKeyGenerator",
//                    properties = {
//                            @Property(name = "useReflection", value = "true"),
//                            @Property(name = "checkforCycles", value = "true"),
//                            @Property(name = "includeMethod", value = "false")
//                    }
//            )
//    )
    List<Nation> list();

    /**
     * Inserts an entry to the database with ID = -1.
     */
    //@TriggersRemove(cacheName = CONSTANT_CACHE, when = When.AFTER_METHOD_INVOCATION, removeAll = true)
    void addNegativeNationID();

}

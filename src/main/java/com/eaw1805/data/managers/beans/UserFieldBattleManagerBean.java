package com.eaw1805.data.managers.beans;

import com.eaw1805.data.model.battles.field.UserFieldBattle;

import java.util.List;

/**
 * The interface of the UserFieldBattleManagerBean.
 */
public interface UserFieldBattleManagerBean extends EntityBean {

    /**
     * get the UserFieldBattle from the database that corresponds to the input id.
     *
     * @param entityID the id of the Entity object.
     * @return an Entity object.
     */
    UserFieldBattle getByID(int entityID);

    /**
     * adding a new entry into the database, according to the input object it
     * receives.
     *
     * @param value the UserFieldBattle that we want to add.
     */
    void add(final UserFieldBattle value);

    /**
     * updating an entry into the database, according to the input object it
     * receives.
     *
     * @param value the Sector that we want to update.
     */
    void update(final UserFieldBattle value);

    /**
     * Delete the input Sector from the database.
     *
     * @param entity the UserFieldBattle that we want to delete
     */
    void delete(UserFieldBattle entity);

    /**
     * Listing all the Sectors from the database.
     *
     * @return a list of all the Sectors that exist inside the table Avatar.
     */
    List<UserFieldBattle> list();

    UserFieldBattle getByBattleNation(final int battleId, final int nationId);

    List<UserFieldBattle> listByBattleId(final int battleId);

    List<UserFieldBattle> listByUser(final int userId);

    /**
     * Get user field battle for a battle and user.
     *
     * @param battleId The battle.
     * @param userId The user.
     * @return A user field battle object.
     */
    UserFieldBattle getByBattleUser(final int battleId, final int userId);

    /**
     * Get all pending fieldbattles for current user.
     *
     * @param facebookId The facebook id for this user.
     * @return A list of pending user fieldbattles.
     */
    List<UserFieldBattle> listPending(final String facebookId);

}

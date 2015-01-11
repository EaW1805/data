package com.eaw1805.data.model.battles.field.log;

import com.google.gwt.user.client.rpc.IsSerializable;
import com.eaw1805.data.model.battles.field.enumerations.MoraleStatusEnum;
import com.eaw1805.data.model.army.Brigade;
import com.eaw1805.data.model.battles.field.FieldBattleSector;

import java.io.Serializable;

/**
 * Interface to be implemented by half round logs.
 *
 * @author fragkakis
 */
public interface IHalfRoundLog
        extends Serializable, IsSerializable {

    /**
     * Clears the half round log collections.
     */
    void clear();

    /**
     * Logs a rally outcome.
     *
     * @param side             the side of the brigade that attempted the rally
     * @param moraleStatusEnum the outcome morale
     * @param brigade          the brigade
     */
    void logRallyOutcome(int side, MoraleStatusEnum moraleStatusEnum, Brigade brigade);

    /**
     * Logs a brigade leaving the field battle.
     *
     * @param brigade the brigade
     */
    void logBrigadeLeftBattlefield(Brigade brigade);

    /**
     * Logs the movement of a brigade.
     *
     * @param side          the side of the brigade that moved
     * @param brigade       the brigade
     * @param initialSector the initial sector
     * @param destination   the destination
     */
    void logBrigadeMovement(int side, Brigade brigade, FieldBattleSector initialSector, FieldBattleSector destination);

    /**
     * Logs a long range attack.
     *
     * @param side           the side of the brigade that made the attack
     * @param attacker       the attacher brigade
     * @param target         the target brigade
     * @param ricochetAttack whether this was a ricochet attack
     * @param casualties     the number of casualties
     */
    void logLongRangeAttack(int side, Brigade attacker, Brigade target, boolean ricochetAttack, double casualties);

    /**
     * Logs a melee attack.
     *
     * @param side       the side of the brigade that made the attack
     * @param attacker   the attacker brigade
     * @param target     the target brigade
     * @param casualties the number of casualties
     */
    void logMeleeAttack(int side, Brigade attacker, Brigade target, double casualties);

    /**
     * Logs a structure-related event.
     *
     * @param structureX    the x coordinate
     * @param structureY    the y coordinate
     * @param structureType the type of structure
     * @param brigade       the brigade involved in the event
     * @param oldHitPoints  the old hit points of the structure
     * @param hitPointsDiff the change in the hit points
     */
    void logStructureAffected(int structureX, int structureY, String structureType, Brigade brigade, int oldHitPoints, int hitPointsDiff);

    /**
     * Registers a structure status
     *
     * @param structureStatus the structure status
     */
    void registerStructureStatus(StructureStatus structureStatus);

    /**
     * Logs the morale level for a side.
     *
     * @param morale the morale
     * @param side   the side
     */
    void logMoraleForSide(int morale, int side);

}
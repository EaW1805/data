package com.eaw1805.data.model.battles.field.log;

import com.eaw1805.data.model.battles.field.enumerations.MoraleStatusEnum;
import com.eaw1805.data.model.battles.field.log.entries.BrigadeMovementLogEntry;
import com.eaw1805.data.model.battles.field.log.entries.LongRangeAttackLogEntry;
import com.eaw1805.data.model.battles.field.log.entries.MeleeAttackLogEntry;
import com.eaw1805.data.model.battles.field.log.entries.RallyLogEntry;
import com.eaw1805.data.model.battles.field.log.entries.StructureAffectedLogEntry;
import com.eaw1805.data.model.army.Brigade;
import com.eaw1805.data.model.battles.field.FieldBattleSector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the {@link IHalfRoundLog} interface.
 *
 * @author fragkakis
 */
public class HalfRoundLog
        implements IHalfRoundLog {

    private int moraleSide0;
    private int moraleSide1;
    private List<RallyLogEntry> rallyLogEntriesSide0 = new ArrayList<RallyLogEntry>();
    private List<RallyLogEntry> rallyLogEntriesSide1 = new ArrayList<RallyLogEntry>();
    private List<Integer> brigadesLeftBattlefieldLogEntries = new ArrayList<Integer>();
    private List<BrigadeMovementLogEntry> brigadeMovementLogEntriesSide0 = new ArrayList<BrigadeMovementLogEntry>();
    private List<BrigadeMovementLogEntry> brigadeMovementLogEntriesSide1 = new ArrayList<BrigadeMovementLogEntry>();
    private List<LongRangeAttackLogEntry> longRangeAttackLogEntriesSide0 = new ArrayList<LongRangeAttackLogEntry>();
    private List<LongRangeAttackLogEntry> longRangeAttackLogEntriesSide1 = new ArrayList<LongRangeAttackLogEntry>();
    private List<MeleeAttackLogEntry> meleeAttackLogEntries = new ArrayList<MeleeAttackLogEntry>();
    private List<StructureStatus> structuresStatuses = new ArrayList<StructureStatus>();

    private static final long serialVersionUID = 2146198099751797380L;
    private static final Logger LOGGER = LoggerFactory.getLogger(HalfRoundLog.class);


    @Override
    public void clear() {
        moraleSide0 = 0;
        moraleSide1 = 0;
        rallyLogEntriesSide0 = new ArrayList<RallyLogEntry>();
        rallyLogEntriesSide1 = new ArrayList<RallyLogEntry>();
        brigadesLeftBattlefieldLogEntries = new ArrayList<Integer>();
        brigadeMovementLogEntriesSide0 = new ArrayList<BrigadeMovementLogEntry>();
        brigadeMovementLogEntriesSide1 = new ArrayList<BrigadeMovementLogEntry>();
        longRangeAttackLogEntriesSide0 = new ArrayList<LongRangeAttackLogEntry>();
        longRangeAttackLogEntriesSide1 = new ArrayList<LongRangeAttackLogEntry>();
        meleeAttackLogEntries = new ArrayList<MeleeAttackLogEntry>();
        structuresStatuses = new ArrayList<StructureStatus>();
        LOGGER.debug("Clearing logs");
    }

    @Override
    public void logRallyOutcome(int side, MoraleStatusEnum moraleStatusEnum, Brigade brigade) {
        List<RallyLogEntry> thisSideEntries = side == 0 ? rallyLogEntriesSide0 : rallyLogEntriesSide1;
        thisSideEntries.add(new RallyLogEntry(brigade.getBrigadeId(), brigade.getFieldBattlePosition().getX(),
                brigade.getFieldBattlePosition().getY(), moraleStatusEnum));
    }

    @Override
    public void logBrigadeLeftBattlefield(Brigade brigade) {
        brigadesLeftBattlefieldLogEntries.add(brigade.getBrigadeId());
    }

    @Override
    public void logBrigadeMovement(int side, Brigade brigade, FieldBattleSector currentSector, FieldBattleSector destination) {
        List<BrigadeMovementLogEntry> thisSideEntries = side == 0 ? brigadeMovementLogEntriesSide0 : brigadeMovementLogEntriesSide1;
        thisSideEntries.add(new BrigadeMovementLogEntry(brigade.getBrigadeId(), currentSector.getX(),
                currentSector.getY(), destination.getX(), destination.getY()));
    }

    @Override
    public void logLongRangeAttack(int side, Brigade attacker, Brigade target, boolean ricochetAttack, double casualties) {
        List<LongRangeAttackLogEntry> thisSideEntries = side == 0 ? longRangeAttackLogEntriesSide0 : longRangeAttackLogEntriesSide1;
        thisSideEntries.add(new LongRangeAttackLogEntry(attacker.getBrigadeId(), target.getBrigadeId(),
                ricochetAttack, (int) casualties));
    }

    @Override
    public void logMeleeAttack(int side, Brigade attacker, Brigade target, double casualties) {
        meleeAttackLogEntries.add(new MeleeAttackLogEntry(attacker.getBrigadeId(), target.getBrigadeId(), (int) casualties));
    }

    @Override
    public void logStructureAffected(int structureX, int structureY, String structureType, Brigade attacker, int oldHitPoints, int hitPointsDiff) {
        StructureStatus affectedStructureStatus = null;
        for (StructureStatus structureStatus : structuresStatuses) {
            if (structureStatus.getX() == structureX && structureStatus.getY() == structureY) {
                affectedStructureStatus = structureStatus;
                break;
            }
        }
        // this is a non-existent structure being built
        if (affectedStructureStatus == null) {
            affectedStructureStatus = new StructureStatus(structureX, structureY, structureType, oldHitPoints + hitPointsDiff);
            structuresStatuses.add(affectedStructureStatus);
        }
        affectedStructureStatus.getStructureAffectedLogEntries().add(
                new StructureAffectedLogEntry(attacker.getBrigadeId(), oldHitPoints, hitPointsDiff));
    }

    @Override
    public void registerStructureStatus(StructureStatus structureStatus) {
        structuresStatuses.add(structureStatus);
    }

    public List<RallyLogEntry> getRallyLogEntriesSide0() {
        return rallyLogEntriesSide0;
    }

    public List<RallyLogEntry> getRallyLogEntriesSide1() {
        return rallyLogEntriesSide1;
    }

    public List<Integer> getBrigadesLeftBattlefieldLogEntries() {
        return brigadesLeftBattlefieldLogEntries;
    }

    public List<BrigadeMovementLogEntry> getBrigadeMovementLogEntriesSide0() {
        return brigadeMovementLogEntriesSide0;
    }

    public List<BrigadeMovementLogEntry> getBrigadeMovementLogEntriesSide1() {
        return brigadeMovementLogEntriesSide1;
    }

    public List<LongRangeAttackLogEntry> getLongRangeAttackLogEntriesSide0() {
        return longRangeAttackLogEntriesSide0;
    }

    public List<LongRangeAttackLogEntry> getLongRangeAttackLogEntriesSide1() {
        return longRangeAttackLogEntriesSide1;
    }

    public List<MeleeAttackLogEntry> getMeleeAttackLogEntries() {
        return meleeAttackLogEntries;
    }

    public List<StructureStatus> getStructuresStatuses() {
        return structuresStatuses;
    }

    public int getMoraleSide0() {
        return moraleSide0;
    }

    public int getMoraleSide1() {
        return moraleSide1;
    }

    @Override
    public void logMoraleForSide(int morale, int side) {
        if (side == 0) {
            moraleSide0 = morale;
        } else if (side == 1) {
            moraleSide1 = morale;
        }
    }

}

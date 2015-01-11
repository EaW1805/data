package com.eaw1805.data.dto.web.field;

import com.eaw1805.data.dto.web.army.BrigadeDTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FieldBattleHalfRoundStatisticsDTO implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD

    private int halfRound;
    private List<BrigadeDTO> allBrigades = new ArrayList<BrigadeDTO>();

    private FieldBattleMapDTO map;
    private int winner;
    private List<RallyLogEntryDTO> rallyLogEntriesSide0 = new ArrayList<RallyLogEntryDTO>();
    private List<RallyLogEntryDTO> rallyLogEntriesSide1 = new ArrayList<RallyLogEntryDTO>();
    private List<Integer> brigadesLeftBattlefieldLogEntries = new ArrayList<Integer>();
    private List<BrigadeMovementLogEntryDTO> brigadeMovementLogEntriesSide0 = new ArrayList<BrigadeMovementLogEntryDTO>();
    private List<BrigadeMovementLogEntryDTO> brigadeMovementLogEntriesSide1 = new ArrayList<BrigadeMovementLogEntryDTO>();
    private List<LongRangeAttackLogEntryDTO> longRangeAttackLogEntriesSide0 = new ArrayList<LongRangeAttackLogEntryDTO>();
    private List<LongRangeAttackLogEntryDTO> longRangeAttackLogEntriesSide1 = new ArrayList<LongRangeAttackLogEntryDTO>();
    private List<MeleeAttackLogEntryDTO> meleeAttackLogEntries = new ArrayList<MeleeAttackLogEntryDTO>();
    private List<StructureStatusDTO> structureStatusEntries = new ArrayList<StructureStatusDTO>();
    private int moraleSide0;
    private int moraleSide1;

    public int getHalfRound() {
        return halfRound;
    }

    public void setHalfRound(int halfRound) {
        this.halfRound = halfRound;
    }

    public List<BrigadeDTO> getAllBrigades() {
        return allBrigades;
    }

    public void setAllBrigades(List<BrigadeDTO> allBrigades) {
        this.allBrigades = allBrigades;
    }

    public FieldBattleMapDTO getMap() {
        return map;
    }

    public void setMap(FieldBattleMapDTO map) {
        this.map = map;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }


    public List<RallyLogEntryDTO> getRallyLogEntriesSide0() {
        return rallyLogEntriesSide0;
    }

    public void setRallyLogEntriesSide0(List<RallyLogEntryDTO> rallyLogEntriesSide0) {
        this.rallyLogEntriesSide0 = rallyLogEntriesSide0;
    }

    public List<RallyLogEntryDTO> getRallyLogEntriesSide1() {
        return rallyLogEntriesSide1;
    }

    public void setRallyLogEntriesSide1(List<RallyLogEntryDTO> rallyLogEntriesSide1) {
        this.rallyLogEntriesSide1 = rallyLogEntriesSide1;
    }

    public List<Integer> getBrigadesLeftBattlefieldLogEntries() {
        return brigadesLeftBattlefieldLogEntries;
    }

    public void setBrigadesLeftBattlefieldLogEntries(List<Integer> brigadesLeftBattlefieldLogEntries) {
        this.brigadesLeftBattlefieldLogEntries = brigadesLeftBattlefieldLogEntries;
    }

    public List<BrigadeMovementLogEntryDTO> getBrigadeMovementLogEntriesSide0() {
        return brigadeMovementLogEntriesSide0;
    }

    public void setBrigadeMovementLogEntriesSide0(List<BrigadeMovementLogEntryDTO> brigadeMovementLogEntriesSide0) {
        this.brigadeMovementLogEntriesSide0 = brigadeMovementLogEntriesSide0;
    }

    public List<BrigadeMovementLogEntryDTO> getBrigadeMovementLogEntriesSide1() {
        return brigadeMovementLogEntriesSide1;
    }

    public void setBrigadeMovementLogEntriesSide1(List<BrigadeMovementLogEntryDTO> brigadeMovementLogEntriesSide1) {
        this.brigadeMovementLogEntriesSide1 = brigadeMovementLogEntriesSide1;
    }

    public List<LongRangeAttackLogEntryDTO> getLongRangeAttackLogEntriesSide0() {
        return longRangeAttackLogEntriesSide0;
    }

    public void setLongRangeAttackLogEntriesSide0(List<LongRangeAttackLogEntryDTO> longRangeAttackLogEntriesSide0) {
        this.longRangeAttackLogEntriesSide0 = longRangeAttackLogEntriesSide0;
    }

    public List<LongRangeAttackLogEntryDTO> getLongRangeAttackLogEntriesSide1() {
        return longRangeAttackLogEntriesSide1;
    }

    public void setLongRangeAttackLogEntriesSide1(List<LongRangeAttackLogEntryDTO> longRangeAttackLogEntriesSide1) {
        this.longRangeAttackLogEntriesSide1 = longRangeAttackLogEntriesSide1;
    }

    public List<MeleeAttackLogEntryDTO> getMeleeAttackLogEntries() {
        return meleeAttackLogEntries;
    }

    public void setMeleeAttackLogEntries(List<MeleeAttackLogEntryDTO> meleeAttackLogEntries) {
        this.meleeAttackLogEntries = meleeAttackLogEntries;
    }

    public List<StructureStatusDTO> getStructureStatusEntries() {
        return structureStatusEntries;
    }

    public void setStructureStatusEntries(List<StructureStatusDTO> structureStatusEntries) {
        this.structureStatusEntries = structureStatusEntries;
    }

    public int getMoraleSide0() {
        return moraleSide0;
    }

    public void setMoraleSide0(int moraleSide0) {
        this.moraleSide0 = moraleSide0;
    }

    public int getMoraleSide1() {
        return moraleSide1;
    }

    public void setMoraleSide1(int moraleSide1) {
        this.moraleSide1 = moraleSide1;
    }
}

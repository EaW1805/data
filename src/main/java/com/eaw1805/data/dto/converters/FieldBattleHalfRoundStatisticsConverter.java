package com.eaw1805.data.dto.converters;

import com.eaw1805.data.model.battles.field.log.HalfRoundLog;
import com.eaw1805.data.model.battles.field.log.StructureStatus;
import com.eaw1805.data.model.battles.field.log.entries.BrigadeMovementLogEntry;
import com.eaw1805.data.model.battles.field.log.entries.LongRangeAttackLogEntry;
import com.eaw1805.data.model.battles.field.log.entries.MeleeAttackLogEntry;
import com.eaw1805.data.model.battles.field.log.entries.RallyLogEntry;
import com.eaw1805.data.model.battles.field.log.entries.StructureAffectedLogEntry;
import com.eaw1805.data.model.battles.field.FieldBattleHalfRoundStatistics;
import com.eaw1805.data.dto.web.army.BrigadeDTO;
import com.eaw1805.data.dto.web.field.BrigadeMovementLogEntryDTO;
import com.eaw1805.data.dto.web.field.FieldBattleHalfRoundStatisticsDTO;
import com.eaw1805.data.dto.web.field.LongRangeAttackLogEntryDTO;
import com.eaw1805.data.dto.web.field.MeleeAttackLogEntryDTO;
import com.eaw1805.data.dto.web.field.RallyLogEntryDTO;
import com.eaw1805.data.dto.web.field.StructureAffectedLogEntryDTO;
import com.eaw1805.data.dto.web.field.StructureStatusDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class FieldBattleHalfRoundStatisticsConverter {
    static Random rand = new Random();

    /**
     * Cannot instantiate this class.
     */
    private FieldBattleHalfRoundStatisticsConverter() {
        // empty constructor
        rand.setSeed(new Date().getTime());
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static FieldBattleHalfRoundStatisticsDTO convert(final FieldBattleHalfRoundStatistics value) {
        FieldBattleHalfRoundStatisticsDTO out = new FieldBattleHalfRoundStatisticsDTO();
        out.setHalfRound(value.getHalfRound());
        out.setMap(FieldBattleMapConverter.convert(value.getFbMap()));
        List<BrigadeDTO> brigs = new ArrayList<BrigadeDTO>();
        if (value.getSideBrigades()[0] != null) {
            brigs.addAll(value.getSideBrigades()[0]);
        }
        if (value.getSideBrigades()[1] != null) {
            brigs.addAll(value.getSideBrigades()[1]);
        }
        out.setAllBrigades(brigs);
        out.setWinner(value.getWinner());


        final HalfRoundLog logs = (HalfRoundLog) value.getHalfRoundLog();

        final List<RallyLogEntryDTO> rallySide0 = new ArrayList<RallyLogEntryDTO>();
        final List<RallyLogEntryDTO> rallySide1 = new ArrayList<RallyLogEntryDTO>();
        final List<BrigadeMovementLogEntryDTO> brigadesMoveSide1 = new ArrayList<BrigadeMovementLogEntryDTO>();
        final List<BrigadeMovementLogEntryDTO> brigadesMoveSide0 = new ArrayList<BrigadeMovementLogEntryDTO>();
        final List<LongRangeAttackLogEntryDTO> longRangeSide0 = new ArrayList<LongRangeAttackLogEntryDTO>();
        final List<LongRangeAttackLogEntryDTO> longRangeSide1 = new ArrayList<LongRangeAttackLogEntryDTO>();
        final List<MeleeAttackLogEntryDTO> meleeAttack = new ArrayList<MeleeAttackLogEntryDTO>();
        final List<StructureStatusDTO> structureStatus = new ArrayList<StructureStatusDTO>();

        final List<Integer> brigadesLeft = new ArrayList<Integer>();
        if (logs != null) {
            for (RallyLogEntry entry : logs.getRallyLogEntriesSide0()) {
                final RallyLogEntryDTO entryDTO = new RallyLogEntryDTO();
                entryDTO.setBrigadeId(entry.getBrigadeId());
                entryDTO.setMoralStatusOutCome(entry.getMoraleStatusOutcome().getName());
                entryDTO.setX(entry.getX());
                entryDTO.setY(entry.getY());
                rallySide0.add(entryDTO);
            }


            for (RallyLogEntry entry : logs.getRallyLogEntriesSide1()) {
                final RallyLogEntryDTO entryDTO = new RallyLogEntryDTO();
                entryDTO.setBrigadeId(entry.getBrigadeId());
                entryDTO.setMoralStatusOutCome(entry.getMoraleStatusOutcome().getName());
                entryDTO.setX(entry.getX());
                entryDTO.setY(entry.getY());
                rallySide1.add(entryDTO);
            }


            brigadesLeft.addAll(logs.getBrigadesLeftBattlefieldLogEntries());


            for (BrigadeMovementLogEntry entry : logs.getBrigadeMovementLogEntriesSide0()) {
                final BrigadeMovementLogEntryDTO entryDTO = new BrigadeMovementLogEntryDTO();
                entryDTO.setBrigadeId(entry.getBrigadeId());
                entryDTO.setStartX(entry.getStartX());
                entryDTO.setStartY(entry.getStartY());
                entryDTO.setEndX(entry.getEndX());
                entryDTO.setEndY(entry.getEndY());
                brigadesMoveSide0.add(entryDTO);
            }


            for (BrigadeMovementLogEntry entry : logs.getBrigadeMovementLogEntriesSide1()) {
                final BrigadeMovementLogEntryDTO entryDTO = new BrigadeMovementLogEntryDTO();
                entryDTO.setBrigadeId(entry.getBrigadeId());
                entryDTO.setStartX(entry.getStartX());
                entryDTO.setStartY(entry.getStartY());
                entryDTO.setEndX(entry.getEndX());
                entryDTO.setEndY(entry.getEndY());
                brigadesMoveSide1.add(entryDTO);
            }


            for (LongRangeAttackLogEntry entry : logs.getLongRangeAttackLogEntriesSide0()) {
                final LongRangeAttackLogEntryDTO entryDTO = new LongRangeAttackLogEntryDTO();
                entryDTO.setAttackerBrigadeId(entry.getAttackerBrigadeId());
                entryDTO.setCasualties(entry.getCasualties());
                entryDTO.setRicochetAttack(entry.isRicochetAttack());
                entryDTO.setTargetBrigadeId(entry.getTargetBrigadeId());
                longRangeSide0.add(entryDTO);
            }


            for (LongRangeAttackLogEntry entry : logs.getLongRangeAttackLogEntriesSide1()) {
                final LongRangeAttackLogEntryDTO entryDTO = new LongRangeAttackLogEntryDTO();
                entryDTO.setAttackerBrigadeId(entry.getAttackerBrigadeId());
                entryDTO.setCasualties(entry.getCasualties());
                entryDTO.setRicochetAttack(entry.isRicochetAttack());
                entryDTO.setTargetBrigadeId(entry.getTargetBrigadeId());
                longRangeSide1.add(entryDTO);
            }


            for (MeleeAttackLogEntry entry : logs.getMeleeAttackLogEntries()) {
                final MeleeAttackLogEntryDTO entryDTO = new MeleeAttackLogEntryDTO();
                entryDTO.setAttackerBrigadeId(entry.getAttackerBrigadeId());
                entryDTO.setCasualties(entry.getCasualties());
                entryDTO.setTargetBrigadeId(entry.getTargetBrigadeId());
                meleeAttack.add(entryDTO);
            }
            if (logs.getStructuresStatuses() != null) {
                for (StructureStatus entry : logs.getStructuresStatuses()) {
                    final StructureStatusDTO entryDTO = new StructureStatusDTO();
                    entryDTO.setX(entry.getX());
                    entryDTO.setY(entry.getY());
                    entryDTO.setHitPoints(entry.getHitPoints());
                    entryDTO.setType(entry.getType());
                    for (StructureAffectedLogEntry entry2 : entry.getStructureAffectedLogEntries()) {
                        StructureAffectedLogEntryDTO entry2DTO = new StructureAffectedLogEntryDTO();
                        entry2DTO.setBrigadeId(entry2.getAttackerBrigadeId());
                        entry2DTO.setHitPointDiff(entry2.getDamage());
                        entry2DTO.setOldHitPoints(entry2.getOldHitPoints());
                        entryDTO.getStructureAffected().add(entry2DTO);
                    }
                    structureStatus.add(entryDTO);
                }
            }

        }
        out.setRallyLogEntriesSide0(rallySide0);
        out.setRallyLogEntriesSide1(rallySide1);
        out.setBrigadeMovementLogEntriesSide0(brigadesMoveSide0);
        out.setBrigadesLeftBattlefieldLogEntries(brigadesLeft);
        out.setMeleeAttackLogEntries(meleeAttack);
        out.setLongRangeAttackLogEntriesSide1(longRangeSide1);
        out.setLongRangeAttackLogEntriesSide0(longRangeSide0);
        out.setBrigadeMovementLogEntriesSide1(brigadesMoveSide1);
        out.setStructureStatusEntries(structureStatus);
        try {
            out.setMoraleSide0(logs.getMoraleSide0());
            out.setMoraleSide1(logs.getMoraleSide1());
        } catch (Exception e) {
            out.setMoraleSide0(rand.nextInt(101));
            out.setMoraleSide1(rand.nextInt(101));
        }
        return out;
    }

    public static List<FieldBattleHalfRoundStatisticsDTO> convert(final List<FieldBattleHalfRoundStatistics> values) {
        List<FieldBattleHalfRoundStatisticsDTO> out = new ArrayList<FieldBattleHalfRoundStatisticsDTO>();
        for (FieldBattleHalfRoundStatistics value : values) {
            out.add(convert(value));
        }
        return out;
    }


}

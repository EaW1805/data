package com.eaw1805.data.dto.converters;


import com.eaw1805.data.dto.web.field.FieldBattleOrderDTO;
import com.eaw1805.data.dto.web.field.FieldBattlePositionDTO;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.battles.field.FieldBattlePosition;
import com.eaw1805.data.model.battles.field.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FieldBattleOrderConverter {
    /**
     * Cannot instantiate this class.
     */
    private FieldBattleOrderConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static FieldBattleOrderDTO convert(final Order value) {
        final FieldBattleOrderDTO order = new FieldBattleOrderDTO();
        if (value.getOrderType() == null) {
            order.setOrderType("SELECT_AN_ORDER");
        } else {
            order.setOrderType(value.getOrderType());
        }
        order.setCheckPoint1(createPosition(value.getCheckpoint1()));
        order.setCheckPoint2(createPosition(value.getCheckpoint2()));
        order.setCheckPoint3(createPosition(value.getCheckpoint3()));
        order.setReachedCheckpoint1(value.isReachedCheckpoint1());
        order.setReachedCheckpoint2(value.isReachedCheckpoint2());
        order.setReachedCheckpoint3(value.isReachedCheckpoint3());
        if (value.getFormation() == null) {
            order.setFormation("ALL");
        } else {
            order.setFormation(value.getFormation());
        }

        order.setMaintainDistance(value.getMaintainDistance());
        order.setStrategicPoint1(createPosition(value.getStrategicPoint1()));
        order.setStrategicPoint2(createPosition(value.getStrategicPoint2()));
        order.setStrategicPoint3(createPosition(value.getStrategicPoint3()));
        order.setConstructionCounter(value.getConstructionCounter());
        final Set<Integer> nations = new TreeSet<Integer>();
        for (Nation nation : value.getTargetNations()) {
            nations.add(nation.getId());
        }
        order.setTargetNations(nations);
        if (value.getTargetArm() == null) {
            order.setTargetArm("ALL");
        } else {
            order.setTargetArm(value.getTargetArm());
        }
        if (value.getTargetFormation() == null) {
            order.setTargetFormation("ALL");
        } else {
            order.setTargetFormation(value.getTargetFormation());
        }
        order.setTargetHighestHeadcount(value.isTargetHighestHeadcount());
        order.setTargetClosestInRange(value.isTargetClosestInRange());
        order.setActivationRound(value.getActivationRound());
        order.setHeadCountThreshold(value.getHeadCountThreshold());
        order.setLastDestinationReached(value.isLastDestinationReached());
        order.setOwnSideCapturedEnemyStrategicPoint(value.isOwnSideCapturedEnemyStrategicPoint());
        order.setEnemySideCapturedOwnStrategicPoint(value.isEnemySideCapturedOwnStrategicPoint());
        order.setCustomStrategicPoint1(createPosition(value.getCustomStrategicPoint1()));
        order.setCustomStrategicPoint2(createPosition(value.getCustomStrategicPoint2()));
        order.setCustomStrategicPoint3(createPosition(value.getCustomStrategicPoint3()));
        order.setLeaderId(value.getDetachmentLeaderId());
        if (value.getDetachmentPosition() == null) {
            //add a default value for the client...
            order.setDetachmentPosition("TOP_CENTER");
        } else {
            order.setDetachmentPosition(value.getDetachmentPosition());
        }

        return order;
    }

    public static FieldBattlePositionDTO createPosition(FieldBattlePosition position) {

        FieldBattlePositionDTO out = new FieldBattlePositionDTO();
        if (position == null) {
            out.setX(-1);
            out.setY(-1);
        } else {
            out.setX(position.getX());
            out.setY(position.getY());
        }

        return out;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<FieldBattleOrderDTO> convert(final List<Order> list) {
        final List<FieldBattleOrderDTO> listDTOs = new ArrayList<FieldBattleOrderDTO>();
        for (final Order value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }

}

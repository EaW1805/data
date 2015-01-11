package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.web.army.BrigadeDTO;
import com.eaw1805.data.model.army.Brigade;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert Brigade DB objects into BrigadeDTOs.
 */
public final class BrigadeConverter {

    /**
     * Cannot instantiate this class.
     */
    private BrigadeConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static BrigadeDTO convert(final Brigade value) {
        final BrigadeDTO empireBrigadeDTO = new BrigadeDTO();
        empireBrigadeDTO.setBrigadeId(value.getBrigadeId());
        empireBrigadeDTO.setRegionId(value.getPosition().getRegion().getId());
        empireBrigadeDTO.setNationId(value.getNation().getId());
        empireBrigadeDTO.setX(value.getPosition().getX());
        empireBrigadeDTO.setY(value.getPosition().getY());
        empireBrigadeDTO.setXStart(value.getPosition().getX());
        empireBrigadeDTO.setYStart(value.getPosition().getY());
        empireBrigadeDTO.setMps(value.getMps());
        if (value.getCorp() == null) {
            empireBrigadeDTO.setCorpId(0);
            empireBrigadeDTO.setStartCorp(0);
        } else {
            empireBrigadeDTO.setCorpId(value.getCorp());
            empireBrigadeDTO.setStartCorp(value.getCorp());
        }

        empireBrigadeDTO.setName(value.getName());
        empireBrigadeDTO.setOriginalName(value.getName());
        empireBrigadeDTO.setBattalions(BattalionConverter.convert(value.getBattalions()));
        empireBrigadeDTO.setFromInit(value.getFromInit());
        if (value.getFieldBattlePosition() == null) {
            empireBrigadeDTO.setFieldBattleY(0);
            empireBrigadeDTO.setFieldBattleX(0);
            empireBrigadeDTO.setPlacedOnFieldMap(false);
        } else {
            empireBrigadeDTO.setFieldBattleY(value.getFieldBattlePosition().getY());
            empireBrigadeDTO.setFieldBattleX(value.getFieldBattlePosition().getX());
            if (value.getFieldBattlePosition().getX() != -1 && value.getFieldBattlePosition().getY() != -1) {
                empireBrigadeDTO.setPlacedOnFieldMap(value.getFieldBattlePosition().isPlaced());
            } else {
                empireBrigadeDTO.setPlacedOnFieldMap(false);
            }
        }

        // Detect if unit is loaded
        if (value.getBattalions().iterator().hasNext()) {
            if (value.getBattalions().iterator().next().getCarrierInfo().getCarrierType() != 0) {
                empireBrigadeDTO.setLoaded(true);
                empireBrigadeDTO.setStartLoaded(true);
            }
        }
        empireBrigadeDTO.setFieldBattleUpdateMiddleRound(false);
        if (value.getBasicOrder() != null) {
            empireBrigadeDTO.setFieldBattleUpdateMiddleRound(value.getBasicOrder().getBackup() != null);
            empireBrigadeDTO.setBasicOrder(FieldBattleOrderConverter.convert(value.getBasicOrder()));
            if (value.getBasicOrder().getBackup() != null) {
                empireBrigadeDTO.getBasicOrder().setOriginalOrder(FieldBattleOrderConverter.convert(value.getBasicOrder().getBackup()));
            } else {
                empireBrigadeDTO.getBasicOrder().setOriginalOrder(FieldBattleOrderConverter.convert(value.getBasicOrder()));
            }

        }
        if (value.getAdditionalOrder() != null) {
            if (!empireBrigadeDTO.isFieldBattleUpdateMiddleRound()) {
                empireBrigadeDTO.setFieldBattleUpdateMiddleRound(value.getAdditionalOrder().getBackup() != null);
            }
            empireBrigadeDTO.setAdditionalOrder(FieldBattleOrderConverter.convert(value.getAdditionalOrder()));
            if (value.getAdditionalOrder().getBackup() != null) {
                empireBrigadeDTO.getAdditionalOrder().setOriginalOrder(FieldBattleOrderConverter.convert(value.getAdditionalOrder().getBackup()));
            } else {
                empireBrigadeDTO.getAdditionalOrder().setOriginalOrder(FieldBattleOrderConverter.convert(value.getAdditionalOrder()));
            }
        }

        empireBrigadeDTO.setFieldBattleCommanderId(value.getFieldBattleCommanderId());
        empireBrigadeDTO.setFieldBattleOverallCommanderId(value.getFieldBattleOverallCommanderId());

        return empireBrigadeDTO;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<BrigadeDTO> convert(final List<Brigade> list) {
        final List<BrigadeDTO> listDTOs = new ArrayList<BrigadeDTO>();
        for (final Brigade value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }

}

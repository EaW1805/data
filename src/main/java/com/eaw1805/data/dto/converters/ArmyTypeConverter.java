package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.web.army.ArmyTypeDTO;
import com.eaw1805.data.model.army.ArmyType;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert ArmyType DB objects into ArmyTypeDTOs.
 */
public final class ArmyTypeConverter {

    /**
     * Cannot instantiate this class.
     */
    private ArmyTypeConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static ArmyTypeDTO convert(final ArmyType value) {
        final ArmyTypeDTO empireArmyTypeDTO = new ArmyTypeDTO();
        empireArmyTypeDTO.setIntId(value.getIntId());
        empireArmyTypeDTO.setNationId(value.getNation().getId());
        if (value.getRegion() == null) {
            empireArmyTypeDTO.setRegionId(0);
        } else {
            empireArmyTypeDTO.setRegionId(value.getRegion().getId());
        }
        empireArmyTypeDTO.setId(value.getId());
        empireArmyTypeDTO.setCost(value.getCost());
        empireArmyTypeDTO.setIndPt(value.getIndPt());
        empireArmyTypeDTO.setMaxExp(value.getMaxExp());
        empireArmyTypeDTO.setHandCombat(value.getHandCombat());
        empireArmyTypeDTO.setLongRange(value.getLongRange());
        empireArmyTypeDTO.setLongCombat(value.getLongCombat());
        empireArmyTypeDTO.setMps(value.getMps());
        empireArmyTypeDTO.setSps(value.getSps());
        empireArmyTypeDTO.setType(value.getType());
        empireArmyTypeDTO.setName(value.getName());
        empireArmyTypeDTO.setShortName(value.getShortName());
        empireArmyTypeDTO.setFormationCo(value.getFormationCo());
        empireArmyTypeDTO.setFormationLi(value.getFormationLi());
        empireArmyTypeDTO.setFormationSq(value.getFormationSq());
        empireArmyTypeDTO.setFormationSk(value.getFormationSk());
        empireArmyTypeDTO.setTroopSpecsLr(value.getTroopSpecsLr());
        empireArmyTypeDTO.setTroopSpecsLc(value.getTroopSpecsLc());
        empireArmyTypeDTO.setTroopSpecsCu(value.getTroopSpecsCu());
        empireArmyTypeDTO.setCrack(value.getCrack());
        empireArmyTypeDTO.setElite(value.getElite());
        empireArmyTypeDTO.setUpgradeCrackFrom(value.getUpgradeCrackFrom());
        empireArmyTypeDTO.setUpgradeEliteTo(value.getUpgradeEliteTo());
        empireArmyTypeDTO.setVps(value.getVps());
        return empireArmyTypeDTO;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list the list of DB object.
     * @return the list of DTO object.
     */
    public static List<ArmyTypeDTO> convert(final List<ArmyType> list) {
        final List<ArmyTypeDTO> listDTOs = new ArrayList<ArmyTypeDTO>();
        for (final ArmyType value : list) {
            listDTOs.add(convert(value));
        }
        return listDTOs;
    }

}

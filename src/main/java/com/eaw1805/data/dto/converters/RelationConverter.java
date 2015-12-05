package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.web.RelationDTO;
import com.eaw1805.data.managers.beans.RelationsManagerBean;
import com.eaw1805.data.model.NationsRelation;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert Relation DB objects into RelationDTOs.
 */
public final class RelationConverter {

    /**
     * Cannot instantiate this class.
     */
    private RelationConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value            the DB object.
     * @param relationsManager a bean for accessing NationsRelation entities.
     * @return the DTO object.
     */
    public static RelationDTO convert(final NationsRelation value, final RelationsManagerBean relationsManager) {
        final RelationDTO empireRelationDTO = new RelationDTO();
        empireRelationDTO.setNationId(value.getNation().getId());
        empireRelationDTO.setTargetNationId(value.getTarget().getId());
        empireRelationDTO.setRelation(value.getRelation());
        empireRelationDTO.setPeaceCount(value.getPeaceCount());
        empireRelationDTO.setSurrenderCount(value.getSurrenderCount());
        empireRelationDTO.setVisible(value.isVisible());
        empireRelationDTO.setFixed(value.getFixed());

        // Get their relation towards us
        final NationsRelation theirNationsRelation = relationsManager.getByNations(value.getGame(),
                value.getTarget(),
                value.getNation());

        empireRelationDTO.setTheirRelation(theirNationsRelation.getRelation());

        return empireRelationDTO;
    }

    /**
     * Convert the list of DB object into a list of DTO.
     *
     * @param list             the list of DB object.
     * @param relationsManager a bean for accessing NationsRelation entities.
     * @return the list of DTO object.
     */
    public static List<RelationDTO> convert(final List<NationsRelation> list, final RelationsManagerBean relationsManager) {
        final List<RelationDTO> listDTOs = new ArrayList<RelationDTO>();
        for (final NationsRelation value : list) {
            listDTOs.add(convert(value, relationsManager));
        }
        return listDTOs;
    }

}

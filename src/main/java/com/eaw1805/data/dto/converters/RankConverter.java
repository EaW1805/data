package com.eaw1805.data.dto.converters;

import com.eaw1805.data.dto.web.army.RankDTO;
import com.eaw1805.data.model.army.Rank;

import java.util.ArrayList;
import java.util.List;

/**
 * Convert Rank DB objects into RankDTOs.
 */
public final class RankConverter {

    /**
     * Cannot instantiate this class.
     */
    private RankConverter() {
        // empty constructor
    }

    /**
     * Convert the DB object into a DTO.
     *
     * @param value the DB object.
     * @return the DTO object.
     */
    public static RankDTO convert(final Rank value) {
        final RankDTO rankDTO = new RankDTO();
        rankDTO.setMaxComC(value.getMaxComC());
        rankDTO.setMinComC(value.getMinComC());
        rankDTO.setStrC(value.getStrC());
        rankDTO.setName(value.getName());
        rankDTO.setRankId(value.getRankId());
        rankDTO.setSalary(value.getSalary());
        return rankDTO;
    }

    public static List<RankDTO> convert(final List<Rank> value) {
        final List<RankDTO> out = new ArrayList<RankDTO>();
        for (Rank rank : value) {
            out.add(convert(rank));
        }
        return out;
    }

}

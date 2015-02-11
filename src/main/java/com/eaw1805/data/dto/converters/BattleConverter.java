package com.eaw1805.data.dto.converters;

import com.eaw1805.data.constants.RelationConstants;
import com.eaw1805.data.dto.common.BattleDTO;
import com.eaw1805.data.model.Nation;
import com.eaw1805.data.model.battles.NavalBattleReport;
import com.eaw1805.data.model.battles.TacticalBattleReport;

import java.util.Map;

/**
 * Convert Tactical and Naval Battle report objects.
 */
public final class BattleConverter implements RelationConstants {

    /**
     * Cannot instantiate this class.
     */
    private BattleConverter() {
        // empty constructor
    }

    public static BattleDTO convert(final NavalBattleReport value,
                                    final int nationId,
                                    final Map<Integer, Integer> relationMap) {

        // find the side of this nation
        int side = -1;
        boolean show = false;
        for (final Nation nation : value.getSide1()) {
            if (nationId == nation.getId()) {
                side = 1;
                show = true;
                break;
            }

            if (relationMap.containsKey(nation.getId())
                    && relationMap.get(nation.getId()) == REL_ALLIANCE) {
                show = true;
            }
        }

        if (side == -1) {
            for (final Nation nation : value.getSide2()) {
                if (nationId == nation.getId()) {
                    side = 2;
                    show = true;
                    break;
                }

                if (relationMap.containsKey(nation.getId())
                        && relationMap.get(nation.getId()) == REL_ALLIANCE) {
                    show = true;
                }
            }
        }

        final BattleDTO battleDTO = new BattleDTO();
        battleDTO.setRegionId(value.getPosition().getRegion().getId());
        battleDTO.setX(value.getPosition().getX());
        battleDTO.setXStart(value.getPosition().getX());
        battleDTO.setY(value.getPosition().getY());
        battleDTO.setYStart(value.getPosition().getY());
        battleDTO.setSide(side);
        battleDTO.setWinner(value.getWinner());
        battleDTO.setBattleId(value.getBattleId());
        battleDTO.setBattleType(0);//for naval
        battleDTO.setShow(show);
        return battleDTO;
    }

    public static BattleDTO convert(final TacticalBattleReport value,
                                    final int nationId,
                                    final Map<Integer, Integer> relationMap) {
        // find the side of this nation
        int side = -1;
        boolean show = false;
        for (Nation nation : value.getSide1()) {
            if (nationId == nation.getId()) {
                side = 1;
                show = true;
                break;
            }

            if (relationMap.containsKey(nation.getId())
                    && relationMap.get(nation.getId()) == REL_ALLIANCE) {
                show = true;
            }
        }

        if (side == -1) {
            for (Nation nation : value.getSide2()) {
                if (nationId == nation.getId()) {
                    side = 2;
                    show = true;
                    break;
                }

                if (relationMap.containsKey(nation.getId())
                        && relationMap.get(nation.getId()) == REL_ALLIANCE) {
                    show = true;
                }
            }
        }

        final BattleDTO battleDTO = new BattleDTO();
        battleDTO.setRegionId(value.getPosition().getRegion().getId());
        battleDTO.setX(value.getPosition().getX());
        battleDTO.setXStart(value.getPosition().getX());
        battleDTO.setY(value.getPosition().getY());
        battleDTO.setYStart(value.getPosition().getY());
        battleDTO.setSide(side);
        battleDTO.setWinner(value.getWinner() + 1);//+1 for just to follow the same logic as naval battles
        battleDTO.setBattleId(value.getBattleId());
        battleDTO.setBattleType(1);//for tactical
        battleDTO.setShow(show);
        return battleDTO;
    }
}

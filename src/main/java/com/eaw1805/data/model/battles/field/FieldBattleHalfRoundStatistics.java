package com.eaw1805.data.model.battles.field;

import com.eaw1805.data.dto.converters.BrigadeConverter;
import com.eaw1805.data.dto.web.army.BrigadeDTO;
import com.eaw1805.data.model.army.Brigade;
import com.eaw1805.data.model.battles.field.log.IHalfRoundLog;

import java.io.Serializable;
import java.util.List;

/**
 * Class to represent the half-round statistics for field battles.
 *
 * @author fragkakis
 */
public class FieldBattleHalfRoundStatistics
        implements Serializable {

    private static final long serialVersionUID = -4871301738536343763L;

    private final int halfRound;
    @SuppressWarnings("unchecked")
    private final List<BrigadeDTO>[] sideBrigades = new List[2];
    // TODO: To be changed to appropriate DTOs
    private final FieldBattleMap fbMap;
    private final IHalfRoundLog halfRoundLog;
    private final int winner;

    /**
     * Constructor
     *
     * @param halfRound    the halfround. If -1, this is the initial state of the field battle (after initialization)
     * @param brigades     the brigades of each side
     * @param fbMap        the field battle map
     * @param halfRoundLog the half round log
     * @param winner       the winner (0 or 1), or -1 for non-winner
     */
    public FieldBattleHalfRoundStatistics(int halfRound, List<Brigade>[] brigades,
                                          FieldBattleMap fbMap, IHalfRoundLog halfRoundLog, int winner) {

        this.halfRound = halfRound;
        if (brigades != null) {
            for (int side = 0; side < 2; side++) {
                sideBrigades[side] = BrigadeConverter.convert(brigades[side]);
            }
        }
        this.fbMap = fbMap;
        this.halfRoundLog = halfRoundLog;
        this.winner = winner;
    }

    public int getHalfRound() {
        return halfRound;
    }

    public int getWinner() {
        return winner;
    }

    public List<BrigadeDTO>[] getSideBrigades() {
        return sideBrigades;
    }

    public FieldBattleMap getFbMap() {
        return fbMap;
    }

    public IHalfRoundLog getHalfRoundLog() {
        return halfRoundLog;
    }
}

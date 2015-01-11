package com.eaw1805.data.model.army.comparators;

import com.eaw1805.data.model.battles.FieldBattleReport;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Used to sort field battle reports.
 */
public class FieldBattleOrder implements Comparator<FieldBattleReport>, Serializable {

    /**
     * For serialization purposes.
     */
    static final long serialVersionUID = -33875699324229948L;

    @Override
    public int compare(final FieldBattleReport report1, final FieldBattleReport report2) {
        int comparison = 0;
        if (report1.getTurn() < report2.getTurn()) {
            comparison = 1;

        } else if (report1.getTurn() > report2.getTurn()) {
            comparison = -1;

        } else {
            // Then check id.
            if (report1.getBattleId() < report2.getBattleId()) {
                comparison = 1;

            } else if (report1.getBattleId() > report2.getBattleId()) {
                comparison = -1;
            }
        }

        return comparison;
    }

}

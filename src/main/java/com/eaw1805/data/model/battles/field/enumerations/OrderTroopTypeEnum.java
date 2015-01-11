package com.eaw1805.data.model.battles.field.enumerations;

/**
 * Troop types.
 */
public enum OrderTroopTypeEnum {

    ALL_TYPES,
    ALL_TYPES_WITH_HIGHEST_HEADCOUNT,

    INFANTRY_IN_COLUMN_OR_LINE,
    INFANTRY_IN_SQUARE_FORMATION,
    SKIRMISHING_INFANTRY,
    FLEEING_INFANTRY,
    INFANTRY_IN_ANY_FORMATION,
    INFANTRY_UNIT_WITH_THE_HIGHEST_HEADCOUNT,

    CAVALRY_IN_A_COLUMN_OR_LINE_FORMATION,
    SKIRMISHING_CAVALRY,
    FLEEING_CAVALRY,
    CAVALRY_IN_ANY_FORMATION,
    CAVALRY_UNIT_WITH_THE_HIGHEST_HEADCOUNT,

    ARTILLERY,
    FLEEING_ARTILLERY,
    ARTILLERY_UNIT_WITH_THE_HIGHEST_HEADCOUNT,

    ALL_FLEEING_ENEMY_BRIGADES,

    NO_REACTION_TO_ANY_TROOP_TYPE;
    ;

}

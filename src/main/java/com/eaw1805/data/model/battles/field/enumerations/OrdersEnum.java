package com.eaw1805.data.model.battles.field.enumerations;

/**
 * Field battle orders.
 */
public enum OrdersEnum {

    ENGAGE_IF_IN_RANGE(true),

    MOVE_TO_FIRE(true),

    MOVE_TO_ENGAGE(true),

    ATTACK_AND_REFORM(true),

    DEFEND_POSITION(false),

    MAINTAIN_DISTANCE(false),

    RETREAT(false),

    BREAK_DETACHMENT(false),

    HEAVY_CAVALRY_CHARGE(true),

    // strategic points-related orders
    ATTACK_ENEMY_STRATEGIC_POINTS(true),

    RECOVER_OWN_STRATEGIC_POINTS(true),

    // pioneer orders
    DIG_ENTRENCHMENTS(false),

    BUILD_PONTOON_BRIDGE(false),

    MOVE_TO_DESTROY_FORTIFICATIONS(true),

    MOVE_TO_DESTROY_BRIDGES(true),

    // follow
    FOLLOW_DETACHMENT(false);

    /**
     * Indicates whether the particular order is an attack order.
     */
    private final boolean attackOrder;

    private OrdersEnum(boolean attackOrder) {
        this.attackOrder = attackOrder;
    }

    /**
     * Indicates whether the particular order is an attack order.
     *
     * @return true or false
     */
    public boolean isAttackOrder() {
        return attackOrder;
    }
}

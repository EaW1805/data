package com.eaw1805.data.model.battles.field.enumerations;

/**
 * Detachment position.
 */
public enum DetachmentPosition {

    TOP_LEFT(-1, -1),
    TOP_CENTER(0, -1),
    TOP_RIGHT(1, -1),

    LEFT(-1, 0),
    RIGHT(1, 0),

    BOTTOM_LEFT(-1, 1),
    BOTTOM_CENTER(0, 1),
    BOTTOM_RIGHT(1, 1);

    private final int displacementX;
    private final int displacementY;

    private DetachmentPosition(int displacementX, int displacementY) {
        this.displacementX = displacementX;
        this.displacementY = displacementY;
    }

    public int getDisplacementX() {
        return displacementX;
    }

    public int getDisplacementY() {
        return displacementY;
    }

}

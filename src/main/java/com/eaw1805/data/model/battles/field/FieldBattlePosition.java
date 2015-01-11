package com.eaw1805.data.model.battles.field;

import java.io.Serializable;

/**
 * This class represents the a position in the field battle map.
 * @author fragkakis
 *
 */
public class FieldBattlePosition implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD
	
	private int x;
	private int y;
    private boolean placed;

	public FieldBattlePosition() {
		// do nothing
	}
	
	public FieldBattlePosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }
    
    public boolean exists() {
    	return x>=0 && y>=0;
    }

    @Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FieldBattlePosition other = (FieldBattlePosition) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

}

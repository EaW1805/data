package com.eaw1805.data.dto.web.field;

import java.io.Serializable;

public class FieldBattlePositionDTO implements com.google.gwt.user.client.rpc.IsSerializable, Serializable {

	private static final long serialVersionUID = -8006682855489187090L;
	
	private int x;
    private int y;

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

    public void reset() {
        x = -1;
        y = -1;
    }

    public String toString() {
        return (x + 1)+"/"+ (y + 1);
    }
}

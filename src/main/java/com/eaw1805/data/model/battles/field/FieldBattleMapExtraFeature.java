package com.eaw1805.data.model.battles.field;

import java.io.Serializable;

/**
 * This class represents the extra features a field battle map may have.
 * @author fragkakis
 *
 */
public class FieldBattleMapExtraFeature implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD
	
	/**
	 * The id of the field battle map extra feature.
	 */
	private int id;
	/**
	 * The name of the field battle map extra feature.
	 */
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}

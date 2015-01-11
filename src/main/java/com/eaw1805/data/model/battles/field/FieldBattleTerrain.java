package com.eaw1805.data.model.battles.field;

import java.io.Serializable;

/**
 * Class representing the possible field battle terrain types.
 * 
 * @author fragkakis
 * 
 */
public class FieldBattleTerrain implements Serializable {

    /**
     * Required by Serializable interface.
     */
    static final long serialVersionUID = 42L; //NOPMD
	
	/**
	 * The id of the field battle terrain.
	 */
	private int id;
	/**
	 * The name of the field battle terrain.
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

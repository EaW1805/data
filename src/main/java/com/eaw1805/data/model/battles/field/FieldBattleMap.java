package com.eaw1805.data.model.battles.field;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * This class represents the terrain for the field battle.
 * @author fragkakis
 *
 */
public class FieldBattleMap implements Serializable {
	
	private static final long serialVersionUID = -6824707958913340952L;
	
	private int id;
	private int battleId;
	private int sizeX;
	private int sizeY;
	private FieldBattleSector[][] sectors;
	private Set<FieldBattleSector> sectorsSet;

	/**
	 * Constructor that initializes all the internal sectors.
	 * @param terrainX the size of axis X
	 * @param terrainY the size of axis Y
	 */
	public FieldBattleMap(int terrainX, int terrainY) {
		
		sectors = new FieldBattleSector[terrainX][terrainY];
		sectorsSet = new HashSet<FieldBattleSector>();
		
		this.sizeX = terrainX;
		this.sizeY = terrainY;
		for(int x=0; x<terrainX; x++) {
			for(int y=0; y<terrainY; y++) {
				FieldBattleSector fieldBattleSector = new FieldBattleSector();
				fieldBattleSector.setX(x);
				fieldBattleSector.setY(y);
				fieldBattleSector.setMap(this);
				sectors[x][y] = fieldBattleSector;
				sectorsSet.add(fieldBattleSector);
			}
		}
	}
	
	/**
	 * No arguments constructor
	 */
	public FieldBattleMap() {

	}

	public int getSizeX() {
		return sizeX;
	}

	public int getSizeY() {
		return sizeY;
	}
	
	public FieldBattleSector getFieldBattleSector(int sectorX, int sectorY) {
		return getSectors()[sectorX][sectorY];
	}

	public FieldBattleSector[][] getSectors() {
		if(sectors == null) {
			sectors = new FieldBattleSector[sizeX][sizeY];
			for(FieldBattleSector sector : sectorsSet) {
				sectors[sector.getX()][sector.getY()] = sector;
			}
		}
		return sectors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSizeX(int sizeX) {
		this.sizeX = sizeX;
	}

	public void setSizeY(int sizeY) {
		this.sizeY = sizeY;
	}

	public Set<FieldBattleSector> getSectorsSet() {
		return sectorsSet;
	}

	public void setSectorsSet(Set<FieldBattleSector> sectorsSet) {
		this.sectorsSet = sectorsSet;
	}

	public int getBattleId() {
		return battleId;
	}

	public void setBattleId(int battleId) {
		this.battleId = battleId;
	}

}

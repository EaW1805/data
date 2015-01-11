package com.eaw1805.data.model.battles.field.enumerations;

/**
 * The possible morale statuses in a field battle.
 * @author fragkakis
 *
 */
public enum MoraleStatusEnum {
	NORMAL("Normal"),
	ROUTING("Routing"),
	DISORDER("Disorder");
	
	private final String name;
	private MoraleStatusEnum(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public static MoraleStatusEnum fromName(String name) {
		for(MoraleStatusEnum moraleStatusEnum : MoraleStatusEnum.values()) {
			if(moraleStatusEnum.getName().equalsIgnoreCase(name)) {
				return moraleStatusEnum;
			}
		}
		throw new IllegalArgumentException("There is no MoraleStatusEnum with name " + name);
	}
	
}

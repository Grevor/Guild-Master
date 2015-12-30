package org.staticvoid.gm.model;

public enum Skills {
	Herbalism("Herbalism"),
	Woodcutting("Woodcutting"),
	Prospecting("Prospecting"),
	Mining("Mining"),
	Alchemy("Alchemy"),
	Agility("Agility"),
	Smelting("Smelting"),
	Metalworking("Metalworking"),
	Hunting("Hunting"),
	RangedCombat("Ranged Weapons"),
	MeleeCombat("Melee Combat"),
	Strength("Strength"),
	Carpentry("Carpentry"),
	Magic("Magic"),
	Scholar("Scholar");
	
	
	private final String displayName;
	private Skills(String dispName) {
		displayName = dispName;
	}
	
}

package org.staticvoid.gm.model.time;

public enum Season {
	LateWinter("Frosty Winter"),
	EarlySpring("Early Spring"),
	Spring("Spring"),
	LateSpring("Late Spring"),
	EarlySummer("Summer"),
	Summer("High Summer"),
	LateSummer("Late Summer"),
	EarlyAutumn("Early Autumn"),
	Autumn("Storm Season"),
	LateAutumn("Late Autumn"),
	EarlyWinter("Winter"),
	Winter("Harsh Winter");
	
	private final String displayName;
	
	private Season(String disp) {
		displayName = disp;
	}

	
	public String getDisplayName() { return displayName; }
	
}

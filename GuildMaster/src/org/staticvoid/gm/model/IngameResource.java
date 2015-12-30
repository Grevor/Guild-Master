package org.staticvoid.gm.model;

public enum IngameResource {
	Wood("Wood"),
	Stone("Stone"),
	Iron("Iron"),
	Copper("Copper");
	
	private final String displayName;
	private final String scriptName;
	private IngameResource(String disp) {
		displayName = disp;
		scriptName = disp;
	}

	
	public String getDisplayName() { return displayName; }
	public String getScriptName() { return scriptName; }
	
}

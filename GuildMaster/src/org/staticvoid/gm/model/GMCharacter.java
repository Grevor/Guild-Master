package org.staticvoid.gm.model;

import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.model.action.GMAction;
import org.staticvoid.gm.model.location.GMLocation;
import org.staticvoid.gm.model.time.DayProgression;

public class GMCharacter {
	private long lastBusyDay = -1;
	private GMAction action;
	private GMLocation location;
	private String name;
	
	public GMCharacter(String name) {
		this.name = name;
	}
	
	public boolean isBusy(DayProgression prog) { return  lastBusyDay >= prog.getTotalDays(); }
	public String getName() { return name; }

	public void setCurrentAction(GameMasterState state, GMAction action, GMLocation location) { 
		this.action = action; 
		this.location = location; 
		lastBusyDay = state.getProgression().getTotalDays() + action.timeThatWillBeSpent(state, this, location);
	}
	public GMAction getCurrentAction() { return action; }
	public GMLocation getLocation() { return location; }

	public void delinkAction() {
		action = null;
		location = null;
	}

	public String getCurrentActionName(GameMasterState state) { return getCurrentAction().getDisplayName(state, this, location); }
}

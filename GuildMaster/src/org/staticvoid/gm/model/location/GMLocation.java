package org.staticvoid.gm.model.location;

import java.util.ArrayList;

import org.staticvoid.collections.SecondOrderIterable;
import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.model.GMCharacter;
import org.staticvoid.gm.model.action.GMAction;

import viking.collections.NamedItem;

public class GMLocation implements NamedItem {
	private String name, displayName;
	private ArrayList<GMLocation> innerLocations = new ArrayList<>();
	private ArrayList<GMAction> actions = new ArrayList<>();
	
	public GMLocation(String name, String display) {
		this.name = name;
		this.displayName = display;
	}
	
	@Override
	public String getName() { return name; }
	public String getDisplayName(GameMasterState state) { return displayName; }
	
	public void add(GMLocation l) { innerLocations.add(l); }
	public void add(GMAction l) { actions.add(l); }
	
	public Iterable<GMLocation> innerLocations() { return innerLocations; }
	public Iterable<GMAction> actions() { return actions; }
	public Iterable<GMCharacter> activeCharacters() {
		ArrayList<Iterable<GMCharacter>> chars = new ArrayList<>();
		for(GMAction action : actions)
			chars.add(action.activeCharacters());
		return new SecondOrderIterable<>(chars);
	}
	
	public int numInnerLocations() { return innerLocations.size(); }
	public boolean isLocation(int answer) { return answer >= numInnerLocations(); }
	
	public GMLocation getLocation(int answer) { return innerLocations.get(answer - 1); }
	public GMAction getAction(int answer) { return actions.get(answer - numInnerLocations() - 1); }
	public String getDescription(GameMasterState state) {
		return "<MISSING DESCRIPTION>";
	}
}

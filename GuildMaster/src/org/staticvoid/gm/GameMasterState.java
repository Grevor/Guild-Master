package org.staticvoid.gm;

import org.staticvoid.gm.input.ConsoleGameInput;
import org.staticvoid.gm.input.GameIO;
import org.staticvoid.gm.input.states.InputStateStack;
import org.staticvoid.gm.model.City;
import org.staticvoid.gm.model.location.GMLocation;
import org.staticvoid.gm.model.location.World;
import org.staticvoid.gm.model.time.DayProgression;

public class GameMasterState {
	private GameIO input = new ConsoleGameInput();
	private InputStateStack states = new InputStateStack();
	private City city = new City("SAMPLE CITY");
	private DayProgression progression = new DayProgression();
	private GMLocation world = new World();
	
	public DayProgression getProgression() { return progression; }
	public GameIO getInput() { return input; }
	public InputStateStack getStates() { return states; }
	public City getCity() { return city; }
	public void setCity(City c) { city = c; }
	public GMLocation getWorld() { return world; }
	public void setWorld(GMLocation location) { world = location; }
	
}

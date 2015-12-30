package org.staticvoid.gm.model;

import org.staticvoid.gm.model.action.ActionCollection;

public class City {
	private final String name;
	private CharacterList characters = new CharacterList();
	private IngameResources storage = new IngameResources();
	private ActionCollection actions = new ActionCollection();
	private ActionCollection events = new ActionCollection();
	public City(String n) {
		name = n;
	}
	
	/**
	 * Gets the name of the city.
	 * @return
	 * The name.
	 */
	public String getName() { return name; }
	/**
	 * Gets the characters (guildies) in the city.
	 * @return
	 * The characters.
	 */
	public CharacterList getCharacters() { return characters; }
	/**
	 * Gets the resource storage of this city.
	 * @return
	 * The resource storage.
	 */
	public IngameResources getStorage() { return storage; }
	/**
	 * Gets the active actions in this city.
	 * @return
	 * The actions.
	 */
	public ActionCollection getActiveActions() { return actions; }
	/**
	 * Gets the active events in this city.<br>
	 * Events can be thought of as actions which require no participants.
	 * @return
	 * The events.
	 */
	public ActionCollection getActiveEvents() { return events; }
}

package org.staticvoid.gm.input.states.ingame;

import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.input.GameIO;
import org.staticvoid.gm.input.IOUtil;
import org.staticvoid.gm.input.states.EmptyInputState;
import org.staticvoid.gm.model.IngameResource;

/**
 * Class representing a state which simply displays available resources.
 * @author Grevor
 *
 */
public class DisplayResourcesState extends EmptyInputState {

	@Override
	public void beforeInput(GameMasterState state) {
		printResources(state, state.getInput());
	}
	
	public void printResources(GameMasterState state, GameIO io) {
		IOUtil.decorateAsHeader("Resource Storages", io);
		for(IngameResource r : IngameResource.values())
			io.println(pad(r.getDisplayName() + ":", 20) + (int)state.getCity().getStorage().getAmount(r));
	}
	
	private String pad(String s, int i) {
		while(s.length() < i)
			s += " ";
		return s;
	}

}

package org.staticvoid.gm.input.states.ingame;

import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.input.GameIO;
import org.staticvoid.gm.input.IOUtil;
import org.staticvoid.gm.input.InputState;
import org.staticvoid.gm.model.location.GMLocation;

/**
 * State which simply gives the player a description of a certain location.
 * @author Grevor
 *
 */
public class ExamineLocationState implements InputState {
	private GMLocation location;
	
	public ExamineLocationState(GMLocation loc) {
		location = loc;
	}

	@Override
	public void run(GameMasterState state) {
		GameIO io = state.getInput();
		IOUtil.decorateAsHeader(location.getDisplayName(state), io);
		io.println(location.getDescription(state));
		io.nextInput();
		state.getStates().reset(new MainIngameState());
	}

}

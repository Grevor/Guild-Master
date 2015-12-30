package org.staticvoid.gm.input.states.ingame;

import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.input.GameIO;
import org.staticvoid.gm.input.IOUtil;
import org.staticvoid.gm.input.states.EmptyInputState;
import org.staticvoid.gm.model.GMCharacter;
import org.staticvoid.gm.model.action.GMAction;
import org.staticvoid.gm.model.location.GMLocation;

/**
 * Class representing a state where the player is about to perform an action with a certain character.
 * @author Grevor
 *
 */
public class ActionState extends EmptyInputState {
	private GMAction action;
	private GMCharacter character;
	private GMLocation location;
	
	public ActionState(GMAction action, GMCharacter character, GMLocation location) {
		this.action = action;
		this.character = character;
		this.location = location;
	}

	@Override
	public void beforeInput(GameMasterState state) {
		GameIO io = state.getInput();
		IOUtil.decorateAsHeader(action.getDisplayName(state, character, location), io);
		io.println(action.getCharacterJoinString(character));
		
		// --- Sets the data correctly. Everything must be linked correctly.
		action.assignCharacter(character);
		character.setCurrentAction(state, action, location);
		state.getCity().getActiveActions().add(action);
	}
}

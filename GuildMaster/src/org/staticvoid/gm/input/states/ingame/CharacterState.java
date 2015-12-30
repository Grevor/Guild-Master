package org.staticvoid.gm.input.states.ingame;

import org.staticvoid.development.NotYetImplementedException;
import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.input.GameIO;
import org.staticvoid.gm.input.IOUtil;
import org.staticvoid.gm.input.states.AnswerState;
import org.staticvoid.gm.input.states.InputStateStack;
import org.staticvoid.gm.model.GMCharacter;

/**
 * Class representing a state where the player can select what to do with a character.
 * @author Grevor
 *
 */
public class CharacterState extends AnswerState {
	private static final int numOptionsBusy = 4;
	private static final int numOptionsNonBusy = 5;
	
	private GMCharacter character;
	
	public CharacterState(GMCharacter c) {
		character = c;
	}
	
	@Override
	protected void showOptions(GameMasterState state, GameIO io) {
		io.println("1) Show Biography");
		io.println("2) Check Status");
		io.println("3) Show Skills");
		if(character.isBusy(state.getProgression()))
			io.println("4) Back");
		else {
			io.println("4) Assign Task");
			io.println("5) Back");
		}
	}

	@Override
	protected boolean enactAnswer(GameMasterState state, int ans, GameIO io) {
		boolean isBusy = character.isBusy(state.getProgression());
		int options = isBusy ? numOptionsBusy : numOptionsNonBusy;
		if(!IOUtil.isIn(1, options, ans))
			return false;
		
		InputStateStack stack = state.getStates();
		
		switch(ans) {
		case 1:
		case 2:
		case 3:
			throw new NotYetImplementedException(ans + " is not yet implemented...");
		case 4:
			if(isBusy)
				stack.pop();
			else
				stack.push(new ActionSelectState(state, character, state.getWorld()));
			break;
		case 5:
			stack.pop();
			break;
		}
		
		return true;
	}

}

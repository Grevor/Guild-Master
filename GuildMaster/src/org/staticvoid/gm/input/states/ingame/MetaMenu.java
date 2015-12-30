package org.staticvoid.gm.input.states.ingame;


import org.staticvoid.development.NotYetImplementedException;
import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.input.GameIO;
import org.staticvoid.gm.input.IOUtil;
import org.staticvoid.gm.input.states.AnswerState;
import org.staticvoid.gm.input.states.InputStateStack;
import org.staticvoid.gm.input.states.MainMenuState;

/**
 * Class representing the meta menu of the game.<br>
 * This menu contains the save/load/exit functionality.
 * @author Grevor
 *
 */
public class MetaMenu extends AnswerState {

	@Override
	protected void showOptions(GameMasterState state, GameIO io) {
		IOUtil.decorateAsHeader("Meta Menu", io);
		io.println("1) Save Game");
		io.println("2) Load Game");
		io.println("3) Return to Game");
		io.println("4) Return to Main Menu");
		io.println("5) Exit game");
	}

	@Override
	protected boolean enactAnswer(GameMasterState state, int ans, GameIO io) {
		if(!IOUtil.isIn(1, 5, ans))
			return false;
		
		InputStateStack stack = state.getStates();
		
		switch(ans) {
		case 1:
		case 2:
			throw new NotYetImplementedException();
		case 3:
			stack.pop();
			break;
		case 4:
			stack.reset(new MainMenuState());
			break;
		case 5:
			stack.clear();
			break;
		}
		return true;
	}

}

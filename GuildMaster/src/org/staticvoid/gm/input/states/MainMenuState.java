package org.staticvoid.gm.input.states;

import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.input.GameIO;
import org.staticvoid.gm.input.IOUtil;
import org.staticvoid.gm.input.InputState;
import org.staticvoid.gm.input.states.ingame.MainIngameState;

public class MainMenuState extends AnswerState {


	@Override
	protected void showOptions(GameMasterState state, GameIO io) {
		IOUtil.decorateAsHeader("Game Master Main Menu", io);
		io.println("1) New Game");
		io.println("2) Load Game");
		io.println("3) How to Play");
		io.println("4) Exit Game");
	}

	@Override
	protected boolean enactAnswer(GameMasterState state, int ans, GameIO io) {
		if(!IOUtil.isIn(1, 4, ans))
			return false;
		
		InputState nextState = null;
		switch(ans) {
		case 1:
		case 2:
			state.getStates().reset(new MainIngameState());
			break;
		case 3:
			state.getStates().push(nextState);
			break;
		case 4:
			state.getStates().clear();
			break;
		}
		return true;
	}
}

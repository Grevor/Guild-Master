package org.staticvoid.gm.input.states;

import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.input.GameIO;
import org.staticvoid.gm.input.InputState;

public abstract class AnswerState implements InputState {
	
	@Override
	public void run(GameMasterState state) {
		GameIO io = state.getInput();
		while(true) {
			io.clear();
			showOptions(state, io);
			int answer = -1;
			try {
				io.println("What would you like to do? Select a number:");
				answer = io.getAnswer();
			} catch(Exception e) {
				io.println("\nCould not understand answer, try again.\n");
				continue;
			}
			if(!enactAnswer(state, answer, io)) {
				io.println("\nAnswer failed to parse. Please try again.\n");
				continue;
			} else
				return;
		}
	}

	protected abstract void showOptions(GameMasterState state, GameIO io);
	protected abstract boolean enactAnswer(GameMasterState state, int ans, GameIO io);

}

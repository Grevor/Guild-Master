package org.staticvoid.gm.input.states;

import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.input.InputState;

/**
 * State which only waits for enter to be pressed, and then goes back to the last state.
 * @author Grevor
 *
 */
public abstract class EmptyInputState implements InputState {
	private int num;
	
	public EmptyInputState() { this(1); }
	public EmptyInputState(int n) { num = n; }

	@Override
	public void run(GameMasterState state) {
		beforeInput(state);
		state.getInput().println("Press enter to continue...");
		state.getInput().nextInput();
		state.getStates().pop(num);
	}
	public abstract void beforeInput(GameMasterState state);
}

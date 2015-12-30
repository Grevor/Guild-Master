package org.staticvoid.gm.input.states;

import java.util.Stack;

import org.staticvoid.gm.input.InputState;

public class InputStateStack {
	private Stack<InputState> states = new Stack<>();
	/**
	 * Gets the current input state.
	 * @return
	 * The current state.
	 */
	public InputState getCurrent() { return states.peek(); }
	
	/**
	 * Pushes a new state onto the stack. This state will now be the current state.
	 * @param state - The new state.
	 */
	public void push(InputState state) { states.push(state); }
	/**
	 * Pops the current state, possibly revealing the state under it.
	 * @return
	 * The old state.
	 */
	public InputState pop() { return states.pop(); }
	/**
	 * Pops a number of states.
	 * @param num - The number of states to drop.
	 * @return
	 * The last popped state, or null if no states were popped.
	 */
	public InputState pop(int num) {
		InputState state = null;
		for(int i = 0; i < num; i++)
			state = pop();
		return state;
	}
	/**
	 * Clears the state stack. If left in this state, the game will exit.
	 */
	public void clear() { states.clear(); }
	/**
	 * Resets the stack, effectively clearing it and pushing the specified state onto an empty stack.
	 * @param state - The state to push.
	 */
	public void reset(InputState state) {
		clear();
		push(state);
	}

	/**
	 * 
	 * @return
	 */
	public boolean has() {
		return !states.isEmpty();
	}
}

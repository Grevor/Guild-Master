package org.staticvoid.gm.input.states.ingame;

import java.util.ArrayList;

import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.input.GameIO;
import org.staticvoid.gm.input.IOUtil;
import org.staticvoid.gm.input.states.AnswerState;
import org.staticvoid.gm.input.states.InputStateStack;
import org.staticvoid.gm.model.City;
import org.staticvoid.gm.model.GMCharacter;

/**
 * Class representing a state where the player selects a character.
 * @author Grevor
 *
 */
public class CharacterSelectState extends AnswerState {
	private City city;
	private int max;
	private ArrayList<GMCharacter> chars = new ArrayList<>();
	public CharacterSelectState(City c) {
		city = c;
		for(GMCharacter cc : c.getCharacters())
			chars.add(cc);
	}
	@Override
	protected void showOptions(GameMasterState state, GameIO io) {
		if(chars.size() < 1) {
			io.println("There are no living Guildies. Your guild is beyond saving...");
		}
		
		int n = 1;
		for(GMCharacter c : city.getCharacters())
			io.println(n++ + ") " + c.getName() + (c.isBusy(state.getProgression()) ? c.getCurrentActionName(state) : ""));
		io.println(n + ") Back");
		max = n;
	}
	@Override
	protected boolean enactAnswer(GameMasterState state, int ans, GameIO io) {
		if(!IOUtil.isIn(1, max, ans))
			return false;
		
		InputStateStack stack = state.getStates();
		
		if(ans == max)
			stack.pop();
		else
			stack.push(new CharacterState(chars.get(ans - 1)));
		
		return true;
	}

	
}

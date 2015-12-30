package org.staticvoid.gm.input.states.ingame;

import java.util.ArrayList;

import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.input.GameIO;
import org.staticvoid.gm.input.IOUtil;
import org.staticvoid.gm.input.states.AnswerState;
import org.staticvoid.gm.model.location.GMLocation;
import org.staticvoid.gm.model.GMCharacter;
import org.staticvoid.gm.model.situation.Choice;
import org.staticvoid.gm.model.situation.Situation;

/**
 * Class representing a state where the player is presented with a situation and a few choices.
 * @author Grevor
 *
 */
public class SituationState extends AnswerState {
	private ArrayList<Choice> choices = new ArrayList<>();
	private Situation situation;
	private GMCharacter character;
	private GMLocation location;
	
	public SituationState(Situation s, GameMasterState state, GMCharacter ch, GMLocation loc) {
		situation = s;
		character = ch;
		location = loc;
		
		for(Choice c : situation.getChoices())
			if(c.canBeChosen(state, ch, loc))
				choices.add(c);
	}

	@Override
	protected void showOptions(GameMasterState state, GameIO io) {
		IOUtil.decorateAsHeader(situation.getDisplayString(state, character, location), io);
		io.println(situation.getDescriptionString(state, character, location));
		int n = 1;
		for(Choice c : choices)
			io.println(n++ + ") " + c.getDisplayString(state, character, location));
	}

	@Override
	protected boolean enactAnswer(GameMasterState state, int ans, GameIO io) {
		if(!IOUtil.isIn(1, choices.size(), ans))
			return false;
		
		Choice c = choices.get(ans - 1);
		c.enact(state, character, location);
		return true;
	}

}

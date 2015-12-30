package org.staticvoid.gm.input.states.ingame;

import org.staticvoid.development.NotYetImplementedException;
import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.input.GameIO;
import org.staticvoid.gm.input.IOUtil;
import org.staticvoid.gm.input.states.AnswerState;
import org.staticvoid.gm.input.states.InputStateStack;
import org.staticvoid.gm.model.time.DayProgression;

/**
 * Class representing the main game menu.
 * @author Grevor
 *
 */
public class MainIngameState extends AnswerState {

	@Override
	protected void showOptions(GameMasterState state, GameIO io) {
		StringBuilder b = new StringBuilder();
		b.append(state.getCity().getName() + "\n");
		DayProgression prog = state.getProgression();
		b.append("Day: " + prog.getDay() + " Month: " + prog.getMonth() + " Year: " + prog.getYear() + "\n");
		b.append("It is " + prog.getSeason().getDisplayName());
		
		IOUtil.decorateAsHeader(b.toString(), io);
		io.println("1) Examine Locations");
		io.println("2) Weather Information");
		io.println("3) Examine Resource Stockpiles");
		io.println("4) Guildies");
		io.println("5) Menu");
	}

	@Override
	protected boolean enactAnswer(GameMasterState state, int ans, GameIO io) {
		if(!IOUtil.isIn(1, 5, ans))
			return false;
		
		InputStateStack stack = state.getStates();
		
		switch(ans) {
		case 1:
			stack.push(new LocationSelectState(state.getWorld()));
			break;
		case 2:
			throw new NotYetImplementedException();
		case 3:
			stack.push(new DisplayResourcesState());
			break;
		case 4:
			stack.push(new CharacterSelectState(state.getCity()));
			break;
		case 5:
			stack.push(new MetaMenu());
			break;
		}
		
		return true;
	}

	

}

package org.staticvoid.gm.input.states.ingame;

import java.util.ArrayList;

import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.input.GameIO;
import org.staticvoid.gm.input.IOUtil;
import org.staticvoid.gm.input.states.AnswerState;
import org.staticvoid.gm.input.states.InputStateStack;
import org.staticvoid.gm.model.GMCharacter;
import org.staticvoid.gm.model.action.GMAction;
import org.staticvoid.gm.model.location.GMLocation;

/**
 * Class representing a state where the player selects a location and finally an action to take, given a character.
 * @author Grevor
 *
 */
public class ActionSelectState extends AnswerState {
	private static final int locationIndexAdjustment = 2;
	private GMLocation location;
	private GMCharacter character;
	private ArrayList<GMLocation> innerLocations = new ArrayList<>();
	private ArrayList<GMAction> actions = new  ArrayList<>();
	
	public ActionSelectState(GameMasterState state, GMCharacter character, GMLocation loc) {
		this.location = loc;
		this.character = character;
		
		for(GMLocation l: location.innerLocations())
			innerLocations.add(l);
		for(GMAction a : location.actions())
			if(a.acceptsParticipant(state, character))
				actions.add(a);
	}
	
	private int max() { return 1 + innerLocations.size() + actions.size(); }
	private boolean isLocation(int n) { n-= locationIndexAdjustment; return 0 <= n && n < innerLocations.size(); }
	private GMLocation getLocation(int ans) { return innerLocations.get(ans - locationIndexAdjustment); }
	private GMAction getAction(int ans) { return actions.get(ans - locationIndexAdjustment - innerLocations.size()); }

	@Override
	protected void showOptions(GameMasterState state, GameIO io) {
		IOUtil.decorateAsHeader(location.getDisplayName(state), io);
		int n = 2;
		io.println("1) Examine");
		io.println("[Locations]");
		
		for(GMLocation l : innerLocations)
			io.println(n++ + ") ->" + l.getDisplayName(state));
		
		io.println("[Actions]");
		for(GMAction a : actions)
			io.println(n++ + ") " + a.getDisplayName(state, character, location));
	}

	@Override
	protected boolean enactAnswer(GameMasterState state, int ans, GameIO io) {
		if(!IOUtil.isIn(1, max(), ans))
			return false;
		
		InputStateStack stack = state.getStates();
		
		// --- Check for "examine" and "go back" option.
		if(ans == 1)
			stack.push(new ExamineLocationState(location));
		else if(ans == max())
			stack.pop();
		// --- Else, we expect this to be a location or an action, and defer to the apropriate state.
		else if(isLocation(ans))
			stack.push(new ActionSelectState(state, character, getLocation(ans)));
		else
			stack.push(new ActionState(getAction(ans), character, location));
		
		return true;
	}

}

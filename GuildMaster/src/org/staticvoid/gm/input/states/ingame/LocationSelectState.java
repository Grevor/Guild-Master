package org.staticvoid.gm.input.states.ingame;

import java.util.ArrayList;

import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.input.GameIO;
import org.staticvoid.gm.input.IOUtil;
import org.staticvoid.gm.input.states.AnswerState;
import org.staticvoid.gm.input.states.InputStateStack;
import org.staticvoid.gm.model.location.GMLocation;

/**
 * Class representing a state where the player selects a location, ending in examining a location.
 * @author Grevor
 *
 */
public class LocationSelectState extends AnswerState {
	private static final int numOptions = 2;
	private GMLocation loc;
	private ArrayList<GMLocation> locations = new ArrayList<>();;
	
	public LocationSelectState(GMLocation location) {
		loc = location;
		for(GMLocation l : loc.innerLocations())
			locations.add(l);
	}
	
	private int last() { return locations.size() + numOptions; }

	@Override
	protected void showOptions(GameMasterState state, GameIO io) {
		IOUtil.decorateAsHeader(loc.getDisplayName(state), io);
		io.println("1) Examine");
		io.println(getListing(1, state));
		io.println(last() + ") Back to Previous");
	}

	@Override
	protected boolean enactAnswer(GameMasterState state, int ans, GameIO io) {
		if(!IOUtil.isIn(1, locations.size() + numOptions, ans))
			return false;
		
		InputStateStack st = state.getStates();
		
		// --- If we examine or go back.
		if(ans == 1) {
			st.push(new ExamineLocationState(loc));
			return true;
		} if(ans == last()) {
			st.pop();
			return true;
		}
		
		// --- Else, we get the next location.
		// If there are no inner locations, we instantly examine the location.
		GMLocation l = locations.get(ans - numOptions);
		if(l.numInnerLocations() < 1) {
			st.push(new ExamineLocationState(l));
		} else {
			st.push(new LocationSelectState(l));
		}
		return true;
	}
	
	public String getListing(int n, GameMasterState state) {
		StringBuilder b = new StringBuilder();
		for(GMLocation t : locations)
			b.append(++n + ") -> " + t.getDisplayName(state) + "\n");
		
		return b.toString();
	}

}

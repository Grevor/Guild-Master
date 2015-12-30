package org.staticvoid.gm.model.situation;

import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.model.GMCharacter;
import org.staticvoid.gm.model.location.GMLocation;

public interface Choice {
	boolean canBeChosen(GameMasterState state, GMCharacter character, GMLocation location);
	
	String getDisplayString(GameMasterState state, GMCharacter character, GMLocation location);
	
	void enact(GameMasterState state, GMCharacter character, GMLocation location);
}

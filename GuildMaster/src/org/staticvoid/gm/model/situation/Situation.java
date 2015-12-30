package org.staticvoid.gm.model.situation;

import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.model.GMCharacter;
import org.staticvoid.gm.model.location.GMLocation;

public interface Situation {
	String getDisplayString(GameMasterState state, GMCharacter character, GMLocation location);
	String getDescriptionString(GameMasterState state, GMCharacter character, GMLocation location);
	
	Iterable<Choice> getChoices();
}

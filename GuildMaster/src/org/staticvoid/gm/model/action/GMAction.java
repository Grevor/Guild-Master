package org.staticvoid.gm.model.action;

import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.model.GMCharacter;
import org.staticvoid.gm.model.location.GMLocation;

public interface GMAction {
	boolean isSelectable(GameMasterState state);
	boolean acceptsParticipant(GameMasterState state, GMCharacter character);
	int timeThatWillBeSpent(GameMasterState state, GMCharacter character, GMLocation location);
	
	String getDisplayName(GameMasterState state, GMCharacter character, GMLocation location);
	String getCharacterJoinString(GMCharacter character);
	
	void assignCharacter(GMCharacter character);
	Iterable<GMCharacter> activeCharacters();
	
	void enact(GameMasterState state, int days);
}

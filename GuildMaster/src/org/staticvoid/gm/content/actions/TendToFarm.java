package org.staticvoid.gm.content.actions;

import java.util.ArrayList;
import java.util.Iterator;

import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.model.GMCharacter;
import org.staticvoid.gm.model.action.GMAction;
import org.staticvoid.gm.model.location.GMLocation;

public class TendToFarm implements GMAction {
	ArrayList<GMCharacter> chars = new ArrayList<>();

	@Override
	public boolean isSelectable(GameMasterState state) { return chars.size() < 1; }

	@Override
	public boolean acceptsParticipant(GameMasterState state,
			GMCharacter character) { return chars.size() == 0; }

	@Override
	public int timeThatWillBeSpent(GameMasterState state, GMCharacter character, GMLocation location) { return 1; }


	@Override
	public String getCharacterJoinString(GMCharacter character) { return character.getName() + " will be tending to the farm today."; }

	@Override
	public void assignCharacter(GMCharacter character) { chars.add(character); }

	@Override
	public Iterable<GMCharacter> activeCharacters() { return chars; }

	@Override
	public void enact(GameMasterState state, int days) {
		Iterator<GMCharacter> ch = chars.iterator();
		while(ch.hasNext())
			if(!ch.next().isBusy(state.getProgression()))
				ch.remove();
	}

	@Override
	public String getDisplayName(GameMasterState state, GMCharacter character, GMLocation location) {
		return "Tend to Farmland";
	}

}

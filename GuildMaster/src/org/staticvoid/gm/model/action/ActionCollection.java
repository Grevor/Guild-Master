package org.staticvoid.gm.model.action;

import java.util.HashSet;
import java.util.Iterator;

import org.staticvoid.collections.IteratorUtil;
import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.model.GMCharacter;

public class ActionCollection implements Iterable<GMAction> {
	private HashSet<GMAction> actions = new HashSet<>();
	
	public void add(GMAction a) { actions.add(a); }
	public void removeCharactersFromActions(GameMasterState state) {
		for(GMAction a : this)
			remove(a, state);
	}
	
	private void remove(GMAction a, GameMasterState state) {
		Iterator<GMCharacter> iter = a.activeCharacters().iterator();
		
		while(iter.hasNext()) {
			GMCharacter c = iter.next();
			if(!c.isBusy(state.getProgression())) {
				iter.remove();
				c.delinkAction();
			}
		}
	}
	
	public void removeAllEmptyActions() {
		Iterator<GMAction> iter = iterator();
		while(iter.hasNext())
			if(IteratorUtil.count(iter.next().activeCharacters()) < 1)
				iter.remove();
	}
	
	@Override
	public Iterator<GMAction> iterator() {
		return actions.iterator();
	}

}

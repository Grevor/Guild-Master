package org.staticvoid.gm.model;

import java.util.ArrayList;
import java.util.Iterator;

public class CharacterList implements Iterable<GMCharacter> {
	private ArrayList<GMCharacter> characters = new ArrayList<>();
	
	public void add(GMCharacter c) { characters.add(c); }
	public boolean remove(GMCharacter c) { return characters.remove(c); }

	@Override
	public Iterator<GMCharacter> iterator() { return characters.iterator(); }
}

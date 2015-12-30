package org.staticvoid.gm;

import org.staticvoid.gm.input.states.MainMenuState;
import org.staticvoid.gm.model.City;
import org.staticvoid.gm.model.GMCharacter;
import org.staticvoid.gm.model.location.GMLocation;


public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to Guild Master!");
		System.out.println("");
		
		GameMasterState state = new GameMasterState();
		state.getStates().push(new MainMenuState());
		
		// --- Sets up testing environment.
		setupTest(state);
		
		// --- Run while we have a state.
		while(state.getStates().has()) {
			state.getInput().clear();
			state.getStates().getCurrent().run(state);
		}
		
		System.out.println("Thank you for testing Guild Master!");
		System.out.println("Hope to see you again soon...");
	}

	private static void setupTest(GameMasterState state) {
		City c = new City("SAMPLE CITY");
		GMLocation w = new GMLocation("World", "Mirth");
		
		GMCharacter you = new GMCharacter("You");
		c.getCharacters().add(you);
		
		
		GMLocation town = new GMLocation("TOWN", "Town of Domina");
		
		GMLocation house = new GMLocation("HOUSE", "Your House");
		town.add(house);
		
		w.add(town);
		
		
		state.setCity(c);
		state.setWorld(w);
	}
}

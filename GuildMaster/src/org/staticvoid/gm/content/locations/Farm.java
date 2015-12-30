package org.staticvoid.gm.content.locations;

import org.staticvoid.gm.content.actions.TendToFarm;
import org.staticvoid.gm.model.location.GMLocation;

public class Farm extends GMLocation {
	public Farm() {
		super("Farm", "Farm");
		add(new TendToFarm());
	}
}

package org.staticvoid.gm.scripting.variables;

import org.staticvoid.expression.symbol.instanced.InstanceVariable;
import org.staticvoid.expression.token.Token;
import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.model.location.GMLocation;

public class LocationName extends InstanceVariable<GMLocation> {
	private GameMasterState state;

	public LocationName(GameMasterState state, GMLocation obj, String name) {
		super(obj, name);
		this.state = state;
	}

	@Override
	public Token getValue() { return new Token(getObject().getDisplayName(state)); }

}

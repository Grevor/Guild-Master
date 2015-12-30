package org.staticvoid.gm.scripting.variables;

import org.staticvoid.expression.symbol.instanced.InstanceVariable;
import org.staticvoid.expression.token.Token;
import org.staticvoid.gm.model.GMCharacter;
import org.staticvoid.gm.scripting.GMScriptContext;

public class CharacterName extends InstanceVariable<GMCharacter> {
	public CharacterName(GMCharacter c, String name) {
		super(c, name + GMScriptContext.C_name);
	}

	@Override
	public Token getValue() { return new Token(getObject().getName()); }

}

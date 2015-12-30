package org.staticvoid.gm.scripting.variables;

import org.staticvoid.expression.symbol.instanced.InstanceVariable;
import org.staticvoid.expression.token.Token;
import org.staticvoid.gm.model.IngameResource;
import org.staticvoid.gm.model.IngameResources;

public class StorageResourceVariable extends InstanceVariable<IngameResources> {
	IngameResource resource;

	public StorageResourceVariable(IngameResource res, IngameResources obj, String name) {
		super(obj, name + "." + res.getScriptName());
		resource = res;
	}

	@Override
	public Token getValue() { return new Token(getObject().getAmount(resource)); }
	
	@Override
	public Token setValue(Token value) {
		Double number = value.tryGetNumber();
		if(value.hasMarkedError())
			return value.getErrorToken();
		return new Token(getObject().setAmount(resource, number));
	}
}

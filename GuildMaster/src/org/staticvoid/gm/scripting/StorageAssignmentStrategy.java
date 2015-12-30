package org.staticvoid.gm.scripting;

import org.staticvoid.development.NotYetImplementedException;
import org.staticvoid.expression.EvaluationContext;
import org.staticvoid.expression.operator.assignment.AssignmentStrategy;
import org.staticvoid.expression.symbol.BasicReadOnlyVariable;
import org.staticvoid.expression.token.Token;
import org.staticvoid.gm.model.IngameResource;
import org.staticvoid.gm.model.IngameResources;
import org.staticvoid.gm.scripting.variables.StorageResourceVariable;

public class StorageAssignmentStrategy implements AssignmentStrategy {
	public StorageAssignmentStrategy() { }

	@Override
	public void add(EvaluationContext context, Token left, Token right) {
		IngameResources character = right.<IngameResources>tryGetTypeObject();
		String symbol = left.getSymbol();
		context.symbols().addVariable(symbol, new BasicReadOnlyVariable(symbol, new Token(right.getObject())));
		for(IngameResource r : IngameResource.values()) {
			StorageResourceVariable var = new StorageResourceVariable(r, character, symbol);
			context.symbols().addVariable(var.getName(), var);
		}
	}

	@Override
	public void remove(EvaluationContext context, Token remove) {
		throw new NotYetImplementedException();
	}

}

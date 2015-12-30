package org.staticvoid.gm.scripting;

import org.staticvoid.development.NotYetImplementedException;
import org.staticvoid.expression.EvaluationContext;
import org.staticvoid.expression.operator.assignment.AssignmentStrategy;
import org.staticvoid.expression.symbol.BasicReadOnlyVariable;
import org.staticvoid.expression.token.Token;
import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.model.location.GMLocation;
import org.staticvoid.gm.scripting.variables.LocationName;

public class LocationAsignmentStrategy  implements AssignmentStrategy {
	private GameMasterState state;
	public LocationAsignmentStrategy(GameMasterState state) {
		this.state = state;
	}

	@Override
	public void add(EvaluationContext context, Token left, Token right) {
		GMLocation character = right.<GMLocation>tryGetTypeObject();
		String symbol = left.getSymbol();
		context.symbols().addVariable(symbol, new BasicReadOnlyVariable(symbol, new Token(right.getObject())));
		
		LocationName name = new LocationName(state, character, symbol);
		context.symbols().addVariable(name.getName(), name);
	}

	@Override
	public void remove(EvaluationContext context, Token remove) {
		throw new NotYetImplementedException();
	}

}

package org.staticvoid.gm.scripting;

import org.staticvoid.development.NotYetImplementedException;
import org.staticvoid.expression.EvaluationContext;
import org.staticvoid.expression.operator.assignment.AssignmentStrategy;
import org.staticvoid.expression.symbol.BasicReadOnlyVariable;
import org.staticvoid.expression.token.Token;
import org.staticvoid.gm.model.GMCharacter;
import org.staticvoid.gm.scripting.variables.CharacterName;

public class CharacterAssignmentStrategy implements AssignmentStrategy {

	@Override
	public void add(EvaluationContext context, Token left, Token right) {
		GMCharacter character = right.<GMCharacter>tryGetTypeObject();
		String symbol = left.getSymbol();
		
		context.symbols().addVariable(symbol, new BasicReadOnlyVariable(symbol, new Token(right.getObject())));
		
		CharacterName name = new CharacterName(character, symbol);
		context.symbols().addVariable(name.getName(), name);
	}

	@Override
	public void remove(EvaluationContext context, Token remove) {
		throw new NotYetImplementedException();
	}
	
}

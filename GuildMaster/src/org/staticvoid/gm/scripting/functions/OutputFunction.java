package org.staticvoid.gm.scripting.functions;

import org.staticvoid.expression.EvaluationContext;
import org.staticvoid.expression.TokenFunction;
import org.staticvoid.expression.token.Token;
import org.staticvoid.expression.token.TokenArray;
import org.staticvoid.gm.input.GameIO;

public class OutputFunction implements TokenFunction {
	private GameIO io;
	
	public OutputFunction(GameIO io) {
		this.io = io;
	}

	@Override
	public Token invoke(EvaluationContext context, TokenArray parameters) {
		StringBuilder b = new StringBuilder();
		for(Token t : parameters) {
			String output = t.tryGetString(context.numberParser());
			if(output == null)
				b.append("[NULL]");
			else
				b.append(output);
		}
		
		io.println(b.toString());
		return Token.createNA("ok");
	}

}

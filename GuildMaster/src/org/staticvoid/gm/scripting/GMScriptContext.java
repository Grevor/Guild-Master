package org.staticvoid.gm.scripting;

import org.staticvoid.expression.AggregateEvaluationContext;
import org.staticvoid.expression.BasicFunctionDescriptor;
import org.staticvoid.expression.DataOrientedNumberParser;
import org.staticvoid.expression.EvaluationContext;
import org.staticvoid.expression.NumberParser;
import org.staticvoid.expression.operator.NormalOperators;
import org.staticvoid.expression.operator.OperatorCollection;
import org.staticvoid.expression.operator.assignment.GeneralAssignmentOperator;
import org.staticvoid.expression.symbol.BasicSymbols;
import org.staticvoid.expression.symbol.Symbols;
import org.staticvoid.expression.token.Token;
import org.staticvoid.expression.token.TokenParser;
import org.staticvoid.expression.token.TokenType;
import org.staticvoid.gm.GameMasterState;
import org.staticvoid.gm.model.GMCharacter;
import org.staticvoid.gm.model.IngameResources;
import org.staticvoid.gm.model.location.GMLocation;
import org.staticvoid.gm.scripting.functions.OutputFunction;

public final class GMScriptContext {
	public static final String VN_character = "char";
	public static final String VN_location = "loc";
	public static final String VN_action = "action";
	public static final String VN_storage = "storage";
	public static final String VN_weather = "weather";
	
	public static final String C_name = ".name";
	
	public static final String FN_outputLine = "println";
	
	public static OperatorCollection getActionOperators(GameMasterState state, GMLocation location, GMCharacter character) {
		// --- Add all normal operators.
		OperatorCollection actionOperators = new OperatorCollection();
		NormalOperators.addAllCOperators(actionOperators);
		
		GeneralAssignmentOperator assignment = new GeneralAssignmentOperator();
		assignment.put(GMCharacter.class, new CharacterAssignmentStrategy());
		assignment.put(GMLocation.class, new LocationAsignmentStrategy(state));
		assignment.put(IngameResources.class, new StorageAssignmentStrategy());
		
		actionOperators.addBinary("=", assignment);
		return actionOperators;
	}
	
	private GMScriptContext() {}
	
	public static EvaluationContext createActionContext(GameMasterState state, GMLocation location, GMCharacter character) {
		AggregateEvaluationContext context = null;
		NumberParser parser = DataOrientedNumberParser.GetDoubleNumberParser();
		Symbols symbols = new BasicSymbols();
		context = new AggregateEvaluationContext(symbols, parser, getActionOperators(state, location, character));
		
		// --- Adds functions.
		symbols.addFunction(FN_outputLine, new BasicFunctionDescriptor(new OutputFunction(state.getInput()), 0, true));
		
		// --- Adds the global variables variable.
		new CharacterAssignmentStrategy().add(context, new Token(TokenType.Symbol, VN_character), new Token(character));
		new LocationAsignmentStrategy(state).add(context, new Token(TokenType.Symbol, VN_location), new Token(location));
		new StorageAssignmentStrategy().add(context, new Token(TokenType.Symbol, VN_storage), new Token(state.getCity().getStorage()));
		return context;
	}
	
	/**
	 * Creates a parser which will parse the specified expression.
	 * @param expression - The expression to parse.
	 * @return
	 * The parser, ready to be used.
	 */
	public static TokenParser createParser(String expression) {
		return new TokenParser(expression, "_.", " \t\n\r", "_", DataOrientedNumberParser.GetDoubleNumberParser());
	}
	
}

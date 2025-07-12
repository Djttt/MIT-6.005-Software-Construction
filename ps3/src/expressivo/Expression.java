/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package expressivo;


import expressivo.parser.ExpressionLexer;
import expressivo.parser.ExpressionListener;
import expressivo.parser.ExpressionParser;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.IOException;
import java.util.Map;

/**
 * An immutable data type representing a polynomial expression of:
 *   + and *
 *   nonnegative integers and floating-point numbers
 *   variables (case-sensitive nonempty strings of letters)
 * 
 * <p>PS3 instructions: this is a required ADT interface.
 * You MUST NOT change its name or package or the names or type signatures of existing methods.
 * You may, however, add additional methods, or strengthen the specs of existing methods.
 * Declare concrete variants of Expression in their own Java source files.
 */
public interface Expression {

    // Datatype definition
    //   TODO
    // Expression = constant(number: string)
    //              ｜variable(name: String)
    //              ｜ Add(left: Expression, right: Expression)
    //              |  Mul(left: Expression, right: Expression)
    
    /**
     * Parse an expression.
     * @param input expression to parse, as defined in the PS3 handout.
     * @return expression AST for the input
     * @throws IllegalArgumentException if the expression is invalid
     */
    public static Expression parse(String input) throws IllegalArgumentException {
        CharStream stream = new ANTLRInputStream(input);
        try {
            ExpressionLexer lexer = new ExpressionLexer(stream);
            lexer.reportErrorsAsExceptions();
            TokenStream tokens = new CommonTokenStream(lexer);

            ExpressionParser parser = new ExpressionParser(tokens);

            // produces a parse tree
            parser.reportErrorsAsExceptions();
            ParseTree tree = parser.root();


            // Traversing the parse tree
            ParseTreeWalker walker = new ParseTreeWalker();
            MakeExpresion listener = new MakeExpresion();
            walker.walk(listener, tree);
            Expression result = listener.getExpression();
            return result;
        } catch (ParseCancellationException e) {
            throw new IllegalArgumentException("ParseError: unknown expression");
        }
    }
    
    /**
     * @return a parsable representation of this expression, such that
     * for all e:Expression, e.equals(Expression.parse(e.toString())).
     */
    @Override
    public String toString();

    /**
     * @param thatObject any object
     * @return true if and only if this and thatObject are structurally-equal
     * Expressions, as defined in the PS3 handout.
     */
    @Override
    public boolean equals(Object thatObject);
    
    /**
     * @return hash code value consistent with the equals() definition of structural
     * equality, such that for all e1,e2:Expression,
     *     e1.equals(e2) implies e1.hashCode() == e2.hashCode()
     */
    @Override
    public int hashCode();


    // TODO more instance methods

    /**
     * according to precedence to decide to add parentheses, and return a human-readable string of expression.
     * @param parentPrecedence parent node precedence, parentPrecedence = 1, 2, 3, higher is more precedence.
     * @return a human-readable string of an expression.
     */
    String toString(int parentPrecedence);


    /**
     * @return get currently node's operator precedence
     */
    public int getPrecedence();

    /**
     * produce an expression of the derivative of itself expression
     * does not need to be simplified.
     * @return a new expression of the derivative of this expression
     */
    public Expression differentiation(Variable variable);


    /**
     *  simplificationHelper function to help to make simplification work out
     *  It substitutes the values for those variables into the expression, and attempts
     * to simply the substituted polynomial as much as it can.
     * @param env a map(mapping of variables to values)
     * @return new expression which is substitute polynomial.
     */
    public Expression simplificationHelper(Map<Variable, Double> env);

    /**
     *  takes an expression and an environment (a mapping of variables to values)
     *  It substitutes the values for those variables into the expression, and attempts
     * to simply the substituted polynomial as much as it can.
     * @param expr currently expression want to simply
     * @param env a map(mapping of variables to values)
     * @return new expression which is substitute polynomial.
     */
    public static Expression simplification(Expression expr, Map<Variable, Double> env) {
        return expr.simplificationHelper(env);
    }
}

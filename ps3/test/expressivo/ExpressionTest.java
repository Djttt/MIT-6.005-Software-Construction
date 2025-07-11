/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package expressivo;

import expressivo.parser.ExpressionLexer;
import expressivo.parser.ExpressionListener;
import expressivo.parser.ExpressionParser;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for the Expression abstract data type.
 */
public class ExpressionTest {

    // Testing strategy
    //   TODO
    // toString method:
    // only include add in expression
    // only include multiplication in expression
    // both include add and multiplication in expression.

    // equals method:
    // only include add in expression
    // only include multiplication in expression
    // both include add and multiplication in expression.

    // hashCode method:
    // only include add in expression
    // only include multiplication in expression
    // both include add and multiplication in expression.

    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }


    @Test
    public void testANTLRParser() {
        CharStream stream = new ANTLRInputStream("54*(2+89)");
        ExpressionLexer lexer = new ExpressionLexer(stream);
        TokenStream tokens = new CommonTokenStream(lexer);

        ExpressionParser parser = new ExpressionParser(tokens);

        // produces a parse tree
        ParseTree tree = parser.root();

        // Traversing the parse tree
        ParseTreeWalker walker = new ParseTreeWalker();
        ExpressionListener listener = new PrintEverything();
        walker.walk(listener, tree);


        while (true) {
            Trees.inspect(tree, parser);
            try {
                TimeUnit.SECONDS.sleep(200); // pause for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    // TODO tests for Expression
    @Test
    public void testANTLRParserWithOneValueOrNumber() throws IOException {
        // test toString method.
        Expression expr1 = Expression.parse("5");
        assertEquals("5.0", expr1.toString());

        Expression expr2 = Expression.parse("val");
        assertEquals("val", expr2.toString());



        // test equals method
        Expression expr4 = Expression.parse("5");
        assertTrue(expr4.equals(expr1));

        Expression expr6 = Expression.parse("val");
        assertTrue(expr6.equals(expr2));


        // test hashCode method
        assertEquals(expr4.hashCode(), expr1.hashCode());
        assertEquals(expr6.hashCode(), expr2.hashCode());

    }



    @Test
    public void testANTLRParserExpression() throws IOException {
        // test toString method.
        Expression expr1 = Expression.parse("54+(2+89)");

        assertEquals("54.0+2.0+89.0", expr1.toString());

        Expression expr2 = Expression.parse("54*2*89");
        assertEquals("54.0*2.0*89.0", expr2.toString());


        Expression expr3 = Expression.parse("54*(2.0+89.0)");
        assertEquals("54.0*(2.0+89.0)", expr3.toString());


        // test equals method
        Expression expr4 = Expression.parse("54+(2+89)");
        assertTrue(expr4.equals(expr1));

        Expression expr6 = Expression.parse("54*2*89");
        assertTrue(expr6.equals(expr2));

        Expression expr7 = Expression.parse("54*(2+89)");
        assertTrue(expr7.equals(expr3));

        // test hashCode method
        assertEquals(expr4.hashCode(), expr1.hashCode());
        assertEquals(expr6.hashCode(), expr2.hashCode());
        assertEquals(expr7.hashCode(), expr3.hashCode());
    }
}

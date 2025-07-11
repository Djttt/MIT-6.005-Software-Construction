package expressivo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MulTest {

    // test strategy
    // toString method:
    // Partition input as followed:
    // one operator add other operator
    // exited expression add other operator.
    //
    // Equals method:
    // test with two operators and > 2  operators expression.
    //
    // hashCode method
    //  test with two operators and > 2  operators expression.

    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

    @Test
    public void testToString() {
        Variable variable1 = new Variable("x");
        Variable variable2 = new Variable("y");
        Mul ExpressionResult = new Mul(variable1, variable2);

        assertEquals( "x*y", ExpressionResult.toString());
    }

    @Test
    public void testEquals() {
        Variable variable1 = new Variable("x");
        Variable variable2 = new Variable("y");
        Constant number = new Constant(2);
        // x * (y + 2);
        Expression result = new Mul(variable1, new Add(variable2, number));


        assertEquals("x*(y+2)", result.toString());
    }

    @Test
    public void testHashCode() {

    }

}
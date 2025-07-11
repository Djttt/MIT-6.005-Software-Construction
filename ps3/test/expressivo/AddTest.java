package expressivo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AddTest {

    // test strategy
    // toString method:
    // Partition input as followed:
    // one operator add other operator
    // exited expression add other operator.
    //
    //
    // Equals method:
    // test one operator representation.
    //
    // hashCode method
    //  test one operator representation


    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }

    @Test
    public void testToString() {
        Variable variable = new Variable("x");
        Constant num = new Constant(22.3);
        Add expr = new Add(variable, num);

        assertEquals("x+22.3", expr.toString());

        Mul mul = new Mul(new Variable("y"), expr);

        assertEquals("y*(x+22.3)", mul.toString());
    }

    @Test
    public void testEquals() {
        Variable variable = new Variable("x");
        Constant num = new Constant(2233);
        Add expr = new Add(variable, num);
        Add expr2 = new Add(num, variable);

        assertFalse(expr.equals(expr2));

        assertEquals("x+2233.0", expr.toString());
    }

    @Test
    public void testHashCode() {
        Variable variable = new Variable("x");
        Constant num = new Constant(1);
        Add expr = new Add(variable, num);
        Add expr2 = new Add(variable, new Constant(1.0));

        Add expr3 = new Add(new Constant(1.0), variable);

        assertEquals(expr2.hashCode(), expr.hashCode());

        assertNotEquals(expr2.hashCode(), expr3.hashCode());
    }

}
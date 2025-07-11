package expressivo;


import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VariableTest {
    // test strategy
    // toString method:
    // Partition input as followed:
    // one operator
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


        assertEquals("x", variable.toString());
    }

    @Test
    public void testEquals() {
        Variable variable1 = new Variable("x");
        Variable variable2 = new Variable("x");

        assertEquals(variable1, variable2, "expected true");
    }


    @Test
    public void testHashCode() {
        Variable variable1 = new Variable("zz");
        Variable variable2 = new Variable("zzz");
        Variable variable3 = new Variable("zz");

        assertNotEquals(variable1.hashCode(), variable2.hashCode(), "expected false");
        assertEquals(variable1.hashCode(), variable3.hashCode(), "expected true");
    }

}

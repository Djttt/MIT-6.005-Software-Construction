package expressivo;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConstantTest {
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
        Constant number = new Constant(2.2);

        assertEquals("2.2", number.toString());
    }

    @Test
    public void testEquals() {
        Constant number1 = new Constant(3.14);
        Constant number2 = new Constant(3.14);

        assertTrue(number1.equals(number2), "expected true");
    }


    @Test
    public void testHashCode() {
        Constant number1 = new Constant(3.14);
        Constant number2 = new Constant(3.14);

        assertEquals(number1.hashCode(), number2.hashCode(), "expected equals");
    }


}

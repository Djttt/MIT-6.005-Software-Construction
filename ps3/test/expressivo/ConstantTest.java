package expressivo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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



    // Test Commands.simplify() method
    @Test
    public void testSimply() {
        Map<String, Double> environment = new HashMap<>();
        environment.put("x", 3.0);
        String expr = Commands.simplify("3.14", environment);
        assertEquals("3.14", expr);

        String expr1 = Commands.simplify("x + y + z + x", environment);
        assertEquals("3.0+y+z+3.0", expr1);

        environment.put("x", 2.0);
        environment.put("y", 10.0);
        environment.put("z", 20.0);
        String expr2 = Commands.simplify("x*x*x + y + x", environment);
        assertEquals("20.0", expr2);

        String expr3 =  Commands.simplify("x*x*x + y*y*y", environment);
        assertEquals("1008.0", expr3);

        String expr4 = Commands.simplify("1+2*3+8*0.5", environment);
        assertEquals("11.0", expr4);
    }

}

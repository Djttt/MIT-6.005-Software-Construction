/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package expressivo;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests for the static methods of Commands.
 */
public class CommandsTest {

    // Testing strategy
    //   TODO
    // Partition input as followed:
    // differentiate method:
    // valid input:
    //             only one constant
    //             only one variable
    //             complex add expression
    //             complex mul expression
    //             combination add and mul complex expression
    // invalid input:
    //              only have '(' expression, but not have ')'
    //              like 3 + this kind of expression
    //

    // simplify method
    //
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    
    // TODO tests for Commands.differentiate() and Commands.simplify()

    @Test
    public void testDifferentiateWithConstant() {
        String expr = Commands.differentiate("2", "x");
        assertEquals("0.0", expr);
    }

    @Test
    public void testDifferentiateWithVariable() {
        String expr = Commands.differentiate("x", "x");
        assertEquals("1.0", expr);

        String expr1 = Commands.differentiate("x", "y");
        assertEquals("0.0", expr1);
    }

    @Test
    public void testDifferentiateWithAdd() {
        String expr = Commands.differentiate("x + x + y + 2", "x");
        assertEquals("1.0+1.0+0.0+0.0", expr);

        String expr1 = Commands.differentiate("x + x + y + 2", "y");
        assertEquals("0.0+0.0+1.0+0.0", expr1);

        String expr2 = Commands.differentiate("x + x + y + 2", "Y");
        assertEquals("0.0+0.0+0.0+0.0", expr2);
    }

    @Test
    public void testDifferentiateWithMul() {
        String expr = Commands.differentiate("x * x * y * 2", "x");
        assertEquals("x*(x*(y*0.0+2.0*0.0)+y*2.0*1.0)+x*y*2.0*1.0", expr);

        String expr1 = Commands.differentiate("x*x*x", "y");
        assertEquals("x*(x*0.0+x*0.0)+x*x*0.0", expr1);

    }


    @Test
    public void testDifferentiateWithMulAndAdd() {
        String expr = Commands.differentiate("x * x + x + y", "x");
        assertEquals("x*1.0+x*1.0+1.0+0.0", expr);

        String expr1 = Commands.differentiate("z+x*z*y+z", "z");
        assertEquals("1.0+x*(z*0.0+y*1.0)+z*y*0.0+1.0", expr1);

    }

    @Test
    public void testDifferentiateWithInvalidLackParent() {
        try {
            String expr = Commands.differentiate("x * x + (x + y", "x");

            String expr1 = Commands.differentiate("x * x + x + y)", "z");

        } catch (IllegalArgumentException e) {
            System.out.println("unknown expression");
        }

    }

    @Test
    public void testDifferentiateWithInvalidString() {
        try {
            String expr = Commands.differentiate("2+", "x");
        } catch (IllegalArgumentException e) {
            System.out.println("unknown expression");
        }

    }

    @Test
    public void testDifferentiateWithInvalidString2() {
        try {
            String expr1 = Commands.differentiate("(x (* x + x + y)", "z");
        } catch (IllegalArgumentException e) {
            System.out.println("unknown expression");
        }
    }

    @Test
    public void testDifferentiateWithInvalidString3() {
        try {
            String expr2 = Commands.differentiate("3 x", "z");
        } catch (IllegalArgumentException e) {
            System.out.println("unknown expression");
        }
    }
}

package expressivo;

import java.security.PublicKey;

/**
 * An immutable data type to present a polynomial expression with add operator.
 */
public class Add implements Expression {
    private final Expression left;
    private final Expression right;
    // Rep invariants
    // operator != null, rest != null
    // abstraction function
    // represent a new expression: newExpression = expression(rest)+operator.
    // safety from Rep exposure
    // all fields is private
    // operator is string, which is immutable.
    // expression is immutable.

    private void checkRep () {
        throw new RuntimeException("not implemented");
    }

    /**
     * construct a new Expression by expression1 + expression2
     * @param left currently variable
     * @param right the old expression
     */
    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Get Binary operator *.
     * @return return String of + operator.
     */
    public String getOp() {
        return "+";
    }

    /**
     * Get a precedence of this operator, higher is more precedence.
     * @return an int data to represent precedence.
     */
    public int getPrecedence() { return 1; }



    @Override
    public String toString() {
        return left.toString() + "+" + right.toString();
    }

    @Override
    public boolean equals(Object thatObject) {
        if (this == thatObject) return true;
        if (thatObject == null || getClass() != thatObject.getClass()) return false;

        Expression that = (Expression) thatObject;
        return toString().equals(that.toString());
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString(int parentPrecedence) {
        String leftStr = left.toString(getPrecedence());
        String rightStr = right.toString(getPrecedence());

        String expr = leftStr + getOp() + rightStr;
        if (getPrecedence() < parentPrecedence) {
            expr = "(" + expr + ")";
        }
        return expr;
    }

}

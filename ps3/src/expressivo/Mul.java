package expressivo;

/**
 * An immutable data type to present a polynomial expression with multiplication operator.
 * new Expression = expression left + expression right.
 */
public class Mul implements Expression{
    private final Expression left;
    private final Expression right;
    // Rep invariants
    // left != null, right != null
    // abstraction function
    // represent a new expression: newExpression = expression(rest)*expression(right).
    // safety from Rep exposure
    // all fields is private
    // left  is immutable.
    // expression right is immutable.

    private void checkRep () {
        assert left != null;
        assert right != null;
    }

    /**
     *  construct a new Expression using multiplication.
     * @param left the left expression.
     * @param right the right expression.
     */
    public Mul(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Get Binary operator *.
     * @return String of * operator.
     */
    public String getOp() {
        return "*";
    }

    /**
     * Get a precedence of this operator, higher is more precedence.
     * @return an int data to represent precedence.
     */
    public int getPrecedence() { return 2; }

    @Override
    public Expression differentiation(Variable variable) {
        return new Add(new Mul(left, right.differentiation(variable)),
                        new Mul(right, left.differentiation(variable)));
    }

    @Override
    public String toString() {
        return toString(getPrecedence());
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
        return this.toString().hashCode();
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

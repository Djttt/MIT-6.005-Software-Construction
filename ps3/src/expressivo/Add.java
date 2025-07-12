package expressivo;

import java.security.PublicKey;
import java.util.Map;

/**
 * An immutable data type to present a polynomial expression.
 * newExpression = expression left + expression right.
 */
public class Add implements Expression {
    private final Expression left;
    private final Expression right;
    // Rep invariants
    // left != null, right != null
    // abstraction function
    // represent a new expression: newExpression = expression(left)+expression(right).
    // safety from Rep exposure
    // all fields is private
    // Expression left  is immutable.
    // Expression right is immutable.

    private void checkRep () {
        assert left != null;
        assert right != null;
    }

    /**
     * construct a new Expression by expression1 + expression2
     * @param left currently variable
     * @param right the old expression
     */
    public Add(Expression left, Expression right) {
        this.left = left;
        this.right = right;
        checkRep();
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

    /**
     * get add expression's left sub-expression
     * @return this expression's left child expression
     */
    public Expression getLeft() {
        return left;
    }

    /**
     * get add expression's right sub-expression
     * @return this expression's right child expression
     */
    public Expression getRight() {
        return right;
    }

    @Override
    public Expression differentiation(Variable variable) {
        return new Add(left.differentiation(variable),
                        right.differentiation(variable));
    }

    @Override
    public Expression simplificationHelper(Map<Variable, Double> env) {
        Add expr =  new Add(left.simplificationHelper(env), right.simplificationHelper(env));
        if (expr.getLeft() instanceof Constant && expr.getRight() instanceof Constant) {
            return new Constant(((Constant) expr.getLeft()).getValue() +
                    ((Constant) expr.getRight()).getValue());
        }
        return expr;
    }


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

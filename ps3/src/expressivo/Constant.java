package expressivo;

/**
 * represent a constant number, this constant is double value data type. And value must >= 0.
 */
public class Constant implements Expression{
    private final double value;
    // rep invariant
    // value >=0, immutable data type
    //
    // abstraction function
    // represent a constant in expression
    //
    // safety from rep exposure.
    // all fields are private.

    private void checkRep() {
        assert this.value >= 0;
    }

    Constant(double value) {
        this.value = value;
        checkRep();
    }


    @Override
    public String toString() {
        return String.valueOf(value);
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
        return toString();
    }

    @Override
    public int getPrecedence() {
        return 3;
    }

    @Override
    public Expression differentiation(Variable variable) {
        return new Constant(0.0);
    }
}

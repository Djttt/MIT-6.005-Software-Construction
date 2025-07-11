package expressivo;


/**
 * represent a variable, this variable are case-sensitive nonempty sequences of letters.
 */
public class Variable implements Expression{
    private final String name;
    // rep invariant
    // string name should not null, and which are case-sensitive nonempty sequences of letters (e.g. y and Foo )
    //
    // abstraction function
    // represent a variable in expression
    //
    // safety from rep exposure.
    // all fields are private.


    /**
     * construct a variable in expression.
     * @param name input variable name, nonempty sequences of letters
     */
    Variable(String name) {
        this.name = name.trim();
        checkRep();
    }

    private void checkRep() {
        assert this.name != null;
    }

    @Override
    public String toString() {
        return name;
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

}

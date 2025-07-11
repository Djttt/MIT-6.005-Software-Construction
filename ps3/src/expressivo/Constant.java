package expressivo;

public class Constant implements Expression{
    double value;

    Constant(double value) {
        this.value = value;
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
}

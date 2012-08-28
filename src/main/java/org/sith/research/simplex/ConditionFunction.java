package org.sith.research.simplex;

public class ConditionFunction extends Function {

    protected Condition condition;
    private final Basis basis = new Basis();

    public void checkFreeCoefficient() {

        if (freeCoefficient < 0) {
            condition = condition.inverse();
            for (int i = 0; i < coefficients.size(); i++) {
                coefficients.set(i, coefficients.get(i));
            }
        }
    }


    public void setCondition(Condition condition) {
        this.condition = condition;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= coefficients.size(); i++) {
            Integer coefficient = coefficients.get(i - 1);
            if (coefficient != 0) {
                if (coefficient > 0 && i > 1) {
                    builder.append(" + ");
                }
                builder.append(coefficient);
                builder.append("x");
                builder.append(i);
            }
        }


        if (basis.getValue() != 0) {
            if (basis.getValue() > 0) {
                builder.append(" + ");
            }
            builder.append(basis.getValue());
            builder.append("x");
            builder.append(basis.getIndex());
        }


        builder.append(condition.print()).append(freeCoefficient);
        return builder.toString();

    }

    public void setBases(int basesCoefficient, int coefficientBaseIndex) {
        this.basis.update(coefficientBaseIndex, basesCoefficient);
    }


    @Override
    public boolean equals(Object o) {
        if (!super.equals(o)) {
            return false;
        }
        if (this == o) return true;
        if (!(o instanceof ConditionFunction)) return false;
        if (!super.equals(o)) return false;

        ConditionFunction that = (ConditionFunction) o;

        if (!basis.equals(that.basis)) return false;
        if (condition != that.condition) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + condition.hashCode();
        result = 31 * result + basis.hashCode();
        return result;
    }

    public Condition getCondition() {
        return condition;
    }

    public Basis getBasis() {
        return basis;
    }
}

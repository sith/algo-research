package org.sith.research.simplex;


import java.util.ArrayList;
import java.util.List;

public class Function {

    protected List<Integer> coefficients = new ArrayList<Integer>();
    protected int freeCoefficient;


    public void coefficients(Integer... coefficients) {
        for (Integer coefficient : coefficients) {
            this.coefficients.add(coefficient);
        }
    }

    public void freeCoefficient(Integer freeCoefficient) {
        this.freeCoefficient = freeCoefficient;
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("L(x) = ");
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

        builder.append(" = ").append(freeCoefficient);
        return builder.toString();

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Function function = (Function) o;

        if (freeCoefficient != function.freeCoefficient) return false;
        if (coefficients != null ? !coefficients.equals(function.coefficients) : function.coefficients != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = coefficients != null ? coefficients.hashCode() : 0;
        result = 31 * result + freeCoefficient;
        return result;
    }

    public List<Integer> getCoefficients() {
        return coefficients;
    }

    public int getFreeCoefficient() {
        return freeCoefficient;
    }
}

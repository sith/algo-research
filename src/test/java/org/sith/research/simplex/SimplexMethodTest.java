package org.sith.research.simplex;


import org.junit.Test;

public class SimplexMethodTest {

    @Test
    public void test() {

        SimplexMethod simplexMethod = new SimplexMethod(3, 3);
        Function targetFunction = new Function();
        targetFunction.coefficients(6, 5, 9);
        simplexMethod.targetFunction(targetFunction);

        simplexMethod.addConditionFunction(initCondition(25, Condition.LESS_OR_EQUAL, 5, 2, 3));
        simplexMethod.addConditionFunction(initCondition(20, Condition.LESS_OR_EQUAL, 1, 6, 2));
        simplexMethod.addConditionFunction(initCondition(18, Condition.LESS_OR_EQUAL, 4, 0, 3));


        simplexMethod.calculate();

    }

    @Test
    public void test2() {

        SimplexMethod simplexMethod = new SimplexMethod(2, 2);
        Function targetFunction = new Function();
        targetFunction.coefficients(3,-1);
        targetFunction.freeCoefficient(0);
        simplexMethod.targetFunction(targetFunction);

        simplexMethod.addConditionFunction(initCondition(11, Condition.LESS_OR_EQUAL, 3,0));
        simplexMethod.addConditionFunction(initCondition(4, Condition.EQUAL,0,1));


        simplexMethod.calculate();

    }

    private ConditionFunction initCondition(Integer freeCoefficient, Condition condition, Integer... coefficients) {
        ConditionFunction conditionFunction = new ConditionFunction();
        conditionFunction.coefficients(coefficients);
        conditionFunction.freeCoefficient(freeCoefficient);
        conditionFunction.setCondition(condition);
        return conditionFunction;
    }
}

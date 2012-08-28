package org.sith.research.simplex;


import java.util.ArrayList;
import java.util.List;

public class SimplexMethod {

    private Function targetFunction;
    private List<ConditionFunction> conditions = new ArrayList<ConditionFunction>();

    private final int coefficientsCount;
    private final int conditionsCount;

    public SimplexMethod(int coefficientsCount, int conditionsCount) {
        this.coefficientsCount = coefficientsCount;
        this.conditionsCount = conditionsCount;
    }


    public void targetFunction(Function targetFunction) {
        this.targetFunction = targetFunction;
    }


    public void addConditionFunction(ConditionFunction condition) {
        conditions.add(condition);
    }


    public void calculate() {

        System.out.println("Target function: " + targetFunction);
//        printConditions("Condition functions: ");
        //check the negative values of free coefficient
        checkThreeCoefficient(conditions);


        //go to canonical view
        convertToCanonicalView(conditions);
//        printConditions("Canonical Condition functions: ");


        //create bases solution
        createBasesSolution(conditions);


        //TODO
        //check target function


        //createSimplexTable
        double[][] simplexTable = createSimplexTable();

        double[] solution = new double[0];
        boolean isOptimal = false;
        while (!isOptimal) {
            int rowIndex = findSelectedRow(simplexTable);
            System.out.println("Selected row: " + rowIndex);

            int columnIndex = findSelectedColumn(simplexTable, rowIndex);
            System.out.println("Selected column: " + columnIndex);

            calculateNewTable(rowIndex, columnIndex, simplexTable);
            printTable(simplexTable);


            solution = new double[conditionsCount + coefficientsCount + 1];
            for (int i = 1; i <= conditionsCount; i++) {
                int a = (int) simplexTable[i][0];
                solution[a] = simplexTable[i][getFreeCoefficientIndex(simplexTable[i])];
            }

            isOptimal = true;
            double[] indexRow = simplexTable[conditionsCount + 1];
            for (int i = 1; i < indexRow.length - 1; i++) {
                if (indexRow[i] < 0) {
                    isOptimal = false;
                }

            }

        }
        for (int i = 1; i < solution.length; i++) {
            double v = solution[i];
            System.out.printf("x %s = %f", i, v);
            System.out.println();
        }

    }

    private void calculateNewTable(int rowIndex, int columnIndex, double[][] simplexTable) {

        double[][] tmp = copyArray(simplexTable);


        double selectedElement = tmp[rowIndex][columnIndex];
        for (int i = 1; i < simplexTable.length; i++) {
            if (i == rowIndex) {
                continue;
            }
            double[] row = simplexTable[i];

            for (int j = 1; j < row.length; j++) {
                if (j == columnIndex) {
                    continue;
                }
                row[j] = tmp[i][j] - (tmp[i][columnIndex] * tmp[rowIndex][j] / selectedElement);
            }
        }

        double[] selectedRow = simplexTable[rowIndex];
        for (int i = 1; i < selectedRow.length; i++) {
            if (i == columnIndex) {
                continue;
            }
            selectedRow[i] = selectedRow[i] / selectedElement;
        }

        for (int i = 1; i <= conditionsCount + 1; i++) {
            simplexTable[i][columnIndex] = simplexTable[i][columnIndex] / -selectedElement;

        }
        simplexTable[rowIndex][columnIndex] = 1;


        simplexTable[rowIndex][0] = columnIndex;


    }

    private double[][] copyArray(double[][] simplexTable) {
        double[][] tmp = new double[simplexTable.length][];

        for (int k = 0; k < tmp.length; k++) {
            tmp[k] = new double[simplexTable[k].length];
            for (int i = 0; i < tmp[k].length; i++) {
                tmp[k][i] = simplexTable[k][i];
            }
        }
        return tmp;
    }

    private int findSelectedColumn(double[][] simplexTable, int rowIndex) {
        double mimRatio = Double.MAX_VALUE;
        int minIndex = 0;

        for (int i = 1; i <= conditionsCount; i++) {
            double[] row = simplexTable[i];
            double element = row[rowIndex];
            if (element == 0) {
                continue;
            }

            double ratio = row[getFreeCoefficientIndex(row)] / element;
            if (ratio < mimRatio) {
                mimRatio = ratio;
                minIndex = i;
            }


        }
        return minIndex;
    }


    public int findSelectedRow(double[][] table) {
        int minIndex = 0;
        double minValue = Double.MAX_VALUE;

        for (int i = 1; i <= coefficientsCount + conditionsCount; i++) {
            double v = table[conditionsCount + 1][i];
            if (v < minValue) {
                minValue = v;
                minIndex = i;
            }
        }
        return minIndex;
    }

    private double[][] createSimplexTable() {

        double[][] table = new double[conditionsCount + 2][coefficientsCount + conditionsCount + 2];


        for (int i = 1; i <= coefficientsCount + conditionsCount; i++) {
            table[0][i] = i;
        }

        for (int i = 1; i < table.length - 1; i++) {
            double[] row = table[i];
            row[0] = coefficientsCount + i;
            ConditionFunction conditionFunction = conditions.get(i - 1);
            addFunctionToTheTable(row, conditionFunction, 1);
            Basis basis = conditionFunction.getBasis();
            row[basis.getIndex()] = basis.getValue();
            row[getFreeCoefficientIndex(row)] = conditionFunction.freeCoefficient;

        }


        double[] indexRow = table[table.length - 1];
        addFunctionToTheTable(indexRow, targetFunction, -1);
        indexRow[getFreeCoefficientIndex(indexRow)] = targetFunction.freeCoefficient;
        printTable(table);

        return table;
    }


    private void addFunctionToTheTable(double[] row, Function conditionFunction, int k) {
        for (int j = 1; j <= coefficientsCount; j++) {
            row[j] = conditionFunction.getCoefficients().get(j - 1) * k;
        }

    }

    private void printTable(double[][] table) {
        for (double[] doubles : table) {
            for (double aDouble : doubles) {
                System.out.printf("   %.2f    |", aDouble);
            }
            System.out.println();
        }
    }


    private int getFreeCoefficientIndex(double[] row) {
        return row.length - 1;
    }

    private void createBasesSolution(List<ConditionFunction> conditions) {

        //TODO
        for (ConditionFunction condition : conditions) {
            if (condition.getBasis().getValue() < 0) {
                throw new IllegalStateException("Not single basis");
            }
        }
    }

    private void printConditions(String message) {
        System.out.println(message);
        for (ConditionFunction condition : conditions) {
            System.out.println(condition);
        }
    }

    private void convertToCanonicalView(List<ConditionFunction> conditions) {

        for (int i = 1; i <= conditions.size(); i++) {
            ConditionFunction conditionFunction = conditions.get(i - 1);
            switch (conditionFunction.condition) {
                case GRATE_OR_EQUAL: {
                    conditionFunction.setBases(-1, coefficientsCount + i);
                    conditionFunction.setCondition(Condition.EQUAL);
                    break;
                }
                case LESS_OR_EQUAL: {
                    conditionFunction.setBases(1, coefficientsCount + i);
                    conditionFunction.setCondition(Condition.EQUAL);
                    break;
                }
                case EQUAL: {
                    break;
                }
            }
        }
    }

    private void checkThreeCoefficient(List<ConditionFunction> conditions) {
        for (ConditionFunction condition : conditions) {
            condition.checkFreeCoefficient();
        }
    }

}

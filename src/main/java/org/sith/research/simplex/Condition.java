package org.sith.research.simplex;

public enum Condition {

    GRATE_OR_EQUAL(">=") {
        @Override
        public Condition inverse() {
            return LESS_OR_EQUAL;
        }
    },
    LESS_OR_EQUAL("<=") {
        @Override
        public Condition inverse() {
            return GRATE_OR_EQUAL;
        }
    },
    EQUAL("=") {
        @Override
        public Condition inverse() {
            return EQUAL;
        }
    };
    private String printSymbol;

    private Condition(String printSymbol) {
        this.printSymbol = printSymbol;
    }

    public abstract Condition inverse();

    public String print() {
        return printSymbol;
    }
}

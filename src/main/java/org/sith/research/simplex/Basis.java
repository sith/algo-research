package org.sith.research.simplex;

public class Basis {


    private int index;
    private int value;



    public int getIndex() {

        return index;
    }

    public int getValue() {
        return value;
    }


    public void update(int index, int value) {
        this.index = index;
        this.value = value;
    }
}

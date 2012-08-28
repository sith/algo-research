package org.sith.research.transport;

import org.junit.Test;

import java.util.List;

public class PotentialMethodTest {


    @Test
    public void test() {
        PotentialMethod service = new PotentialMethod();
        service.addNeedAndPrices(50, 10, 10, 10);
        service.addProviders(20, 30, 40);

        service.buildMatrix();

        service.addPrices(5, 8, 9, 10);
        service.addPrices(10, 5, 8, 9);
        service.addPrices(3, 10, 5, 8);

        service.printMatrix();
//        service.printElements();

        List<PotentialMethod.Element> initialSolution = service.findInitialSolution();

        for (PotentialMethod.Element element : initialSolution) {
            System.out.println(element);
        }
    }

}

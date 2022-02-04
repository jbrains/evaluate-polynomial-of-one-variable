package ca.jbrains.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EvaluatePolynomialAtOnePointTest {
    @Test
    void constant() {
        Assertions.assertEquals(5, polynomialOfAt(5, 2));
    }

    private int polynomialOfAt(int zerothPowerCoefficient, int point) {
        return 0;
    }
}

package ca.jbrains.math;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EvaluatePolynomialAtOnePointTest {
    @Test
    void constant() {
        Assertions.assertEquals(5, polynomialOfAt(5, 2));
    }

    @Property
    void constantIsConstant(@ForAll int zerothPowerCoefficient, @ForAll int atPoint) {
        Assertions.assertEquals(zerothPowerCoefficient, polynomialOfAt(zerothPowerCoefficient, atPoint));
    }

    private int polynomialOfAt(int zerothPowerCoefficient, int point) {
        return zerothPowerCoefficient;
    }
}

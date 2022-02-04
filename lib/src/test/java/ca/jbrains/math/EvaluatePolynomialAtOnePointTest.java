package ca.jbrains.math;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EvaluatePolynomialAtOnePointTest {
    @Test
    void constant() {
        Assertions.assertEquals(5, Polynomial.of(5).at(2));
    }

    @Test
    void linearWithZeroIntercept() {
        Assertions.assertEquals(10, Polynomial.of(0, 5).at(2));
    }

    @Property
    void constantIsConstant(@ForAll int zerothPowerCoefficient, @ForAll int atPoint) {
        Assertions.assertEquals(zerothPowerCoefficient, Polynomial.of(zerothPowerCoefficient).at(atPoint));
    }

    private static class Polynomial {
        private int[] coefficients;

        public Polynomial(int[] coefficients) {
            this.coefficients = coefficients;
        }

        public static Polynomial of(int... coefficients) {
            return new Polynomial(coefficients);
        }

        public int at(int point) {
            return coefficients.length == 1 ? coefficients[0] : 10;
        }
    }
}

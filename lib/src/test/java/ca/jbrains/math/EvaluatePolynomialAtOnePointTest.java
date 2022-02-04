package ca.jbrains.math;

import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EvaluatePolynomialAtOnePointTest {
    @Property
    void empty(@ForAll int point) {
        Assertions.assertEquals(0, Polynomial.of().at(point));
    }

    @Test
    void constant() {
        Assertions.assertEquals(5, Polynomial.of(5).at(2));
    }

    @Test
    void linearWithZeroIntercept() {
        Assertions.assertEquals(10, Polynomial.of(0, 5).at(2));
    }

    @Test
    void linearWithNonZeroIntercept() {
        Assertions.assertEquals(31, Polynomial.of(3, 4).at(7));
    }

    @Property
    void constantIsConstant(@ForAll int zerothPowerCoefficient, @ForAll int atPoint) {
        Assertions.assertEquals(zerothPowerCoefficient, Polynomial.of(zerothPowerCoefficient).at(atPoint));
    }

    private static class Polynomial {
        private int[] legacyCoefficients;

        public Polynomial(int[] legacyCoefficients) {
            this.legacyCoefficients = legacyCoefficients;
        }

        public static Polynomial of(int... coefficients) {
            return new Polynomial(coefficients);
        }

        public int at(int point) {
            return legacyCoefficients.length == 0 ? 0
                    : legacyCoefficients.length == 1 ? legacyCoefficients[0]
                    : legacyCoefficients[1] * point + legacyCoefficients[0];
        }
    }
}

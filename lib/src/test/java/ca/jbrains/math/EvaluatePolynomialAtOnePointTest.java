package ca.jbrains.math;

import io.vavr.collection.List;
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
        private final List<Integer> coefficients;

        public Polynomial(int[] legacyCoefficients) {
            this.coefficients = List.ofAll(legacyCoefficients);
        }

        public static Polynomial of(int... coefficients) {
            return new Polynomial(coefficients);
        }

        public int at(int point) {
            return coefficients.length() == 0 ? 0
                    : coefficients.length() == 1 ? coefficients.get(0)
                    : coefficients.get(1) * point + coefficients.get(0);
        }
    }
}

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

    @Test
    void simplestQuadratic() {
        Assertions.assertEquals(45, Polynomial.of(0, 0, 5).at(3));
    }

    @Test
    void quadraticWithNonZeroLinearCoefficient() {
        Assertions.assertEquals(7 * 4 * 4 + 3 * 4, Polynomial.of(0, 3, 7).at(4));
    }

    @Test
    void quadraticWithNonZeroLinearCoefficientAndNonZeroConstant() {
        Assertions.assertEquals(7 * 4 * 4 + 3 * 4 + 9, Polynomial.of(9, 3, 7).at(4));
    }

    @Property
    void constantIsConstant(@ForAll int zerothPowerCoefficient, @ForAll int atPoint) {
        Assertions.assertEquals(zerothPowerCoefficient, Polynomial.of(zerothPowerCoefficient).at(atPoint));
    }

    private static class Polynomial {
        private final List<Integer> coefficients;

        public Polynomial(List<Integer> coefficients) {
            this.coefficients = coefficients;
        }

        public static Polynomial of(int... coefficients) {
            return new Polynomial(List.ofAll(coefficients));
        }

        public int at(int point) {
            if (coefficients.length() == 0) return 0;
            if (coefficients.length() == 0) return 0;
            if (coefficients.length() == 1)
                return coefficients.last() * foo(point, coefficients.length() - 1) + Polynomial.of(coefficients.init()).at(point);
            if (coefficients.length() == 2)
                return coefficients.last() * foo(point, coefficients.length() - 1) + Polynomial.of(coefficients.init()).at(point);
            if (coefficients.length() == 3)
                return coefficients.last() * foo(point, coefficients.length() - 1) + Polynomial.of(coefficients.init()).at(point);
            return -223816;
        }

        // CONTRACT power >= 0
        private int foo(int point, int power) {
            int result = 1;
            while (power-- > 0) {
                result *= point;
            }
            return result;
        }

        private static Polynomial of(List<Integer> coefficients) {
            return new Polynomial(coefficients);
        }
    }
}

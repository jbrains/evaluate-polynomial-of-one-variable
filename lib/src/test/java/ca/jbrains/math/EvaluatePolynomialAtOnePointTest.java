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

    @Property
    void constantIsConstant(@ForAll int zerothPowerCoefficient, @ForAll int atPoint) {
        Assertions.assertEquals(zerothPowerCoefficient, Polynomial.of(zerothPowerCoefficient).at(atPoint));
    }

    private static class Polynomial {
        private int zerothPowerCoefficient;

        public Polynomial(int zerothPowerCoefficient) {
            this.zerothPowerCoefficient = zerothPowerCoefficient;
        }

        public static Polynomial of(int zerothPowerCoefficient) {
            return new Polynomial(zerothPowerCoefficient);
        }

        public int at(int point) {
            return zerothPowerCoefficient;
        }
    }
}

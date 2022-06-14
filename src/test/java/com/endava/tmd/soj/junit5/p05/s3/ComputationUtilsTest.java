package com.endava.tmd.soj.junit5.p05.s3;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p05.s3.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

// Scopul acestei sectiuni este sa urmarim rescrierile de cod din partea de productie
// Deci pastram testele din sectiunea precedenta
@DisplayName("Tests for my sum method")
class ComputationUtilsTest {

    @Test
    @DisplayName("0 + 0 = 0")
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        assertEquals(0, sum(0, 0));
        //assertEquals(1, sum(0, 0));
        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
    }
    @Test
    @DisplayName("2 + 0 = 2")
    void zeroShouldNotChangePositive() {
        assertEquals(2, sum(2, 0));

        assertThat(sum(2,0)).isEqualTo(2);
    }
    @Test
    @DisplayName("(-2) + 0 = -2")
    void zeroShouldNotChangeNegative() {
        assertEquals(-2, sum(-2, 0));

        assertThat(sum(-2,0)).isEqualTo(-2);
    }
    @Test
    @DisplayName("2 + 3 = 5")
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertEquals(5, sum(2,3));
        assertThat(sum(2,3)).isEqualTo(5);
    }
    @Test
    @DisplayName("(-5) + (-4) = (-9)")
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertEquals(-9, sum(-5,-4));
        assertThat(sum(-5,-4)).isEqualTo(-9);
    }
    @Test
    @DisplayName("(-1) + 25 = 24")
    void oneSmallNegativeAndOneBigPositiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertEquals(24, sum(-1,25));
        assertThat(sum(-1,25)).isEqualTo(24);
    }
    @Test
    @DisplayName("(-40) + 5 = (-35)")
    void oneBigNegativeAndOneSmallPositiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertEquals(-35, sum(-40,5));
        assertThat(sum(-40,5)).isEqualTo(-35);
    }
    @Test
    void zeroShouldNotChangeMaxInt() {
        assertThat(sum(0,Integer.MAX_VALUE)).isEqualTo(Integer.MAX_VALUE);
    }
    @Test
    void maxIntAndANegativeNumber() {
        assertThat(sum(-1,Integer.MAX_VALUE)).isEqualTo(Integer.MAX_VALUE-1);
    }
    @Test
    void zeroShouldNotChangeMinInt() {
        assertThat(sum(0,Integer.MIN_VALUE)).isEqualTo(Integer.MIN_VALUE);
    }
    @Test
    void minIntAndAPositiveNumber() {
        assertThat(sum(2,Integer.MIN_VALUE)).isEqualTo(Integer.MIN_VALUE + 2);
    }
    @Test
    void minIntAndMaxInt() {
        assertEquals(sum(Integer.MIN_VALUE,Integer.MAX_VALUE),-1);
    }
    @Test
    @Disabled("not usable for now")
    void whatToDoWhenSumExceedsMaxIntegerValue() {
        assertThat(sum(Integer.MAX_VALUE,100)).isGreaterThan(Integer.MAX_VALUE);
    }
    @DisplayName("2147483647 + 1 \u21D2 Overflow")
    @Test
    void exceptionWhenSumIsGreaterThanIntegerMaxValue() {
        // JUnit way of checking the exception class
        assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));

        // JUnit way of checking the exception class and its characteristics
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(2147483647, 1));
        assertEquals("Overflow while computing the sum", exception.getMessage());

        // AssertJ
        assertThatThrownBy(() -> sum(2147483647, 1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }

    @DisplayName("-2147483648 + (-1) \u21D2 Overflow")
    @Test
    void exceptionWhenSumIsLowerThanIntegerMinValue() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(-2147483648, -1));
        assertEquals("Overflow while computing the sum", exception.getMessage());

        assertThatThrownBy(() -> sum(-2147483648, -1))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Overflow while computing the sum");
    }

}

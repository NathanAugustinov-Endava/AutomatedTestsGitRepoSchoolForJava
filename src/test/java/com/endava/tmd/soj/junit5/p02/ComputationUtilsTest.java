package com.endava.tmd.soj.junit5.p02;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p02.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat:
// 1. Sa fie afisat "Tests for my sum method" in loc de "ComputationUtilsTest"
// 2. La fiecare test sa fie afisata suma. De exemplu "zeroShouldNotChangeZero" ar trebui sa fie inlocuit cu "0 + 0 = 0"
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
    @DisplayName("(-5) + (-4) = (-9) ")
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

}

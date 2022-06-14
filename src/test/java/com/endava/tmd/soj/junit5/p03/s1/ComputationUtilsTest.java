package com.endava.tmd.soj.junit5.p03.s1;

import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p03.s1.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Provocare: Copiati metodele de test din tema anterioara, si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in ordine alfabetica. Modificati numele metodelor de test astfel incat metodele
// sa fie executate in ordinea in care sunt scrise

//@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestMethodOrder(MethodOrderer.MethodName.class)
@DisplayName("Tests for my sum method")
class ComputationUtilsTest {

    @Test
    @DisplayName("0 + 0 = 0")
    void test1ZeroShouldNotChangeZero() {
        // JUnit Assertion
        assertEquals(0, sum(0, 0));
        //assertEquals(1, sum(0, 0));
        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
    }
    @Test
    @DisplayName("2 + 0 = 2")
    void test2ZeroShouldNotChangePositive() {
        assertEquals(2, sum(2, 0));

        assertThat(sum(2,0)).isEqualTo(2);
    }
    @Test
    @DisplayName("(-2) + 0 = -2")
    void test3ZeroShouldNotChangeNegative() {
        assertEquals(-2, sum(-2, 0));

        assertThat(sum(-2,0)).isEqualTo(-2);
    }
    @Test
    @DisplayName("2 + 3 = 5")
    void test4TwoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertEquals(5, sum(2,3));
        assertThat(sum(2,3)).isEqualTo(5);
    }
    @Test
    @DisplayName("(-5) + (-4) = (-9)")
    void test5TwoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertEquals(-9, sum(-5,-4));
        assertThat(sum(-5,-4)).isEqualTo(-9);
    }
    @Test
    @DisplayName("(-1) + 25 = 24")
    void test6OneSmallNegativeAndOneBigPositiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertEquals(24, sum(-1,25));
        assertThat(sum(-1,25)).isEqualTo(24);
    }
    @Test
    @DisplayName("(-40) + 5 = (-35)")
    void test7OneBigNegativeAndOneSmallPositiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertEquals(-35, sum(-40,5));
        assertThat(sum(-40,5)).isEqualTo(-35);
    }
}

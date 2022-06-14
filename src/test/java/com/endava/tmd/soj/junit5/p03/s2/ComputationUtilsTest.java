package com.endava.tmd.soj.junit5.p03.s2;

import com.endava.tmd.soj.junit5.p03.s1.ComputationUtils;
import org.junit.jupiter.api.*;

import static com.endava.tmd.soj.junit5.p03.s2.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Provocare: Copiati metodele de test din tema anterioara (p02), si adaugati adnotarile necesare astfel incat
// sa fie rulate testele in functie de adnotarea de ordine specificata pe fiecare metoda de test. Adnotarea de ordine
// trebuie sa fie pusa pe fiecare metoda de test astfel incat metodele sa fie executate in ordinea in care sunt scrise
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Tests for my sum method")
class ComputationUtilsTest {

    @Test
    @DisplayName("0 + 0 = 0")
    @Order(1)
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        assertEquals(0, sum(0, 0));
        //assertEquals(1, sum(0, 0));
        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
    }
    @Test
    @DisplayName("2 + 0 = 2")
    @Order(2)
    void zeroShouldNotChangePositive() {
        assertEquals(2, sum(2, 0));
        assertThat(sum(2,0)).isEqualTo(2);
    }
    @Test
    @DisplayName("(-2) + 0 = -2")
    @Order(3)
    void zeroShouldNotChangeNegative() {
        assertEquals(-2, sum(-2, 0));
        assertThat(sum(-2,0)).isEqualTo(-2);
    }
    @Test
    @DisplayName("2 + 3 = 5")
    @Order(4)
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertEquals(5, sum(2,3));
        assertThat(sum(2,3)).isEqualTo(5);
    }
    @Test
    @DisplayName("(-5) + (-4) = (-9)")
    @Order(5)
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertEquals(-9, sum(-5,-4));
        assertThat(sum(-5,-4)).isEqualTo(-9);
    }
    @Test
    @DisplayName("(-1) + 25 = 24")
    @Order(6)
    void oneSmallNegativeAndOneBigPositiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertEquals(24, sum(-1,25));
        assertThat(sum(-1,25)).isEqualTo(24);
    }
    @Test
    @DisplayName("(-40) + 5 = (-35)")
    @Order(7)
    void oneBigNegativeAndOneSmallPositiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertEquals(-35, sum(-40,5));
        assertThat(sum(-40,5)).isEqualTo(-35);
    }

}

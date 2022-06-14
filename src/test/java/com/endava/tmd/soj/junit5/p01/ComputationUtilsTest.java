package com.endava.tmd.soj.junit5.p01;

// Provocari:
// 1. Adaugati adnotarea neecesara pentru a rula prima metoda ca si un test unitar
// 2. Rulati prima metoda ca si un test unitar
// 3. Decomentati asertiile din primul test, si efectuati importurile necesare. Rulati testul din nou.
// 4. Adaugati o linie care sa determine testul sa fie "failed". La sfarsit commentati acea linie
// 5. Completati celelalte metode astfel incat sa reprezinte scenarii de testare

import com.sun.source.tree.AssertTree;
import org.junit.jupiter.api.Test;

import static com.endava.tmd.soj.junit5.p01.ComputationUtils.sum;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class ComputationUtilsTest {
    @Test
    void zeroShouldNotChangeZero() {
        // JUnit Assertion
        assertEquals(0, sum(0, 0));
        //assertEquals(1, sum(0, 0));
        // AssertJ Assertion
        assertThat(sum(0, 0)).isZero();
    }
    @Test
    void zeroShouldNotChangePositive() {
        assertEquals(2, sum(2, 0));
        assertThat(sum(2,0)).isEqualTo(2);
    }
    @Test
    void zeroShouldNotChangeNegative() {
        assertEquals(-2, sum(-2, 0));
        assertThat(sum(-2,0)).isEqualTo(-2);
    }
    @Test
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult() {
        assertEquals(5, sum(2,3));
        assertThat(sum(2,3)).isEqualTo(5);
    }
    @Test
    void twoNegativeNumbersShouldHaveAbsoluteValuesAddedAndNegativeResult() {
        assertEquals(-9, sum(-5,-4));
        assertThat(sum(-5,-4)).isEqualTo(-9);
    }
    @Test
    void oneSmallNegativeAndOneBigPositiveNumberShouldHaveAbsoluteValuesSubtractedAndPositiveResult() {
        assertEquals(24, sum(-1,25));
        assertThat(sum(-1,25)).isEqualTo(24);
    }
    @Test
    void oneBigNegativeAndOneSmallPositiveNumberShouldHaveAbsoluteValuesSubtractedAndNegativeResult() {
        assertEquals(-35, sum(-40,5));
        assertThat(sum(-40,5)).isEqualTo(-35);
    }

}

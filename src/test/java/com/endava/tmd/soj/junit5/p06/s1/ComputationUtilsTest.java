package com.endava.tmd.soj.junit5.p06.s1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.endava.tmd.soj.junit5.p05.s1.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

// Provocare: Rescrieti scenariile de testare din tema precedenta folosind teste parametrizate.
// Se vor utiliza adnotarile @ParameterizedTest si @CsvSource
// E suficient sa scrieti 2 teste distincte:
// - Un test care verifica valoarea sumei a doua numere
// - Un test care verifica exceptiile generate
//
// Bonus: personalizarea numelui afisat al testului
//   * vom folosi {0} pentru a folosi valoarea primului parametru al metodei
//   * vom folosi {1} pentru a folosi valoarea celui de-al doilea parametru al metodei
//   * ...
//   dar NU in @DisplayName ci in atributul "name" al adnotarii @ParameterizedTest
@DisplayName("Tests for my sum method")
class ComputationUtilsTest {

    @ParameterizedTest(name="Positive Number Sum With Zero Test #{index}: {0} + 0 = {1}")
    @CsvSource({"1,1","2,2","3,3"})
    void zeroShouldNotChangePositive(int numberInput, int expectedOutput) {
        assertEquals(expectedOutput, sum(numberInput, 0));
        assertThat(sum(numberInput,0)).isEqualTo(expectedOutput);
    }

    @ParameterizedTest(name="Two Positive Numbers Sum Test #{index}: {0} + {1} = {2} ")
    @CsvSource({"1,2,3","5,7,12","12,3,15"})
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult(int firstNumberInput, int secondNumberInput, int expectedOutput) {
        assertEquals(expectedOutput,sum(firstNumberInput,secondNumberInput));
        assertThat(sum(firstNumberInput,secondNumberInput)).isEqualTo(expectedOutput);
    }

    @ParameterizedTest(name="Overflow Exception Sum Test #{index}: firstNumber={0} secondNumber={1}")
    @CsvSource({"2147483647,1,Overflow while computing the sum","2147483645,3,Overflow while computing the sum"})
    void exceptionWhenSumIsGreaterThanIntegerMaxValue(int firstNumberInput, int secondNumberInput, String outputExpected) {
        // JUnit way of checking the exception class and its characteristics
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(firstNumberInput, secondNumberInput));
        assertEquals(outputExpected, exception.getMessage());

        // AssertJ
        assertThatThrownBy(() -> sum(firstNumberInput, secondNumberInput))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage(outputExpected);
    }

}

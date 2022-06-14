package com.endava.tmd.soj.junit5.p06.s3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.endava.tmd.soj.junit5.p06.s3.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

// Provocare: Rescrieti cele doua teste parametrizate din sectiunea 1 astfel incat sa existe
// cate o metoda care sa furnizeze valorile parametrilor. Dar, nu se vor mai folosi valorile
// explicite pentru valoarea minima si maxima acceptata de Java pentru tipul de date intreg,
// ci se vor folosi Integer.MIN_VALUE, respectiv Integer.MAX_VALUE
// Se va utiliza adnotarea @MethodSource.

@DisplayName("Tests for my sum method")
class ComputationUtilsTest {

    @ParameterizedTest(name="Two Positive Numbers Sum Test #{index}: {0} + {1} = {2}")
    @MethodSource("firstTestParameters")
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult(int firstNumberInput, int secondNumberInput, int expectedOutput) {
        assertEquals(expectedOutput,sum(firstNumberInput,secondNumberInput));
        assertThat(sum(firstNumberInput,secondNumberInput)).isEqualTo(expectedOutput);
    }

    @ParameterizedTest(name="Overflow Exception Sum Test #{index}: firstNumber={0} secondNumber={1}")
    @MethodSource("secondTestParameters")
    void exceptionWhenSumIsGreaterThanIntegerMaxValue(int firstNumberInput, int secondNumberInput, String outputExpected) {
        // JUnit way of checking the exception class
        //assertThrows(ArithmeticException.class, () -> sum(Integer.parseInt(firstNumberInput), Integer.parseInt(secondNumberInput)));

        // JUnit way of checking the exception class and its characteristics
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> sum(firstNumberInput, secondNumberInput));
        assertEquals(outputExpected, exception.getMessage());

        // AssertJ
        assertThatThrownBy(() -> sum(firstNumberInput, secondNumberInput))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage(outputExpected);
    }

    static Stream<Arguments> firstTestParameters(){
        return Stream.of(
                arguments(1, 2, 3),
                arguments(5, 7, 12),
                arguments(12, 3, 15)
        );
    }

    static Stream<Arguments> secondTestParameters(){
        return Stream.of(
                arguments(Integer.MAX_VALUE,1,"Overflow while computing the sum"),
                arguments(Integer.MAX_VALUE-2, 3, "Overflow while computing the sum")
        );
    }

}

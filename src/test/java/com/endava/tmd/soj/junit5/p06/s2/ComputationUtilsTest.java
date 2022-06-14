package com.endava.tmd.soj.junit5.p06.s2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static com.endava.tmd.soj.junit5.p05.s1.ComputationUtils.sum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Provocare: Rescrieti testul care verifica valoarea sumei a doua numere din tema precedenta
// folosind un fisier (Comma-Separated Value) care sa stocheze datele necesare pentru test
// Fisierul se va numi "sumCheckArguments.csv" si va fi creat in folderul src/test/resources
// Se va utiliza adnotarea @CsvFileSource.
// 
// Testul care verifica exceptiile generate se va copia din tema precedenta
@DisplayName("Tests for my sum method")
class ComputationUtilsTest {

    @ParameterizedTest(name="Two Positive Numbers Sum Test #{index}: {0} + {1} = {2}")
    @CsvFileSource(resources = {"/sumCheckArguments.csv"})
    void twoPositiveNumbersShouldHaveAbsoluteValuesAddedAndPositiveResult(int firstNumberInput, int secondNumberInput, int expectedOutput) {
        assertEquals(expectedOutput, sum(firstNumberInput,secondNumberInput));
        assertThat(sum(firstNumberInput,secondNumberInput)).isEqualTo(expectedOutput);
    }

}

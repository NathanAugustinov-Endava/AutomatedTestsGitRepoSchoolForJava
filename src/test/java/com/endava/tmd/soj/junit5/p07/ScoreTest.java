package com.endava.tmd.soj.junit5.p07;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.Locale;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

// Provocare: definiti cel putin 3 teste pentru clasa care tine scorul
// Unde e cel mai potrivit ca sa initializam variabila "score"?
//
// Pentru un raspuns corect si doua incorecte, cat ar trebui sa fie scorul: 33.3 sau 33,3 ?
// 
// Daca avem colegi pe proiect care sunt din diferite parti ale lumii,
// cum putem scrie testul astfel incat sa functioneze pentru toti, indiferent de ce Locale are fiecare? 
class ScoreTest {
    private Score score;

    @BeforeAll
    static void setUpLocale() {
        Locale.setDefault(Locale.US);
    }

    @BeforeEach
    void setUpScore() {
        score = new Score();
    }

    @Test
    void noAnswerGiven(){
        assertThat(score.getPercent()).isEqualTo("100.0");
    }

    @Test
    void noIncorrectAnswers(){
        score.addCorrectAnswer();
        assertThat((score.getPercent())).isEqualTo("100.0");
    }

    @Test
    void noCorrectAnswers(){
        score.addIncorrectAnswer();
        assertThat(score.getPercent()).isEqualTo("0.0");
    }

    @ParameterizedTest(name="getPercentTest #{index}")
    @MethodSource("getPercentTestParameters")
    void getPercentTest(int numberOfCorrectAnswers, int numberOfIncorrectAnswers, double percentScore){
        for(int i = 0; i < numberOfCorrectAnswers; i++){
            score = score.addCorrectAnswer();
        }
        for(int i = 0 ;i < numberOfIncorrectAnswers; i++){
            score = score.addIncorrectAnswer();
        }
        assertEquals(Double.parseDouble(score.getPercent()), percentScore);
    }

    static Stream<Arguments> getPercentTestParameters(){
        return Stream.of(
                arguments(1,2,33.3),
                arguments(2,1,66.7)
        );
    }
}

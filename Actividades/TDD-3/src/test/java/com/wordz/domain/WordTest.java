package com.wordz.domain;

import org.junit.jupiter.api.Test;

import static com.wordz.domain.Letter.*;
import static org.assertj.core.api.Assertions.assertThat;

public class WordTest {
    @Test
    public void oneCorrectLetter() {
        var word = new Word("A");
        var score = word.guess("A");
        assertThat(score.letter(0))
                .isEqualTo(Letter.CORRECT);
    }
    private void assertScoreForLetter(Score score,
                                      int position, Letter expected) {
        assertThat(score.letter(position))
                .isEqualTo(expected);
    }
}

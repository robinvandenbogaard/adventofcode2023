package nl.roka.adventofcode.aoc2023.day4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ScoreCalculatorTest {
  @ParameterizedTest
  @CsvSource({"0,0", "1,1", "2,2", "3,4", "4,8", "8,128"})
  void zeroMatchersZeroPoints(long matches, long expected) {
    assertThat(ScoreCalculator.score(matches)).isEqualTo(expected);
  }
}

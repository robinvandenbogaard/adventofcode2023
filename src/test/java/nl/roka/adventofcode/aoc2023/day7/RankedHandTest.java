package nl.roka.adventofcode.aoc2023.day7;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RankedHandTest {
  @ParameterizedTest
  @CsvSource({"1,10", "10,100", "5,50"})
  void score(int rank, int expected) {
    assertThat(new RankedHand(Bid.of("10"), rank).score()).isEqualTo(expected);
  }
}

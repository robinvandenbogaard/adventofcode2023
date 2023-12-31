package nl.roka.adventofcode.aoc2023.day5;

import static org.assertj.core.api.Assertions.assertThat;

import nl.roka.adventofcode.aoc.puzzle.Answer;
import org.junit.jupiter.api.Test;

class Day5Test {

  @Test
  void runSilver() {
    assertThat(new Day5().runSilver()).isEqualTo(Answer.of("35"));
  }

  @Test
  void runGold() {
    assertThat(new Day5().runGold()).isEqualTo(Answer.of("46"));
  }
}

package nl.roka.adventofcode.aoc2023.day10;

import static org.assertj.core.api.Assertions.assertThat;

import nl.roka.adventofcode.aoc.puzzle.Answer;
import org.junit.jupiter.api.Test;

class Day10Test {

  @Test
  void runSilver() {
    assertThat(new Day10().runSilver()).isEqualTo(Answer.of(4));
  }

  @Test
  void runGold() {
    assertThat(new Day10().runGold()).isEqualTo(Answer.TBD);
  }
}

package nl.roka.adventofcode.aoc2023.day9;

import static org.assertj.core.api.Assertions.assertThat;

import nl.roka.adventofcode.aoc.puzzle.Answer;
import org.junit.jupiter.api.Test;

class Day9Test {
  @Test
  void runSilver() {
    assertThat(new Day9().runSilver()).isEqualTo(Answer.of(114));
  }

  @Test
  void runGold() {
    assertThat(new Day9().runGold()).isEqualTo(Answer.TBD);
  }
}
